package com.module.service.ftaTradeApplication.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.comm.ZmqcChangePublicFormsMapper;
import com.module.domain.ftaTradeApplication.change.comm.ZmqcChangePublicFormsWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.comm.DxxzspLicenseOfLegalPersonFtaService;
import com.util.AppException;

@Service("DxxzspLicenseOfLegalPersonFta")
public class DxxzspLicenseOfLegalPersonFtaServiceImpl implements DxxzspLicenseOfLegalPersonFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcChangePublicFormsMapper zmqcChangePublicFormsMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<ZmqcChangePublicFormsWithBLOBs> list_ret = new ArrayList<ZmqcChangePublicFormsWithBLOBs>();
		List<Map<String,Object>> list_ZmqcChangePublicForms =  commonMapper.findManyData("select * from ZMQC_CHANGE_PUBLIC_FORMS where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZmqcChangePublicForms ){
			ZmqcChangePublicFormsWithBLOBs blob = zmqcChangePublicFormsMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("ZMQC_CHANGE_PUBLIC_FORMS", list_ret);
		return ret;
	}
}
