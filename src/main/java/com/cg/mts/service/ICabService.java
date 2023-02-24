package com.cg.mts.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;

@Service
public interface ICabService {
	
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab, int perKmRate);
	public List<Cab> getAllCab();
	public void DeleteCabbycabId(int cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
	
	

}
