package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //Real DB 로 연동해야 하는 경우에, Replace.NONE 선언
public class DemoApplicationTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void contextLoads() {
    }

    @Test
    public void 데이터_입력_테스트(){

        //최범균님 JPA 책 참고
        User user = entityManager.find(User.class, "sieunkr@gmail.com");
        Assert.assertEquals("sieunkim", user.getName());

        Date date = new Date();
        MembershipCard membershipCard = new MembershipCard("1", user, new Timestamp(date.getTime()));
        //영속 컨텍스트 까지만 저장되고 롤백 됨 = 실제 DB에 저장하지 않음
        //DataJPATest 에서 기본적으로 @Transactional 적용 되는 듯
        entityManager.persist(membershipCard);

        MembershipCard membershipCard1 = entityManager.find(MembershipCard.class, "1");
        Assert.assertEquals("sieunkr@gmail.com", membershipCard1.getOwner().getEmail());

    }

}
