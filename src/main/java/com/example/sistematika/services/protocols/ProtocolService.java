package com.example.sistematika.services.protocols;

import com.example.sistematika.entities.Candidate;
import com.example.sistematika.entities.Precinct;
import com.example.sistematika.entities.Protocol;
import com.example.sistematika.models.CandidateDtoModel;
import com.example.sistematika.models.PrecinctDtoModel;
import com.example.sistematika.models.ProtocolDtoModel;
import com.example.sistematika.models.ProtocolInputModel;

import java.util.ArrayList;
import java.util.List;

public class ProtocolService implements ProtocolInputBoundary{
    private final ProtocolDataAccess protocolDataAccess;
    private final PrecinctDataAccess precinctDataAccess;
    private final CandidateDataAccess candidateDataAccess;
    private final ProtocolOutputBoundary protocolOutputBoundary;

    public ProtocolService(ProtocolDataAccess protocolDataAccess,
                           PrecinctDataAccess precinctDataAccess,
                           CandidateDataAccess candidateDataAccess,
                           ProtocolOutputBoundary protocolOutputBoundary) {
        this.protocolDataAccess = protocolDataAccess;
        this.precinctDataAccess = precinctDataAccess;
        this.candidateDataAccess = candidateDataAccess;
        this.protocolOutputBoundary = protocolOutputBoundary;
    }

    @Override
    public AddProtocolResponseModel addProtocol(ProtocolInputModel protocolInputModel) {
        ProtocolDtoModel protocolDtoModel = protocolInputModel.getProtocol();
        if (protocolInputModel.getPrecinctId()==null
                ||protocolInputModel.getCandidateList()==null
                ||protocolDtoModel.getName()==null
                ||protocolDtoModel.getDate()==null
                ||protocolDtoModel.getNumberOfVotersInList()==null
                ||protocolDtoModel.getBallotsRecievedByCommission()==null
                ||protocolDtoModel.getBallotsIssuedToEarly()==null
                ||protocolDtoModel.getBallotsIssuedInRoom()==null
                ||protocolDtoModel.getBallotsIssuedOutsideRoom()==null
                ||protocolDtoModel.getCancelledBallots()==null
                ||protocolDtoModel.getBallotsInPortableBoxes()==null
                ||protocolDtoModel.getBallotsInStationaryBoxes()==null
                ||protocolDtoModel.getInvalidBallots()==null
                ||protocolDtoModel.getValidBallots()==null
                ||protocolDtoModel.getLostBallots()==null
                ||protocolDtoModel.getNotTakenBallots()==null)
            return protocolOutputBoundary.prepareFailAddProtocol();
        Protocol protocol = new Protocol();
        protocol.setName(protocolDtoModel.getName());
        protocol.setDate(protocolDtoModel.getDate());
        protocol.setNumberOfVotersInList(protocolDtoModel.getNumberOfVotersInList());
        protocol.setBallotsRecievedByCommission(protocolDtoModel.getBallotsRecievedByCommission());
        protocol.setBallotsIssuedToEarly(protocolDtoModel.getBallotsIssuedToEarly());
        protocol.setBallotsIssuedInRoom(protocolDtoModel.getBallotsIssuedInRoom());
        protocol.setBallotsIssuedOutsideRoom(protocolDtoModel.getBallotsIssuedOutsideRoom());
        protocol.setCancelledBallots(protocolDtoModel.getCancelledBallots());
        protocol.setBallotsInPortableBoxes(protocolDtoModel.getBallotsInPortableBoxes());
        protocol.setBallotsInStationaryBoxes(protocolDtoModel.getBallotsInStationaryBoxes());
        protocol.setInvalidBallots(protocolDtoModel.getInvalidBallots());
        protocol.setValidBallots(protocolDtoModel.getValidBallots());
        protocol.setLostBallots(protocolDtoModel.getLostBallots());
        protocol.setNotTakenBallots(protocolDtoModel.getNotTakenBallots());

        protocolDataAccess.save(protocol);
        Precinct precinct = precinctDataAccess.getById(protocolInputModel.getPrecinctId());
        precinct.setProtocol(protocol);
        for (CandidateDtoModel candidateDto: protocolInputModel.getCandidateList()){
            Candidate candidate = candidateDataAccess.getById(candidateDto.getId());
            if (candidate != null) {
                candidate.setVoters(candidateDto.getVoters());
                candidate.setPercent(((double)candidate.getVoters()/(protocol.getBallotsInStationaryBoxes()+protocol.getBallotsInPortableBoxes())*100));
                candidateDataAccess.save(candidate);
                precinct.getCandidates().add(candidate);
            }
        }
        precinctDataAccess.save(precinct);
        return protocolOutputBoundary.prepareSuccessAddProtocol();
    }

    @Override
    public PrecinctDtoModel formReportById(Long id) {
        Precinct precinct = precinctDataAccess.getById(id);
        if(precinct==null) return protocolOutputBoundary.prepareFailReport();
        else return protocolOutputBoundary.prepareSuccessReport(PrecinctDtoModel.mapping(precinct));
    }
}
