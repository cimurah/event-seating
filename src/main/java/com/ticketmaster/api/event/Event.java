package com.ticketmaster.api.event;

import com.ticketmaster.api.seat.Seat;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
//http://docs.jboss.org/hibernate/orm/5.0/userguide/html_single/Hibernate_User_Guide.html#identifiers
@Entity
public class Event {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "event")
    private Set<Seat> seats = new HashSet<>();
    
    public Event() { } // JPA only
    
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
