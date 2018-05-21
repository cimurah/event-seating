package com.ticketmaster.api.repository;

import com.ticketmaster.api.model.Seat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatRepository extends JpaRepository<Seat, Long>{
  
    @Query("select s from Seat s JOIN s.event e where e.id = :eventId AND " 
            + "(:type is null or s.type = :type) AND (:aisle is null or s.aisle = :aisle) AND " 
            + "(:available is null or s.available = :available)")
    List<Seat> findByEventAndAttributes(@Param("eventId") UUID event_id, 
            @Param("type") Optional<Seat.SeatType> type, 
            @Param("aisle") Optional<Boolean> aisle,
            @Param("available") Optional<Boolean> available);
    
}
