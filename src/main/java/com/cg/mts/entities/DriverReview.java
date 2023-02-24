package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverReview {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;

	public String driverName;
	private int starRating;

	private String message;

	public DriverReview(String driverName, int starRating, 
			String message) {
		super();
		this.driverName = driverName;

		
		this.starRating = starRating;
	
		this.message = message;
	}

}
