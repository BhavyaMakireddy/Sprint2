package com.cg.mts.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.repository.ITripBookingRepository;
import com.cg.mts.service.TripBookingServiceImpl;

class TripBookingServiceImplTest {
	
	@InjectMocks   // use on which class to test
	TripBookingServiceImpl tripBookingServiceImpl;
	
	@Mock
	ITripBookingRepository tripRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void doInit()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test case to test insertion of Course when input values are valid")
	void testAddTripBooking() {
		// sample input 
		TripBooking sampleInput = new TripBooking(0,"Marthahalli","Whitefield",true,4.0f,6.5f);
		// expected output 
		TripBooking actualOutput = new TripBooking(0,"Marthahalli","Whitefield",true,4.0f,6.5f);
		actualOutput.setTripBookingId(0);
		//actualOutput.setDriverId(0);
		//actualOutput.setCabId(0);
	
		
		TripBooking expectedOutput = new TripBooking(0,"Marthahalli","Whitefield",true,4.0f,6.5f);
		expectedOutput.setTripBookingId(0);
		//expectedOutput.setDriverId(0);
		//expectedOutput.setCabId(0);
		
		// call actual method and store actual result : actual output
		
		when(tripRepository.save(sampleInput)).thenReturn(actualOutput);
		
			
		// compare actual output with expected output
		assertEquals(actualOutput, expectedOutput);
		
	}

	
	
	
	
	@Test
	@DisplayName("Test case to test insertion of Course when input values are invalid")
	void testAddTripBooking2() {
		TripBooking sampleInput = new TripBooking(0,"Marthahalli","Whitefield",true,4.0f,6.5f);
		
		// call actual method and store actual result : actual output
		
		when(tripRepository.save(sampleInput)).thenThrow(NullPointerException.class);
		
		
	}

	


}
