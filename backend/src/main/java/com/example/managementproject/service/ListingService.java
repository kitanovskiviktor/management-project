package com.example.managementproject.service;

import com.example.managementproject.dataTransferObject.ListingDTO;
import com.example.managementproject.model.Listing;

import java.util.List;

public interface ListingService {
    List<Listing> getListings();
    List<Listing> getListingsByCategoryName(String categoryName);

    List<Listing> getListingsByCityName(String cityName);

    Listing addListing(ListingDTO listingDTO);

    Listing editListing(Long id, ListingDTO listingDTO);

    void deleteListing(Long id);

}