package com.module.service.threeWebElectric.change.change;

import java.util.Map;

import com.util.AppException;

//1、固定网国内数据传送业务
public interface DxxzspChangeLegRepService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

