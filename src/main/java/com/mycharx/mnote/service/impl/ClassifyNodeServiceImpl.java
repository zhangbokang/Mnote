package com.mycharx.mnote.service.impl;

import com.mycharx.mnote.entity.ClassifyNode;
import com.mycharx.mnote.repository.ClassifyNodeRepository;
import com.mycharx.mnote.service.ClassifyNodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * The type Classify node service.
 *
 * @author 张卜亢
 * @date 2018.09.03 14:57:02
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class ClassifyNodeServiceImpl implements ClassifyNodeService {
    @Resource
    private ClassifyNodeRepository classifyNodeRepository;

    @Override
    public ClassifyNode saveClassifyNode(ClassifyNode classifyNode) {
        classifyNode.setUpdateTime(System.currentTimeMillis());
        return classifyNodeRepository.save(classifyNode);
    }

    @Override
    public ClassifyNode updateClassifyNode(ClassifyNode classifyNode) {
        classifyNode.setUpdateTime(System.currentTimeMillis());
        return classifyNodeRepository.save(classifyNode);
    }

    @Override
    public void deleteClassifyNode(ClassifyNode classifyNode) {
        classifyNodeRepository.delete(classifyNode);
    }

    @Override
    public void deleteClassifyNodeById(Long classifyNodeId) {
        classifyNodeRepository.deleteById(classifyNodeId);
    }

    @Override
    public ClassifyNode findClassifyNodeById(Long classifyNodeId) {
        Optional<ClassifyNode> optionalClassifyNode = classifyNodeRepository.findById(classifyNodeId);
        if (optionalClassifyNode.isPresent()) {
            return optionalClassifyNode.get();
        }
        return new ClassifyNode();
    }

    @Override
    public List<ClassifyNode> findClassifyNodeLikeName(String name) {
        return null;
    }
}
