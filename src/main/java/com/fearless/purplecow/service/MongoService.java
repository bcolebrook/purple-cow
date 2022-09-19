package com.fearless.purplecow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fearless.purplecow.model.Item;
import com.fearless.purplecow.repository.ItemRepository;

@Service
public class MongoService {
    @Autowired
    ItemRepository repository;

    public List<Item> findAll() {
        return repository.findAll();
    }

    public void saveAll(List<Item> items) {
        repository.saveAll(items);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
