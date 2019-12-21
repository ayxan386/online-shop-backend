package com.shopers.controllers;

import com.shopers.entities.Product;
import com.shopers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController (ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    Optional<Product> getProduct(@PathVariable("id") int id){
      System.out.printf("%s\n", id);
      Optional<Product> byId = productService.getById(id);
      byId.ifPresent(product -> System.out.println(product));
      return byId;
    }
    @GetMapping("")
    Optional<Product> getProduct2(@RequestParam("id") int id){
        return productService.getById(id);
    }
}

