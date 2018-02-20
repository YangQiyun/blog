package com.edu.seu.blog.dataobject;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Total implements Serializable{

    private static final long serialVersionUID = 22509353374672951L;

    //总的文章数量
    @Id
    @Column(name = "article_counter",nullable = false)
    private Integer totalArticleN;

    //访问总数量
    @Column(name = "visitor_counter",nullable = false)
    private  Integer totalVisitorN;

    //评论总数量
    @Column(name = "visitorreview_counter",nullable = false)
    private Integer totalReviewN;

    //关于我的html内容
    @Column(name = "aboutme")
    @Lob
    private String aboutMe;

    //首页置顶博文的id
    @Column(name = "homepage_articleid")
    private Integer homeId;
}
