package com.ticketmaster.api.event;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    
    public Event(long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
