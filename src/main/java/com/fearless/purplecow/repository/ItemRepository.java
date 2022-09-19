package com.fearless.purplecow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fearless.purplecow.model.Item;

public interface ItemRepository extends MongoRepository<Item, String>{
    
    
}
