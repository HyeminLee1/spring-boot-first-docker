package com.javis.UserService.item.controller;

import com.javis.UserService.item.entity.Cart;
import com.javis.UserService.item.entity.CartItem;
import com.javis.UserService.item.repository.CartRepository;
import com.javis.UserService.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
public class ItemController {
    private ItemRepository itemRepository;
    private CartRepository cartRepository;


    @GetMapping
    Mono<?> home(){
        return Mono.just(Rendering.view("home.html")
        .modelAttribute("items", this.itemRepository.findAll())
        .modelAttribute("cart", this.cartRepository.findById("My Cart")
        .defaultIfEmpty(new Cart("My Cart")))
        .build());
    }
    //87p
    @PatchMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id){
        return this.cartRepository.findById("My Cart")
                .defaultIfEmpty(new Cart("My Cart"))
                .flatMap(cart -> cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getItem()
                                .getId().equals(id))
                        .findAny()
                        .map(cartItem -> {
                            // cartItem.increment();
                            return Mono.just(cart);
                        }).orElseGet(()->{
                            return this.itemRepository.findById(id).map(item -> new CartItem(item)).map(cartItem -> {
                                cart.getCartItems().add(cartItem);
                                return cart;
                            });
                        })).flatMap(cart -> this.cartRepository.save(cart)).thenReturn("redirect:/");


    }

}
