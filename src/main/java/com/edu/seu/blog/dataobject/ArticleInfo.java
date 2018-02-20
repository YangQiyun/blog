package com.edu.seu.blog.dataobject;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ArticleInfo implements Serializable{

    //shift+F
    private static final long serialVersionUID = -569482055393787552L;

    //博文信息的唯一索引
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id",nullable = false)
    private Integer articleId;

    //博文的标题
    @Column(name = "article_title",nullable = false)
    private String articleTitle;

    //博文的简短描述
    @Column(name = "article_description")
    private String articleDescription;

    //博文下面的图片地址
    @Column(name = "article_picture")
    private String articlePicture;

    //博文的类型
    @Column(name = "article_type",nullable = false)
    private String articleType;

    //博文的评论数量
    @Column(name = "article_reviewcounter")
    private Integer articleRvn;

    //博文的查看数量
    @Column(name = "article_scancounter")
    private Integer articleScn;

    //博文的内容
    @Lob
    @Column(name = "article_content")
    private String articleContent;

    //博文的简要展示内容
    @Column(name = "article_shortcontent")
    private String articleShort;

    //创建日期
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    //修改日期
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
