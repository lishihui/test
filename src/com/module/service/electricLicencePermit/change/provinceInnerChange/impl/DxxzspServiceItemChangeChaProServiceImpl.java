package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspServiceProjectChangeMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspServiceProjectChangeWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspServiceItemChangeChaProService;
import com.util.AppException;

@Service("DxxzspServiceItemChangeChaProService")
public class DxxzspServiceItemChangeChaProServiceImpl implements DxxzspServiceItemChangeChaProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspServiceProjectChangeMapper dxxzspServiceProjectChangeMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ServiceItemChangeChaPro =  commonMapper.findOneData("select * from SERVICE_PROJECT_CHANGE where id = '"+id+"'");
		if(list_ServiceItemChangeChaPro != null){
			String ywid = (String) list_ServiceItemChangeChaPro.get("ID");
			
			List<DxxzspServiceProjectChangeWithBLOBs> list_ret = new ArrayList<DxxzspServiceProjectChangeWithBLOBs>();
			List<Map<String,Object>> list_ServiceProjectChange =  commonMapper.findManyData("select * from SERVICE_PROJECT_CHANGE where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_ServiceProjectChange ){
				DxxzspServiceProjectChangeWithBLOBs blob = dxxzspServiceProjectChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    		
	    	}
			ret.put("SERVICE_PROJECT_CHANGE", list_ret);
			
		}
		return ret;
	}
	
}
