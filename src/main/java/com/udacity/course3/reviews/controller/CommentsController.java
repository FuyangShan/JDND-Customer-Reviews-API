package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    // TODO: Wire needed JPA repositories here

    @Autowired
    CommentsRepository commentsRepository;
    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<Set<Comment>> createCommentForReview(@PathVariable("reviewId") String comment, Integer reviewId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        //Create a newComment
        Comment newComment = new Comment;
        newComment.setComment(comment);

        //add newComment into the set of comments
        Set<Comment> comments = CommentsRepository.getCommentsByReview_id(reviewId);
        comments.add(newComment);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<Comment> listCommentsForReview(@PathVariable("reviewId") String comment, Integer reviewId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        Set<Comment> commentsList = CommentsRepository.getCommentsByReview_id(reviewId);
        List<Comment> commentsReturn = new ArrayList<Comment>();

    }
}
