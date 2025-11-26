package com.example.springbootdemo.repository;
import java.util.List;

import com.example.springbootdemo.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByUserId(Integer userId);
    List<Ticket> findByEventId(Integer eventId);
}