package com.murtuzarahman.ecommerce.repositories;

import com.murtuzarahman.ecommerce.model.Category;
import com.murtuzarahman.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);
    List<Product> findByProductNameLikeIgnoreCase(String keyword);
    boolean existsByProductNameAndCategory(String productName, Category category);
}
