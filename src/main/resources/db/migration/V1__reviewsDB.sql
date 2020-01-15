
CREATE TABLE product (
    `product_id` INT AUTO_INCREMENT PRIMARY KEY,
    `product_name` VARCHAR(30) NOT NULL,
    `information` TEXT NOT NULL,
    `madeFrom` VARCHAR(30) NOT NULL
);

CREATE TABLE review (
    `review_id` INT AUTO_INCREMENT PRIMARY KEY,
    `product_id` INT NOT NULL,
    `userName` VARCHAR(30) NOT NULL,
    `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `review` TEXT NOT NULL,
);

CREATE TABLE comment (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `review_id` INT NOT NULL,
    `userName` VARCHAR(30) NOT NULL,
    `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `comment` TEXT NOT NULL,
);
