package com.ItemBucketservice.ItemBucketservice.service;

import com.ItemBucketservice.ItemBucketservice.model.Wishlist;
import com.ItemBucketservice.ItemBucketservice.repository.ProductRepository;
import com.ItemBucketservice.ItemBucketservice.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;



    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Wishlist getWishlistById(String wishlistId) {
        return wishlistRepository.findById(wishlistId).orElse(null);
    }

    public void addToWishlist(String wishlistId, String productId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
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

  /*  public List<Product> getProductsInWishlist(String wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (wishlist != null) {
            List<String> productIds = wishlist.getProductIds();

            return (List<Product>) productRepository.findAllById(productIds);
        } else {
            return new ArrayList<>();
        }
    }*/
}
