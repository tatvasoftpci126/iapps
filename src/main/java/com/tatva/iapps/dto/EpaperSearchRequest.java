package com.tatva.iapps.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Request dto for EpaperSearch
 */

@Data
public class EpaperSearchRequest {

    private int pageNumber;
    private int pageSize;
    private String sortBy;
    private String sortOrderBy;
    private String searchText;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
