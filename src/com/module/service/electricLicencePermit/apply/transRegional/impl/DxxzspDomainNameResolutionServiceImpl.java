package com.module.service.electricLicencePermit.apply.transRegional.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDomainNameResolutionService;
import com.util.AppException;

@Service("DxxzspDomainNameResolutionService")
public class DxxzspDomainNameResolutionServiceImpl implements DxxzspDomainNameResolutionService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_YMJXFW where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_YMJXFW where id = '"+ywid+"'");
			List<Map<String,Object>> list_agreement_platfrom =  commonMapper.findManyData("select * from DXXZSP_YMJXIPVSIXDTBG where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement_user =  commonMapper.findManyData("select * from DXXZSP_YMJXIPVDTVG where parentid = '"+parentid+"'");
			ret.put("DXXZSP_YMJXFW", list_agreement);
			ret.put("DXXZSP_YMJXIPVSIXDTBG", list_agreement_platfrom);
			ret.put("DXXZSP_YMJXIPVDTVG", list_agreement_user);
			
		}
		return ret;
	}
}
