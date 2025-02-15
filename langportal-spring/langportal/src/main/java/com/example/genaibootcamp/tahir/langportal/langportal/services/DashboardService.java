package com.example.genaibootcamp.tahir.langportal.langportal.services;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.RecentSessionDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.StudySessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private StudySessionsRepository studySessionsRepository;

    public RecentSessionDTO getRecentSession() {
        return studySessionsRepository.findRecentSession();
    }
}