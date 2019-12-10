package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspTopDomainInfoMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspTopDomainInfoWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspTopLevelDomainService;
import com.util.AppException;

@Service("DxxzspTopLevelDomainService")
public class DxxzspTopLevelDomainServiceImpl implements DxxzspTopLevelDomainService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTopDomainInfoMapper dxxzspTopDomainInfoMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_DxxzspTopDomainInfo =  commonMapper.findManyData("select * from DXXZSP_TOP_DOMAIN_INFO where itemid = '"+itemid+"'");
		List<DxxzspTopDomainInfoWithBLOBs> list_ret = new ArrayList<DxxzspTopDomainInfoWithBLOBs>();
		for(Map<String,Object> tmp : list_DxxzspTopDomainInfo ){
			DxxzspTopDomainInfoWithBLOBs blob = dxxzspTopDomainInfoMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_TOP_DOMAIN_INFO", list_ret);
		
		return ret;
	}
}
