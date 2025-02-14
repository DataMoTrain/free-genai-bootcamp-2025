package com.example.genaibootcamp.tahir.langportal.langportal.repositories;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {

    @Query("SELECT COUNT(w) FROM Words w JOIN WordGroups wg ON w.id = wg.word.id WHERE wg.group.id = :groupId")
    long countByGroupId(Integer groupId);
}