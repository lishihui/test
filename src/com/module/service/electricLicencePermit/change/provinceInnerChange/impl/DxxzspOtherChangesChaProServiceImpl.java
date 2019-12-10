package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspOtherChangesChaProService;
import com.util.AppException;

@Service("DxxzspOtherChangesChaProService")
public class DxxzspOtherChangesChaProServiceImpl implements DxxzspOtherChangesChaProService {
	@Resource
	private CommonMapper commonMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_OtherMatterChanges =  commonMapper.findManyData("select * from OTHER_MATTER_CHANGES where id = '"+id+"'");
		ret.put("OTHER_MATTER_CHANGES", list_OtherMatterChanges);
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
