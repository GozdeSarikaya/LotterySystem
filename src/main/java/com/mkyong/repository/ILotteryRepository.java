package com.mkyong.repository;

import com.mkyong.entity.Lottery;
import com.mkyong.entity.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ILotteryRepository extends CrudRepository<Lottery, Long> {

    @Query("SELECT l FROM Lottery l WHERE l.pullDate < :currentDate ORDER BY l.pullDate")
    List<Lottery> previousLotteries(Date currentDate);

    @Query("SELECT l FROM Lottery l WHERE l.pullDate > :currentDate ORDER BY l.pullDate")
    List<Lottery> nextLotteries(Date currentDate);

    @Query("SELECT l FROM Lottery l WHERE l.lotteryId = :lotteryId ORDER BY l.lotteryId")
    Lottery findLotteryByLotteryId(int lotteryId);
}

