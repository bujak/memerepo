package com.bujak.memesearch.controller;


import com.bujak.memesearch.dto.SearchRequest;
import com.bujak.memesearch.entity.Meme;
import com.bujak.memesearch.service.MemeService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private MemeService memeService;

    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @PostMapping("/find")
    public Set<Meme> find(@RequestBody SearchRequest request) {
        return memeService.find(request.getSearchPhrase());
    }
}
