package com.example.sistematika.models;

import com.example.sistematika.entities.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CandidateDtoModel {
    private Long id;
    private String name;
    private String surname;
    private String middleName;
    private Integer voters;
    private String percent;

    public static CandidateDtoModel mapping(Candidate candidate){
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        return new CandidateDtoModel(
                candidate.getId(),
                candidate.getName(),
                candidate.getSurname(),
                candidate.getMiddleName(),
                candidate.getVoters(),
                decimalFormat.format(candidate.getPercent())
        );
    }

    public static List<CandidateDtoModel> mappingList(List<Candidate> candidates){
        List<CandidateDtoModel> candidateDtoModels = new ArrayList<>();
        for (Candidate c :candidates) {
            candidateDtoModels.add(mapping(c));
        }
        return candidateDtoModels;
    }
}
