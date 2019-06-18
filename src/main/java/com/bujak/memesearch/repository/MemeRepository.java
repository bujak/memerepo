package com.bujak.memesearch.repository;

import com.bujak.memesearch.entity.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemeRepository extends MongoRepository<Meme, String> {

    List<Meme> findAll();
}
