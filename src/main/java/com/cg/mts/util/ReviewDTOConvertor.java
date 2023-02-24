package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.ReviewResponseDTO;
import com.cg.mts.entities.DriverReview;

@Component
public class ReviewDTOConvertor {
	
	public  ReviewResponseDTO   getReviewResponseDTO( DriverReview review)
	{
		
		ReviewResponseDTO dto=new  ReviewResponseDTO ();
		dto.setDriverName(review.getDriverName());
		dto.setStarRating(review.getStarRating());
		dto.setMessage("Review saved" );
		return dto;
	}

}
