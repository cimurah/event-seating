package com.ticketmaster.api.seat;

import com.ticketmaster.api.event.Event;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Seat{
    @Id
    @GeneratedValue
    private Long id;
    
    private boolean aisle;
    private boolean available;
    private SeatType type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Event event;
    
    private Seat() { } // JPA only
    
    public Seat(boolean aisle, boolean available, SeatType type){
        this.aisle = aisle;
        this.available = available;
        this.type = type;
    }
    
    public enum SeatType {
        ADULT,
        CHILD
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isAisle() {
        return aisle;
    }

    public void setAisle(boolean aisle) {
        this.aisle = aisle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
