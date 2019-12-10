package com.module.service.registrationManagement.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspRegistrationAddressChangeChaService;
import com.util.AppException;

@Service("DxxzspRegistrationAddressChangeChaService")
public class DxxzspRegistrationAddressChangeChaServiceImpl implements DxxzspRegistrationAddressChangeChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_OfficeAddress =  commonMapper.findManyData("select * from DXXZSP_OFFICE_ADDRESS where itemid = '"+itemid+"'");
		ret.put("DXXZSP_OFFICE_ADDRESS", list_OfficeAddress);
		return ret;
	}
	
}