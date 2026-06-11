package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Cart;
import com.ecommerce.ecommerce.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping
    public List<Cart> getCartItems() {
        return cartService.getCartItems();
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {

        cartService.removeFromCart(id);

        return "Item Removed From Cart";
    }
}