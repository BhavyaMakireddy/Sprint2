package com.cg.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBookingDTO {
	
	private String fromLocation;
	private String toLocation;
	private float distanceInKm;

}
