package com.chalim.backend.config;

import com.chalim.backend.controller.ReviewController;
import com.chalim.backend.controller.WordCloudController;
import com.chalim.backend.service.ReviewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean(name = "appRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
