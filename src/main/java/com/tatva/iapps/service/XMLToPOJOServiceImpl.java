package com.tatva.iapps.service;

import com.tatva.iapps.dto.EpaperRequest;
import com.tatva.iapps.entity.Epaper;
import com.tatva.iapps.mapper.EpaperMapper;
import com.tatva.iapps.repository.EpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;

/**
 * Service impl for XML to POJO.
 */
@Service
public class XMLToPOJOServiceImpl implements XMLToPOJOService{

    @Autowired
    private EpaperRepository epaperRepository;

    @Autowired
    private EpaperMapper mapper;

    @Override
    public ResponseEntity<?> converXMLToPOJO(MultipartFile file) {
        try {

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            // Create schema from xsd to validate xml
            URL url = getClass().getClassLoader().getResource("xsd/EpaperRequest.xsd");
            Schema schema = sf.newSchema(url);

            JAXBContext context = JAXBContext.newInstance(EpaperRequest.class);
            Unmarshaller un = context.createUnmarshaller();
            un.setSchema(schema);

            // Validate XML using XSD
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(file.getInputStream()));

            EpaperRequest epaperRequest = (EpaperRequest) un.unmarshal(file.getInputStream());
            Epaper epaper = mapper.mapModelToEntity(epaperRequest, file.getOriginalFilename());

            epaper = epaperRepository.save(epaper);
            return ResponseEntity.ok(epaper);

        } catch (SAXException ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("XML is not valid");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}
