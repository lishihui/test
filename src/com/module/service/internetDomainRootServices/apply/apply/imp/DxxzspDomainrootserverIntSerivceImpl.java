package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspDnsOrganizationMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspDnsOrganizationWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspDomainrootserverIntSerivce;
import com.util.AppException;

@Service("DxxzspDomainrootserverIntSerivce")
public class DxxzspDomainrootserverIntSerivceImpl implements DxxzspDomainrootserverIntSerivce {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDnsOrganizationMapper dxxzspDnsOrganizationMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_Domainrootserver =  commonMapper.findOneData("select * from DXXZSP_DNS_ORGANIZATION where itemid = '"+itemid+"'");
		if(list_Domainrootserver != null){
			String ywid = (String) list_Domainrootserver.get("ID");
			String parentid = (String) list_Domainrootserver.get("ID");
			List<DxxzspDnsOrganizationWithBLOBs> list_ret = new ArrayList<DxxzspDnsOrganizationWithBLOBs>();
			List<Map<String,Object>> list_DxxzspDnsOrganization =  commonMapper.findManyData("select * from DXXZSP_DNS_ORGANIZATION where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_DxxzspDnsOrganization ){
				DxxzspDnsOrganizationWithBLOBs blob = dxxzspDnsOrganizationMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			List<Map<String,Object>> list_ShareholderDynamic =  commonMapper.findManyData("select * from SHAREDHOLDER_DYNAMIC where parentid = '"+parentid+"'");
			ret.put("DXXZSP_DNS_ORGANIZATION", list_ret);
			ret.put("SHAREDHOLDER_DYNAMIC", list_ShareholderDynamic);
		}
		return ret;
	}
	
}

