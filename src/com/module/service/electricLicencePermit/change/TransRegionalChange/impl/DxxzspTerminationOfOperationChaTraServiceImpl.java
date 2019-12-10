package com.module.service.electricLicencePermit.change.TransRegionalChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.TransRegionalChange.TerminateApplicationMapper;
import com.module.domain.electricLicencePermit.change.TransRegionalChange.TerminateApplicationWithBLOBs;
import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspTerminationOfOperationChaTraService;
import com.util.AppException;

@Service("DxxzspTerminationOfOperationChaTraService")
public class DxxzspTerminationOfOperationChaTraServiceImpl implements DxxzspTerminationOfOperationChaTraService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private TerminateApplicationMapper terminateApplicationMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<TerminateApplicationWithBLOBs> list_ret = new ArrayList<TerminateApplicationWithBLOBs>();
		List<Map<String,Object>> list_TerminationOfOperation =  commonMapper.findManyData("select * from TERMINATE_APPLICATION where id = '"+id+"'");
		for(Map<String,Object> tmp : list_TerminationOfOperation ){
			TerminateApplicationWithBLOBs blob = terminateApplicationMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);

    	}
		ret.put("TERMINATE_APPLICATION", list_ret);

		return ret;
	}
}
