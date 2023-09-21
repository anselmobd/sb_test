package com.example.sb_test.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String index() {
        return "O imundo!";
    }

}
