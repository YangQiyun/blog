package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.Total;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TotalRepositoryTest {

    @Autowired
    private TotalRepository totalRepository;

    @Test
    public void Test(){
        Total total=new Total();
        total.setTotalArticleN(1);
        total.setTotalReviewN(1);
        total.setTotalVisitorN(1);

        Total result =totalRepository.save(total);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        Total total=totalRepository.findOne(1);
        Assert.assertNotNull(total);
    }
}