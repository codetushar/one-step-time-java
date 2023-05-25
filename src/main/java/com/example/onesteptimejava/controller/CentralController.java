package com.example.onesteptimejava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentralController {
    @GetMapping(value = "")
    public String main() {
        return "!!!OK!!!";
    }
}
