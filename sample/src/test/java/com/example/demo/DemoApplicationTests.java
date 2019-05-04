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
    public void 팀_조회(){
        Teams teams = entityManager.find(Teams.class, 10);
        Assert.assertEquals("Give",teams.getTeamName());
    }

    @Test
    public void 팀_포인트_조회(){
        Teams teams = entityManager.find(Teams.class, 10);

        Assert.assertEquals(3, teams.getNumPoints().longValue());
    }


}
