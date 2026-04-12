package com.example.customfhir.controller;

import com.example.customfhir.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    HelloResponseDto hello() {
        return new HelloResponseDto("customfhir", "ok");
    }
}
