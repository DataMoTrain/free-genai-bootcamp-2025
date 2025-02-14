package com.example.genaibootcamp.tahir.langportal.langportal.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Groups;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.GroupsRepository;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.WordsRepository;
import com.example.genaibootcamp.tahir.langportal.langportal.services.StudyActivityService;
import com.example.genaibootcamp.tahir.langportal.langportal.services.WordsService;

@Configuration
public class DataSeeder {

    @Bean
    @Order(1)
    CommandLineRunner initDatabase(GroupsRepository groupsRepository) {
        return args -> {
            if (groupsRepository.count() == 0) {  // Only insert if database is empty
                groupsRepository.save(new Groups("Core Verbs"));
                groupsRepository.save(new Groups("Core Adjectives"));
                System.out.println("Inserted sample groups into database.");
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner seedAdjectives(WordsService wordsService, WordsRepository wordsRepository) {
        return args -> {
                wordsService.seedWordsData("seed/data_adjectives.json", 2);
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner seedVerbs(WordsService wordsService, WordsRepository wordsRepository) {
        return args -> {
                wordsService.seedWordsData("seed/data_verbs.json", 1);
        };
    }

    @Bean
    @Order(4)
    CommandLineRunner updateWordCountAdjectives(GroupsRepository groupsRepository, WordsRepository wordsRepository) {
        return args -> {
            long wordCount = wordsRepository.countByGroupId(2);
            groupsRepository.updateWordCount(2, wordCount);
            System.out.println("Updated word count for group with ID 2.");
        };
    }

    @Bean
    @Order(5)
    CommandLineRunner updateWordCountVerbs(GroupsRepository groupsRepository, WordsRepository wordsRepository) {
        return args -> {
            long wordCount = wordsRepository.countByGroupId(1);
            groupsRepository.updateWordCount(1, wordCount);
            System.out.println("Updated word count for group with ID 1.");
        };
    }

    @Bean
    @Order(6)
    CommandLineRunner seedStudyActivities(StudyActivityService studyActivityService) {
        return args -> {
            studyActivityService.seedStudyActivity("seed/study_activities.json");
        };
    }


}