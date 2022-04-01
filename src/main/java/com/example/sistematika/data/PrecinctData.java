package com.example.sistematika.data;

import com.example.sistematika.entities.Precinct;
import com.example.sistematika.repositories.PrecinctRepository;
import com.example.sistematika.services.protocols.PrecinctDataAccess;

public class PrecinctData implements PrecinctDataAccess {

    private final PrecinctRepository precinctRepository;

    public PrecinctData(PrecinctRepository precinctRepository) {
        this.precinctRepository = precinctRepository;
    }

    @Override
    public Precinct getById(Long id) {
        return precinctRepository.getById(id);
    }

    @Override
    public void save(Precinct precinct) {
        precinctRepository.save(precinct);
    }
}
