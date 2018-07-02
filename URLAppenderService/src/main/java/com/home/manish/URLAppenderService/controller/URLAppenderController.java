package com.home.manish.URLAppenderService.controller;

import com.home.manish.URLAppenderService.entities.URLInfo;
import com.home.manish.URLAppenderService.service.URLInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urlinfo")
public class URLAppenderController {

    private final URLInfoService urlInfoService;

    @Autowired
    public URLAppenderController(URLInfoService urlInfoService) {
        this.urlInfoService = urlInfoService;
    }

    @PostMapping("")
    public Long addURL(@RequestBody URLInfo order){

        return 0L;
    }

}
