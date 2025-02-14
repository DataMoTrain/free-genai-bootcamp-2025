package com.example.genaibootcamp.tahir.langportal.langportal.services;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.WordDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.Words;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.WordGroups;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.Groups;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.WordsRepository;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.WordGroupsRepository;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.GroupsRepository;
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

    @Autowired
    private WordGroupsRepository wordGroupsRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    public void seedWordsData(String filePath, Integer groupId) {
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

            // Fetch the group entity
            Groups group = groupsRepository.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));

            // Create entries in the word_groups table
            wordsList.forEach(word -> {
                WordGroups wordGroup = new WordGroups(word, group);
                wordGroupsRepository.save(wordGroup);
            });

            System.out.println("Inserted seed data into words and word_groups tables.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}