package com.imir.backend.repository;

import com.example.studyflow.entity.Subject;
import com.example.studyflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByUser(User user);
}