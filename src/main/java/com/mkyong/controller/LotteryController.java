package com.mkyong.controller;

import com.mkyong.entity.Lottery;
import com.mkyong.entity.Ticket;
import com.mkyong.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class LotteryController {

    @Autowired
    LotteryService lotteryService;
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @PostMapping("/lottery/add")
    public ResponseEntity<Void> addLottery(@RequestParam(name = "date") String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lotteryService.createLottery(df.parse(date));
        return new ResponseEntity<>(CREATED);
    }

/*
    @GetMapping("/lottery/list")
    public ResponseEntity<Void> listLottery() throws ParseException {
        List<Lottery> availableLotteries = lotteryService.getAvailableLotteries();
        return new ResponseEntity<>(CREATED);
    }
*/

    @GetMapping("/lottery/list")
    public String lotterylist(Model model) {
        List<Lottery> availableLotteries = lotteryService.getAvailableLotteries();
        model.addAttribute("message", message);
        model.addAttribute("availableLotteries", availableLotteries);
        return "lotterylist"; //view
    }

    @GetMapping("/lottery/end")
    public ResponseEntity<Void> endLottery() {
        Ticket winningticket = lotteryService.endLottery();
        return new ResponseEntity<>(CREATED);
    }

/*    @GetMapping("/lottery/winners")
    public ResponseEntity<Void> winners() {
        List<Lottery> previousLotteries = lotteryService.getPreviousLotteries();
        return new ResponseEntity<>(CREATED);
    }*/

    @GetMapping("/lottery/winners")
    public String winners(Model model) {
        List<Lottery> previousLotteries = lotteryService.getPreviousLotteries();
        model.addAttribute("message", message);
        model.addAttribute("previousLotteries", previousLotteries);
        return "winners"; //view
    }

/*    @GetMapping("/test")
    public String main(Model model) {
        List<Lottery> previousLotteries = lotteryService.getPreviousLotteries();
        List<Lottery> availableLotteries = lotteryService.getAvailableLotteries();
        Ticket winningticket = lotteryService.endLottery();
        model.addAttribute("message", message);
        model.addAttribute("tasks", previousLotteries);

        return "welcome"; //view
    }*/

}
