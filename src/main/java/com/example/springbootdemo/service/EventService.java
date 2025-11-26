package com.example.springbootdemo.service;


import com.example.springbootdemo.api.model.Event;
import com.example.springbootdemo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Integer id) {
        return eventRepository.getReferenceById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
