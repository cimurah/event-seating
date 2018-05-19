package com.ticketmaster.api.repository;

import com.ticketmaster.api.model.Event;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, UUID>{
  
}
