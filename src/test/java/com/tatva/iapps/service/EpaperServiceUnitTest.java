package com.tatva.iapps.service;

import com.tatva.iapps.dto.EpaperSearchRequest;
import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.repository.EpaperRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * Unit tests for EpaperService.
 */

@RunWith(MockitoJUnitRunner.class)
public class EpaperServiceUnitTest {

    @InjectMocks
    private EpaperServiceImpl epaperService;

    @Mock
    private EpaperRepository epaperRepository;

    @Test
    public void testGetAllEpaperList() {
        Epaper epaper = new Epaper();
        List<Epaper> epaperList = new ArrayList<>();
        epaperList.add(epaper);
        doReturn(epaperList).when(epaperRepository).findAll();
        List<Epaper> result = epaperService.getAllEpaperList();
        assertEquals(result, epaperList);
    }

    @Test
    public void testGetAllEpaperListWithPaginationAndFilter() {
        EpaperSearchRequest epaperSearchRequest = new EpaperSearchRequest();
        epaperSearchRequest.setPageNumber(0);
        epaperSearchRequest.setPageSize(1);
        epaperSearchRequest.setSearchText("");
        epaperSearchRequest.setStartDate(LocalDateTime.now().minusWeeks(1));
        epaperSearchRequest.setEndDate(LocalDateTime.now());
        Epaper epaper = new Epaper();
        epaper.setUploadDateTime(LocalDateTime.now().minusDays(1));
        epaper.setNewspaperName("");
        List<Epaper> epaperList = new ArrayList<>();
        epaperList.add(epaper);
        Page<Epaper> epaperPage = new PageImpl<>(epaperList, Pageable.ofSize(1), 1);

        doReturn(epaperPage).when(epaperRepository).findByUploadDateTimeBetweenAndNewspaperNameContainingIgnoreCase(PageRequest.of(0,1),epaperSearchRequest.getStartDate(),epaperSearchRequest.getEndDate(),epaperSearchRequest.getSearchText());
        List<Epaper> result = epaperService.getAllEpaperListWithPaginationAndFilter(epaperSearchRequest);
        assertEquals(result, epaperList);
    }

}
