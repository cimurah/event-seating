package com.ticketmaster.api.seat;

import org.springframework.data.repository.PagingAndSortingRepository;

//@Repository
//@RepositoryRestResource
public interface SeatRepository extends PagingAndSortingRepository<Seat, Long>{
    //public Iterable<Seat> findByAvailableTrue();
}
