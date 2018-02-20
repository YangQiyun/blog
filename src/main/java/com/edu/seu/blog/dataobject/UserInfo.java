package com.edu.seu.blog.dataobject;

import com.edu.seu.blog.enums.SexEnum;
import com.edu.seu.blog.enums.UserAuthorityEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class UserInfo implements Serializable{


    private static final long serialVersionUID = -368638199679472684L;
    //用户唯一编号id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Integer userID;

    //用户昵称
    @Column(name = "user_name",nullable = false,length = 32)
    private String userName;

    //用户密码
    @Column(name = "user_pwd",nullable = false,length = 32)
    private String user_pwd;

    //用户性别，默认是男
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "user_sex")
    private SexEnum userSex= SexEnum.BOY;

    //用户头像的小图url地址
    @Column(name = "user_photo",length = 512)
    private String userPhoto;

    //用户的认证信息0表示游客，1表示管理者，默认是游客
    @Column(name = "user_authority",nullable = false)
    private Integer userAuthority= UserAuthorityEnum.VISITOR.getStatus();

    //用户的ip地址
    @Column(name = "user_ipaddr",length = 32)
    private String userAddr;
}
