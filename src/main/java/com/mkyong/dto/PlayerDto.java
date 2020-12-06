package com.mkyong.dto;

import com.mkyong.entity.Player;
import com.mkyong.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerDto {

    @Autowired
    private IPlayerRepository playerRepository;

    /**
     * Creates a new player
     *
     * @param firstName
     * @param lastName
     * @param email
     * @return Create player or null
     */
    public Player createPlayer(String firstName, String lastName, String email) {
        try {
            Player player = new Player(firstName, lastName, email);
            playerRepository.save(player);
            return player;
        } catch (Exception e) {
            return null;
        }
    }
}
