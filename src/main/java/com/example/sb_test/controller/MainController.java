package com.example.sb_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "api")
public class MainController {

    @GetMapping
    public String index() {
        return "O imundo!";
    }

}