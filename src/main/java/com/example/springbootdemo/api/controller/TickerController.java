package com.example.springbootdemo.api.controller;

import com.example.springbootdemo.api.model.Event;
import com.example.springbootdemo.api.model.Ticket;
import com.example.springbootdemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TickerController {

    private final TicketService ticketService;

    @Autowired
    public TickerController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Integer id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public Ticket buyTicket(@RequestParam Integer userId,
                            @RequestParam Integer eventId,
                            @RequestParam String seat){
        return ticketService.buyTicket(userId,eventId,seat);
    }

    //interni endpoint -> securee with spring security later
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }
}
