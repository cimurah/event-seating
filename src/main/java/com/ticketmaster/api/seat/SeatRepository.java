package com.ticketmaster.api.seat;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//@Repository
//@RepositoryRestResource
public interface SeatRepository extends PagingAndSortingRepository<Seat, Long>{
    //public Iterable<Seat> findByAvailableTrue();
}
