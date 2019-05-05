package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HotelRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Hotel find(String id){
        return entityManager.find(Hotel.class, id);
    }
}
