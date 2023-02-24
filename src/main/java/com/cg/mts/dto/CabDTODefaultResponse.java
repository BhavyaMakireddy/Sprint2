package com.cg.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CabDTODefaultResponse {
	
	private int cabId;
	private String carType;
	private float perKmRate;

}
