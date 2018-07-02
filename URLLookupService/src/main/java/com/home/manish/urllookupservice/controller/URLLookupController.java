package com.home.manish.urllookupservice.controller;

import com.google.common.collect.Lists;
import com.home.manish.urllookupservice.controller.model.URLInfoModel;
import com.home.manish.urllookupservice.entities.URLInfo;
import com.home.manish.urllookupservice.service.URINotFoundException;
import com.home.manish.urllookupservice.service.URLInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/urlinfo")
public class URLLookupController {

    final List<String> backendServices = Lists.newArrayList("https://www.virustotal.com/,http://www.urlvoid.com/");

    private final URLInfoService urlInfoService;
    @Autowired
    private ModelMapper modelMapper;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    public URLLookupController(URLInfoService urlInfoService) {
        this.urlInfoService = urlInfoService;
    }


    @GetMapping("{hostname_and_port}/{original_path_and_query_string}")
    public URLInfoModel getURLInfo(@PathVariable(name = "hostname_and_port") String hostNameAndPort,
                                   @PathVariable(name = "original_path_and_query_string",
                                           required = false) String urlPath) {

        String requestUrl = hostNameAndPort + "/" + urlPath.split("\\?")[0];
        String urlHash = null;
        try {
            urlHash = String.valueOf(DigestUtils.md5DigestAsHex(requestUrl.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        URLInfo urlInfo = null;
              try {
                  urlInfo = urlInfoService.findURLInfoByUrlId(urlHash)
                          .orElseThrow(() -> new URINotFoundException("Url [" + requestUrl + "] doesn't exist"));
              }catch (URINotFoundException exp){
                  for (String backingService:backendServices){
                      executorService.submit(new URLInfoFetcher(requestUrl,backingService));
                  }
              }
        return convertToModel(urlInfo);
    }


    private URLInfoModel convertToModel(URLInfo urlInfo) {
        if(urlInfo==null){
            return new URLInfoModel().getDefault();
        }
        return modelMapper.map(urlInfo, URLInfoModel.class);
    }


    class URLInfoFetcher implements Runnable{
        private String currentUrl;
        private String backingService;
        public URLInfoFetcher(String currentUrl, String backingService){
            this.backingService = backingService;
            this.currentUrl = currentUrl;
        }

        @Override
        public void run() {
            // Call the backingservice for the currenturl.  parse result and send it out to URLAppenderService.
        }
    }

}
