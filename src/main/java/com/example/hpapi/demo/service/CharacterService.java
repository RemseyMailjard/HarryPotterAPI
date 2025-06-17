package com.example.hpapi.demo.service;

import com.example.hpapi.demo.dto.CharacterResponseDto;
import com.example.hpapi.demo.dto.CreateCharacterRequestDto;
import com.example.hpapi.demo.mapper.CharacterMapper;
import com.example.hpapi.demo.model.Character;
import com.example.hpapi.demo.repository.CharacterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    /**
     * Haalt alle characters op, optioneel gefilterd op huis.
     * @param house De naam van het huis om op te filteren (optioneel).
     * @return Een lijst van character DTOs.
     */
    public List<CharacterResponseDto> getAllCharacters(String house) {
        List<Character> characters;

        // Controleer of er een filter op 'house' is meegegeven.
        if (house != null && !house.isBlank()) {
            // Ja, filter op huis (case-insensitive).
            characters = characterRepository.findByHouseIgnoreCase(house);
        } else {
            // Nee, haal alle characters op.
            characters = characterRepository.findAll();
        }

        // Converteer de gevonden lijst van entities naar DTOs.
        return characters.stream()
                .map(characterMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Maakt een nieuw character aan op basis van de request DTO.
     */
    @Transactional
    public CharacterResponseDto createCharacter(CreateCharacterRequestDto createDto) {
        Character characterToSave = characterMapper.toEntity(createDto);
        Character savedCharacter = characterRepository.save(characterToSave);
        return characterMapper.toDto(savedCharacter);
    }
}