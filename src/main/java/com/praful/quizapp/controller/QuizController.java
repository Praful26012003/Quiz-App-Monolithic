package com.praful.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praful.quizapp.dtos.QuizReponse;
import com.praful.quizapp.dtos.QuizWrapper;
import com.praful.quizapp.dtos.ResultDTO;
import com.praful.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("/{id}")
    public QuizWrapper getQuiz(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/create")
    public String createQuiz(@RequestParam String title, @RequestParam String category, @RequestParam int numQ) {
        quizService.createQuiz(title, category, numQ);
        return "Quiz has been created Successfully";
    }

    @PostMapping("/submit/{id}")
    public ResultDTO fetchResult(@RequestBody QuizReponse quizReponse, @PathVariable Long id) {
        return quizService.fetchResult(quizReponse, id);
    }
}
