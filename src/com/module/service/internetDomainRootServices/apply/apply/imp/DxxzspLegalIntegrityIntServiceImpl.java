package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspRootdnsPromiseMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspRootdnsPromiseWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspLegalIntegrityIntService;
import com.util.AppException;

@Service("DxxzspLegalIntegrityIntService")
public class DxxzspLegalIntegrityIntServiceImpl implements DxxzspLegalIntegrityIntService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRootdnsPromiseMapper dxxzspRootdnsPromiseMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspRootdnsPromiseWithBLOBs> list_ret = new ArrayList<DxxzspRootdnsPromiseWithBLOBs>();
		List<Map<String,Object>> list_RootdnsPromise =  commonMapper.findManyData("select * from DXXZSP_ROOTDNS_PROMISE where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_RootdnsPromise ){
			DxxzspRootdnsPromiseWithBLOBs blob = dxxzspRootdnsPromiseMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}

		ret.put("DXXZSP_ROOTDNS_PROMISE", list_ret);
		return ret;
	}
}

