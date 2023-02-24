package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Cab;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.entities.User;
//import com.cg.mts.exception.TripBookingNotFoundException;
import com.cg.mts.repository.ICabRepository;

import com.cg.mts.repository.IDriverRepository;
import com.cg.mts.repository.ITripBookingRepository;
import com.cg.mts.repository.IUserRepository;

@Service
public class TripBookingServiceImpl implements ITripBookingService {

	@Autowired
	private ITripBookingRepository tripBookingRepository;
	
	@Autowired
	private IUserRepository userRepository;

	/*@Autowired
	private IDriverRepository  driverRepository;
	
	@Autowired
	private ICabRepository cabRepository;
    */
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		
		return tripBookingRepository.save(tripBooking);

	}

	@Override
	public TripBooking updateTripBookingByUserId(TripBooking tripBooking, int tripBookingId, int userId) {
		
		TripBooking trip = tripBookingRepository.getReferenceById(tripBookingId);
        User savedUser = userRepository.getReferenceById(userId);
		TripBooking savedTripBooking = tripBookingRepository.getReferenceById(tripBookingId);
		
		/*if( savedTripBooking != null & savedUser !=null)
		{
			TripBooking updatedTripBooking = tripBookingRepository.updateTripBookingByUserId(savedTripBooking);
			tripBookingRepository.save(updatedTripBooking); // if data is already saved then hibernate calls update query in background
			return updatedTripBooking;
		}
		else return null;
		*/
		return null;
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		
		TripBooking tripBooking=tripBookingRepository.findById(tripBookingId).get();
		tripBookingRepository.deleteById(tripBookingId);
		return tripBooking;

	}

	@Override
	public List<TripBooking> viewAllTripsUser(int userId) {
		
		User savedUser = userRepository.getReferenceById(userId);
		List<TripBooking> abc = tripBookingRepository.getTripBookingByUser(savedUser);
		return abc;
	}
	
	@Override
	public TripBooking viewTripBooking(int tripBookingId) {
		return tripBookingRepository.getReferenceById(tripBookingId);
	}

	@Override
	public float calculateBill(int userId) {
		
		TripBooking tripBooking = new TripBooking();
		Cab cab = new Cab();
		float distance = tripBooking.getDistanceInKm();
		float price = cab.getPerKmRate();
		float bill = distance * price;
		return bill;
	}

	

	
		
	

}
