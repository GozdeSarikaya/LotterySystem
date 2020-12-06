package com.mkyong.service;

import com.mkyong.dto.LotteryDto;
import com.mkyong.entity.Lottery;
import com.mkyong.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LotteryService {

    LotteryDto lotteryDto;

    @Autowired
    public LotteryService(LotteryDto lotteryDto) {
        this.lotteryDto = lotteryDto;
        //initialize();
    }

    public void initialize() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lotteryDto.createLottery(df.parse("2020-12-6 18:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 19:10:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 19:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 20:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 20:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 21:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 21:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 22:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 22:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 23:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-6 23:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-7 00:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-7 00:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-7 01:00:00"));
        lotteryDto.createLottery(df.parse("2020-12-7 01:30:00"));
        lotteryDto.createLottery(df.parse("2020-12-7 02:00:00"));
    }

    /**
     * Randomly pulls a winner for the current lottery.
     * Fetches the next lottery.
     */
    public Ticket endLottery() {
        Ticket ticket = null;
        if (lotteryDto != null) {
            ticket = lotteryDto.pullWinner();
            lotteryDto.fetchNextLottery();
        }

        return ticket;
    }

    /**
     * @return Pulldate of lottery
     */
    public String getDate() {
        Lottery lottery = null;
        if (lotteryDto != null)
            lottery = lotteryDto.getNextLottery();

        if (lottery != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = lottery.getPullDate();
            return df.format(date);
        } else {
            return null;
        }
    }

    public List<Lottery> getPreviousLotteries() {
        return lotteryDto.getPreviousLotteries();
    }

    public List<Lottery> getAvailableLotteries() {
        return lotteryDto.getAvailableLotteries();
    }

    public void createLottery(Date date) {
        lotteryDto.createLottery(date);
    }

}
