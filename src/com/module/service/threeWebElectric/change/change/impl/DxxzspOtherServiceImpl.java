package com.module.service.threeWebElectric.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspOtherService;
import com.util.AppException;

@Service("DxxzspOtherService")
public class DxxzspOtherServiceImpl implements DxxzspOtherService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> map =  commonMapper.findOneData("select * from DXXSP_RFC_OTHER where itemid = '"+itemid+"'");
		
		if(map != null){
			String ywid = (String)map.get("ID");
			List<Map<String,Object>> list_Other =  commonMapper.findManyData("select * from DXXSP_RFC_OTHER where id = '"+ywid+"'");
			
			ret.put("DXXSP_RFC_OTHER", list_Other);
		}
		return ret;
	}
}