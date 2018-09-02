package com.mycharx.mnote.service;

import com.mycharx.mnote.entity.ClassifyNode;

import java.util.List;

/**
 * The interface Classify node service.
 *
 * @author 张卜亢
 * @date 2018.09.02 22:14:28
 */
public interface ClassifyNodeService {
    /**
     * Save classify node classify node.
     *
     * @param classifyNode the classify node
     * @return the classify node
     */
    ClassifyNode saveClassifyNode(ClassifyNode classifyNode);

    /**
     * Update classify node classify node.
     *
     * @param classifyNode the classify node
     * @return the classify node
     */
    ClassifyNode updateClassifyNode(ClassifyNode classifyNode);

    /**
     * Delete classify node.
     *
     * @param classifyNode the classify node
     */
    void deleteClassifyNode(ClassifyNode classifyNode);

    /**
     * Delete classify node by id.
     *
     * @param classifyNodeId the classify node id
     */
    void deleteClassifyNodeById(Long classifyNodeId);

    /**
     * Find classify node by id classify node.
     *
     * @param classifyNodeId the classify node id
     * @return the classify node
     */
    ClassifyNode findClassifyNodeById(Long classifyNodeId);

    /**
     * Find classify node like name list.
     *
     * @param name the name
     * @return the list
     */
    List<ClassifyNode> findClassifyNodeLikeName(String name);
}
