package com.example.sistematika.services.protocols;

import com.example.sistematika.models.PrecinctDtoModel;

public interface ProtocolOutputBoundary {
    AddProtocolResponseModel prepareSuccessAddProtocol();
    AddProtocolResponseModel prepareFailAddProtocol();
    PrecinctDtoModel prepareSuccessReport(PrecinctDtoModel precinctDto);
    PrecinctDtoModel prepareFailReport();
}
