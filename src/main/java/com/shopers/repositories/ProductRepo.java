package com.shopers.repositories;

import com.shopers.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
  Iterable<Product> findByNameOrDescriptionContains(@Param("name") String name, @Param("description") String description);

  Iterable<Product> findByTypeContains(@Param("type") String type);

  Iterable<Product> findByDiscountGreaterThan(@Param("discount") int discount);
}
