package com.home.manish.urllookupservice.service;

import com.home.manish.urllookupservice.dao.URLInfoRepository;
import com.home.manish.urllookupservice.entities.URLInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLInfoService {
    private final URLInfoRepository urlInfoRepository;

    @Autowired
    public URLInfoService(URLInfoRepository urlInfoRepository) {
        this.urlInfoRepository = urlInfoRepository;
    }

    public Optional<URLInfo> findURLInfoByUrlId(String urlId){

        Optional<URLInfo> urlInfoOptional = urlInfoRepository.findURLInfoByUrlHash(urlId);

        return urlInfoOptional;

    }
}
