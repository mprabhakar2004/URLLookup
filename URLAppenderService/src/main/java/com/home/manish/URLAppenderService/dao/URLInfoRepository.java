package com.home.manish.URLAppenderService.dao;

import com.home.manish.URLAppenderService.entities.URLInfo;
import org.springframework.data.repository.CrudRepository;

public interface URLInfoRepository extends CrudRepository<URLInfo,String> {
}
