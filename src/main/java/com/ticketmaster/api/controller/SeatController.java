package com.ticketmaster.api.controller;

import com.ticketmaster.api.model.*;
import com.ticketmaster.api.repository.*;
import com.ticketmaster.api.exception.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/events/{eventId}/seats")
    public List<Seat> getSeats(@PathVariable UUID eventId, 
            @RequestParam("type") Optional<Seat.SeatType> type, 
            @RequestParam("aisle") Optional<Boolean> aisle, 
            @RequestParam("available") Optional<Boolean> available) {
        
        this.validateEvent(eventId);
        
        return seatRepository.findByEventAndAttributes(eventId, type, aisle, available);
    }
    
    private void validateEvent(UUID eventId) {
		this.eventRepository.findById(eventId).orElseThrow(
				() -> new CustomNotFoundException("Event " + eventId + " Not Found."));
    }
}
