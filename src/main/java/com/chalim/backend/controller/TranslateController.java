package com.chalim.backend.controller;

import com.chalim.backend.apiPayLoad.ApiResponse;
import com.chalim.backend.dto.TranslateRequest;
import com.chalim.backend.dto.TranslateResponse;
import com.chalim.backend.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final TranslateService translateService;

    @Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/{language}")
    public ResponseEntity<ApiResponse<TranslateResponse>> translateText(@PathVariable String language, @RequestBody TranslateRequest request) {
        try {
            String translatedText = translateService.translate(request.getText(), language);
            TranslateResponse translateResponse = new TranslateResponse(translatedText);
            ApiResponse<TranslateResponse> response = ApiResponse.onSuccess(translateResponse);
            return ResponseEntity.ok(response);
        } catch (Exception e) {

            ApiResponse<TranslateResponse> errorResponse = ApiResponse.onFailure("에러코드", "에러 메시지", null);
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
