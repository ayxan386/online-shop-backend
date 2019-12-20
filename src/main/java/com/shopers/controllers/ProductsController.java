package com.shopers.controllers;

import com.shopers.entities.Product;
import com.shopers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products**")
public class ProductsController {
  private final ProductService productService;

  @Autowired
  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  Iterable<Product> getAll() {
    return productService.findAll();
  }

  @PostMapping("")
  String postList(@RequestBody List<Product> data) {
    productService.saveAll(data);
    return "success";
  }

  @GetMapping("/search")
  Iterable<Product> searchFor(@RequestParam("q") String query) {
    return productService.searchFor(query);
  }

  @GetMapping("/type")
  Iterable<Product> searchForType(@RequestParam("type") String type) {
    return productService.searchForType(type);
  }

}
