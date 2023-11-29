package com.chalim.backend.client;


import com.chalim.backend.dto.MenuInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Component
public class OpenAIAPI {

    @Value("${openai.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public MenuInfoDto getMenuInfo(String menuName) {
        // API 요청을 위한 URL
        String url = "https://api.openai.com/v1/engines/davinci/completions";

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // API 요청 바디
        String requestBody = String.format("{ \"prompt\": \"Write a short description, history, and list of ingredients for a menu item called '%s'.\", \"max_tokens\": 100 }", menuName);

        // 요청 엔티티 생성
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // API 호출 및 응답 수신
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // OpenAI API 응답 처리 로직
        // 이 부분에서 OpenAI 응답을 파싱하여 필요한 정보를 추출합니다.
        // 예제에서는 단순히 응답 문자열을 그대로 사용합니다.
        String generatedText = response.getBody();

        // 메뉴 정보 DTO 생성 및 반환
        return new MenuInfoDto(generatedText, generatedText, generatedText);
    }
}
