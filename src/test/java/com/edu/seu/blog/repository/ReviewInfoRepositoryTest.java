package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.ReviewInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewInfoRepositoryTest {

    @Autowired
    private ReviewInfoRepository repository;

    @Test
    public void findOneTest(){
        ReviewInfo result=repository.findOne(1);
        Assert.assertNotNull(result);
    }
}