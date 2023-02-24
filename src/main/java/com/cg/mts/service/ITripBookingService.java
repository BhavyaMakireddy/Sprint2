package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.TripBookingNotFoundException;

@Service
public interface ITripBookingService {
	
	
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking deleteTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTripsUser(int userId);
	public float calculateBill(int userId);
	TripBooking viewTripBooking(int tripBookingId);
	TripBooking updateTripBookingByUserId(TripBooking tripBooking, int tripBookingId, int userId) throws TripBookingNotFoundException;
	

}
