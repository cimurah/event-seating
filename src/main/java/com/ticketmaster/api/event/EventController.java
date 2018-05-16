package com.ticketmaster.api.event;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/events")
public class EventController {
    private final EventRepository eventRepository;
//    
    @Autowired
	EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
//    @GetMapping
//    public ResponseEntity<List<Event>> getAllArticles() {
//        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
//       // return new Event(counter.incrementAndGet(), LocalDate.parse("2018-11-16"));
//    }
}
