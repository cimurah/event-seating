package com.ticketmaster.api.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Event {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)") 
    private UUID id;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "event")
    @OnDelete(action=OnDeleteAction.CASCADE) 
    private Set<Seat> seats = new HashSet<>();
    
    public Event() { }
    
    public void setId(UUID id){
        this.id = id;
    }
    
    public UUID getId() {
        return id;
    }
        
    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
