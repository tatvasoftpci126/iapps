package com.tatva.iapps.service;

import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.repository.EpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service impl class for EpaperService.
 */
@Service
public class EpaperServiceImpl implements EpaperService{

    @Autowired
    private EpaperRepository epaperRepository;

    @Override
    public List<Epaper> getAllEpaperList() {
        List<Epaper> epaperList = epaperRepository.findAll();
        if (epaperList.isEmpty() || Objects.isNull(epaperList))
            return new ArrayList<>();
        return epaperList;
    }
}
