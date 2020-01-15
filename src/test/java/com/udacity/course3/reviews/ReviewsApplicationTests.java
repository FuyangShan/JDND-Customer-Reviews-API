package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.repository.ProductsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ReviewsRepository reviewsRepository;

	@Test
	public void contextLoads() {
		Review review = new Review();
		List<Comment> testComments = new ArrayList<>();

		//add arguments in comments;
		Comment comment = new Comment();
		comment.setComment("This is Fuyang Testing");
		comment.setUserName("Fuyang");
		comment.setCommentId(1);

		testComments.add(comment);

		//set the comments for review
		review.setReviewId(007);
		review.setComments(testComments);
		reviewsRepository.save(review);
		commentsRepository.save(comment);
	}

	@Test
	public void injectedComponentsAreNotNull(){
		Assert.assertNotNull(commentsRepository);
		Assert.assertNotNull(productsRepository);
		Assert.assertNotNull(reviewsRepository);
	}

	@Test
	public void testFindCommentsByReview() {
		Review actualReview = reviewsRepository.getOne(007);
		Assert.assertNotNull(actualReview);

		Comment actualComment = commentsRepository.getOne(1);
		Assert.assertNotNull(actualComment);
		Assert.assertEquals(actualComment.getComment(), "This is Fuyang Testing");
		Assert.assertEquals(actualComment.getUserName(), "Fuyang");
	}
}
