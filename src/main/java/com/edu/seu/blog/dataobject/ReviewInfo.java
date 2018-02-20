package com.edu.seu.blog.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class ReviewInfo implements Serializable{


    private static final long serialVersionUID = -2619678482599744962L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "user_id")
    private Integer userId;

    @Lob
    @Column(name = "review_content")
    private String reviewContent;
}
