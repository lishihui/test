package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcMergerMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcMergerWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspCompanyMergerService;
import com.util.AppException;

@Service("DxxzspCompanyMergerService")
public class DxxzspCompanyMergerServiceImpl implements DxxzspCompanyMergerService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRfcMergerMapper dxxzspRfcMergerMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspRfcMergerWithBLOBs> list_ret = new ArrayList<DxxzspRfcMergerWithBLOBs>();
		List<Map<String,Object>> list_CompanyMerger =  commonMapper.findManyData("select * from DXXZSP_RFC_MERGER where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_CompanyMerger ){
			DxxzspRfcMergerWithBLOBs blob = dxxzspRfcMergerMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}
		ret.put("DXXZSP_RFC_MERGER", list_ret);
		return ret;
	}
	
}
