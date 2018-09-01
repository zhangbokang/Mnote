package com.mycharx.mnote.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 树节点实体类
 *
 * @author 张卜亢
 * @date 2018.09.01 15:30:38
 */
@Data
//@Entity
public class TreeNode {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 树节点名称
     */
    private String text;
    /**
     * 树子节点
     * 延迟加载时设置为true，其他时候为List<TreeNode>
     */
    private List<TreeNode> children;
    /**
     * 父节点ID
     */
    private Long parentId;
}
