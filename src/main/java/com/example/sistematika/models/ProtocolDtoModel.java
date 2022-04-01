package com.example.sistematika.models;

import com.example.sistematika.entities.Protocol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolDtoModel {
    private String name;
    private Date date;
    private Integer numberOfVotersInList;
    private Integer ballotsRecievedByCommission;
    private Integer ballotsIssuedToEarly;
    private Integer ballotsIssuedInRoom;
    private Integer ballotsIssuedOutsideRoom;
    private Integer cancelledBallots;
    private Integer ballotsInPortableBoxes;
    private Integer ballotsInStationaryBoxes;
    private Integer invalidBallots;
    private Integer validBallots;
    private Integer lostBallots;
    private Integer notTakenBallots;

    public static ProtocolDtoModel mapping(Protocol protocol){
        return new ProtocolDtoModel(
                protocol.getName(),
                protocol.getDate(),
                protocol.getNumberOfVotersInList(),
                protocol.getBallotsRecievedByCommission(),
                protocol.getBallotsIssuedToEarly(),
                protocol.getBallotsIssuedInRoom(),
                protocol.getBallotsIssuedOutsideRoom(),
                protocol.getCancelledBallots(),
                protocol.getBallotsInPortableBoxes(),
                protocol.getBallotsInStationaryBoxes(),
                protocol.getInvalidBallots(),
                protocol.getValidBallots(),
                protocol.getLostBallots(),
                protocol.getNotTakenBallots()
        );
    }
}
