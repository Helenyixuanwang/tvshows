package com.helen.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.belt.models.TvRating;
import com.helen.belt.repositories.TvRatingRepository;

@Service
public class TvRatingService {
@Autowired
private TvRatingRepository tvRepo;

	public TvRating createNewRating(TvRating tvRating) {
		return this.tvRepo.save(tvRating);
	}
	
	//update a rating
	public TvRating updateRating(TvRating tvRating) {
		return this.tvRepo.save(tvRating);
	}
	
	//
	public List<TvRating> scoreOrder() {
		return tvRepo.findAllByOrderByScore();
	}
	
	
}
