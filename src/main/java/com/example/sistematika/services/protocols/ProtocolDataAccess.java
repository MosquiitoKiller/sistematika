package com.example.sistematika.services.protocols;

import com.example.sistematika.entities.Protocol;

public interface ProtocolDataAccess {
    void save(Protocol protocol);
    Protocol getProtocolById(Long id);
}
