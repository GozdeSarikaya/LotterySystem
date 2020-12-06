package com.mkyong.dto;

import com.mkyong.entity.Lottery;
import com.mkyong.entity.Ticket;
import com.mkyong.repository.ILotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class LotteryDto {

    @Autowired
    private ILotteryRepository lotteryRepository;

    private Lottery nextLottery;

    /**
     * Create new lottery
     *
     * @param pullDate
     * @return Created lottery or null
     */
    public Lottery createLottery(Date pullDate) {
        try {
            Lottery lottery = new Lottery(pullDate);
            lotteryRepository.save(lottery);
            return lottery;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Fetches the next lottery from the database
     */
    public void fetchNextLottery() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = format.format(new Date());
            Date date = format.parse(dateString);
            nextLottery = lotteryRepository.nextLotteries(date).get(0);
        } catch (NoResultException | ParseException e) {

        }
    }

    /**
     * Fetches the next lottery from the database
     */
    public List<Lottery> getAvailableLotteries() {
        List<Lottery> listOfAvailableLotteries = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = format.format(new Date());
            Date date = format.parse(dateString);
            listOfAvailableLotteries = lotteryRepository.nextLotteries(date);
        } catch (NoResultException | ParseException e) {

        }

        return listOfAvailableLotteries;
    }

    public Lottery getNextLottery() {
        if (nextLottery == null)
            fetchNextLottery();
        return nextLottery;
    }

    /**
     * Randomly pulls a winning ticket from the current lottery
     *
     * @return Winning ticket
     */
    public Ticket pullWinner() {
        try {
            List<Ticket> tickets;
            Ticket winner = null;
            Lottery lottery = lotteryRepository.findLotteryByLotteryId(getNextLottery().getLotteryId());
            if (lottery != null) {
                tickets = lottery.getTickets();
                if (tickets.size() > 0) {
                    if (lottery.getWinningTicket() == null) {
                        Random random = new Random();
                        int i = random.nextInt(tickets.size());
                        winner = tickets.get(i);
                        lottery.setWinningTicket(winner);
                        winner.setWonLottery(lottery);
                        lotteryRepository.save(lottery);
                    } else
                        winner = lottery.getWinningTicket();
                }
            }

            return winner;
        } catch (NullPointerException | IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * @return List of lotteries that have ended or null
     */
    public List<Lottery> getPreviousLotteries() {
        List<Lottery> listOfPreviousLotteries = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = format.format(new Date());
            Date date = format.parse(dateString);
            listOfPreviousLotteries = lotteryRepository.previousLotteries(date);
        } catch (NoResultException | ParseException e) {
            return null;
        }

        return listOfPreviousLotteries;
    }

    public long getAllLotteries() {
        try {
            return lotteryRepository.count();
        } catch (NoResultException e) {
            return 0;
        }
    }
}
