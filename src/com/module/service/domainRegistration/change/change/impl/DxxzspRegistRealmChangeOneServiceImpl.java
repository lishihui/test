package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.DxxzspAgencyLegalflexMapper;
import com.module.domain.domainRegistration.change.change.DxxzspAgencyLegalflexWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspRegistRealmChangeOneService;
import com.util.AppException;

@Service("DxxzspRegistRealmChangeOneService")
public class DxxzspRegistRealmChangeOneServiceImpl implements DxxzspRegistRealmChangeOneService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspAgencyLegalflexMapper dxxzspAgencyLegalflexMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspAgencyLegalflexWithBLOBs> list_ret = new ArrayList<DxxzspAgencyLegalflexWithBLOBs>();
		List<Map<String,Object>> list_RegistRealmChangeOne =  commonMapper.findManyData("select * from DXXZSP_AGENCY_LEGALFLEX where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_RegistRealmChangeOne ){
			DxxzspAgencyLegalflexWithBLOBs blob = dxxzspAgencyLegalflexMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}
		ret.put("DXXZSP_AGENCY_LEGALFLEX", list_ret);
		return ret;
	}
}
