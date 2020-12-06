package com.mkyong.repository;

import com.mkyong.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends CrudRepository<Ticket, Long> {
}
