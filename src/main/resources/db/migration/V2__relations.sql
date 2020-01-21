ALTER TABLE review ADD FOREIGN KEY(product_id) REFERENCES product(product_id);

ALTER TABLE comment ADD FOREIGN KEY(review_id) REFERENCES review(review_id);
