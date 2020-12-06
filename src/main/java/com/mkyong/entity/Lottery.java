package com.mkyong.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "LOTTERY_LOTTERY")
public class Lottery {

    @Id
    @Column(name = "LOTTERY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lotteryId;

    @NotNull
    @Column(unique = true)
    private Date pullDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "lottery")
    private List<Ticket> tickets;

    @OneToOne
    @JoinColumn(name = "WINNING_TICKET")
    private Ticket winningTicket;

    public Lottery() {
    }


    public Lottery(Date pullDate) {
        this.pullDate = pullDate;
    }

    public Lottery(Date pullDate, List<Ticket> tickets) {
        this.pullDate = pullDate;
        this.tickets = tickets;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Date getPullDate() {
        return pullDate;
    }

    public void setPullDate(Date pullDate) {
        this.pullDate = pullDate;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "lotteryId=" + lotteryId +
                ", pullDate=" + pullDate +
                ", ticketsCount=" + tickets.stream().count() +
                ", winningTicket=" + winningTicket +
                '}';
    }

    public List<Ticket> getTickets() {
        if (tickets != null) {
            return tickets;
        } else {
            return new ArrayList<>();
        }
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket getWinningTicket() {
        return winningTicket;
    }

    public void setWinningTicket(Ticket ticket) {
        this.winningTicket = ticket;
    }
}
