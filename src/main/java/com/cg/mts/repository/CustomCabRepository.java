package com.cg.mts.repository;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;

public interface CustomCabRepository {
	
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab , int perKmRate) throws CabNotFoundException;
	public Cab deleteCab(Cab cab,int id) throws CabNotFoundException;

}
