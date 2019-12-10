package com.module.service.registrationManagement.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.DxxzspAgencyPromiseMapper;
import com.module.domain.domainRegistration.change.change.DxxzspAgencyPromiseWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.comm.DxxzspLegalIntegrityComService;
import com.util.AppException;

@Service("DxxzspLegalIntegrityComService")
public class DxxzspLegalIntegrityComServiceImpl implements DxxzspLegalIntegrityComService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspAgencyPromiseMapper dxxzspAgencyPromiseMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspAgencyPromiseWithBLOBs> list_ret = new ArrayList<DxxzspAgencyPromiseWithBLOBs>();
		List<Map<String,Object>> list_AgencyPromise =  commonMapper.findManyData("select * from DXXZSP_AGENCY_PROMISE where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_AgencyPromise ){
			DxxzspAgencyPromiseWithBLOBs blob = dxxzspAgencyPromiseMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_AGENCY_PROMISE", list_ret);
		return ret;
	}
}
