package com.chalim.backend.controller;

import com.chalim.backend.apiPayLoad.ApiResponse;
import com.chalim.backend.dto.TranslateRequest;
import com.chalim.backend.dto.TranslateResponse;
import com.chalim.backend.service.TranslateService;
import com.chalim.backend.apiPayLoad.exception.GeneralException;
import com.chalim.backend.apiPayLoad.code.ErrorReasonDTO;
import com.chalim.backend.apiPayLoad.code.status.ErrorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
            String translatedText = translateService.translate(request.getText(), language);
            TranslateResponse translateResponse = new TranslateResponse(translatedText);
            ApiResponse<TranslateResponse> response = ApiResponse.onSuccess(translateResponse);
            return ResponseEntity.ok(response);
    }
}
