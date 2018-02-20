package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.ArticleInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleInfoRepositoryTest {

    @Autowired
    private ArticleInfoRepository repository;

    @Test
    public void test(){
        ArticleInfo articleInfo=new ArticleInfo();
        articleInfo.setArticleTitle("标题2");
        articleInfo.setArticleType("类型");
        StringBuffer stringBuffer=new StringBuffer();
        articleInfo.setArticleContent("测试内容");

        ArticleInfo result=repository.save(articleInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        ArticleInfo result=repository.findOne(1);
        Assert.assertNotNull(result);
    }

}