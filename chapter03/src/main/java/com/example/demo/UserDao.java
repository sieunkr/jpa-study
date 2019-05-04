package com.example.demo;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User getByEmail(String email){
        return entityManager.find(User.class, email);
    }

    //TODO:트랜잭션 추가
    public List<User> getByName(String name){

        TypedQuery<User> query =
                entityManager.createQuery(
                        "select u from User u order by u.name",
                        User.class);
        List<User> result = query.getResultList();
        return result;

    }

    //TODO:트랜잭션
    public void changeName(String email, String name){

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            User user = entityManager.find(User.class, email);
            user.changeName(name);
            entityTransaction.commit();
        }
        catch(Exception e){
            entityTransaction.rollback();
        }

    }

}
