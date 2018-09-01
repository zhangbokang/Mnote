package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 标签实体类
 *
 * @author 张卜亢
 * @date 2018.09.01 15:28:32
 */
@Data
@Entity
public class Tag implements Serializable {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 标签创建时间
     */
    private Long createTime;
    /**
     * 该标签对应的类
     */
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "doc_tag",//外键名称，和对方一样
            joinColumns = @JoinColumn(name = "id"),//本类ID
            inverseJoinColumns = @JoinColumn(name = "docId")//对方类ID
    )
    private Set<Doc> docs = new HashSet<>();
}
