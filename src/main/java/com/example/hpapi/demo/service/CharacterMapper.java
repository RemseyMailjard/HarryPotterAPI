package com.example.hpapi.demo.service;

import com.example.hpapi.demo.dto.CharacterResponseDto;
import com.example.hpapi.demo.dto.CreateCharacterRequestDto;
import com.example.hpapi.demo.model.Character;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CharacterMapper {

    // BELANGRIJK: De formatter moet overeenkomen met je databaseformaat (yyyy-MM-dd)
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CharacterResponseDto toDto(Character character) {
        if (character == null) {
            return null;
        }

        CharacterResponseDto dto = new CharacterResponseDto();

        // --- VUL ALLE VELDEN IN ---
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setHouse(character.getHouse());
        dto.setSpecies(character.getSpecies());
        dto.setGender(character.getGender());
        dto.setWizard(character.isWizard());
        dto.setAncestry(character.getAncestry());
        dto.setEyeColour(character.getEyeColour());
        dto.setHairColour(character.getHairColour());
        dto.setPatronus(character.getPatronus());
        dto.setHogwartsStudent(character.isHogwartsStudent());
        dto.setHogwartsStaff(character.isHogwartsStaff());
        dto.setActor(character.getActor());
        dto.setAlive(character.isAlive());
        dto.setImage(character.getImage());

        // Converteer de String datum uit de database naar een LocalDate voor de DTO
        if (character.getDateOfBirth() != null && !character.getDateOfBirth().isEmpty()) {
            try {
                dto.setDateOfBirth(LocalDate.parse(character.getDateOfBirth(), formatter));
            } catch (Exception e) {
                // Als het parsen mislukt, laat het veld null. Log eventueel de fout.
                System.err.println("Could not parse date: " + character.getDateOfBirth());
                dto.setDateOfBirth(null);
            }
        }

        return dto;
    }

    public Character toEntity(CreateCharacterRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Character character = new Character();

        // Genereer een ID voor het nieuwe character, want de client geeft deze niet mee
        character.setId(UUID.randomUUID());

        // --- VUL ALLE VELDEN IN ---
        character.setName(dto.getName());
        character.setHouse(dto.getHouse());
        character.setSpecies(dto.getSpecies());
        character.setGender(dto.getGender());
        character.setWizard(dto.getWizard());
        character.setAncestry(dto.getAncestry());
        character.setEyeColour(dto.getEyeColour());
        character.setHairColour(dto.getHairColour());
        character.setPatronus(dto.getPatronus());
        character.setHogwartsStudent(dto.getHogwartsStudent());
        character.setHogwartsStaff(dto.getHogwartsStaff());
        character.setActor(dto.getActor());
        character.setAlive(dto.getAlive());
        character.setImage(dto.getImage());

        // Converteer de LocalDate uit de DTO terug naar een String voor de database
        if (dto.getDateOfBirth() != null) {
            character.setDateOfBirth(dto.getDateOfBirth().format(formatter));
        }

        return character;
    }
}