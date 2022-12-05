package com.tatva.iapps.service;

import com.tatva.iapps.dto.EpaperSearchRequest;
import com.tatva.iapps.entity.Epaper;

import java.util.List;

/**
 * Service class for Eapper.
 */
public interface EpaperService {

    List<Epaper> getAllEpaperList();

    List<Epaper> getAllEpaperListWithPaginationAndFilter(final EpaperSearchRequest epaperSearchRequest);
}
