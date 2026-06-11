package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // GET ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Product updateProduct(Long id, Product updatedProduct) {

        Product product =
                productRepository.findById(id).orElse(null);

        if(product != null) {

            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setImageUrl(updatedProduct.getImageUrl());

            return productRepository.save(product);
        }

        return null;
    }

    // DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}