package com.module.service.registrationManagement.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaService;
import com.util.AppException;

@Service("DxxzspTerminationChangeChaService")
public class DxxzspTerminationChangeChaServiceImpl implements DxxzspTerminationChangeChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_ZZJY_ZZJYBGB where itemid = '"+itemid+"'");
		ret.put("DXXZSP_ZZJY_ZZJYBGB", list_agreement);
		return ret;
	}
	
}