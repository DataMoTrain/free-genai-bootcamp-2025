package com.example.genaibootcamp.tahir.langportal.langportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Words;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {
}