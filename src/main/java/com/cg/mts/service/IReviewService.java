package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.DriverReview;

@Service
public interface IReviewService {
	public List<DriverReview> listallReviews();
	public DriverReview addReview(DriverReview review);
	public List<DriverReview> getReviewByDriverName(String driverName);

}
