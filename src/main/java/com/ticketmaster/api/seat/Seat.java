package com.ticketmaster.api.seat;

public class Seat {
    private Long id;
    private boolean aisle;
    private SeatType type;
    public enum SeatType {
        ADULT,
        CHILD
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
     * @return the aisle
     */
    public boolean isAisle() {
        return aisle;
    }

    /**
     * @param aisle the aisle to set
     */
    public void setAisle(boolean aisle) {
        this.aisle = aisle;
    }

    /**
     * @return the type
     */
    public SeatType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(SeatType type) {
        this.type = type;
    }
}
