package com.example.hpapi.demo.repository;

import com.example.hpapi.demo.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {

    /**
     * Vindt alle characters die bij een specifiek huis horen, zonder rekening te houden met hoofdletters.
     * Spring Data JPA implementeert deze methode automatisch.
     * @param house De naam van het huis om op te filteren.
     * @return Een lijst van characters die bij het huis horen.
     */
    List<Character> findByHouseIgnoreCase(String house);
}