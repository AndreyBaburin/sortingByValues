package com.andrey_baburin.controller;

import com.andrey_baburin.services.Calculation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageRestController {

    private final Calculation calculation;

    public MessageRestController(Calculation calculation) {
        this.calculation = calculation;
    }

    @GetMapping
    public List<Map.Entry<Character, Integer>> getAllValues() {
        return calculation.convertAndSort();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody String value) {
        calculation.createPost(value);
    }

    @PutMapping
    public void update(String value) {
        calculation.updatePost(value);
    }

    @DeleteMapping
    public void delete() {
        calculation.delete();
    }

}
