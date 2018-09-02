package com.mycharx.mnote.service.impl;

import com.mycharx.mnote.entity.Tag;
import com.mycharx.mnote.repository.TagRepository;
import com.mycharx.mnote.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        tag.setCreateTime(System.currentTimeMillis());
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        tag.setCreateTime(System.currentTimeMillis());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }

    @Override
    public void deleteTagById(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Tag findTagById(Long tagId) {
        Optional<Tag> optionalTag = tagRepository.findById(tagId);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        }
        return new Tag();
    }

    @Override
    public List<Tag> findTagLikeName(String name) {
        return null;
    }
}
