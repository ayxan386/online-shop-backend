package com.shopers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Column(name = "id")
  @Id
  int id;

  @Column(name = "name")
  @Size(min = 3, message = "name is too short")
  String name;

  @Column(name = "brand")
  String brand;

  @Column(name = "description")
  String description;

  @Column(name = "price")
  @Positive
  int price;

  @ElementCollection
  List<Integer> size;

  @Column(name = "type")
  String type;

  @Column(name = "category")
  String category;

  @ElementCollection
  List<String> image;

  @Column(name = "itemNo")
  String itemNo;

}
