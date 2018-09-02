package com.mycharx.mnote.service;

import com.mycharx.mnote.entity.Doc;

import java.util.List;

/**
 * The interface Doc service.
 *
 * @author 张卜亢
 * @date 2018.09.02 22:14:33
 */
public interface DocService {
    /**
     * Save doc doc.
     *
     * @param doc the doc
     * @return the doc
     */
    Doc saveDoc(Doc doc);

    /**
     * Update doc doc.
     *
     * @param doc the doc
     * @return the doc
     */
    Doc updateDoc(Doc doc);

    /**
     * Delete doc.
     *
     * @param doc the doc
     */
    void deleteDoc(Doc doc);

    /**
     * Delete doc by id.
     *
     * @param docId the doc id
     */
    void deleteDocById(Long docId);

    /**
     * Find doc by id doc.
     *
     * @param docId the doc id
     * @return the doc
     */
    Doc findDocById(Long docId);

    /**
     * Find doc like title list.
     *
     * @param title the title
     * @return the list
     */
    List<Doc> findDocLikeTitle(String title);
}
