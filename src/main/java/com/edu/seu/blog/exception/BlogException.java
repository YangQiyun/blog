package com.edu.seu.blog.exception;

import com.edu.seu.blog.enums.ErrorEnum;

public class BlogException extends RuntimeException{

    private Integer code;

    public BlogException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());

        this.code=errorEnum.getCode();
    }

    public BlogException(Integer code, String messge){
        super(messge);
        this.code=code;
    }

}
