package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspZzjyTermBusinessMapper;
import com.module.domain.registrationManagement.change.change.DxxzspZzjyTermBusinessWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaOneService;
import com.util.AppException;

@Service("DxxzspTerminationChangeChaOneService")
public class DxxzspTerminationChangeChaOneServiceImpl implements DxxzspTerminationChangeChaOneService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZzjyTermBusinessMapper dxxzspZzjyTermBusinessMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspZzjyTermBusinessWithBLOBs> list_ret = new ArrayList<DxxzspZzjyTermBusinessWithBLOBs>();
		List<Map<String,Object>> list_ZzjyTermBusiness =  commonMapper.findManyData("select * from DXXZSP_ZZJY_TERM_BUSINESS where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZzjyTermBusiness ){
			DxxzspZzjyTermBusinessWithBLOBs blob = dxxzspZzjyTermBusinessMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);

    	}
		ret.put("DXXZSP_ZZJY_TERM_BUSINESS", list_ret);
		return ret;
	}
}
