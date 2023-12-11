package com.chalim.backend.controller;

import com.chalim.backend.dto.openAi.MenuDetailsDto;
import com.chalim.backend.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/menuInfo")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuService;

    @GetMapping("/details")
    public ResponseEntity<MenuDetailsDto> getMenuDetails(@RequestParam String menuName, @RequestParam String language) {
        MenuDetailsDto details = menuService.getMenuDetails(menuName, language);
        return ResponseEntity.ok(details);
    }
}


