package com.ItemBucketservice.ItemBucketservice.repository;

import com.ItemBucketservice.ItemBucketservice.model.Wishlist;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface WishlistRepository extends DynamoDBCrudRepository<Wishlist ,String> {
    Optional<Object> findById(String userId, String wishlistId);
}