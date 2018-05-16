package com.ticketmaster.api.event;

import com.ticketmaster.api.seat.Seat;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
public class Event {

  //  @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private final UUID uniqueId = UUID.randomUUID();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "event")
    private Set<Seat> seats = new HashSet<>();
    
    public Event() { } // JPA only
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public UUID getUniqueId() {
        return uniqueId;
    }
    
    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
