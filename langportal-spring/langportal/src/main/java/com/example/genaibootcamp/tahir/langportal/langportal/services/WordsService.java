package com.example.genaibootcamp.tahir.langportal.langportal.services;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.WordDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.Words;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.WordsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordsService {

    @Autowired
    private WordsRepository wordsRepository;

    public void seedWordsData(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = new ClassPathResource(filePath);
            InputStream inputStream = resource.getInputStream();
            List<WordDTO> wordDTOList = objectMapper.readValue(inputStream, new TypeReference<List<WordDTO>>() {});
            List<Words> wordsList = wordDTOList.stream()
                    .map(dto -> {
                        try {
                            String partsJson = objectMapper.writeValueAsString(dto.getParts());
                            return new Words(dto.getJapanese(), dto.getRomaji(), dto.getEnglish(), partsJson);
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to convert parts to JSON", e);
                        }
                    })
                    .collect(Collectors.toList());
            wordsRepository.saveAll(wordsList);
            System.out.println("Inserted seed data into words table.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}