package com.ItemBucketservice.ItemBucketservice.repository;

import com.ItemBucketservice.ItemBucketservice.model.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}



