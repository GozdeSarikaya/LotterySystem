package com.mkyong.service;

import com.mkyong.dto.TicketDto;
import com.mkyong.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TicketService {

    @Autowired
    TicketDto ticketDto;
    private Ticket ticket;

    public Ticket createTicket(int playerId, int lotteryId) {
        ticketDto.createTicket(playerId, lotteryId);
        if (ticket != null) {
            return ticket;
        } else {
            return null;
        }
    }
    
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}
