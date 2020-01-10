package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    @NotNull
    private String productName;
    @NotNull
    private String information;
    @NotNull
    private String madeFrom;

    //get all reviews of one product
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getMadeFrom() {
        return madeFrom;
    }

    public void setMadeFrom(String madeFrom) {
        this.madeFrom = madeFrom;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
