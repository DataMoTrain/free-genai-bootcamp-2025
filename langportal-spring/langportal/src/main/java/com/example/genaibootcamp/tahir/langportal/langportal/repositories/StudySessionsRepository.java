package com.example.genaibootcamp.tahir.langportal.langportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.RecentSessionDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.StudySessions;

@Repository
public interface StudySessionsRepository extends JpaRepository<StudySessions, Integer> {

    @Query("SELECT new com.example.genaibootcamp.tahir.langportal.langportal.dto.RecentSessionDTO(" +
            "ss.id, ss.group.id, sa.name, ss.createdAt, " +
            "SUM(CASE WHEN wri.correct = true THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN wri.correct = false THEN 1 ELSE 0 END)) " +
            "FROM StudySessions ss " +
            "JOIN ss.studyActivity sa ON ss.studyActivity.id = sa.id " +
            "LEFT JOIN WordReviewItems wri ON ss.id = wri.studySession.id " +
            "GROUP BY ss.id " +
            "ORDER BY ss.createdAt DESC LIMIT 1")
    RecentSessionDTO findRecentSession();

}