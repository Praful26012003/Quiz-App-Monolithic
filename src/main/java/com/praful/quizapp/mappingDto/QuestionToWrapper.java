package com.praful.quizapp.mappingDto;

import java.util.ArrayList;
import java.util.List;

import com.praful.quizapp.dtos.QuestionWrapper;
import com.praful.quizapp.entity.Question;

public class QuestionToWrapper {
    public static List<QuestionWrapper> questionToWrapper(List<Question> questions) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for(Question question : questions) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestion(), question.getCategory()
            , question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionWrappers.add(questionWrapper);
        }
        return questionWrappers;
    }
}
