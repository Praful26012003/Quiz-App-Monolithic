package com.praful.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praful.quizapp.dao.QuestionDAO;
import com.praful.quizapp.dtos.QuestionWrapper;
import com.praful.quizapp.entity.Question;
import com.praful.quizapp.mappingDto.QuestionToWrapper;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public Question addQuestion(Question question) {
       return questionDAO.save(question);
    }

    public List<QuestionWrapper> getQuestionByCategory(String category, int numQ) {
        List<Question> questions = questionDAO.findQuestionByCategory(category, numQ);
        return QuestionToWrapper.questionToWrapper(questions);
    }
    
}
