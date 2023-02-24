package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

@Service
public interface IDriverService {
	
	public List<Driver> insertDriver(Driver driver);
	public Driver updateDriver(Driver driver,int driverId)throws DriverNotFoundException;
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;
	public List<Driver>viewBestDrivers() throws DriverNotFoundException;
	public Driver viewDriver(int driverId) throws DriverNotFoundException;
	public List<Driver> getDriverByExperience(int experience) throws DriverNotFoundException;
	public List<Driver> getDriverByNativeLanguage(int language) throws DriverNotFoundException;
	List<Driver> displayAllDriver();

}
