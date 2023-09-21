package com.example.sb_test.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MainService {

    public String index() {
        return "O imundo!";
    }

    public List<String> list_topics() {
        return List.of("aa", "sss");
    }

}
