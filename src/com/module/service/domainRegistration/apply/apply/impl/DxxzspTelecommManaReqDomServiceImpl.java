package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspOtherMaterialMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspOtherMaterialWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspTelecommManaReqDomService;
import com.util.AppException;

@Service("DxxzspTelecommManaReqDomService")
public class DxxzspTelecommManaReqDomServiceImpl implements DxxzspTelecommManaReqDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspOtherMaterialMapper dxxzspOtherMaterialMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspOtherMaterialWithBLOBs> list_ret = new ArrayList<DxxzspOtherMaterialWithBLOBs>();
		List<Map<String,Object>> list_OtherMaterial =  commonMapper.findManyData("select * from DXXZSP_OTHER_MATERIAL where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_OtherMaterial ){
			DxxzspOtherMaterialWithBLOBs blob = dxxzspOtherMaterialMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}

		ret.put("DXXZSP_OTHER_MATERIAL", list_ret);
		return ret;
	}
}
