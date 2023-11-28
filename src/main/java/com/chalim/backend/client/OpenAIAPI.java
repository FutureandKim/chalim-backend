package com.chalim.backend.client;

import com.chalim.backend.dto.MenuInfoDto;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class OpenAIAPI {

    @Value("${openai.api.key}")
    private String apiKey;

    public MenuInfo getMenuInfo(String menuName) throws Exception {
        OpenAIClient client = new OpenAIClient.Builder().apiKey(apiKey).build();
        String prompt = "Write a short description, history, and list of ingredients for a menu item called '" + menuName + "'.";

        Completion completion = client.completions().create(prompt, "text-davinci-002", 1, 150, null, null, null, null, null, null, null, null, null, null);
        String response = completion.getChoices().get(0).getText().trim();

        // 파싱 로직은 반환된 텍스트의 형식에 따라 달라질 수 있음
        // 예시 코드이므로, 실제 응답에 맞춰 파싱 로직을 조정해야 함
        String[] parts = response.split("\\r?\\n");
        return new MenuInfoDto(parts[0], parts[1], parts[2]);
    }
}


