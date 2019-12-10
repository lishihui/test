package com.module.service.domain;

import com.util.AppException;

import java.util.Map;

public interface IDxxzspDomainPlaceService {
    Map<String,Object> getRow(String id, String flowrunid) throws AppException;
}
