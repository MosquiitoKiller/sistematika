package com.example.sistematika.repositories;

import com.example.sistematika.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
