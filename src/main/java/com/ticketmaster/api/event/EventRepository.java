package com.ticketmaster.api.event;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
//https://docs.spring.io/spring-data/commons/docs/current/reference/html/#core.web.type-safe
public interface EventRepository extends PagingAndSortingRepository<Event, UUID>{

}
