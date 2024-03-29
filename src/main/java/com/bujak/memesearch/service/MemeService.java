package com.bujak.memesearch.service;

import com.bujak.memesearch.dto.UploadRequest;
import com.bujak.memesearch.entity.Meme;
import com.bujak.memesearch.repository.MemeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MemeService {

    private MemeRepository memeRepository;
    private AmazonClient amazonClient;


    public MemeService(AmazonClient amazonClient, MemeRepository memeRepository) {
        this.amazonClient = amazonClient;
        this.memeRepository = memeRepository;
    }

    public Meme createAndSave(UploadRequest uploadRequest) {
        var newMeme = Meme.builder().name(uploadRequest.getName())
                .keywords(uploadRequest.getKeywords())
                .link(amazonClient.uploadFile(uploadRequest.getFile()))
                .build();
        return memeRepository.save(newMeme);
    }

    public Set<Meme> find(String searchPhrase) {
        var phrases = Set.of(searchPhrase.split(" "));
        return memeRepository.
                findAllByNameContainsOrKeywordsContains(phrases, phrases);
    }
}
