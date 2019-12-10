package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.DxxzspFwchangeMaterialMapper;
import com.module.domain.domainRegistration.change.change.DxxzspFwchangeMaterialWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspRangeRealmChangeChaService;
import com.util.AppException;

@Service("DxxzspRangeRealmChangeChaService")
public class DxxzspRangeRealmChangeChaServiceImpl implements DxxzspRangeRealmChangeChaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspFwchangeMaterialMapper dxxzspFwchangeMaterialMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_FWCHANGE_MATERIAL where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspFwchangeMaterialWithBLOBs> list_ret = new ArrayList<DxxzspFwchangeMaterialWithBLOBs>();
			List<Map<String,Object>> list_FwchangeMaterial =  commonMapper.findManyData("select * from DXXZSP_FWCHANGE_MATERIAL where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_FwchangeMaterial ){
				DxxzspFwchangeMaterialWithBLOBs blob = dxxzspFwchangeMaterialMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_FWCHANGE_MATERIAL", list_ret);
		}
		return ret;
	}
	
}
