package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Product;
import com.example.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // Save Single Product with POST method
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    // Bulk Save Product with POST method
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    // Show All Products with GET method
    public List<Product> getProducts(){
        return repository.findAll();
    }

    // Show Single Product By Id with GET method
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    // Show Single Product By Name with GET method
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    // Delete Product By Id
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product " + id + "Deleted!";
    }

    // Update Product By Id
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
