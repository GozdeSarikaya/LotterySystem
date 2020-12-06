package com.mkyong.controller;


import com.mkyong.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/submit")
    public ResponseEntity<Void> addPlayer(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "email") String email) {

        playerService.createPlayer(firstName, lastName, email);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/signup")
    public String addPlayer() {
        return "signup";
    }
}
