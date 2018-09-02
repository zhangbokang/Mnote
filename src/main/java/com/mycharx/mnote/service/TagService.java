package com.mycharx.mnote.service;

import com.mycharx.mnote.entity.Tag;

import java.util.List;

/**
 * The interface Tag service.
 *
 * @author 张卜亢
 * @date 2018.09.02 22:14:37
 */
public interface TagService {
    /**
     * Save tag tag.
     *
     * @param tag the tag
     * @return the tag
     */
    Tag saveTag(Tag tag);

    /**
     * Update tag tag.
     *
     * @param tag the tag
     * @return the tag
     */
    Tag updateTag(Tag tag);

    /**
     * Delete tag.
     *
     * @param tag the tag
     */
    void deleteTag(Tag tag);

    /**
     * Delete tag by id.
     *
     * @param tagId the tag id
     */
    void deleteTagById(Long tagId);

    /**
     * Find tag by id tag.
     *
     * @param tagId the tag id
     * @return the tag
     */
    Tag findTagById(Long tagId);

    /**
     * Find tag like name list.
     *
     * @param name the name
     * @return the list
     */
    List<Tag> findTagLikeName(String name);
}
