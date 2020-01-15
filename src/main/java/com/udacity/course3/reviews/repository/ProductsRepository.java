package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Set<Product> saveProduct(Integer product_id);
    Product getProductByProduct_id(Integer product_id);
}
