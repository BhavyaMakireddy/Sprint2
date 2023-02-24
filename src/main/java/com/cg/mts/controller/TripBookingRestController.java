package com.cg.mts.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.dto.TripBookingDTO;
import com.cg.mts.entities.Driver;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.entities.User;
import com.cg.mts.exception.InvalidUserException;
import com.cg.mts.exception.TripBookingNotFoundException;
import com.cg.mts.repository.IDriverRepository;
import com.cg.mts.repository.ITripBookingRepository;
import com.cg.mts.repository.IUserRepository;
import com.cg.mts.service.ITripBookingService;
import com.cg.mts.util.TripBookingDTOConverter;


@RestController
@RequestMapping("/api/tripbooking")
public class TripBookingRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ITripBookingService tripBookingService;
	
	@Autowired
	private ITripBookingRepository tripBookingRepository;
	
	@Autowired
	private IDriverRepository driverRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	TripBookingDTOConverter dtoConvertor;
	
	public TripBookingRestController() {
		logger.info("Trip booking Rest Controller called");
		System.err.println("Trip booking Rest Controller called");
	}
	
	
	@PostMapping("/register/{userId}/driver/{driverId}")
	public ResponseEntity<TripBookingDTO> saveTripBooking(@RequestBody TripBooking tripBooking,@PathVariable int userId, @PathVariable int driverId)
	{
		Driver savedDriver = driverRepository.getReferenceById(driverId);
		User savedUser = userRepository.getReferenceById(userId);
		tripBooking.setUser(savedUser);
		tripBooking.setDriver(savedDriver);
		TripBooking savedTrip = tripBookingService.insertTripBooking(tripBooking);
		logger.info(" --->> Trip saved "+savedTrip);
		TripBookingDTO dtoObj = dtoConvertor.convertTo(savedTrip);
		
		return new ResponseEntity<TripBookingDTO>(dtoObj,HttpStatus.OK);
	}
	
	
	@PutMapping("/updatetrip/{tid}/user/{uid}") 
	public String updateTripBookingByUserID(@RequestBody TripBooking tripBooking, @PathVariable int tripBookingId, @PathVariable int userId) throws TripBookingNotFoundException
	{
		TripBooking updatedTrip = tripBookingService.updateTripBookingByUserId(tripBooking, tripBookingId, userId);
		
		if(updatedTrip.getTripBookingId() != 0)
		{
			return updatedTrip.toString();
		}
		else return "error : - "+updatedTrip.toString()+" ";
	}
	
	/*@PutMapping("/updatetrip/{id}")
	public TripBooking updateTripBooking( @RequestBody TripBooking tripBooking, @PathVariable("id")int id) {
		return tripBookingService.updateTripBooking(tripBooking,id);
	}
	*/
	
	@DeleteMapping("/deletetrip/{id}")
	public TripBooking deleteTripBooking(  @PathVariable("id")int tripBookingId) {
		return tripBookingService.deleteTripBooking(tripBookingId);
	}
	
	
	@GetMapping("/alltripsbyuser/{id}")
	public ResponseEntity<List<TripBookingDTO>> getAllTrips( @PathVariable("id") int userId) throws InvalidUserException
	{
		List<TripBooking> allTripsInDB = tripBookingService.viewAllTripsUser(userId);
		
		List<TripBookingDTO> dtoList = new ArrayList<>();
		for (TripBooking tripBooking : allTripsInDB) {
			
			TripBookingDTO dtoObj = dtoConvertor.convertTo(tripBooking);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<TripBookingDTO>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/userbill/{id}")
	public float calculateBill( @PathVariable("id") int userId) {
		return tripBookingService.calculateBill(userId);
	}

}
