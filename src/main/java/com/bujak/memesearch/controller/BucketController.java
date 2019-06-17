package com.bujak.memesearch.controller;

import com.bujak.memesearch.dto.UploadRequest;
import com.bujak.memesearch.entity.Meme;
import com.bujak.memesearch.service.MemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/storage")
public class BucketController {

    private MemeService memeService;

    BucketController(MemeService memeService) {
        this.memeService = memeService;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Meme> upload(UploadRequest uploadRequest) {
        Meme createdMeme = memeService.createAndSave(uploadRequest);
        return new ResponseEntity<>(createdMeme, HttpStatus.OK);
    }

}
