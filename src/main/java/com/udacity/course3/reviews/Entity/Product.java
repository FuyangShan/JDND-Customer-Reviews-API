package com.udacity.course3.reviews.Entity;

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
    private String companyName;

    //get all reviews of one product
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;
}
