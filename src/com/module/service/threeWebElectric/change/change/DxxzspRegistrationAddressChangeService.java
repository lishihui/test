package com.module.service.threeWebElectric.change.change;

import java.util.Map;

import com.util.AppException;

//1、国内甚小口径终端地球站通信业务
public interface DxxzspRegistrationAddressChangeService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
