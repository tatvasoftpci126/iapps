package com.tatva.iapps.service;

import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.repository.EpaperRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

}
