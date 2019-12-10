package com.module.service.electricLicencePermit.change.TransRegionalChange.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspChangeOfCompanyChaTraService;
import com.util.AppException;

@Service("DxxzspChangeOfCompanyChaTraService")
public class DxxzspChangeOfCompanyChaTraServiceImpl implements DxxzspChangeOfCompanyChaTraService{
	@Resource
	private CommonMapper commonMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_ChangeOfCompany =  commonMapper.findManyData("select * from COMPANY_CONVERSION where id = '"+id+"'");
		ret.put("COMPANY_CONVERSION", list_ChangeOfCompany);
//		System.out.println("================================");
//		System.out.println(ret);
//		 for (Entry<String, Object> entry : ret.entrySet()) {
//	            System.out.println("key= " + entry.getKey() + " and value= "
//	                    + entry.getValue());
//	        }
//		System.out.printf("================================");
		return ret;
	}
}
