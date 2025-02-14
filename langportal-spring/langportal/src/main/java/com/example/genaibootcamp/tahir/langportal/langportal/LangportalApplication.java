package com.example.genaibootcamp.tahir.langportal.langportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Groups;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.GroupsRepository;
import com.example.genaibootcamp.tahir.langportal.langportal.services.WordsService;


@SpringBootApplication
public class LangportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangportalApplication.class, args);
	}

	 @Bean
    CommandLineRunner initDatabase(GroupsRepository groupsRepository) {
        return args -> {
            if (groupsRepository.count() == 0) {  // Only insert if database is empty
                groupsRepository.save(new Groups("Core Verbs"));
                groupsRepository.save(new Groups("Core Adjectives"));
                System.out.println("Inserted sample groups into database.");
            }
        };
    }
//langportal\src\main\java\com\example\genaibootcamp\tahir\langportal\langportal\seed
    @Bean
    CommandLineRunner seedAdjectives(WordsService wordsService) {
        return args -> {
            wordsService.seedWordsData("seed/data_adjectives.json");
        };
    }

    @Bean
    CommandLineRunner seedVerbs(WordsService wordsService) {
        return args -> {
            wordsService.seedWordsData("seed/data_verbs.json");
        }; //src/main/java/com/example/genaibootcamp/tahir/langportal/langportal/
    }
}
