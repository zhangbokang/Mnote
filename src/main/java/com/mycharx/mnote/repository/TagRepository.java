package com.mycharx.mnote.repository;

import com.mycharx.mnote.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Tag repository.
 *
 * @author 张卜亢
 * @date 2018.09.04 18:19:29
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
