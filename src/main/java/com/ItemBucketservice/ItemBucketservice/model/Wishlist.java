package com.ItemBucketservice.ItemBucketservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@DynamoDBDocument
public class Wishlist {
    @DynamoDBHashKey(attributeName = "id") //marking a property as the hash key for a modeled class
    @DynamoDBAutoGeneratedKey
    private String wishListId;
    @DynamoDBAttribute
    private String wishListName;
    @DynamoDBAttribute
    private List<String> productIds;

    @DynamoDBAttribute
    private User user;

    public Wishlist(String wishListId, String wishListName, List<String> productIds, String userId) {
        this.wishListId = wishListId;
        this.wishListName = wishListName;
        this.productIds = productIds;

    }



    public String getWishListId() {
        return wishListId;
    }

    public void setWishListId(String wishListId) {
        this.wishListId = wishListId;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
