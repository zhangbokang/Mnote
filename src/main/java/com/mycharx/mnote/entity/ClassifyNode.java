package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 文章分类
 *
 * @author 张卜亢
 * @date 2018.09.01 15:05:52
 */
@Data
@Entity
public class ClassifyNode implements Serializable {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 分类名称
     */
    private String text;
    /**
     * 是否还有子类
     */
    private Boolean children;
    /**
     * 父类ID
     */
    private Long parentId;
    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 和文章实体类多对多映射
     */
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "doc_classnode",//外键名称，和对方一样
            joinColumns = @JoinColumn(name = "id"),//本类的ID
            inverseJoinColumns = @JoinColumn(name = "docId")//对方类的ID
    )
    private Set<Doc> docs = new HashSet<>();
}
