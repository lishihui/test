package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspInfoproChangedMapper;
import com.module.domain.registrationManagement.change.change.DxxzspInfoproChangedWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change. DxxzspDxxzspInfoproChangedChaService;
import com.util.AppException;

@Service(" DxxzspDxxzspInfoproChangedChaService")
public class DxxzspDxxzspInfoproChangedChaServiceImpl implements  DxxzspDxxzspInfoproChangedChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Resource
	private DxxzspInfoproChangedMapper dxxzspInfoproChangedMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspInfoproChangedWithBLOBs> list_ret = new ArrayList<DxxzspInfoproChangedWithBLOBs>();
		List<Map<String,Object>> list_InfoproChangedCha =  commonMapper.findManyData("select * from DXXZSP_INFOPRO_CHANGED where itemid = '"+itemid+"'");		
		for(Map<String,Object> tmp : list_InfoproChangedCha ){
			DxxzspInfoproChangedWithBLOBs blob = dxxzspInfoproChangedMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_INFOPRO_CHANGED", list_ret);		
		return ret;
	}
}
