
High Level component diagram : 

![urllookup srevice](https://user-images.githubusercontent.com/1819006/42159732-6ad32fd6-7e12-11e8-82f5-3c32bd6725c1.png)


Description of Component: Entire application has been split into 5 major parts by considering all the aspect like scaliblity, availability etc. 
* APIGateway 
* Service Registry 
* URLLookupService 
* URLAppenderService
* AggregatorService


### APIGateway ###
This is an edge server which take all the request and transfer it to corresponding service. This will helps us in making
our underline service scalable as well prevent some well know exploitation (like DOS). Also we can add authorisation in
de-coupled way. As this service directly talked with service registry to find out all the running underline service 
instance so we can easily scale our service by just simply spawning an instance of the service. 


### Service Registry ###

All underlined service will be registered with eureka server. It helps in loosely coupled the service as caller don't 
have to bother about actual physical address where service is running. We can easily monitor health of services from 
eureka dashboard. 


### URLLookupService ###

Exposed API : GET /urlinfo/{hostname_and_port}/{original_path_and_query_string}

Response JSON : 
        `
        {
          "urlHash": "e352e52d74e7a40455fcd9a45a4c20c4",
          "url": "www.abcd.com/test?nam=r",
          "domainName": "abcd.com",
          "ipAddress": "162.143.54.1",
          "vulnerabilityStatus": "SAFE",
          "backendServices": [
            "https://www.brightcloud.com",
            "https://sitecheck.sucuri.net/",
            "https://www.virustotal.com/",
            "http://www.urlvoid.com/"
          ]
        }`
        

Every requested url will be mapped to MD5 hash i.e. urlHash. Search it into cache server for the requested information.
If not found fetched it from database update the cache and return the result to the client. Every url will have 
vulnerabilityStatus status as SAFE, UNSAFE or UNKNOWN. If it is UNKNOWN we will initiate a call to get reputation report 
from list of managed backend reputation services. After getting the report the process will call URLAppenderService with
received value. Cassandra will be used as backend database. Data will be replicated across multiple Node in a cluster. This cassandra
node only store the aggregated value. 

Planning to have two different database server- one will store raw data received from various backend reputation server
and second will store the aggregated value and used by URLLookup service. 


### URLAppenderService ###
This service will take the vulnerability information from various source and stored it into database. We need to have 
various approach like push as well pull mechanism to get report from source reputation service.


### AggregatorService ###

This is an background service which take data from Master database cluster for each individual URL and aggregate the 
report and finally put aggregated value to Aggregated database cluster.



