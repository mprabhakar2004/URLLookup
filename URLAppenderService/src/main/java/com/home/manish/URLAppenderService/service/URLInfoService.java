package com.home.manish.URLAppenderService.service;

import com.home.manish.URLAppenderService.dao.URLInfoRepository;
import com.home.manish.URLAppenderService.entities.URLInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLInfoService {
    private final URLInfoRepository urlInfoRepository;

    @Autowired
    public URLInfoService(URLInfoRepository urlInfoRepository) {
        this.urlInfoRepository = urlInfoRepository;
    }

    public Long addUrl(URLInfo urlInfo){
        urlInfo = urlInfoRepository.save(urlInfo);
        return urlInfo.getId();
    }
}
