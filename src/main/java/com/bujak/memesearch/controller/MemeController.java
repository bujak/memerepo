package com.bujak.memesearch.controller;


import com.bujak.memesearch.entity.Meme;
import com.bujak.memesearch.service.MemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private MemeService memeService;

    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping("/find")
    public Set<Meme> find(@RequestParam(required = false) String id) {
        return memeService.find("malpa");
    }
}
