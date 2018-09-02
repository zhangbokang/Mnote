package com.mycharx.mnote.repository;

import com.mycharx.mnote.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doc,Long> {
}
