package com.edu.seu.blog.controller;

import com.edu.seu.blog.dataobject.ArticleInfo;
import com.edu.seu.blog.enums.ErrorEnum;
import com.edu.seu.blog.exception.BlogException;
import com.edu.seu.blog.service.ArticleService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    public ModelAndView specialArticle(@PathVariable(value = "articleId") Integer Id,Map<String, Object> map){
        ArticleInfo articleInfo=articleService.findOne(Id);

        if (articleInfo==null)
            throw  new BlogException(ErrorEnum.ARTICLE_NOT_FOUND);

        map.put("aritcleInfo",articleInfo);
        return new ModelAndView("/List/article",map);
    }

    @GetMapping("/list")
    public ModelAndView allArticleList(Map<String, Object> map){
        List<ArticleInfo> articleInfoList=articleService.findAllArticle();

        if (articleInfoList==null)
            throw  new BlogException(ErrorEnum.ARTICLE_FIND_ERROR);

        map.put("articleList",articleInfoList);
        return new ModelAndView("/List/articlelist",map);
    }

    @GetMapping("/Tag/{tag}")
    public ModelAndView articleTypeList(@PathVariable(value = "tag") String type, Map<String, Object> map){
        List<ArticleInfo> articleTypeList=articleService.findByArticleTypeLike(Arrays.asList(type));

        if (articleTypeList==null){
           // log.error(ErrorEnum.ARTICLE_TYPE_ERROR.getMessage());
            throw  new BlogException(ErrorEnum.ARTICLE_TYPE_ERROR);
        }

        map.put("articleList",articleTypeList);
        return new ModelAndView("/List/articlelist",map);
    }

}
