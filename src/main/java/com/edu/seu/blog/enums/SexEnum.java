package com.edu.seu.blog.enums;

import lombok.Getter;

@Getter
public enum SexEnum {
    BOY("男"),
    GIRL("女"),
    ;

    private String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }
}
