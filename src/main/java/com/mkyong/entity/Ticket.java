package com.mkyong.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOTTERY_TICKET")
public class Ticket {

    @Id
    @Column(name = "TICKET_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketNumber;

    @ManyToOne
    @JoinColumn(name = "PLAYER_ID")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "LOTTERY_ID")
    private Lottery lottery;

    @OneToOne(mappedBy = "winningTicket")
    private Lottery wonLottery;

    public Ticket() {
    }

    public Ticket(Player player, Lottery lottery) {
        this.player = player;
        this.lottery = lottery;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Lottery getWonLottery() {
        return wonLottery;
    }

    public void setWonLottery(Lottery wonLottery) {
        this.wonLottery = wonLottery;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", playerId=" + player.getPlayerId() +
                ", playerFirstName=" + player.getFirstName() +
                ", playerLastName=" + player.getLastName() +
                '}';
    }
}
