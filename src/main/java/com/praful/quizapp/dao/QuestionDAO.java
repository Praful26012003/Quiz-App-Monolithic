package com.praful.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praful.quizapp.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * from question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findQuestionByCategory(String category, int numQ);
}
