package com.example.springbootdemo.api.controller;

import com.example.springbootdemo.api.model.Ticket;
import com.example.springbootdemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
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

    @GetMapping("/user/{id}")
    public List<Ticket> getUserTickets(@PathVariable Integer id) {
        return ticketService.getUserTickets(id);
    }

    @GetMapping("/event/{id}")
    public List<Ticket> getEventTickets(@PathVariable Integer id) {
        return ticketService.getEventTickets(id);
    }

    //request param in url -> later make DTO
    //http://localhost:8080/tickets/buy?userId=1&eventId=1&seat=B1 -> example
    @PostMapping("/buy")
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

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Integer id) {
        ticketService.deleteTicket(id);
    }
}
