package com.example.genaibootcamp.tahir.langportal.langportal.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.StudyActivityDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.entities.StudyActivities;
import com.example.genaibootcamp.tahir.langportal.langportal.repositories.StudyActivitiesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class StudyActivityService {
    @Autowired
    private StudyActivitiesRepository studyActivitiesRepository;

    public void seedStudyActivity(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = new ClassPathResource(filePath);
            InputStream inputStream = resource.getInputStream();
            List<StudyActivityDTO> studyActivityList = objectMapper.readValue(inputStream, new TypeReference<List<StudyActivityDTO>>() {});
            //studyActivitiesRepository.saveAll(studyActivityList);

            studyActivityList.forEach(studyActivityInput -> {
                StudyActivities studyActivity = new StudyActivities(studyActivityInput.getName(), studyActivityInput.getUrl(), studyActivityInput.getPreviewUrl());
                studyActivitiesRepository.save(studyActivity);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}