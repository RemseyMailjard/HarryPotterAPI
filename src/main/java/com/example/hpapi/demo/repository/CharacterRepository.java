package com.example.hpapi.demo.repository;

import com.example.hpapi.demo.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {
}
