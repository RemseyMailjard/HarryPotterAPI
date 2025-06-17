package com.example.hpapi.demo.controller;

import com.example.hpapi.demo.dto.CharacterResponseDto;
import com.example.hpapi.demo.dto.CreateCharacterRequestDto;
import com.example.hpapi.demo.service.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterResponseDto>> getAll(
            @RequestParam(required = false) String house) {

        List<CharacterResponseDto> characters = characterService.getAllCharacters(house);
        return ResponseEntity.ok(characters);
    }

    @PostMapping
    public ResponseEntity<CharacterResponseDto> create(@Valid @RequestBody CreateCharacterRequestDto createDto) {
        CharacterResponseDto newCharacter = characterService.createCharacter(createDto);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable UUID id) {
//        // TODO: Implementeer delete logica in CharacterService
//        return ResponseEntity.noContent().build();
//    }
}