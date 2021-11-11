package com.helen.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.belt.models.Show;
import com.helen.belt.models.TvRating;
import com.helen.belt.models.User;
import com.helen.belt.repositories.ShowRepository;
import com.helen.belt.repositories.TvRatingRepository;

@Service
public class ShowService {
@Autowired
private ShowRepository showRepo;


   public List<Show> getAllShows() {
	   return  showRepo.findAll();
   }
   
   //get one
   public Show getOneShow(Long id) {
	   return showRepo.findById(id).orElse(null);
   }
   
   //create a show
   public Show createShow(Show show) {
	   return this.showRepo.save(show);
   }
   
   //create a rating for a show
   public void ratingShow(User user, Show show, TvRating tvrating) {
	 
	   show.getRatingsCreatedForShow().add(tvrating);
	   tvrating.setRatingCreator(user);
	   tvrating.setShowHasRating(show);
	   this.showRepo.save(show);
   }
   //create average rating for a show
   
}
