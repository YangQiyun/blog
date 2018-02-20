package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleInfoRepository extends JpaRepository<ArticleInfo,Integer>{

    List<ArticleInfo> findByArticleTypeLike(List<String> articleTypeList);
}
