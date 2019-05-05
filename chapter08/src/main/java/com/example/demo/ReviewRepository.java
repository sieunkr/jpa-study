package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Review> findByHotel(Hotel hotel, int startRow, int maxResults) {
        TypedQuery<Review> query = entityManager
                .createQuery("select r from Review r " +
                        "where r.hotel = :hotel order by r.id desc", Review.class);

        query.setParameter("hotel", hotel);
        query.setFirstResult(startRow);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

}
