package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data; 

@Entity
@Table(name = "books")
@Data // Lombok annotation to automatically generate Getters, Setters, and Constructors
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String genre;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Double price;

    private String description;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "image_url")
    private String imageUrl;
}