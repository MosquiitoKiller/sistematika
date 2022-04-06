package com.example.sistematika.services.protocols;

import com.example.sistematika.models.PrecinctDtoModel;
import org.springframework.stereotype.Component;

@Component
public interface ProtocolInputBoundary {
    AddProtocolResponseModel addProtocol(ProtocolInputModel protocolInputModel);
    PrecinctDtoModel formReportById(Long id);
}
