package com.chalim.backend.controller;

import com.chalim.backend.service.WordCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class WordCloudController {

    @Autowired
    private WordCloudService wordcloudService;

    @GetMapping("/wordcloud")
    public String wordcloud(){
        String imageUrl = wordcloudService.generateWordCloudImage();
        return "{\"imageUrl\": \"" + imageUrl + "\"}";
    }
}
