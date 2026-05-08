package com.imir.backend.repository;

import com.imir.backend.entity.MicroCheckpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MicroCheckpointRepository extends JpaRepository<MicroCheckpoint, Long> {

    List<MicroCheckpoint> findByStudySessionIdOrderByCreatedAtAsc(Long studySessionId);
}