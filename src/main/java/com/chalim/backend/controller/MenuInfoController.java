package com.chalim.backend.controller;

import com.chalim.backend.apiPayLoad.ApiResponse;
import com.chalim.backend.dto.MenuInfoDto;
import com.chalim.backend.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @GetMapping("/info/{menuName}")
    public ResponseEntity<ApiResponse<MenuInfoDto>> getMenuInfo(@PathVariable String menuName) {
        try {
            MenuInfoDto menuInfo = menuInfoService.getMenuInfo(menuName);
            ApiResponse<MenuInfoDto> response = ApiResponse.onSuccess(menuInfo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<MenuInfoDto> errorResponse = ApiResponse.onFailure("에러코드", "에러 메시지", null);
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
