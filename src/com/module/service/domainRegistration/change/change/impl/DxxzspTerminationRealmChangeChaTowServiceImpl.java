package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspZzjyTermBusinessMapper;
import com.module.domain.registrationManagement.change.change.DxxzspZzjyTermBusinessWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaTowService;
import com.util.AppException;

@Service("DxxzspTerminationRealmChangeChaTowService")
public class DxxzspTerminationRealmChangeChaTowServiceImpl implements DxxzspTerminationRealmChangeChaTowService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZzjyTermBusinessMapper dxxzspZzjyTermBusinessMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_ZZJY_TERM_BUSINESS where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspZzjyTermBusinessWithBLOBs> list_ret = new ArrayList<DxxzspZzjyTermBusinessWithBLOBs>();
			List<Map<String,Object>> list_ZzjyTermBusiness =  commonMapper.findManyData("select * from DXXZSP_ZZJY_TERM_BUSINESS where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_ZzjyTermBusiness ){
				DxxzspZzjyTermBusinessWithBLOBs blob = dxxzspZzjyTermBusinessMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_ZZJY_TERM_BUSINESS", list_ret);
		}
		return ret;
	}
	
}
