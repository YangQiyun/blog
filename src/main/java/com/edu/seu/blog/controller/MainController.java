package com.edu.seu.blog.controller;

import com.edu.seu.blog.dataobject.ArticleInfo;
import com.edu.seu.blog.enums.ErrorEnum;
import com.edu.seu.blog.exception.BlogException;
import com.edu.seu.blog.form.PageForm;
import com.edu.seu.blog.service.ArticleService;
import com.edu.seu.blog.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private ArticleService service;

    @Autowired
    private MessageService message;

    /**
     * 默认的页表
     */
    @GetMapping (value = "/")
    public ModelAndView index(Map<String, Object> map){
        PageRequest request=new PageRequest(0,2);
        Page<ArticleInfo> articleInfoPage=service.findList(request);
        List<String> allType=service.findAllType();
        map.put("articleInfoPage",articleInfoPage);
        map.put("currentPage", 1);
        map.put("size", 2);
        map.put("totalSize",10);
        map.put("allType",allType);
        map.put("homeArticle",service.findOne(message.getHomeArtId()));
        return  new ModelAndView("index",map);
    }

    /**
     * 页面转化的post请求
     * @param form 请求参数
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping(value = "/")
    public ModelAndView test(@Valid PageForm form,
                              BindingResult bindingResult,
                              Map<String, Object> map){

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/");
            return new ModelAndView("common/error", map);
        }


        PageRequest request=new PageRequest(form.getPage()-1,form.getSize());
        Page<ArticleInfo> articleInfoPage=service.findList(request);

        if (form.getPage()>articleInfoPage.getTotalPages()){
            throw new BlogException(ErrorEnum.PAGE_ERROR);
        }

        List<String> allType=service.findAllType();
        map.put("articleInfoPage",articleInfoPage);
        map.put("currentPage", form.getPage());
        map.put("size", form.getSize());
        map.put("totalSize",articleInfoPage.getTotalPages());
        map.put("allType",allType);
        map.put("homeArticle",service.findOne(message.getHomeArtId()));
        return  new ModelAndView("index", map);
    }

    @GetMapping("/aboutMe")
    public ModelAndView aboutME(Map<String, Object> map){
        map.put("content",message.getAboutMe());
        return  new ModelAndView("about", map);
    }
}
