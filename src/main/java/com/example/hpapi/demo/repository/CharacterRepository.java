package com.example.hpapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<com.example.hpapi.demo.model.Character, Long> {
}
