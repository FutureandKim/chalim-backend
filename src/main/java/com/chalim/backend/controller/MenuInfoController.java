package com.chalim.backend.controller;

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
    public ResponseEntity<MenuInfoDto> getMenuInfo(@PathVariable String menuName) {
        try {
            MenuInfoDto menuInfo = menuInfoService.getMenuInfo(menuName);
            return ResponseEntity.ok(menuInfo);
        } catch (Exception e) {
            // 에러 처리
            return ResponseEntity.internalServerError().build();
        }
    }
}


