package com.tatva.iapps.repository;

import com.tatva.iapps.entity.Epaper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository class for Epaper.
 */

@Repository
public interface EpaperRepository extends JpaRepository<Epaper, Long> {

    Page<Epaper> findByNewspaperNameContainingIgnoreCase(PageRequest pr, String newspaperName);
}
