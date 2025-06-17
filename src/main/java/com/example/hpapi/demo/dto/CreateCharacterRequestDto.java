package com.example.hpapi.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO voor het aanmaken van een nieuw Character.
 * Deze klasse wordt gebruikt als request body en bevat validatieregels.
 */
@Data
public class CreateCharacterRequestDto {

    // De ID wordt niet door de client opgegeven, dus die staat hier niet in.

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String house; // Kan leeg zijn, dus geen @NotBlank

    @NotBlank(message = "Species is mandatory")
    private String species;

    private String gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Wizard status is mandatory")
    private Boolean wizard;

    private String ancestry;
    private String eyeColour;
    private String hairColour;
    private String patronus;

    @NotNull(message = "Hogwarts student status is mandatory")
    private Boolean hogwartsStudent;

    @NotNull(message = "Hogwarts staff status is mandatory")
    private Boolean hogwartsStaff;

    private String actor;

    @NotNull(message = "Alive status is mandatory")
    private Boolean alive;

    private String image;
}
