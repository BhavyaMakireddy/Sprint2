package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.DriverReview;


@Repository
public interface IReviewRepository extends JpaRepository<DriverReview, Integer>{

	public DriverReview findById (int id);



	public List<DriverReview> findAllByDriverName(String driverName);

}
