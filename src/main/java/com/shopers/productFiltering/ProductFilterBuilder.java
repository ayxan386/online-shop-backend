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
    this.type = Optional.ofNullable(type);
    return this;
  }

  public ProductFilterBuilder withBrand(String brand) {
    this.brand = Optional.ofNullable(brand);
    return this;
  }

  public ProductFilterBuilder withSize(List<Integer> sizes) {
    this.size = Optional.ofNullable(sizes);
    return this;
  }

  public ProductFilterBuilder withPrice(Integer price) {
    this.price = Optional.ofNullable(price);
    return this;
  }

  public ProductFilterBuilder withDiscount(Integer discount) {
    this.discount = Optional.ofNullable(discount);
    return this;
  }

  public ProductFilterer build() {
    return new ProductFilterer(type, brand, size, price, discount);
  }
}
