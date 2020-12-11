package com.magenic.mmomodernjava.controller;

import com.magenic.mmomodernjava.model.Question;
import com.magenic.mmomodernjava.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@RestController
public class HelloWorldController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/")
    public String index() {
        long maxQuestions = questionRepository.count();

        Random randomizer = new Random();
        int randomId = randomizer.nextInt((int) maxQuestions) + 1;
        long randomLong = randomId;
        Question question = questionRepository.findById(randomLong).get();
        String output = "Hello, World!<br>" + question.getDescription();
        return output;
    }

}