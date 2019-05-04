package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserDao userDao;


    @Test
    public void 사용자_조회_테스트(){

        User user = userDao.getByEmail("sieunkr@gmail.com");

        Assert.assertEquals("sieunkim", user.getName());

    }

    @Test
    public void 이름으로_조회_사용자_테스트(){

        List<User> users = userDao.getByName("sieunkim");

        Assert.assertEquals(1, users.size());
        Assert.assertEquals("sieunkr@gmail.com", users.get(0).getEmail());

    }

    @Test
    public void 사용자_이름_변경_테스트() throws Exception {

        userDao.changeName("sieunkr@gmail.com", "sieunkim");

    }


}
