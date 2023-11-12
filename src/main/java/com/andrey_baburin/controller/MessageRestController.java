package com.andrey_baburin.controller;
import com.andrey_baburin.services.Calculation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageRestController {

    private final Calculation calculation;

    @GetMapping
    public @ResponseBody List<Map.Entry<Character, Integer>> getAllValues() {
        return calculation.convertAndSort();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody @Valid String value) {
        calculation.createPost(value);
    }

    @PutMapping
    public void update(@RequestBody String value) {
        calculation.updatePost(value);
    }

    @DeleteMapping
    public void delete() {
        calculation.delete();
    }


}
