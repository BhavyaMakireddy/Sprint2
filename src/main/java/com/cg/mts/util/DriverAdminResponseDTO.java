package com.cg.mts.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverAdminResponseDTO {
	
	int driverId;
	 String licenceNo;
	 float rating;
	 String nativeLanguage;
	 int experience;
	 public void setMsg(String string) {
		// TODO Auto-generated method stub
		
	}

}
