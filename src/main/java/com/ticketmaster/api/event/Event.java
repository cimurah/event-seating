package com.ticketmaster.api.event;

import java.time.LocalDate;

public class Event {
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
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
