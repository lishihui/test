package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcShareholderMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcShareholderWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspChangeShareholdersService;
import com.util.AppException;

@Service("DxxzspChangeShareholdersService")
public class DxxzspChangeShareholdersServiceImpl implements DxxzspChangeShareholdersService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRfcShareholderMapper dxxzspRfcShareholderMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_ChangeShareholders =  commonMapper.findManyData("select * from DXXZSP_RFC_SHAREHOLDER where itemid = '"+itemid+"'");
		List<DxxzspRfcShareholderWithBLOBs> list_ret = new ArrayList<DxxzspRfcShareholderWithBLOBs>();
		for(Map<String,Object> tmp : list_ChangeShareholders ){
			DxxzspRfcShareholderWithBLOBs blob = dxxzspRfcShareholderMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);

    	}
		ret.put("DXXZSP_RFC_SHAREHOLDER", list_ret);
		return ret;
	}
	
}
