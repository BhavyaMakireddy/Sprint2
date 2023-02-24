package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabId;
	private String carType;
	private float perKmRate;
	
	public Cab(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

}
