package com.shopers.controllers;

import com.shopers.dto.CartDelete;
import com.shopers.dto.CartUpdate;
import com.shopers.entities.Cart;
import com.shopers.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart**")
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("")
  Iterable<Cart> getAll() {
    return cartService.getAll();
  }

  @PostMapping("")
  String addOne(@RequestBody Cart newPro) {
    cartService.add(newPro);
    return "success";
  }

  @PutMapping("")
  String change(@RequestBody CartUpdate cartUpdate) {
    cartService.change(cartUpdate);
    return "success";
  }

  @DeleteMapping("")
  String delete(@RequestBody CartDelete cart) {
    return cartService.remove(cart);
  }
}
