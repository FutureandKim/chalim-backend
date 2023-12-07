package com.chalim.backend.controller;

import com.chalim.backend.dto.ResponseDto;
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
                                                     @RequestParam("image") MultipartFile imageFile) {
        String imageName = imageFile.getOriginalFilename();
        // You can process the image file if needed
        ResponseDto response = translateService.translateTextData(language, imageName);
        return ResponseEntity.ok(response);
    }
}
