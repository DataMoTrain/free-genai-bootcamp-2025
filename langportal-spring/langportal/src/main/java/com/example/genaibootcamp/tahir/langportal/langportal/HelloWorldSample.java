package com.example.genaibootcamp.tahir.langportal.langportal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldSample {

    @GetMapping("/")
    public String hello()  {
        return "Hello World!";
    }
}
