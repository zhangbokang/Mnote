package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 评论的实体类
 *
 * @author 张卜亢
 * @date 2018.09.01 15:03:46
 */
@Data
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 评论的主要内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 评论的赞成次数
     */
    private Long favorNumber;
    /**
     * 评论的反对次数
     */
    private Long opposeNumber;

}
