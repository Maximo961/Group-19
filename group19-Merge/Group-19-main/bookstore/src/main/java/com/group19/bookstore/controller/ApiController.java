package com.group19.bookstore.controller;

import com.group19.bookstore.models.Cart;
import com.group19.bookstore.models.Price;
import com.group19.bookstore.repository.Cartrepo;
import com.group19.bookstore.repository.Pricerepo;
import com.group19.bookstore.service.CartService;
import com.group19.bookstore.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@RestController
public class ApiController {
        @Autowired
        private Cartrepo cartrepo;
        @Autowired
        private  PriceService priceService;
        @Autowired
        private CartService cartService;
        @GetMapping(value = "/")
        public String getPage() {
            return "Welcome to the Shopping Cart";
        }

        @GetMapping(value = "/cart")
        public List<Cart> getCart() {
            return cartrepo.findAll();
        }
    @GetMapping("/price/{username}")
    public List<Cart> getPrice(@PathVariable("username") long username) {
       return cartService.getPriceByUsername(username);
    }




    @PostMapping(value = "/save")
        public String saveCart(@RequestBody Cart cart) {
            cartrepo.save(cart);
            return "Save";
        }


        /** @PutMapping(value = "update/{username}")
        public String updateCart(@PathVariable long username, @RequestBody Cart cart) {
            Cart updateCart = cartrepo.findById(username).get();
            updateCart.setBookName(cart.getBookName());
            updateCart.setBookId(cart.getBookId());
            updateCart.setPrice(cart.getPrice());
            cartrepo.save(updateCart);
            return "Updated";
        } **/
        @DeleteMapping(value = "/delete/{username}")
        public String deleteCart(@PathVariable long username, Cart cart) {
            Cart deleteCart = cartrepo.findById(username).get();
            cartrepo.delete(deleteCart);
            return "Deleted";
        }
    }
