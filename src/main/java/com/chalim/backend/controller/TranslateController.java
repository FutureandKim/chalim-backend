package com.chalim.backend.controller;

import com.chalim.backend.dto.translate.ResponseDto;
import com.chalim.backend.model.ImageData;
import com.chalim.backend.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final TranslateService translateService;

    @Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/{language}")
    public ResponseEntity<ResponseDto> translateText(@PathVariable String language,
                                                     @ModelAttribute ImageData imageData) {
        String imageName = imageData.getImageName();
        MultipartFile imageFile = imageData.getImageFile();

        ResponseDto response = translateService.translateTextData(language, imageName, imageFile);
        return ResponseEntity.ok(response);
    }
}
