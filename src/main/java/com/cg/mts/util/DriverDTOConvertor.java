package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.DriverDTO;
import com.cg.mts.entities.Driver;

@Component
public class DriverDTOConvertor {

	public DriverAdminResponseDTO getCourseAdminResponseDTO(Driver driver)
	{
		DriverAdminResponseDTO dto = new DriverAdminResponseDTO();
		dto.setDriverId(driver.getDriverId());
		dto.setLicenceNo(driver.getLicenceNo());
		dto.setRating(driver.getRating());
		dto.setNativeLanguage(driver.getNativeLanguage());
		dto.setExperience(driver.getExperience());
		dto.setMsg("Driver Saved");
		return dto;
	}
	
	public DriverDTO getDriverDTO(Driver d)
	{

		DriverDTO obj = new DriverDTO(d.getDriverId(),d.getLicenceNo(),d.getRating(),d.getNativeLanguage(),d.getExperience());
		return obj;
		
	}
	
}
