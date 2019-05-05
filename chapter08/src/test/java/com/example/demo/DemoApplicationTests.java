package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DemoApplicationTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void 호텔_조회_테스트(){

        Hotel hotel = entityManager.find(Hotel.class, "1");
        Assert.assertEquals("Seoul Hotel",hotel.getName());

    }

    @Test
    public void 리뷰_조회_테스트(){
        Review review = entityManager.find(Review.class, 1L);
        Assert.assertEquals("Seoul Hotel",review.getHotel().getName());

        /*
        Lazy 인 경우, 쿼리를 두번 호출
        Hibernate: select review0_.id as id1_1_0_, review0_.comment as comment2_1_0_, review0_.hotel_id as hotel_id5_1_0_, review0_.rate as rate3_1_0_, review0_.rating_date as rating_d4_1_0_ from hotel_review review0_ where review0_.id=?
        Hibernate: select hotel0_.id as id1_0_0_, hotel0_.address1 as address2_0_0_, hotel0_.address2 as address3_0_0_, hotel0_.zipcode as zipcode4_0_0_, hotel0_.grade as grade5_0_0_, hotel0_.name as name6_0_0_ from hotel hotel0_ where hotel0_.id=?
        첫 쿼리 호출 시 Outer Join 하지 않음
        review.getHotel().getName 실행하면 두번째 쿼리 호출

        Eager 인 경우, 쿼리 한번 호출, Join 사용
        Hibernate: select review0_.id as id1_1_0_, review0_.comment as comment2_1_0_, review0_.hotel_id as hotel_id5_1_0_, review0_.rate as rate3_1_0_, review0_.rating_date as rating_d4_1_0_, hotel1_.id as id1_0_1_, hotel1_.address1 as address2_0_1_, hotel1_.address2 as address3_0_1_, hotel1_.zipcode as zipcode4_0_1_, hotel1_.grade as grade5_0_1_, hotel1_.name as name6_0_1_ from hotel_review review0_ left outer join hotel hotel1_ on review0_.hotel_id=hotel1_.id where review0_.id=?
        */


    }

}
