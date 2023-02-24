package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.TripBookingDTO;
import com.cg.mts.entities.TripBooking;

@Component
public class TripBookingDTOConverter {
	
	public TripBookingDTO convertTo(TripBooking tripBooking)
	{
		
		return new TripBookingDTO(tripBooking.getFromLocation(), tripBooking.getToLocation(), tripBooking.getDistanceInKm());
	}
	
	public TripBookingDTO getTripBookingDTO(TripBooking t)
	{

		TripBookingDTO obj = new TripBookingDTO(t.getFromLocation(), t.getToLocation(), t.getDistanceInKm());
		return obj;
		
	}

}
