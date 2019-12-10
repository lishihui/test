package com.module.service.electricLicencePermit.apply.comm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.comm.DxxzspShareholderTraIndInforService;
import com.util.AppException;

@Service("DxxzspShareholderTraIndInforService")
public class DxxzspShareholderTraIndInforServiceImpl implements DxxzspShareholderTraIndInforService{
	@Resource
	private CommonMapper commonMapper;
	@Resource 
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
        String   itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_DxxzspQyguquan =  commonMapper.findManyData("select * from DXXZSP_QYGUQUAN where itemid = '"+itemid+"'");		
		ret.put("DXXZSP_QYGUQUAN", list_DxxzspQyguquan);		
		
		return ret;
	}
}
