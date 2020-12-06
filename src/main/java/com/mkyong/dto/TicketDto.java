package com.mkyong.dto;

import com.mkyong.entity.Lottery;
import com.mkyong.entity.Player;
import com.mkyong.entity.Ticket;
import com.mkyong.repository.ILotteryRepository;
import com.mkyong.repository.IPlayerRepository;
import com.mkyong.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDto {

    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IPlayerRepository playerRepository;
    @Autowired
    private ILotteryRepository lotteryRepository;

    /**
     * Create new ticket
     *
     * @param playerId
     * @param lotteryId
     * @return Created ticket or null
     */
    public Ticket createTicket(int playerId, int lotteryId) {
        try {
            Player player = playerRepository.findPlayerByPlayerId(playerId);
            Lottery lottery = lotteryRepository.findLotteryByLotteryId(lotteryId);
            Ticket ticket = new Ticket(player, lottery);
            if (player != null)
                player.getTickets().add(ticket);
            if (lottery != null)
                lottery.getTickets().add(ticket);
            if (lottery != null && player != null)
                ticketRepository.save(ticket);
            return ticket;
        } catch (Exception e) {
            return null;
        }
    }
}
