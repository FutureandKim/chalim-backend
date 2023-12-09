package com.chalim.backend.controller;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
public class WordCloudController {

    private final RestTemplate restTemplate;

    public WordCloudController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/word-cloud")
    public ResponseEntity<byte[]> generateWordCloud(@RequestBody Map<String, Object> data) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(data, headers);

            ResponseEntity<byte[]> responseEntity = restTemplate.postForEntity("http://127.0.0.1:5000/wordcloud", httpEntity, byte[].class);

            // 받아온 이미지 데이터 그대로 (URL로 수정)
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.IMAGE_PNG);

            return new ResponseEntity<>(responseEntity.getBody(), responseHeaders, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}