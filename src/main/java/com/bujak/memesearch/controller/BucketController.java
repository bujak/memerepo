package com.bujak.memesearch.controller;

import com.bujak.memesearch.service.AmazonClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
public class BucketController {

    private AmazonClient amazonClient;

    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/upload")
    public String upload(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestPart(value = "url") String fileUrl) {
        this.amazonClient.deleteFile(fileUrl);
    }

}
