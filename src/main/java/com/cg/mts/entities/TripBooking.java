package com.cg.mts.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripBookingId;
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "customerId" )
	private User user;
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "driverId")
	private Driver driver;
	
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	
	/*public TripBooking(String fromLocation, String toLocation, LocalDateTime fromDateTime, LocalDateTime toDateTime,
			boolean status, float distanceInKm, float bill) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
*/

	public TripBooking(User user, Driver driver, String fromLocation, String toLocation, LocalDateTime fromDateTime,
			LocalDateTime toDateTime, boolean status, float distanceInKm, float bill) {
		super();
		this.user = user;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}


	public TripBooking(int tripBookingId, String fromLocation, String toLocation, boolean status, float distanceInKm,
			float bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	
	
	
	
	

	

	

}
