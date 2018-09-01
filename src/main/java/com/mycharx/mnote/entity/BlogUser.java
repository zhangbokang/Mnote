package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户登陆信息实体类，现在只做最最简单的登陆
 *
 * @author 张卜亢
 * @date 2018.09.01 15:04:17
 */
@Data
@Entity
public class BlogUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 登陆的用户名
     */
    private String username;
    /**
     * 登陆的密码
     */
    private String password;
    /**
     * 用户状态，是否禁用
     */
    private String status;
}
