package com.cg.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
	
	int driverId;
	String licenceNo;
	float rating;
	String nativeLanguage;
	int experience ;

}
