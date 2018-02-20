package com.edu.seu.blog.enums;

import lombok.Getter;


/**
 * 错误代码编号
 */
@Getter
public enum  ErrorEnum {
    PAGE_ERROR(10,"page页数超出范围"),
    ARTICLE_NOT_FOUND(11,"未找到该id的博文"),
    ARTICLE_FIND_ERROR(12,"查询博文失败"),
    ARTICLE_TYPE_ERROR(13,"标签分类查询失败")
    ;

    private Integer code;

    private String message;

     ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
