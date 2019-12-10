package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfCompanyChaProService;
import com.util.AppException;

@Service("DxxzspChangeOfCompanyChaProService")
public class DxxzspChangeOfCompanyChaProServiceImpl implements DxxzspChangeOfCompanyChaProService{
	@Resource
	private CommonMapper commonMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_ChangeOfCompanyChaPro =  commonMapper.findManyData("select * from COMPANY_CONVERSION where id = '"+id+"'");
		ret.put("COMPANY_CONVERSION", list_ChangeOfCompanyChaPro);

		return ret;
	}
}
