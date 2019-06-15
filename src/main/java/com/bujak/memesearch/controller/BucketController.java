package com.bujak.memesearch.controller;

import com.bujak.memesearch.dto.UploadRequest;
import com.bujak.memesearch.service.AmazonClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/storage")
public class BucketController {

    private AmazonClient amazonClient;

    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestPart("file") MultipartFile file,
                         @RequestPart("meme") String uploadRequest) throws IOException {
        log.info(uploadRequest.toString());
        ObjectMapper mapper = new ObjectMapper();
        UploadRequest request = mapper.readValue(uploadRequest, UploadRequest.class);
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestPart(value = "url") String fileUrl) {
        this.amazonClient.deleteFile(fileUrl);
    }

}
