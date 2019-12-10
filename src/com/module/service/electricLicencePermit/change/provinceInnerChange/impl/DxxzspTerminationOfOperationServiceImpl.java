package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspTerminationOfOperationMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspTerminationOfOperationWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspTerminationOfOperationService;
import com.util.AppException;

@Service("DxxzspTerminationOfOperationService")
public class DxxzspTerminationOfOperationServiceImpl implements DxxzspTerminationOfOperationService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTerminationOfOperationMapper dxxzspTerminationOfOperationMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTerminationOfOperationWithBLOBs> list_ret = new ArrayList<DxxzspTerminationOfOperationWithBLOBs>();
		List<Map<String,Object>> list_DxxzspTerminationOfOperation =  commonMapper.findManyData("select * from TERMINATE_APPLICATION where id = '"+id+"'");
		
		for(Map<String,Object> tmp : list_DxxzspTerminationOfOperation ){
			DxxzspTerminationOfOperationWithBLOBs blob = dxxzspTerminationOfOperationMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);

    	}
		ret.put("TERMINATE_APPLICATION", list_ret); 
		return ret;
	}
}
