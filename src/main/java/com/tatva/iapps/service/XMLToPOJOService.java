package com.tatva.iapps.service;

import com.tatva.iapps.entity.Epaper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service class for XML to POJO.
 */

public interface XMLToPOJOService {

    ResponseEntity<?> converXMLToPOJO(MultipartFile file);
}
