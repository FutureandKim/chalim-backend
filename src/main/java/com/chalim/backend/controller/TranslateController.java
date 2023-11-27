package com.chalim.backend.controller;

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
    public ResponseEntity<TranslateResponse> translateText(@PathVariable String language, @RequestBody TranslateRequest request) {
        String translatedText = translateService.translate(request.getText(), language);
        return ResponseEntity.ok(new TranslateResponse(translatedText));
    }
}
