package com.udacity.course3.reviews.Repository;

import com.udacity.course3.reviews.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentsRepo extends JpaRepository<Comment, Integer> {
    Set<Comment> getCommentsByReview_Id(Integer review_id);
}
