package com.shopers.services;

import com.shopers.entities.Product;
import com.shopers.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  private final ProductRepo productRepo;

  public ProductService(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public Iterable<Product> findAll() {
    return productRepo.findAll();
  }

  public void saveAll(List<Product> data) {
    productRepo.saveAll(data);
  }

  public Iterable<Product> searchFor(String query) {
    return productRepo.findByNameOrDescriptionContains(query, query);
  }
  public Optional<Product> getById(int id){
    return productRepo.findById(id);
  }

  public Iterable<Product> searchForType(String type) {
    return productRepo.findByTypeContains(type);
  }

  public Iterable<Product> getAllDiscounts() {
    return productRepo.findByDiscountGreaterThan(0);
  }
}
