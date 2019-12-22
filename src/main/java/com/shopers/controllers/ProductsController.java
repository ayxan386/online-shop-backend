package com.shopers.controllers;

import com.shopers.entities.Product;
import com.shopers.productFiltering.ProductFilterBuilder;
import com.shopers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/products**")
public class ProductsController {
  private final ProductService productService;

  @Autowired
  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  Stream<Product> findAll(@RequestParam(value = "type", required = false) String type,
                          @RequestParam(value = "brand", required = false) String brand,
                          @RequestParam(value = "price", required = false) Integer price,
                          @RequestParam(value = "discount", required = false) Integer discount,
                          @RequestParam(value = "size", required = false) List<Integer> size) {
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

  @PostMapping("")
  String postList(@RequestBody List<Product> data) {
    productService.saveAll(data);
    return "success";
  }

  @GetMapping("/search")
  Stream<Product> searchFor(@RequestParam("q") String query,
                            @RequestParam(value = "type", required = false) String type,
                            @RequestParam(value = "brand", required = false) String brand,
                            @RequestParam(value = "price", required = false) Integer price,
                            @RequestParam(value = "discount", required = false) Integer discount,
                            @RequestParam(value = "size", required = false) List<Integer> size) {
    return new ProductFilterBuilder()
        .withType(type)
        .withBrand(brand)
        .withDiscount(discount)
        .withPrice(price)
        .withSize(size)
        .build()
        .filter(
            StreamSupport.stream(
                productService.searchFor(query).spliterator(), false)
        );
  }

  @GetMapping("/type")
  Stream<Product> searchForType(@RequestParam("type") String type,
                                @RequestParam(value = "brand", required = false) String brand,
                                @RequestParam(value = "price", required = false) Integer price,
                                @RequestParam(value = "discount", required = false) Integer discount,
                                @RequestParam(value = "size", required = false) List<Integer> size) {
    return new ProductFilterBuilder()
        .withType(null)
        .withBrand(brand)
        .withDiscount(discount)
        .withPrice(price)
        .withSize(size)
        .build()
        .filter(
            StreamSupport.stream(
                productService.searchForType(type).spliterator(), false)
        );
  }

  @GetMapping("/discount**")
  Stream<Product> getAllDiscounts(@RequestParam(value = "type", required = false) String type,
                                  @RequestParam(value = "brand", required = false) String brand,
                                  @RequestParam(value = "price", required = false) Integer price,
                                  @RequestParam(value = "discount", required = false) Integer discount,
                                  @RequestParam(value = "size", required = false) List<Integer> size) {
    return new ProductFilterBuilder()
        .withType(type)
        .withBrand(brand)
        .withDiscount(discount)
        .withPrice(price)
        .withSize(size)
        .build()
        .filter(
            StreamSupport.stream(
                productService.getAllDiscounts().spliterator(), false)
        );
  }

}
