package com.helen.belt.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="tvratings")
public class TvRating {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Min(1)
    @Max(5)
    private double score;
   
    //one user can create many ratings for different shows
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User ratingCreator;
	
	//one show can have many ratings
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	private Show showHasRating;
	
	

	public TvRating() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public User getRatingCreator() {
		return ratingCreator;
	}

	public void setRatingCreator(User ratingCreator) {
		this.ratingCreator = ratingCreator;
	}

	public Show getShowHasRating() {
		return showHasRating;
	}

	public void setShowHasRating(Show showHasRating) {
		this.showHasRating = showHasRating;
	}
	
	

    
    // standard constructors, getters, and setters
    
    
}