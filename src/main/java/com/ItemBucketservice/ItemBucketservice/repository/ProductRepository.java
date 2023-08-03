package com.ItemBucketservice.ItemBucketservice.repository;

import com.ItemBucketservice.ItemBucketservice.model.Product;
import com.ItemBucketservice.ItemBucketservice.model.User;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
/*
    public User save(User person){
        dynamoDBMapper.save(person);
        return person;
    }

    public User findById(String id){
        return dynamoDBMapper.load(User.class, id);
    }

    public List<Person> findAll(){
        return dynamoDBMapper.scan(Person.class, new DynamoDBScanExpression());
    }

    public String update(String id, Person person){
        dynamoDBMapper.save(person,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }

    public String delete(String id){
        Person person = dynamoDBMapper.load(Person.class, id);
        dynamoDBMapper.delete(person);
        return "Person deleted successfully:: "+id;
    }*/
}



