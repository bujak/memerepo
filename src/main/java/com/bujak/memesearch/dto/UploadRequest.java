package com.bujak.memesearch.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UploadRequest {

    private String name;
    private Set<String> keywords;

}
