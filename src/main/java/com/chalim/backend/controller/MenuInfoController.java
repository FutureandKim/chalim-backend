package com.chalim.backend.controller;

import com.chalim.backend.apiPayLoad.ApiResponse;
import com.chalim.backend.dto.MenuInfoDto;
import com.chalim.backend.service.MenuInfoService;
import com.chalim.backend.apiPayLoad.exception.GeneralException;
import com.chalim.backend.apiPayLoad.code.ErrorReasonDTO;
import com.chalim.backend.apiPayLoad.code.status.ErrorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @GetMapping("/info/{menuName}")
    public ResponseEntity<ApiResponse<MenuInfoDto>> getMenuInfo(@PathVariable String menuName) {
        MenuInfoDto menuInfo = menuInfoService.getMenuInfo(menuName);
        ApiResponse<MenuInfoDto> response = ApiResponse.onSuccess(menuInfo);
        return ResponseEntity.ok(response);
    }
}

