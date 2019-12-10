package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.WlxxaqMapper;
import com.module.domain.domainRegistration.apply.apply.WlxxaqWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspGuaranteeSystemandMeasuresDomService;
import com.util.AppException;

@Service("DxxzspGuaranteeSystemandMeasuresDomService")
public class DxxzspGuaranteeSystemandMeasuresDomServiceImpl implements DxxzspGuaranteeSystemandMeasuresDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private WlxxaqMapper wlxxzqMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<WlxxaqWithBLOBs> list_ret = new ArrayList<WlxxaqWithBLOBs>();
		List<Map<String,Object>> list_Wlxxaq =  commonMapper.findManyData("select * from WLXXAQ where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_Wlxxaq ){
			WlxxaqWithBLOBs blob = wlxxzqMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("WLXXAQ", list_ret);
		return ret;
	}
	
}
