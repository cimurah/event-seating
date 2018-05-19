package com.ticketmaster.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Seat{
    @Id
    @GeneratedValue
    private Long id;
    private SeatType type;
    private boolean aisle;
    private boolean available;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;
    
    private Seat() { } // JPA only
    
    public Seat(SeatType type, boolean aisle, boolean available){
        this.type = type;
        this.aisle = aisle;
        this.available = available;
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
    
    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
