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
  Stream<Product> filterThisPlease(@RequestParam(value = "type", required = false) String type,
                                   @RequestParam(value = "brand", required = false) String brand,
                                   @RequestParam(value = "price", required = false) Integer price,
                                   @RequestParam(value = "discount", required = false) Integer discount,
                                   @RequestParam(value = "size", required = false) List<Integer> size) {
    System.out.printf("type : %s brand : %s price : %s discount : %s size :%s\n",
        type, brand, price, discount, size);
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
