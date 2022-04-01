package com.example.sistematika.models;

import lombok.Data;

import java.util.List;

@Data
public class ProtocolInputModel {
    Long precinctId;
    ProtocolDtoModel protocol;
    List<CandidateDtoModel> candidateList;
}
