package com.example.sistematika.services.protocols;

import com.example.sistematika.models.PrecinctDtoModel;
import com.example.sistematika.models.ProtocolInputModel;
import org.springframework.stereotype.Component;

@Component
public interface ProtocolInputBoundary {
    AddProtocolResponseModel addProtocol(ProtocolInputModel protocolInputModel);
    PrecinctDtoModel formReportById(Long id);
}
