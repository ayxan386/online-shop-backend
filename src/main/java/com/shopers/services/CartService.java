package com.shopers.services;

import com.shopers.dto.CartDelete;
import com.shopers.dto.CartUpdate;
import com.shopers.entities.Cart;
import com.shopers.repositories.CartRepo;
import org.springframework.stereotype.Service;

@Service
public class CartService {
  private final CartRepo cartRepo;

  public CartService(CartRepo cartRepo) {
    this.cartRepo = cartRepo;
  }

  public Iterable<Cart> getAll() {
    return cartRepo.findAll();
  }

  public void add(Cart newPro) {
    cartRepo.save(newPro);
  }

  public void change(CartUpdate cartUpdate) {
    System.out.println(cartUpdate);
    cartRepo
        .findById(cartUpdate.getId())
        .map(cart -> {
              cart.setCount(cart.getCount() + cartUpdate.getAction());
              return cart;
            }
        ).ifPresent(updated -> cartRepo.save(updated));
  }

  public String remove(CartDelete cart) {
    cartRepo.deleteById(cart.getId());
    return "success";
  }
}
