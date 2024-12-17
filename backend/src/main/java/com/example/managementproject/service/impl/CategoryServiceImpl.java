package com.example.managementproject.service.impl;

import com.example.managementproject.model.Category;
import com.example.managementproject.repository.CategoryRepository;
import com.example.managementproject.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
