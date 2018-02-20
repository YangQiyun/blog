package com.edu.seu.blog.service;

import com.edu.seu.blog.dataobject.ArticleInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    ArticleInfo findOne(Integer articleId);

    //查询相关类型标签的文章
    List<ArticleInfo> findByArticleTypeLike(List<String> articleTypeList);

    //存储相关的博文
    ArticleInfo save(ArticleInfo articleInfo);

    Page<ArticleInfo> findList(Pageable pageable);

    List<String> findAllType();

    List<ArticleInfo> findAllArticle();
}
