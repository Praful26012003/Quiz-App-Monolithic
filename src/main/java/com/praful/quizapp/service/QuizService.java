package com.praful.quizapp.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.praful.quizapp.dao.QuestionDAO;
import com.praful.quizapp.dao.QuizDAO;
import com.praful.quizapp.dtos.QuestionResponse;
import com.praful.quizapp.dtos.QuizReponse;
import com.praful.quizapp.dtos.QuizWrapper;
import com.praful.quizapp.dtos.ResultDTO;
import com.praful.quizapp.entity.Question;
import com.praful.quizapp.entity.Quiz;
import com.praful.quizapp.mappingDto.QuestionToWrapper;

@Service
public class QuizService {

    QuizDAO quizDAO;
    QuestionDAO questionDAO;

    public QuizService(QuizDAO quizDAO, QuestionDAO questionDAO) {
        this.quizDAO = quizDAO;
        this.questionDAO = questionDAO;
    }

    public void createQuiz(String title, String category, int numQ) {
        List<Question> questions = questionDAO.findQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
    }

    public QuizWrapper getQuiz(Long id) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        QuizWrapper quizWrapper = new QuizWrapper();
        quizWrapper.setId(quiz.getId());
        quizWrapper.setTitle(quiz.getTitle());
        quizWrapper.setQuestions(QuestionToWrapper.questionToWrapper(questions));
        return quizWrapper;
    }

    public ResultDTO fetchResult(QuizReponse quizReponse, Long id) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int correct = 0;
        List<QuestionResponse> reponses = quizReponse.getQuestionResponses();

        for (Question q : questions) {
            for (QuestionResponse r : reponses) {
                if(q.getId() == r.getId()) {
                    if(q.getCorrectAnswer().equals(r.getAnswer())) {
                        correct++;
                    }
                }
            }
        }
        
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setQuizId(quiz.getId());
        resultDTO.setTilte(quiz.getTitle());
        resultDTO.setCorrectQuestion(correct);
        resultDTO.setTotalQuestion(questions.size());
        return resultDTO;
    }

}
