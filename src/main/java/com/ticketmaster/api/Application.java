package com.ticketmaster.api;

import com.ticketmaster.api.model.*;
import com.ticketmaster.api.repository.EventRepository;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
    private EventRepository eventRepository;
    
    public static void main( String[] args ){
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        //add events and seats to database
        Event event = new Event();
        Seat seat1 = new Seat(Seat.SeatType.ADULT, true, false);
        seat1.setEvent(event);
        Seat seat2 = new Seat(Seat.SeatType.CHILD, false, false);
        seat2.setEvent(event);
        
        Seat seat3 = new Seat(Seat.SeatType.CHILD, true, false);
        seat3.setEvent(event);
        
        Set seatsSet = new HashSet<Seat>(){{
            add(seat1);
            add(seat2);
            add(seat3);
        }};
        
        event.setSeats(seatsSet);
        eventRepository.save(event);
        
        Event event2 = new Event();
        Seat seat4 = new Seat(Seat.SeatType.ADULT, true, true);
        seat4.setEvent(event2);
        
        Seat seat5 = new Seat(Seat.SeatType.CHILD, true, false);
        seat5.setEvent(event2);
        
        Seat seat6 = new Seat(Seat.SeatType.CHILD, true, false);
        seat6.setEvent(event2);
        
        Set seatsSet2 = new HashSet<Seat>(){{
            add(seat4);
            add(seat5);
            add(seat6);
        }};
        
        event2.setSeats(seatsSet2);
        eventRepository.save(event2);
    }
}
