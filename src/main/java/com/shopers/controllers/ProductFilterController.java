package com.shopers.controllers;

import com.shopers.entities.Product;
import com.shopers.productFiltering.ProductFilterBuilder;
import com.shopers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/filter**")
public class ProductFilterController {

  private final ProductService productService;

  @Autowired
  public ProductFilterController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  Stream<Product> filterThisPlease(@RequestParam("type") String type,
                                   @RequestParam("brand") String brand,
                                   @RequestParam("price") Integer price,
                                   @RequestParam("discount") Integer discount,
                                   @RequestParam("size") List<Integer> size) {
    return new ProductFilterBuilder()
        .withType(type)
        .withBrand(brand)
        .withDiscount(discount)
        .withPrice(price)
        .withSize(size)
        .build()
        .filter(
            StreamSupport.stream(
                productService.findAll().spliterator(), false)
        );
  }
}
