package com.chalim.backend.controller;

import com.chalim.backend.service.ReviewService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
    public Map<String, Integer> searchAndCountReviewWords(@RequestParam String query) {
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

        // 쿼리에서 추출한 단어만 선택
        Set<String> queryWords = Arrays.stream(query.split("\\s+")).collect(Collectors.toSet());

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String description : descriptions) {
            String[] words = description.split("\\s+");
            for (String word : words) {
                // 쿼리에서 추출한 단어만을 골라내어 빈도수 계산
                if (queryWords.contains(word)) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        Map<String, Integer> sortedWordFrequency = wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        return sortedWordFrequency;
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