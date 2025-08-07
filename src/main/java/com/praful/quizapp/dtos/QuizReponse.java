package com.praful.quizapp.dtos;

import java.util.List;

public class QuizReponse {
    private List<QuestionResponse> questionResponses;

    public List<QuestionResponse> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(List<QuestionResponse> questionResponses) {
        this.questionResponses = questionResponses;
    }
    
}
