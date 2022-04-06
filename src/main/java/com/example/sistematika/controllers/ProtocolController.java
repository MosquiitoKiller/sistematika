package com.example.sistematika.controllers;

import com.example.sistematika.models.PrecinctDtoModel;
import com.example.sistematika.services.protocols.ProtocolInputModel;
import com.example.sistematika.services.protocols.AddProtocolResponseModel;
import com.example.sistematika.services.protocols.ProtocolInputBoundary;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProtocolController {

    private final ProtocolInputBoundary protocolInputBoundary;

    public ProtocolController(ProtocolInputBoundary protocolInputBoundary) {
        this.protocolInputBoundary = protocolInputBoundary;
    }

    @PostMapping("/protocols")
    public AddProtocolResponseModel addProtocol(@RequestBody ProtocolInputModel protocol){
        return protocolInputBoundary.addProtocol(protocol);
    }

    @GetMapping("/protocols/{id}")
    public PrecinctDtoModel getProtocol(@PathVariable Long id){
        return protocolInputBoundary.formReportById(id);
    }
}
