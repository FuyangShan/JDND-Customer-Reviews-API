CREATE TABLE reviewsForProduct (
    'product_id' PRIMARY KEY,
    'review_id' FOREIGN KEY
);

CREATE TABLE commentsForReview (
    'review_id' PRIMARY KEY,
    'comment_id' FOREIGN KEY
);
