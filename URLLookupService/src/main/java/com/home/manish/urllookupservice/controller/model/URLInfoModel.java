package com.home.manish.urllookupservice.controller.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


enum VulnerabilityStatus{
    SAFE,
    UNSAFE,
    UNKNOWN

}

public class URLInfoModel {

    private String urlHash;

    private String url;

    private String domainName;

    private String ipAddress;

    private VulnerabilityStatus vulnerabilityStatus;

    private String backendServices;


    public List<String> getBackendServices() {
        if (backendServices ==null)
            return new ArrayList<>();
        return Arrays.asList(backendServices.split(","));

    }
    public void setBackendServices(String backendServices) {
        this.backendServices = backendServices;
    }

    public String getUrlHash() {
        return urlHash;
    }

    public void setUrlHash(String urlHash) {
        this.urlHash = urlHash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public VulnerabilityStatus getVulnerabilityStatus() {
        return vulnerabilityStatus;
    }

    public void setVulnerabilityStatus(VulnerabilityStatus vulnerabilityStatus) {
        this.vulnerabilityStatus = vulnerabilityStatus;
    }

    public URLInfoModel getDefault() {
        this.vulnerabilityStatus = VulnerabilityStatus.UNKNOWN;
        return this;
    }
}

