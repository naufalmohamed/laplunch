package com.stackroute.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
public class DbSequence {
    @Id
    private String id;
    private int seq;
}