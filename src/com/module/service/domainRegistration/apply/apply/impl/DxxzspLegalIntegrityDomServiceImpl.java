package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspLegallyLetterMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspLegallyLetterWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspLegalIntegrityDomService;
import com.util.AppException;

@Service("DxxzspLegalIntegrityDomService")
public class DxxzspLegalIntegrityDomServiceImpl implements DxxzspLegalIntegrityDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspLegallyLetterMapper dxxzspLegallyLetterMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspLegallyLetterWithBLOBs> list_ret = new ArrayList<DxxzspLegallyLetterWithBLOBs>();
		List<Map<String,Object>> list_LegallyLetter =  commonMapper.findManyData("select * from DXXZSP_LEGALLY_LETTER where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_LegallyLetter ){
			DxxzspLegallyLetterWithBLOBs blob = dxxzspLegallyLetterMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_LEGALLY_LETTER", list_ret);
		return ret;
	}
}
