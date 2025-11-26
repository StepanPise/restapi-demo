package com.example.springbootdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketService ticketService;

    @Autowired
    public TicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
