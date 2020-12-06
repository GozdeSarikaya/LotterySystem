package com.mkyong.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOTTERY_PLAYER")
public class Player {

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    @NotNull
    private String firstName, lastName;

    @NotNull
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<Ticket> tickets;

    /**
     * Constructor
     */
    public Player() {
    }

    /**
     * Constructor
     *
     * @param firstName
     * @param lastName
     * @param email
     */
    public Player(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Constructor
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param tickets
     */
    public Player(String firstName, String lastName, String email, List<Ticket> tickets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tickets = tickets;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int id) {
        this.playerId = id;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}