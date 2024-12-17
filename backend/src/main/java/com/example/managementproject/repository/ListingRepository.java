package com.example.managementproject.repository;

import com.example.managementproject.model.Category;
import com.example.managementproject.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByCategory(Category category);
    List<Listing> findByCity(String cityName);

}
