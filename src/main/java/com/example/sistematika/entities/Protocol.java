package com.example.sistematika.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Protocol() {

    }

}
