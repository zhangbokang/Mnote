package com.mycharx.mnote.repository;

import com.mycharx.mnote.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
