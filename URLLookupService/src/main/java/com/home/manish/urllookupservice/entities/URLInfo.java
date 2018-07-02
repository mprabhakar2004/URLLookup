package com.home.manish.urllookupservice.entities;

import javax.persistence.*;


enum VulnerabilityStatus{
    SAFE,
    UNSAFE,
    UNKNOWN

}

@Entity
public class URLInfo {

    @Id
    @Column(name = "url_hash")
    private String urlHash;

    private String url;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "vulnerability_status")
    @Enumerated(EnumType.STRING)
    private VulnerabilityStatus vulnerabilityStatus;

    @Column(name = "backend_services", nullable = true)
    private String backendServices;

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

    public String getBackendServices() {

        return backendServices;

    }

    public void setBackendServices(String backendServices) {
        this.backendServices = backendServices;
    }
}
