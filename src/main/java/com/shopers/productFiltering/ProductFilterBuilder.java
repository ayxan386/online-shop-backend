package com.shopers.productFiltering;

import java.util.List;
import java.util.Optional;

public class ProductFilterBuilder {
  private Optional<String> type;
  private Optional<String> brand;
  private Optional<List<Integer>> size;
  private Optional<Integer> price;
  private Optional<Integer> discount;

  public ProductFilterBuilder withType(String type) {
    this.type = Optional.of(type);
    return this;
  }

  public ProductFilterBuilder withBrand(String brand) {
    this.brand = Optional.of(brand);
    return this;
  }

  public ProductFilterBuilder withSize(List<Integer> sizes) {
    this.size = Optional.of(sizes);
    return this;
  }

  public ProductFilterBuilder withPrice(Integer price) {
    this.price = Optional.of(price);
    return this;
  }

  public ProductFilterBuilder withDiscount(Integer discount) {
    this.discount = Optional.of(discount);
    return this;
  }

  public ProductFilterer build() {
    return new ProductFilterer(type, brand, size, price, discount);
  }
}
