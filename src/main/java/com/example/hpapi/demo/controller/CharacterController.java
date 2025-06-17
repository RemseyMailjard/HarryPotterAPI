package com.example.hpapi.demo.controller;

import com.example.hpapi.demo.repository.CharacterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository repo;

    public CharacterController(CharacterRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<com.example.hpapi.demo.model.Character> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public com.example.hpapi.demo.model.Character create(@RequestBody com.example.hpapi.demo.model.Character c) {
        return repo.save(c);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        repo.deleteById(id);
//    }
}
