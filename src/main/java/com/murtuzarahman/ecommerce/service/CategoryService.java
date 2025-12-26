package com.murtuzarahman.ecommerce.service;

import com.murtuzarahman.ecommerce.model.Category;
import com.murtuzarahman.ecommerce.payload.CategoryDTO;
import com.murtuzarahman.ecommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
