package com.murtuzarahman.ecommerce.service;

import com.murtuzarahman.ecommerce.model.Product;
import com.murtuzarahman.ecommerce.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO productDTO);
}
