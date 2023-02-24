package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.CabDTODefaultResponse;
import com.cg.mts.entities.Cab;

@Component
public class CabDTOConvertor {
	
	public CabDTODefaultResponse convertTo(Cab cab)
	{
		
		return new CabDTODefaultResponse(cab.getCabId(), cab.getCarType(), cab.getPerKmRate());
	}

}
