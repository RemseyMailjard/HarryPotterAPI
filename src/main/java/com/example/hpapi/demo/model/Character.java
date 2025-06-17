package com.example.hpapi.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "Characters", schema = "GTA")
@Getter
@Setter
public class Character {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;

    private String name;
    private String house;
    private String species;
    private String gender;
    private String dateOfBirth;
    private boolean wizard;
    private String ancestry;
    private String eyeColour;
    private String hairColour;
    private String patronus;
    private boolean hogwartsStudent;
    private boolean hogwartsStaff;
    private String actor;
    private boolean alive;
    private String image;

    // Alle handmatige getters en setters kunnen nu weg!
}