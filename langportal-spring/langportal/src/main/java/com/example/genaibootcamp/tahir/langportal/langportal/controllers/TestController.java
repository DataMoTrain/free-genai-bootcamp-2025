package com.example.genaibootcamp.tahir.langportal.langportal.controllers;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Words;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping("/test")
    public List<Words> getAllWords() {
        return wordsRepository.findAll();
    }
}