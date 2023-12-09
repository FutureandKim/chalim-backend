package com.chalim.backend.service;


import com.chalim.backend.dto.openAi.MenuDetailsDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class MenuInfoService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${openai.api.key}")
    private String apiKey;

    private final String API_URL = "https://api.openai.com/v1/chat/completions";

    public MenuDetailsDto getMenuDetails(String menuName, String language) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(createRequestBody(menuName, language), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(API_URL, entity, String.class);

        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode choicesNode = rootNode.path("choices");
            if (!choicesNode.isArray() || choicesNode.isEmpty()) {
                return new MenuDetailsDto("Error", "Error", "Error");
            }

            JsonNode firstChoice = choicesNode.get(0);
            JsonNode messageNode = firstChoice.path("message");
            String content = messageNode.path("content").asText();

            // Parsing the content
            String explanation = extractDetail(content, "Explanation:", "History:");
            String history = extractDetail(content, "History:", "Ingredients:");
            String ingredients = extractDetail(content, "Ingredients:", null);

            return new MenuDetailsDto(explanation, history, ingredients);
        } catch (Exception e) {
            e.printStackTrace();
            return new MenuDetailsDto("Error", "Error", "Error");
        }
    }

    private String extractDetail(String content, String startDelimiter, String endDelimiter) {
        int startIndex = content.indexOf(startDelimiter);
        if (startIndex == -1) {
            return "Not found";
        }
        startIndex += startDelimiter.length();

        int endIndex;
        if (endDelimiter != null) {
            endIndex = content.indexOf(endDelimiter, startIndex);
            if (endIndex == -1) {
                endIndex = content.length();
            }
        } else {
            endIndex = content.length();
        }

        String detail = content.substring(startIndex, endIndex).trim();
        return detail.length() > 50 ? detail.substring(0, 50) : detail;
    }

    private String createRequestBody(String menuName, String language) {
        String messageContent = String.format("Please provide a description, history, and list of ingredients for the menu item '%s' in %s language.", menuName, language);
        return "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": ["
                + "  {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},"
                + "  {\"role\": \"user\", \"content\": \"" + messageContent + "\"}"
                + "]"
                + "}";
    }
}