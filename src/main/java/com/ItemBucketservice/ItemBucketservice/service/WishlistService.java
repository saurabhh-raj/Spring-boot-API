package com.ItemBucketservice.ItemBucketservice.service;

import com.ItemBucketservice.ItemBucketservice.model.Product;
import com.ItemBucketservice.ItemBucketservice.model.Wishlist;
import com.ItemBucketservice.ItemBucketservice.repository.ProductRepository;
import com.ItemBucketservice.ItemBucketservice.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;



    public Wishlist createWishlist(String userId, Wishlist wishlist) {
        return wishlistRepository.save(userId);
    }

  /*  public Wishlist getWishlistById(String userId) {
        return wishlistRepository.findById(userId).orElse(null);
    }*/
    public List<Wishlist> getWishlistsByUserId(String userId) {
        return wishlistRepository.findById(userId);
    }
    public void addToWishlist(String userId , String wishlistId, String productId) {
        Wishlist wishlist = (Wishlist) wishlistRepository.findById(userId , wishlistId).orElse(null);
        if (wishlist != null) {
            if (!wishlist.getProductIds().contains(productId)) {
                wishlist.getProductIds().add(productId);
                wishlistRepository.save(wishlist);
            }
        }
    }

    public void removeFromWishlist(String wishlistId, String productId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            wishlist.getProductIds().remove(productId);
            wishlistRepository.save(wishlist);
        }
    }

    public List<Product> getProductsInWishlist(String wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            List<String> productIds = wishlist.getProductIds();

            return (List<Product>) productRepository.findAllById(productIds);
        } else {
            return new ArrayList<>();
        }
    }
}
