package com.example.springbootdemo.api.controller;

import com.example.springbootdemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TickerController {

    private final TicketService ticketService;

    @Autowired
    public TickerController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
