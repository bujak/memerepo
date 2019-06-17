package com.bujak.memesearch.service;

import com.bujak.memesearch.dto.UploadRequest;
import com.bujak.memesearch.entity.Meme;
import com.bujak.memesearch.repository.MemeRepository;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    private MemeRepository memeRepository;
    private AmazonClient amazonClient;


    public MemeService(AmazonClient amazonClient, MemeRepository memeRepository) {
        this.amazonClient = amazonClient;
        this.memeRepository = memeRepository;
    }

    public Meme createAndSave(UploadRequest uploadRequest) {
        Meme newMeme = Meme.builder().name(uploadRequest.getName())
                .keywords(uploadRequest.getKeywords())
                .link(amazonClient.uploadFile(uploadRequest.getFile()))
                .build();
        return memeRepository.save(newMeme);
    }
}