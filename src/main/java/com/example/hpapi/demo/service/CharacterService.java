package com.example.hpapi.demo.service;

import com.example.hpapi.demo.dto.CharacterResponseDto;
import com.example.hpapi.demo.dto.CreateCharacterRequestDto;
import com.example.hpapi.demo.model.Character;
import com.example.hpapi.demo.repository.CharacterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Lombok: maakt automatisch een constructor met alle final velden
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    /**
     * Haalt alle characters op en converteert ze naar DTOs.
     */
    public List<CharacterResponseDto> getAllCharacters() {
        return characterRepository.findAll()
                .stream()
                .map(characterMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Maakt een nieuw character aan op basis van de request DTO.
     */
    @Transactional
    public CharacterResponseDto createCharacter(CreateCharacterRequestDto createDto) {
        // 1. Converteer de DTO naar een Entity
        Character characterToSave = characterMapper.toEntity(createDto);

        // 2. Sla de entity op in de database
        Character savedCharacter = characterRepository.save(characterToSave);

        // 3. Converteer de opgeslagen entity terug naar een response DTO en retourneer deze
        return characterMapper.toDto(savedCharacter);
    }
}