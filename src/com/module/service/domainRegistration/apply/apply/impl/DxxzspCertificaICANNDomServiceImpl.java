package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspServerSystemMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspServerSystemWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspCertificaICANNDomService;
import com.util.AppException;

@Service("DxxzspCertificaICANNDomService")
public class DxxzspCertificaICANNDomServiceImpl implements DxxzspCertificaICANNDomService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspServerSystemMapper dxxzspServerSystemMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspServerSystemWithBLOBs> list_ret = new ArrayList<DxxzspServerSystemWithBLOBs>();
		List<Map<String,Object>> list_CertificaICANNDom =  commonMapper.findManyData("select * from DXXZSP_SERVER_SYSTEM where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_CertificaICANNDom ){
			DxxzspServerSystemWithBLOBs blob = dxxzspServerSystemMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}
		ret.put("DXXZSP_SERVER_SYSTEM", list_ret);
		return ret;
	}
}
