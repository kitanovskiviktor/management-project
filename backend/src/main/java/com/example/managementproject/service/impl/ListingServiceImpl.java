package com.example.managementproject.service.impl;

import com.example.managementproject.dataTransferObject.ListingDTO;
import com.example.managementproject.model.Category;
import com.example.managementproject.model.Listing;
import com.example.managementproject.repository.CategoryRepository;
import com.example.managementproject.repository.ListingRepository;
import com.example.managementproject.service.ListingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final CategoryRepository categoryRepository;

    ListingServiceImpl(ListingRepository listingRepository, CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> getListings(){
        return listingRepository.findAll();
    }

    @Override
    public List<Listing> getListingsByCategoryName(String categoryname){
        Category category = categoryRepository.findByName(categoryname);
        return listingRepository.findByCategory(category);
    }

    @Override
    public List<Listing> getListingsByCityName(String cityName){
        return listingRepository.findByCity(cityName);
    }

    @Override
    public Listing addListing(ListingDTO listingDTO){
        Category category = categoryRepository.findById(listingDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Listing newListing = new Listing();
        newListing.setName(listingDTO.getName());
        newListing.setCity(listingDTO.getCity());
        newListing.setLocation(listingDTO.getLocation());
        newListing.setCategory(category);
        newListing.setDescription(listingDTO.getDescription());
        newListing.setContactInfo(listingDTO.getContactInfo());
        newListing.setServices(listingDTO.getServices());
        return listingRepository.save(newListing);
    }

    @Override
    public Listing editListing(Long id, ListingDTO listingDTO){
        Listing existingListing = listingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Listing not found"));

        existingListing.setName(listingDTO.getName());
        existingListing.setCity(listingDTO.getCity());
        existingListing.setLocation(listingDTO.getLocation());
        existingListing.setDescription(listingDTO.getDescription());
        existingListing.setContactInfo(listingDTO.getContactInfo());
        existingListing.setServices(listingDTO.getServices());

        if (listingDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(listingDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingListing.setCategory(category);
        }

        return listingRepository.save(existingListing);
    }

    @Override
    public void deleteListing(Long id){
        listingRepository.deleteById(id);
    }

}
