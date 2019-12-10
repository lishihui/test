package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspSafePlanMapper;
import com.module.domain.registrationManagement.change.change.DxxzspSafePlanWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaFivService;
import com.util.AppException;

@Service("DxxzspTerminationRealmChangeChaFivService")
public class DxxzspTerminationRealmChangeChaFivServiceImpl implements DxxzspTerminationRealmChangeChaFivService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspSafePlanMapper dxxzspSafePlanMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_SAFE_PLAN where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspSafePlanWithBLOBs> list_ret = new ArrayList<DxxzspSafePlanWithBLOBs>();
			List<Map<String,Object>> list_SafePlan =  commonMapper.findManyData("select * from DXXZSP_SAFE_PLAN where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_SafePlan ){
				DxxzspSafePlanWithBLOBs blob = dxxzspSafePlanMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_SAFE_PLAN", list_ret);
		}
		return ret;
	}
	
}
