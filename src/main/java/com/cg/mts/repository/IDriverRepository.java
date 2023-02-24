package com.cg.mts.repository;


import java.util.List;

import javax.transaction.Transactional;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer>{

	//Driver getDriverId(int driverId);

}
