package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.repository.ProductsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {
	//wire the

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ReviewsRepository reviewsRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void injectedComponentsAreNotNull(){
		Assert.assertNotNull(commentsRepository);
		assertThat(productsRepository).isNotNull();
		assertThat(reviewsRepository).isNotNull();
	}

	@Test
	public void testFindCommentsByReview() {
		//new the cases that needed for the test
		Review review = new Review();
		Set<Comment> testComments = new HashSet<Comment>;

		//testing
		Set<Comment> actual = commentsRepository.findAllByReview(review);
		assertThat(actual).isNotNull();
		assertEquals(review.getComments(), actual);
	}
}
