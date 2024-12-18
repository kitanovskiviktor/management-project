package com.example.managementproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<Listing> listings;

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setListings(List<Listing> listings){
        this.listings = listings;
    }

    public String getDescription(){
        return description;
    }

    public List<Listing> getListings(){
        return listings;
    }

}
