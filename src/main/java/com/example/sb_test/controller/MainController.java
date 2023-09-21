package com.example.sb_test.controller;

import com.example.sb_test.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "api")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public String index() {
        return mainService.index();
    }

    @GetMapping("list-topics")
    public List<String> list_topics() {
        return mainService.list_topics();
    }

}