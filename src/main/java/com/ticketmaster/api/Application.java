package com.ticketmaster.api;

import com.ticketmaster.api.event.Event;
import com.ticketmaster.api.event.EventRepository;
import com.ticketmaster.api.seat.Seat;
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
    
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Event event = new Event();
        Seat seat1 = new Seat(true, false, Seat.SeatType.ADULT);
        seat1.setEvent(event);
        Seat seat2 = new Seat(true, false, Seat.SeatType.CHILD);
        seat2.setEvent(event);
        
        Set seats = new HashSet<Seat>(){{
            add(seat1);
            add(seat2);
        }};
        
        event.setSeats(seats);
        eventRepository.save(event);
        
    }
}


//https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
