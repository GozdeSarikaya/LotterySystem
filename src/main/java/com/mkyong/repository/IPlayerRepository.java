package com.mkyong.repository;

import com.mkyong.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.playerId = :playerId ORDER BY p.playerId")
    Player findPlayerByPlayerId(int playerId);
}
