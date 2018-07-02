package com.home.manish.urllookupservice.dao;

import com.home.manish.urllookupservice.entities.URLInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLInfoRepository extends CrudRepository<URLInfo, String> {

    Optional<URLInfo> findURLInfoByUrlHash(String urlId);
}
