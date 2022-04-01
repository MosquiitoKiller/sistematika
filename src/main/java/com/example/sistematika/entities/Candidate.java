package com.example.sistematika.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String middleName;
    private Integer voters;
    private Double percent;

    @ManyToOne
    private Precinct precinct;
}
