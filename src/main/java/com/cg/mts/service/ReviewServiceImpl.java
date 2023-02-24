package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.DriverReview;
import com.cg.mts.exception.ReviewNotFoundException;
import com.cg.mts.repository.IReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	IReviewRepository reviewRepository;
	@Override
	public List<DriverReview> listallReviews() {
		// TODO Auto-generated method stub
		List<DriverReview> myList = reviewRepository.findAll();

		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		else
			return myList;
	}

		
	

	@Override
	public DriverReview addReview(DriverReview review) {
		// TODO Auto-generated method stub
		
		return reviewRepository.save(review);
	}

	@Override
	public List<DriverReview> getReviewByDriverName(String driverName) {
		// TODO Auto-generated method stub
		return reviewRepository.findAllByDriverName(driverName);
	}

}
