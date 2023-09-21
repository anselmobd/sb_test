package com.example.sb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.ListTopicsResponse;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private SnsClient snsClient;

    @Autowired
    private DynamoDbClient dynamoDbClient;

    public String index() {
        return "O imundo!";
    }

    public String list_topics() {
        ListTopicsResponse list_topics = snsClient.listTopics();
        return list_topics.toString();
    }

    public String listAllTables(){

        boolean moreTables = true;
        String lastName = null;

        while(moreTables) {
            try {
                ListTablesResponse response;
                if (lastName == null) {
                    ListTablesRequest request = ListTablesRequest.builder().build();
                    response = dynamoDbClient.listTables(request);
                } else {
                    ListTablesRequest request = ListTablesRequest.builder()
                            .exclusiveStartTableName(lastName).build();
                    response = dynamoDbClient.listTables(request);
                }

                List<String> tableNames = response.tableNames();
                if (!tableNames.isEmpty()) {
                    for (String curName : tableNames) {
//                        System.out.format("* %s\n", curName);
                        return curName;
                    }
                } else {
//                    System.out.println("No tables found!");
                    return "No tables found!";
//                    System.exit(0);
                }

                lastName = response.lastEvaluatedTableName();
                if (lastName == null) {
                    moreTables = false;
                }

            } catch (DynamoDbException e) {
//                System.err.println(e.getMessage());
//                System.exit(1);
                return e.getMessage();
            }
        }
//        System.out.println("\nDone!");
        return "Done!";
    }

}
