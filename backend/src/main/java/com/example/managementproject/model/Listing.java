package com.example.managementproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="listing")
@Getter
@Setter
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;
    private String location;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String description;

    private String contactInfo;

    private String services;

}
