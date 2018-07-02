package com.home.manish.URLAppenderService.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class URLInfo {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "url_hash")
    private String urlHash;
    private String url;
    @Column(name = "backend_service")
    private String backendService;
    @Column(name = "domain_name")
    private String domainName;
    @Column(name = "ip_address")
    private String ipAddress;


    public Long getId() {
        return id;
    }


}
