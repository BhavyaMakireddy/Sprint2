package com.cg.mts.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.entities.User;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Integer>{
	
    //TripBooking updateTripBookingByUserId(TripBooking savedTripBooking);
	
	List<TripBooking> getTripBookingByUser(User user);

	
    
}
