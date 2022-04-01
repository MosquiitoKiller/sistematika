package com.example.sistematika.models;

import com.example.sistematika.entities.Precinct;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PrecinctDtoModel {
    private Long id;
    private String name;
    private ProtocolDtoModel protocol;
    private List<CandidateDtoModel> candidates;

    public static PrecinctDtoModel mapping(Precinct precinct){
        return new PrecinctDtoModel(precinct.getId(),
                precinct.getName(),
                ProtocolDtoModel.mapping(precinct.getProtocol()),
                CandidateDtoModel.mappingList(precinct.getCandidates()));
    }
}
