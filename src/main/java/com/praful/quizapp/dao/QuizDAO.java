package com.praful.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praful.quizapp.entity.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Long> {
    
}
