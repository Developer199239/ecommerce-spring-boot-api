package com.murtuzarahman.ecommerce.service;

import com.murtuzarahman.ecommerce.exceptions.APIException;
import com.murtuzarahman.ecommerce.exceptions.ResourceNotFoundException;
import com.murtuzarahman.ecommerce.model.Category;
import com.murtuzarahman.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()) {
            throw new APIException("No category created till now.");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category saveCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(saveCategory !=null) {
            throw new APIException("Category with name: "+category.getCategoryName()+" already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category with categoryId: "+categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(savedCategory);
        return  savedCategory;
    }
}
