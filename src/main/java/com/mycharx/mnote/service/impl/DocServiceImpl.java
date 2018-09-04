package com.mycharx.mnote.service.impl;

import com.mycharx.mnote.entity.Doc;
import com.mycharx.mnote.repository.DocRepository;
import com.mycharx.mnote.service.DocService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * The type Doc service.
 *
 * @author 张卜亢
 * @date 2018.09.03 14:57:34
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class DocServiceImpl implements DocService {
    @Resource
    private DocRepository docRepository;

    @Override
    public Doc saveDoc(Doc doc) {
        doc.setUpdateTime(System.currentTimeMillis());
        return docRepository.save(doc);
    }

    @Override
    public Doc updateDoc(Doc doc) {
        doc.setUpdateTime(System.currentTimeMillis());
        return docRepository.save(doc);
    }

    @Override
    public void deleteDoc(Doc doc) {
        docRepository.delete(doc);
    }

    @Override
    public void deleteDocById(Long docId) {
        docRepository.deleteById(docId);
    }

    @Override
    public Doc findDocById(Long docId) {
        Optional<Doc> optionalDoc = docRepository.findById(docId);
        if (optionalDoc.isPresent()){
            return optionalDoc.get();
        }
        return new Doc();//后期可以抛出自定义异常
    }

    @Override
    public List<Doc> findDocLikeTitle(String title) {
        return null;
    }
}
