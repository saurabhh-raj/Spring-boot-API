package com.ItemBucketservice.ItemBucketservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@DynamoDBDocument
public class Product {
    @DynamoDBAttribute
    private String Name;
    @DynamoDBAttribute
    private String Url;
    @DynamoDBAttribute
    private String Id;
    @DynamoDBAttribute
    private int Price;

    public Product(String name, String url, String id, int price) {
        Name = name;
        Url = url;
        Id = id;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + Name + '\'' +
                ", Url='" + Url + '\'' +
                ", Id='" + Id + '\'' +
                ", Price=" + Price +
                '}';
    }
}