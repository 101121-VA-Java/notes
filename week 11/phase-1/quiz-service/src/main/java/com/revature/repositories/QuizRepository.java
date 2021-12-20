package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
