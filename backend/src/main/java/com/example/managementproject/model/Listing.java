package com.example.managementproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String description;

    private String contactInfo;

    private String services;

}
