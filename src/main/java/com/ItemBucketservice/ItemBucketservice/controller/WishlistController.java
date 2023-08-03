package com.ItemBucketservice.ItemBucketservice.controller;

import com.ItemBucketservice.ItemBucketservice.model.Product;
import com.ItemBucketservice.ItemBucketservice.model.User;
import com.ItemBucketservice.ItemBucketservice.model.Wishlist;
import com.ItemBucketservice.ItemBucketservice.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.ItemBucketservice.ItemBucketservice.service.WishListService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/wishlists")

public class WishlistController {

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/{userId}/wishlists")
    public ResponseEntity<Wishlist> createWishlist(@PathVariable String userId, @RequestBody Wishlist wishlist) {
        Wishlist createdWishlist = wishlistService.createWishlist(userId, wishlist);
        return ResponseEntity.ok(createdWishlist);
    }

    @GetMapping("/{userId}/wishlists")
    public ResponseEntity<List<Wishlist>> getWishlistsByUserId(@PathVariable String userId) {
        List<Wishlist> wishlists = wishlistService.getWishlistsByUserId(userId);
        return ResponseEntity.ok(wishlists);
    }

    @PostMapping("/{userId}/{wishlistId}/addProduct/{productId}")
    public ResponseEntity<Void> addToWishlist( @PathVariable String userId ,@PathVariable String wishlistId, @PathVariable String productId) {
        wishlistService.addToWishlist(userId ,wishlistId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/{wishlistId}/removeProduct/{productId}")
    public ResponseEntity<Void> removeFromWishlist(@PathVariable String wishlistId, @PathVariable String productId) {
        wishlistService.removeFromWishlist(wishlistId, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/{wishlistId}/products")
    public ResponseEntity<List<Product>> getProductsInWishlist(@PathVariable String wishlistId) {
        List<Product> products = wishlistService.getProductsInWishlist(wishlistId);
        return ResponseEntity.ok(products);
    }
}