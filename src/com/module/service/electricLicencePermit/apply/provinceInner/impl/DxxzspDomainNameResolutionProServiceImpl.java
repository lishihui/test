package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDomainNameResolutionProService;
import com.util.AppException;

@Service("DxxzspDomainNameResolutionProService")
public class DxxzspDomainNameResolutionProServiceImpl implements DxxzspDomainNameResolutionProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_DomainNameResolution =  commonMapper.findOneData("select * from DXXZSP_YMJXFW where itemid = '"+itemid+"'");
		if(list_DomainNameResolution != null){
			String ywid = (String) list_DomainNameResolution.get("ID");
			String parentid = (String) list_DomainNameResolution.get("ID");
			List<Map<String,Object>> list_DxxzspYmjxfw =  commonMapper.findManyData("select * from DXXZSP_YMJXFW where id = '"+ywid+"'");
			List<Map<String,Object>> list_DxxzspYmjxipvsixdtbg =  commonMapper.findManyData("select * from DXXZSP_YMJXIPVSIXDTBG where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DxxzspYmjxipvdtvg =  commonMapper.findManyData("select * from DXXZSP_YMJXIPVDTVG where PARENTID = '"+parentid+"'");
			ret.put("DXXZSP_YMJXFW", list_DxxzspYmjxfw);
			ret.put("DXXZSP_YMJXIPVSIXDTBG", list_DxxzspYmjxipvsixdtbg);
			ret.put("DXXZSP_YMJXIPVDTVG", list_DxxzspYmjxipvdtvg);
		}
		
		
		return ret;
	}
}
