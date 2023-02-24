package com.cg.mts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IDriverService ids;
	

	public DriverController() {
		logger.info("Driver Controller called");
		System.err.println("------Driver Controller called-------");
	}
	@GetMapping("/display")
	public List<Driver> displayAllDrivers() {
		return ids.displayAllDriver();
	}

	@PostMapping("/register")
	public String insertDriver(@RequestBody Driver driver) {
	ids.insertDriver(driver);
	return "savedDriver";
	}
	
	@PutMapping("/update/{driverId}")
	public String updatedDriver(@PathVariable int driverId) throws DriverNotFoundException 
	{
		Driver updatedDriver = ids.viewDriver(driverId);
	return updatedDriver.toString();
	}
	
	@DeleteMapping("/delete/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d = ids.deleteDriver(driverId);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found To Delete!");
		}
		return d;
	}
	
	 @GetMapping("/bestdrivers")
	 public List<Driver> viewBestDrivers() throws DriverNotFoundException {
	  List<Driver> lis = null;
	  try {
	   lis = ids.viewBestDrivers();
	  } catch (Exception e) {
	   throw new DriverNotFoundException("Best Drivers List is Empty");
	  }
	  return lis;
	 }
	 
	 @GetMapping("/{driverId}")
		public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
			Driver driver = null;
			try {
				driver = ids.viewDriver(driverId);
			} catch (Exception e) {
				throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found!");
			}
			return driver;
		}
	 
	 @GetMapping("basedOnExperience/{experience}")
		public Driver getDriverByExperience(@PathVariable int experience) throws DriverNotFoundException {
			Driver driver = null;
			try {
				driver = ids.viewDriver(experience);
			} catch (Exception e) {
				throw new DriverNotFoundException("Driver with experience: " + experience + " Not Found!");
			}
			return driver;
		}


}
