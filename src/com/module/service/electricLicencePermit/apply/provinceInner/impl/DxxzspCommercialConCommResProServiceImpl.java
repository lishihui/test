package com.module.service.electricLicencePermit.apply.provinceInner.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.apply.provinceInner.DxxzspFwydywMapper;
import com.module.domain.electricLicencePermit.apply.provinceInner.DxxzspFwydywWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspCommercialConCommResProService;
import com.util.AppException;

@Service("DxxzspCommercialConCommResProService")
public class DxxzspCommercialConCommResProServiceImpl implements DxxzspCommercialConCommResProService {
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspFwydywMapper dxxzspFwydywMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
        Map<String,Object> list_CommercialConCommRes =  commonMapper.findOneData("select * from DXXZSP_FWYDYW where itemid = '"+itemid+"'");
		
		if(list_CommercialConCommRes != null){
			String ywid = (String)list_CommercialConCommRes.get("ID");
			List<DxxzspFwydywWithBLOBs> list_ret = new ArrayList<DxxzspFwydywWithBLOBs>();
			List<Map<String,Object>> list_DxxzspFwydyw =  commonMapper.findManyData("select * from DXXZSP_FWYDYW where id = '"+ywid+"'");
			
			for(Map<String,Object> tmp : list_DxxzspFwydyw ){
				DxxzspFwydywWithBLOBs blob = dxxzspFwydywMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_FWYDYW", list_ret);
		}
		
		
		return ret;
	}
	
}
