package com.tatva.iapps.controller;

import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.service.XMLToPOJOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Request handler for XML to POJO Converter
 */
@RestController
public class XMLToPOJOController {

    @Autowired
    private XMLToPOJOService xmlToPOJOService;

    @PostMapping("/api/xml/to/pojo")
    public ResponseEntity<?> converXMLToPOJO(@RequestParam("xmlFile") MultipartFile file) {
        return xmlToPOJOService.converXMLToPOJO(file);
    }
    @GetMapping("/api/test")
    public String testAPI() {
        return "Hello";
    }
}
