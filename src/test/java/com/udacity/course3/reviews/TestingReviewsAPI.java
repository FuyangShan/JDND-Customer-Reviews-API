package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.repository.ProductsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestingReviewsAPI {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    @Before
    public void setUp() {
        //setup product
        Product mockProduct = new Product();
        mockProduct.setProductName("Funny Product");
        mockProduct.setMadeFrom("Japan");
        mockProduct.setInformation("Only for Children");
        productsRepository.save(mockProduct);

        //setup review
        Review mockReview = new Review();
        mockReview.setProduct(mockProduct);
        mockReview.setUserName("Fuyang");
        reviewsRepository.save(mockReview);

        //setup comment
        Comment comment1 = new Comment();
        comment1.setComment("This is first comment");
        comment1.setUserName("Fuyang");
        comment1.setReview(mockReview);

        Comment comment2 = new Comment();
        comment2.setUserName("Fuyang");
        comment2.setComment("This is second comment");
        comment2.setReview(mockReview);

        commentsRepository.save(comment1);
        commentsRepository.save(comment2);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testingReviewsRepository() {
        Optional<Review> actualReview = reviewsRepository.findById(1);
        actualReview.ifPresent(review -> Assert.assertEquals(Optional.ofNullable(review.getProduct()), productsRepository.findById(1)));
    }

    @Test
    public void testingCommentsRepository() {
        Optional<Comment> actualComment = commentsRepository.findById(1);
        actualComment.ifPresent(review -> Assert.assertEquals(Optional.ofNullable(actualComment.get().getComment()).get(), "This is first comment"));

        Optional<Comment> actualComment2 = commentsRepository.findById(2);
        actualComment2.ifPresent(review -> Assert.assertEquals(Optional.ofNullable(actualComment2.get().getComment()).get(), "This is second comment"));
    }

    @Test
    public void testingProductsRepository() {
        Optional<Product> actualProduct = productsRepository.findById(1);
        actualProduct.ifPresent(review -> Assert.assertEquals(Optional.ofNullable(actualProduct.get().getProductName()), "Funny Product"));
    }
}
