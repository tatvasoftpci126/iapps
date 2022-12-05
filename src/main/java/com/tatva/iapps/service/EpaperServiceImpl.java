package com.tatva.iapps.service;

import com.tatva.iapps.dto.EpaperSearchRequest;
import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.repository.EpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Epaper> getAllEpaperListWithPaginationAndFilter(final EpaperSearchRequest epaperSearchRequest) {
        try {

            List<Epaper> epaperList = new ArrayList<>();
            PageRequest pr = PageRequest.of(epaperSearchRequest.getPageNumber(),epaperSearchRequest.getPageSize());

            // Default Sort by upload date time
            if (Objects.isNull(epaperSearchRequest.getSortBy()) || epaperSearchRequest.getSortBy().isEmpty()) {
                epaperSearchRequest.setSortBy("uploadDateTime");
            }

            // Default Sort Order by asc
            if (Objects.isNull(epaperSearchRequest.getSortOrderBy()) || epaperSearchRequest.getSortOrderBy().isEmpty()) {
                epaperSearchRequest.setSortOrderBy("ASC");
            }

            if(epaperSearchRequest.getSortOrderBy().equalsIgnoreCase("ASC")) {
                pr.withSort(Sort.Direction.ASC, epaperSearchRequest.getSortBy());
            } else {
                pr.withSort(Sort.Direction.DESC, epaperSearchRequest.getSortBy());
            }

            epaperList = epaperRepository.findByNewspaperNameContainingIgnoreCase(pr, epaperSearchRequest.getSearchText()).getContent();

            return epaperList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
