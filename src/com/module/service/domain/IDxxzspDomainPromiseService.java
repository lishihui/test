package com.module.service.domain;

import com.util.AppException;

import java.util.Map;

public interface IDxxzspDomainPromiseService {
    Map<String, Object> getRow(String id, String flowrunid) throws AppException;
}
