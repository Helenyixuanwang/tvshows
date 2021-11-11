package com.helen.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helen.belt.models.TvRating;

@Repository
public interface TvRatingRepository extends CrudRepository<TvRating, Long> {
   List<TvRating>  findAllByOrderByScore();
}
