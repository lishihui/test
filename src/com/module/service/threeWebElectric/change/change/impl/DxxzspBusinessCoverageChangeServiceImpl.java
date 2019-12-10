package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcBusinesscoverMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcBusinesscoverWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspBusinessCoverageChangeService;
import com.util.AppException;

@Service("DxxzspBusinessCoverageChangeService")
public class DxxzspBusinessCoverageChangeServiceImpl implements DxxzspBusinessCoverageChangeService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRfcBusinesscoverMapper dxxzspRfcBusinesscoverMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_BusinessCoverageChange =  commonMapper.findManyData("select * from DXXZSP_RFC_BUSINESSCOVER where itemid = '"+itemid+"'");
		
		List<DxxzspRfcBusinesscoverWithBLOBs> list_ret = new ArrayList<DxxzspRfcBusinesscoverWithBLOBs>();
		for(Map<String,Object> tmp : list_BusinessCoverageChange){
			DxxzspRfcBusinesscoverWithBLOBs blob = dxxzspRfcBusinesscoverMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}

		
		
		ret.put("DXXZSP_RFC_BUSINESSCOVER", list_ret);

		return ret;
	}
}
