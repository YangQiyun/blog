package com.edu.seu.blog.enums;

import lombok.Getter;

@Getter
public enum UserAuthorityEnum {
    MANEGER(1),
    VISITOR(0),
    ;

    private Integer status;

    UserAuthorityEnum(Integer status) {
        this.status = status;
    }
}
