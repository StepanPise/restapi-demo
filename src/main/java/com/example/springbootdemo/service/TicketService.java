package com.example.springbootdemo.service;


import com.example.springbootdemo.api.model.Event;
import com.example.springbootdemo.api.model.Ticket;
import com.example.springbootdemo.api.model.User;
import com.example.springbootdemo.repository.EventRepository;
import com.example.springbootdemo.repository.TicketRepository;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository =  userRepository;
        this.eventRepository = eventRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Integer id) {
        return ticketRepository.getReferenceById(id);
    }

    public List<Ticket> getUserTickets(Integer userId) {
        return ticketRepository.findByUserId(userId);
    }

    public List<Ticket> getEventTickets(Integer eventId) {
        return ticketRepository.findByEventId(eventId);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket buyTicket(Integer userId, Integer eventId, String seat) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setEvent(event);
        ticket.setSeat(seat);

        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
    }
}
