package com.edu.seu.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handlerAllException(Exception e){
        Map<String, Object> map=new HashMap<>();
        map.put("msg", e.getMessage());
        map.put("url", "/");
        return new ModelAndView("/common/error",map);
    }
}
