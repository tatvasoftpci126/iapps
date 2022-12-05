package com.tatva.iapps.mapper;

import com.tatva.iapps.dto.EpaperRequest;
import com.tatva.iapps.entity.Epaper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EpaperMapper {

    public Epaper mapModelToEntity(final EpaperRequest epaperRequest, final String fileName) {
        Epaper epaper = new Epaper();
        epaper.setFileName(fileName);
        epaper.setNewspaperName(epaperRequest.getDeviceInfo().getAppInfo().getNewspaperName());
        epaper.setHeight(epaperRequest.getDeviceInfo().getScreenInfo().getHeight());
        epaper.setWidth(epaperRequest.getDeviceInfo().getScreenInfo().getWidth());
        epaper.setDpi(epaperRequest.getDeviceInfo().getScreenInfo().getDpi());
        epaper.setUploadDateTime(LocalDateTime.now());
        return epaper;
    }
}
