package com.magenic.mmomodernjava;

import com.magenic.mmomodernjava.model.Question;
import com.magenic.mmomodernjava.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MmoModernJavaApplication {
    private static Logger logger = LoggerFactory.getLogger(MmoModernJavaApplication.class);

    @Autowired
    QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(MmoModernJavaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        logger.info("Number of questions: " + questionRepository.count());

        Question newQuestion = new Question();
        newQuestion.setTitle("First Question");
        newQuestion.setDescription("How are you today?");
        this.questionRepository.save(newQuestion);

        logger.info("Saving new customer...");

        logger.info("Number of customers: " + questionRepository.count());

        Question newQuestion1 = new Question();
        newQuestion1.setTitle("Second Question");
        newQuestion1.setDescription("Have you taken PTO?");
        this.questionRepository.save(newQuestion1);

        logger.info("Saving new customer...");

        logger.info("Number of customers: " + questionRepository.count());
    }

}
