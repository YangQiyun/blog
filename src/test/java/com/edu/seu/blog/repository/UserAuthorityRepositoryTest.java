package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAuthorityRepositoryTest {

    @Autowired
    private UserAuthorityRepository repository;

    @Test
    public void findOneTest(){
        UserInfo result=repository.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void saveTest(){
        UserInfo info=new UserInfo();
        info.setUser_pwd("123");
        info.setUserAddr("123");
        info.setUserName("hello");

        UserInfo result=repository.save(info);
        Assert.assertNotNull(result);
    }
}