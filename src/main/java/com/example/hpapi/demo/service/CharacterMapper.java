package com.example.hpapi.demo.service;

import com.example.hpapi.demo.dto.CharacterResponseDto;
import com.example.hpapi.demo.dto.CreateCharacterRequestDto;
import com.example.hpapi.demo.model.Character;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CharacterMapper {

    public CharacterResponseDto toDto(Character character) {
        CharacterResponseDto dto = new CharacterResponseDto();
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setHouse(character.getHouse());
        // ... set alle andere velden ...
        // Voorbeeld conversie van String naar LocalDate
        if (character.getDateOfBirth() != null && !character.getDateOfBirth().isEmpty()) {
            try {
                // Pas het formaat aan op basis van je data, bv "dd-MM-yyyy"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dto.setDateOfBirth(LocalDate.parse(character.getDateOfBirth(), formatter));
            } catch (Exception e) {
                // Handle parsing error if necessary
                dto.setDateOfBirth(null);
            }
        }
        return dto;
    }

    public Character toEntity(CreateCharacterRequestDto dto) {
        Character character = new Character();
        character.setName(dto.getName());
        character.setHouse(dto.getHouse());
        // ... set alle andere velden ...
        if (dto.getDateOfBirth() != null) {
            // Converteer LocalDate terug naar String voor de database
            character.setDateOfBirth(dto.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        return character;
    }
}