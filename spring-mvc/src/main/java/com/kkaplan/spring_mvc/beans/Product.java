package com.kkaplan.spring_mvc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    private int id;

    private String name;
    private String description;
    private int rating;
    private int noOfReviews;
    private String color;
    private int categoryId;
    private int robotId;
    private String imagePath;
    private int price;
}
