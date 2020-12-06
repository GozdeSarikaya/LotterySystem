package com.mkyong.service;

import com.mkyong.dto.LotteryDto;
import com.mkyong.dto.PlayerDto;
import com.mkyong.dto.TicketDto;
import com.mkyong.entity.Lottery;
import com.mkyong.entity.Player;
import com.mkyong.entity.Ticket;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {


    @NotNull
    private String firstName, lastName, email;
    private boolean signupConfirmed, signupFailed;

    @Autowired
    TicketDto ticketDto;
    @Autowired
    LotteryDto lotteryDto;
    @Autowired
    PlayerDto playerDto;

    /**
     * Constructor
     */
    public PlayerService() {
        signupConfirmed = false;
        signupFailed = false;
    }

    /**
     * Create a player and sign him/her up for the current lottery
     */
    public void signup() {
        Player player = null;
        Lottery lottery = null;
        if (playerDto != null) player = playerDto.createPlayer(firstName, lastName, email);
        if (lotteryDto != null) lottery = lotteryDto.getNextLottery();
        if (player != null && lottery != null) {
            Ticket ticket = ticketDto.createTicket(player.getPlayerId(), lottery.getLotteryId());
            if (ticket != null) {
                setSignupConfirmed(true);
            } else {
                setSignupFailed(false);
            }
        } else {
            setSignupFailed(true);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSignupConfirmed() {
        return signupConfirmed;
    }

    public void setSignupConfirmed(boolean signupConfirmed) {
        this.signupConfirmed = signupConfirmed;
    }

    public boolean isSignupFailed() {
        return signupFailed;
    }

    public void setSignupFailed(boolean signupFailed) {
        this.signupFailed = signupFailed;
    }


    public void createPlayer(String firstName, String lastName, String email) {
        playerDto.createPlayer(firstName, lastName, email);
    }
}
