package com.module.service.electricLicencePermit.change.commChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.domain.electricLicencePermit.change.commChange.DxxzspLicenseOfLegalPersonWithBLOBs;
import com.module.dao.electricLicencePermit.change.commChange.DxxzspLicenseOfLegalPersonMapper;
import com.module.service.electricLicencePermit.change.commChange.DxxzspLicenseOfLegalPersonChaComService;
import com.util.AppException;

@Service("DxxzspLicenseOfLegalPersonChaCom")
public class DxxzspLicenseOfLegalPersonChaComServiceImpl implements DxxzspLicenseOfLegalPersonChaComService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspLicenseOfLegalPersonMapper dxxzspLicenseOfLegalPersonMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspLicenseOfLegalPersonWithBLOBs> list_ret = new ArrayList<DxxzspLicenseOfLegalPersonWithBLOBs>();
		List<Map<String,Object>> list_LicenseOfLegalPerson =  commonMapper.findManyData("select * from CHANGE_PUBLIC_FORMS where id = '"+id+"'");
		for(Map<String,Object> tmp : list_LicenseOfLegalPerson ){
			DxxzspLicenseOfLegalPersonWithBLOBs blob = dxxzspLicenseOfLegalPersonMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
//    		System.out.println("================================");
//    		System.out.print(list_ret);
//    		System.out.println("================================");
    	}
		ret.put("CHANGE_PUBLIC_FORMS", list_LicenseOfLegalPerson);
//		System.out.println("================================");
//		System.out.println(ret);
//		 for (Entry<String, Object> entry : ret.entrySet()) {
//	            System.out.println("key= " + entry.getKey() + " and value= "
//	                    + entry.getValue());
//	        }
//		System.out.printf("================================");
		return ret;
	}
}
