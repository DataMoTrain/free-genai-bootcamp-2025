package com.example.genaibootcamp.tahir.langportal.langportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LangportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangportalApplication.class, args);
	}

	// @Bean
    // CommandLineRunner initDatabase(UserRepository userRepository) {
    //     return args -> {
    //         if (userRepository.count() == 0) {  // Only insert if database is empty
    //             userRepository.save(new User("John Doe", "john@example.com"));
    //             userRepository.save(new User("Jane Doe", "jane@example.com"));
    //             System.out.println("Inserted sample users into database.");
    //         }
    //     };
    // }
}
