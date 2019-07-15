package com.bujak.memesearch.repository;

import com.bujak.memesearch.entity.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface MemeRepository extends MongoRepository<Meme, String> {

    List<Meme> findAll();
    Set<Meme> findAllByNameContainsOrKeywordsContains(Set<String> words, Set<String> names);

}
