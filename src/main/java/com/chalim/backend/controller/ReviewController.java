package com.chalim.backend.controller;

import com.chalim.backend.service.ReviewService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public ResponseEntity<byte[]> searchAndCountReviewWords(@RequestParam String query) {
        String jsonResponse = reviewService.searchReview(query);

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> descriptions = new ArrayList<>();

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode items = jsonNode.get("items");

            if (items.isArray()) {
                for (JsonNode item : items) {
                    JsonNode descriptionNode = item.get("description");
                    if (descriptionNode != null) {
                        String koreanOnly = extractKoreanWithSpaces(descriptionNode.asText());
                        descriptions.add(koreanOnly);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> queryWords = Arrays.stream(query.split("\\s+")).collect(Collectors.toSet());

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String description : descriptions) {
            String[] words = description.split("\\s+");
            for (String word : words) {
                if (queryWords.contains(word)) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        Map<String, Integer> sortedWordFrequency = wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Flask 서버로 데이터 전송
        byte[] imageBytes = sendToFlask(sortedWordFrequency);

        // 클라이언트에게 이미지 바이트 배열 반환
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    private byte[] sendToFlask(Map<String, Integer> sortedWordFrequency) {
        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 엔터티 설정
        HttpEntity<Map<String, Integer>> requestEntity = new HttpEntity<>(sortedWordFrequency, headers);

        // Flask 서버 URL 설정
        String flaskUrl = "http://localhost:5000/wordcloud";

        // Flask 서버에 POST 요청 전송
        ResponseEntity<byte[]> responseEntity = new RestTemplate().postForEntity(flaskUrl, requestEntity, byte[].class);

        // 응답 처리 (이미지를 파일로 저장하거나 화면에 표시 등)
        return responseEntity.getBody();
    }

    private String extractKoreanWithSpaces(String input) {
        Pattern pattern = Pattern.compile("[가-힣\\s]+");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.toString();
    }
}
