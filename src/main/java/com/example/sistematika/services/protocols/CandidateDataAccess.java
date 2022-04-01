package com.example.sistematika.services.protocols;

import com.example.sistematika.entities.Candidate;

public interface CandidateDataAccess {
    void save(Candidate candidate);
    Candidate getById(Long id);
}
