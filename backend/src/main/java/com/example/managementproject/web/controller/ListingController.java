package com.example.managementproject.web.controller;


import com.example.managementproject.dataTransferObject.ListingDTO;
import com.example.managementproject.model.Listing;
import com.example.managementproject.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public List<Listing> getListingsList(){
        return listingService.getListings();
    }

    @GetMapping("/category/{categoryName}")
    public List<Listing> getListingsByCategoryName(@PathVariable  String categoryName){
        return listingService.getListingsByCategoryName(categoryName);
    }

    @GetMapping("/location/{cityName}")
    public List<Listing> getListingsByLocationName(@PathVariable  String cityName){
        return listingService.getListingsByCityName(cityName);
    }

    @PostMapping("/add")
    public Listing addListing(@RequestBody ListingDTO listingDTO){
        return listingService.addListing(listingDTO);
    }


    @PutMapping("/edit/{id}")
    public Listing editListing(@PathVariable Long id, @RequestBody ListingDTO listingDTO) {
        return listingService.editListing(id, listingDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteListing(@PathVariable Long id){
        listingService.deleteListing(id);
    }
}
