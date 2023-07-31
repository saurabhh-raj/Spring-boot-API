package com.ItemBucketservice.ItemBucketservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data

@NoArgsConstructor
@DynamoDBTable(tableName = "itemBucket")
public class User {

    @DynamoDBAttribute
    private String UserId;

    @DynamoDBAttribute
    private String emailId;
    @DynamoDBAttribute
    @ManyToOne
    private Wishlist wishlist;
    @DynamoDBAttribute
    private String password;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userId, String emailId, Wishlist wishlist, String password) {
        UserId = userId;
        this.emailId = emailId;
        this.wishlist = wishlist;
        this.password = password;
    }
}




/*
itemBucketService:{


        User:[
               primary key: UserId
               emailId,
               password,
               Wishlist
               [
                  WishlistId,
                   Product
                     [
                      ProductId
                      Name,
                      Price,
                      Description
                     ]
                ]

              ]



        }

*/

