package com.sise.lengavanzado.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.lengavanzado.shared.BaseResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/saludar")
    public BaseResponse test() {
        
        return BaseResponse.error("No se encontró bd");
    }

}