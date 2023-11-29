package com.chalim.backend.client;

import com.chalim.backend.dto.MenuInfoDto;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenAIAPI {
    private final OpenAiService openAiService;

    public OpenAIAPI(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public MenuInfoDto getMenuInfo(String menuName) {
        String prompt = String.format("list of ingredients for a menu item called '%s'.", menuName);

        String modelName = "text-davinci-003";

        CompletionRequest request = CompletionRequest.builder()
                .prompt(prompt)
                .maxTokens(15)
                .model(modelName) // 모델 이름 추가
                .build();

        String response = openAiService.createCompletion(request).getChoices().get(0).getText().trim();

        return new MenuInfoDto(response, response, response);
    }
}