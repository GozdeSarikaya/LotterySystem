package com.mkyong.controller;

import com.mkyong.service.PlayerService;
import com.mkyong.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/ticket/add")
    public ResponseEntity<Void> addTicket(
            @RequestParam(name = "playerId") int playerId,
            @RequestParam(name = "lotteryId") int lotteryId) {

        ticketService.createTicket(playerId, lotteryId);
        return new ResponseEntity<>(CREATED);
    }

}
