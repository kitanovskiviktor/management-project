package com.example.managementproject.service.impl;

import com.example.managementproject.model.Category;
import com.example.managementproject.model.Listing;
import com.example.managementproject.repository.CategoryRepository;
import com.example.managementproject.repository.ListingRepository;
import com.example.managementproject.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ListingRepository listingRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository, ListingRepository listingRepository){
        this.categoryRepository = categoryRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category newCategory){
            return categoryRepository.save(newCategory);
    }

    @Override
    public Category editCategory(Long id, Category newCategory){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setId(newCategory.getId());
        existingCategory.setName(newCategory.getName());
        existingCategory.setDescription(newCategory.getDescription());
        existingCategory.setListings(newCategory.getListings());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        for(Listing listing : existingCategory.getListings()){
            listing.setCategory(null);
            listingRepository.save(listing);
        }
        categoryRepository.delete(existingCategory);
    }
}
