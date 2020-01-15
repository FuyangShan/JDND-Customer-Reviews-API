package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentByCommentId(Integer comment_id);
    List<Comment> findAllByReviewReviewId(Integer review_id);

    List<Comment> deleteCommentByCommentId(Integer comment_id);
    List<Comment> addComments(Integer product_id, Integer review_id);


}
