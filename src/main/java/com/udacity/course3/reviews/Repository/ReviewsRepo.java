package com.udacity.course3.reviews.Repository;

import com.udacity.course3.reviews.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReviewsRepo extends JpaRepository<Review, Integer> {
    Set<Review> getAllByProduct_id(Integer product_id);
}
