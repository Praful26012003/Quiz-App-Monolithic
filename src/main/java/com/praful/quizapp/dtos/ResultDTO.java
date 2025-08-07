package com.praful.quizapp.dtos;

public class ResultDTO {
    private Long quizId;
    private String tilte;
    private int correctQuestion;
    private int totalQuestion;
    
    public Long getQuizId() {
        return quizId;
    }
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
    public String getTilte() {
        return tilte;
    }
    public void setTilte(String tilte) {
        this.tilte = tilte;
    }
    public int getCorrectQuestion() {
        return correctQuestion;
    }
    public void setCorrectQuestion(int correctQuestion) {
        this.correctQuestion = correctQuestion;
    }
    public int getTotalQuestion() {
        return totalQuestion;
    }
    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
    
}
