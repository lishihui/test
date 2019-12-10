package com.module.service.threeWebElectric.change.comm;

import java.util.Map;

import com.util.AppException;



public interface DxxzspContactService {
   
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
