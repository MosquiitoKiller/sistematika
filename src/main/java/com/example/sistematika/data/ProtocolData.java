package com.example.sistematika.data;

import com.example.sistematika.entities.Protocol;
import com.example.sistematika.repositories.ProtocolRepository;
import com.example.sistematika.services.protocols.ProtocolDataAccess;

public class ProtocolData implements ProtocolDataAccess {
    private final ProtocolRepository protocolRepository;

    public ProtocolData(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }


    @Override
    public void save(Protocol protocol) {
        protocolRepository.save(protocol);
    }

    @Override
    public Protocol getProtocolById(Long id) {
        return protocolRepository.getById(id);
    }
}
