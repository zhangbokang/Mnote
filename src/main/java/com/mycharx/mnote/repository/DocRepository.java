package com.mycharx.mnote.repository;

import com.mycharx.mnote.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Doc repository.
 *
 * @author 张卜亢
 * @date 2018.09.04 18:19:34
 */
public interface DocRepository extends JpaRepository<Doc, Long> {
}
