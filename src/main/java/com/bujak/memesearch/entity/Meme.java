package com.bujak.memesearch.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Builder
@Data
@Document
public class Meme {

    @Id
    public String id;
    private String name;
    private Set<String> keywords;
    private String link;

}
