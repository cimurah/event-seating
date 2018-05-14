package com.ticketmaster.api.event;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/event")
    public Event event(@RequestParam(value="date", defaultValue="World") String name) {
        return new Event(counter.incrementAndGet(), LocalDate.parse("2018-11-16"));
    }
}
