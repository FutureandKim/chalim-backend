package com.chalim.backend.service;


import com.chalim.backend.client.OpenAIAPI;
import com.chalim.backend.dto.MenuInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuInfoService {

    @Autowired
    private OpenAIAPI openAIAPI;

    public MenuInfoDto getMenuInfo(String menuName) {
        return openAIAPI.getMenuInfo(menuName);
    }


}

