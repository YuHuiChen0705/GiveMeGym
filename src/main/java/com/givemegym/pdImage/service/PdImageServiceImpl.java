package com.givemegym.pdImage.service;

import com.givemegym.pdImage.dao.PdImagesDAO;
import com.givemegym.pdImage.vo.PdImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PdImageServiceImpl implements PdImageService {

    @Autowired
    PdImagesDAO pdImagesDAO;

    @Override
    public PdImages saveOrUpdate(PdImages pdImages) {
        return pdImagesDAO.save(pdImages);
    }


}
