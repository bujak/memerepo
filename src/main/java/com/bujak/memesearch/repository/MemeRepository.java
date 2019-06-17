package com.bujak.memesearch.repository;

import com.bujak.memesearch.entity.Meme;
import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends CrudRepository<Meme, String> {
}
