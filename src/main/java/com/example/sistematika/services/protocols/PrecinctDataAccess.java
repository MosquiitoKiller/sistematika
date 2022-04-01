package com.example.sistematika.services.protocols;

import com.example.sistematika.entities.Precinct;

public interface PrecinctDataAccess {
    void save(Precinct precinct);
    Precinct getById(Long id);
}
