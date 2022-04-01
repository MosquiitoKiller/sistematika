package com.example.sistematika.presenters;

import com.example.sistematika.models.PrecinctDtoModel;
import com.example.sistematika.services.protocols.AddProtocolResponseModel;
import com.example.sistematika.services.protocols.ProtocolOutputBoundary;

public class ProtocolPresenter implements ProtocolOutputBoundary {
    @Override
    public AddProtocolResponseModel prepareSuccessAddProtocol() {
        return new AddProtocolResponseModel(true);
    }

    @Override
    public AddProtocolResponseModel prepareFailAddProtocol() {
        return new AddProtocolResponseModel(false);
    }

    @Override
    public PrecinctDtoModel prepareSuccessReport(PrecinctDtoModel precinctDto) {
        return precinctDto;
    }

    @Override
    public PrecinctDtoModel prepareFailReport() {
        return null;
    }
}
