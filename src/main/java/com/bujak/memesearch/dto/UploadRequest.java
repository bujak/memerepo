package com.bujak.memesearch.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Data
public class UploadRequest {

    private String name;
    private Set<String> keywords;
    private MultipartFile file;
}
