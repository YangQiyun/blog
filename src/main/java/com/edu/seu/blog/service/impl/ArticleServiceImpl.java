package com.edu.seu.blog.service.impl;

import com.edu.seu.blog.dataobject.ArticleInfo;
import com.edu.seu.blog.repository.ArticleInfoRepository;
import com.edu.seu.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{


    @Autowired
    private ArticleInfoRepository repository;

    @Override
    @Cacheable(cacheNames = "articleInfo",key = "#articleId")
    public ArticleInfo findOne(Integer articleId) {
        return repository.findOne(articleId);
    }

    @Override
    @Cacheable(cacheNames = "blog",key = "#articleTypeList")
    public List<ArticleInfo> findByArticleTypeLike(List<String> articleTypeList) {
        return repository.findByArticleTypeLike(articleTypeList);
    }

    @Override
    @Caching(cacheable = @Cacheable(cacheNames = "articleInfo",key = "#articleInfo.articleId"),evict = {@CacheEvict(value = "blog",allEntries = true)})
    public ArticleInfo save(ArticleInfo articleInfo) {
        return repository.save(articleInfo);
    }

    @Override
    @Cacheable(cacheNames = "blog", key = "#pageable")
    public Page<ArticleInfo> findList(Pageable pageable) {
        //可以将查询到的内容进行转换成DTO层的内容进行输出
        Page<ArticleInfo> articleInfoPage=repository.findAll(pageable);
        return new PageImpl<>(articleInfoPage.getContent(),pageable,articleInfoPage.getTotalElements());
    }

    @Override
    @Cacheable(cacheNames = "blog", key = "#root.methodName")
    public List<String> findAllType() {
        List<ArticleInfo> articleInfoList=repository.findAll();
        HashSet<String> alltype=new HashSet<>();
        for(ArticleInfo articleInfo:articleInfoList){
            alltype.add(articleInfo.getArticleType());
        }

        Iterator<String> iterator=alltype.iterator();
        List<String> stringList=new ArrayList<>();
       while (iterator.hasNext()){
           stringList.add(iterator.next());
       }

       return stringList;
    }

    @Override
    @Cacheable(cacheNames = "blog", key = "#root.methodName")
    public List<ArticleInfo> findAllArticle() {
        return repository.findAll();
    }


}
