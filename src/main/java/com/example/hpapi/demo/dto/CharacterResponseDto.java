package com.example.hpapi.demo.dto;

import lombok.Data; // Voeg Lombok toe voor minder boilerplate code
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO voor het representeren van een Character in API responses.
 * Deze klasse definieert de data die naar de client wordt gestuurd.
 */
@Data // Genereert automatisch getters, setters, toString(), equals() en hashCode()
public class CharacterResponseDto {

    private UUID id;
    private String name;
    private String house;
    private String species;
    private String gender;
    private LocalDate dateOfBirth; // Gebruik LocalDate voor datums
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
}