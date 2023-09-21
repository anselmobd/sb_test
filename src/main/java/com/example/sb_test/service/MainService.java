package com.example.sb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.ListTopicsResponse;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private SnsClient snsClient;

    public String index() {
        return "O imundo!";
    }

    public String list_topics() {
        ListTopicsResponse list_topics = snsClient.listTopics();
        return list_topics.toString();
    }

}
