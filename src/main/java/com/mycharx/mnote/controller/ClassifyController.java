package com.mycharx.mnote.controller;

import com.mycharx.mnote.entity.ClassifyNode;
import com.mycharx.mnote.service.ClassifyNodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The type Classify controller.
 *
 * @author 张卜亢
 * @date 2018.09.02 22:13:45
 */
@RestController
@RequestMapping("/classifyNote")
public class ClassifyController {
    /**
     * The Classify node service.
     */
    @Resource
    private ClassifyNodeService classifyNodeService;

    /**
     * Save classify node classify node.
     *
     * @param classifyNode the classify node
     * @return the classify node
     */
    @PostMapping("/save")
    public ClassifyNode saveClassifyNode(ClassifyNode classifyNode) {
        return classifyNodeService.saveClassifyNode(classifyNode);
    }
}
