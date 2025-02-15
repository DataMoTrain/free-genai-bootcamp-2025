package com.example.genaibootcamp.tahir.langportal.langportal.controllers;

import com.example.genaibootcamp.tahir.langportal.langportal.dto.RecentSessionDTO;
import com.example.genaibootcamp.tahir.langportal.langportal.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @CrossOrigin
    @GetMapping("/dashboard/recent-session")
    public RecentSessionDTO getRecentSession() {
        return dashboardService.getRecentSession();
    }
}