package com.shopers.productFiltering;

import com.shopers.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductFilterer {
  private final Optional<String> type;
  private final Optional<String> brand;
  private final Optional<String> category;
  private final Optional<List<Integer>> size;
  private final Optional<Integer> price;
  private final Optional<Integer> discount;

  public ProductFilterer(Optional<String> type, Optional<String> brand, Optional<String> category, Optional<List<Integer>> size, Optional<Integer> price, Optional<Integer> discount) {
    this.type = type;
    this.brand = brand;
    this.category = category;
    this.size = size;
    this.price = price;
    this.discount = discount;
  }

  public Stream<Product> filter(Stream<Product> org) {
    return org
        .filter(product ->
            type.flatMap(
                type -> Optional.of(product.getType().contains(type)))
                .orElse(true)
        ).filter(
            product ->
                brand.flatMap(
                    brand -> Optional.of(product.getBrand().contains(brand)))
                    .orElse(true)
        ).filter(
            product ->
                size.flatMap(
                    size -> Optional.of(
                        product.getSize()
                            .stream().anyMatch(size::contains)
                    ))
                    .orElse(true)
        ).filter(
            product ->
                category.flatMap(
                    category -> Optional.of(
                        product.getCategory().equalsIgnoreCase(category)
                    ))
                    .orElse(true)
        ).filter(
            product ->
                price.flatMap(
                    price -> Optional.of(
                        product.getPrice() <= price
                    ))
                    .orElse(true)
        ).filter(
            product ->
                discount.flatMap(
                    discount -> Optional.of(
                        product.getDiscount() <= discount
                    ))
                    .orElse(true)
        );
  }
}
