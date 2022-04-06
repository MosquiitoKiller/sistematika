package com.example.sistematika.services.protocols;

import com.example.sistematika.models.CandidateDtoModel;
import com.example.sistematika.models.ProtocolDtoModel;
import lombok.Data;

import java.util.List;

@Data
public class ProtocolInputModel {
    Long precinctId;
    ProtocolDtoModel protocol;
    List<CandidateDtoModel> candidateList;
}
