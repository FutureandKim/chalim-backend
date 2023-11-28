package com.chalim.backend.service;


import com.chalim.backend.client.OpenAIAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuInfoService {

    @Autowired
    private OpenAIAPI openAIAPI;

    public MenuInfo getMenuInfo(String menuName) throws Exception {
        return openAIAPI.getMenuInfo(menuName);
    }
}

