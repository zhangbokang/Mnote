package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 文章的实体类
 *
 * @author 张卜亢
 * @date 2018.09.01 15:16:30
 */
@Data
@Entity
public class Doc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章md形式内容
     */
    private String docMd;
    /**
     * 文章的分类
     */
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "doc_classnode",//外键名称，和对方一样
            joinColumns = @JoinColumn(name = "docId"),//本类的ID
            inverseJoinColumns = @JoinColumn(name = "id")//对方类的ID
    )
    private Set<ClassifyNode> classifyNodes = new HashSet<>();
    /**
     * 文章的标签
     */
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "doc_tag",
            joinColumns = @JoinColumn(name = "docId"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Tag> tags = new HashSet<>();
    /**
     * 文章最后更新时间
     */
    private Long updateTime;
    /**
     * 文章支持数量
     */
    private Long favorNumber;
    /**
     * 文章查看数量
     */
    private Long openNumber;
}
