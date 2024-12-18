package com.example.managementproject.service;


import com.example.managementproject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category addCategory(Category newCategory);

    Category editCategory(Long id, Category newCategory);

    void deleteCategory(Long id);
}
