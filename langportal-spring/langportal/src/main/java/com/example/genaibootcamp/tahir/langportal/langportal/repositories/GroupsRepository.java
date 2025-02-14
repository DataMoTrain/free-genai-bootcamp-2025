package com.example.genaibootcamp.tahir.langportal.langportal.repositories;

import com.example.genaibootcamp.tahir.langportal.langportal.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Groups g SET g.wordsCount = :wordsCount WHERE g.id = :groupId")
    void updateWordCount(Integer groupId, long wordsCount);
}