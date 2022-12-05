package com.tatva.iapps.controller;

import com.tatva.iapps.dto.EpaperRequest;
import com.tatva.iapps.dto.EpaperSearchRequest;
import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.service.EpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController for Epapar.
 */
@RestController
public class EpaperController {

    @Autowired
    private EpaperService epaperService;

    @GetMapping("/api/epapers")
    public ResponseEntity<?> getAllEpaperList() {
       List<Epaper> epaperList = epaperService.getAllEpaperList();
        return ResponseEntity.ok(epaperList);
    }

    @PostMapping("/api/epapers")
    public ResponseEntity<?> getAllEpaperListWithPaginationAndFilter(@RequestBody EpaperSearchRequest epaperSearchRequest) {
        List<Epaper> epaperList = epaperService.getAllEpaperListWithPaginationAndFilter(epaperSearchRequest);
        return ResponseEntity.ok(epaperList);
    }
}
