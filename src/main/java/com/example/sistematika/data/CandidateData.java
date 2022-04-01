package com.example.sistematika.data;

import com.example.sistematika.entities.Candidate;
import com.example.sistematika.repositories.CandidateRepository;
import com.example.sistematika.services.protocols.CandidateDataAccess;

public class CandidateData implements CandidateDataAccess {
    private final CandidateRepository candidateRepository;

    public CandidateData(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public Candidate getById(Long id) {
        return candidateRepository.getById(id);
    }
}
