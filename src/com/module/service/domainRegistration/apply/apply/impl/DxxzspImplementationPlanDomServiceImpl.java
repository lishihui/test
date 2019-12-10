package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspImplSchemeMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspImplSchemeWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspImplementationPlanDomService;
import com.util.AppException;

@Service("DxxzspImplementationPlanServiceCom")
public class DxxzspImplementationPlanDomServiceImpl implements DxxzspImplementationPlanDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspImplSchemeMapper dxxzspImplSchemeMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspImplSchemeWithBLOBs> list_ret = new ArrayList<DxxzspImplSchemeWithBLOBs>();
		List<Map<String,Object>> list_ImplScheme =  commonMapper.findManyData("select * from DXXZSP_IMPL_SCHEME where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ImplScheme ){
			DxxzspImplSchemeWithBLOBs blob = dxxzspImplSchemeMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_IMPL_SCHEME", list_ret);
		return ret;
	}
}
