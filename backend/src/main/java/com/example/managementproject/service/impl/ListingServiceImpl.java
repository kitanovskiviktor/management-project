package com.example.managementproject.service.impl;

import com.example.managementproject.model.Listing;
import com.example.managementproject.repository.ListingRepository;
import com.example.managementproject.service.ListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    ListingServiceImpl(ListingRepository listingRepository){
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> getListings(){
        return listingRepository.findAll();
    }
}
