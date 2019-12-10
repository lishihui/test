package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspTelecommManaReqMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspTelecommManaReqWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspTelecommManaReqService;
import com.util.AppException;

@Service("DxxzspTelecommManaReqService")
public class DxxzspTelecommManaReqServiceImpl implements DxxzspTelecommManaReqService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTelecommManaReqMapper dxxzspTelecommManaReqMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTelecommManaReqWithBLOBs> list_ret = new ArrayList<DxxzspTelecommManaReqWithBLOBs>();
		List<Map<String,Object>> list_DxxzspTelecommManaReq =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_OTHERS where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_DxxzspTelecommManaReq ){
			DxxzspTelecommManaReqWithBLOBs blob = dxxzspTelecommManaReqMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);

    	}
		ret.put("DXXZSP_DOMAIN_OTHERS", list_ret);
		
		return ret;
	}
}
