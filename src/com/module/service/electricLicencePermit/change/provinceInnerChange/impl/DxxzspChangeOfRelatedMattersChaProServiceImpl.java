package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspAppChildformMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspWebChildformMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspAppChildformWithBLOBs;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspWebChildformWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfRelatedMattersChaProService;
import com.util.AppException;

@Service("DxxzspChangeOfRelatedMattersChaProService")
public class DxxzspChangeOfRelatedMattersChaProServiceImpl implements DxxzspChangeOfRelatedMattersChaProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspWebChildformMapper dxxzspWebChildformMapper;
	@Resource
	private DxxzspAppChildformMapper dxxzspAppChildformMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ChangeOfRelatedMatters =  commonMapper.findOneData("select * from APP_RELATED_CHANGE where id = '"+id+"'");
		if(list_ChangeOfRelatedMatters != null){
			String ywid = (String) list_ChangeOfRelatedMatters.get("ID");
			String parentid = (String) list_ChangeOfRelatedMatters.get("ID");
			List<DxxzspWebChildformWithBLOBs> list_retWeb = new ArrayList<DxxzspWebChildformWithBLOBs>();
			List<DxxzspAppChildformWithBLOBs> list_retApp = new ArrayList<DxxzspAppChildformWithBLOBs>();
			List<Map<String,Object>> list_AppRelatedChange =  commonMapper.findManyData("select * from APP_RELATED_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DxxzspWebChildform =  commonMapper.findManyData("select * from DXXZSP_WEB_CHILDFORM where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DxxzspAppChildform =  commonMapper.findManyData("select * from DXXZSP_APP_CHILDFORM where PARENTID = '"+parentid+"'");
			for(Map<String,Object> tmp : list_DxxzspWebChildform ){
				DxxzspWebChildformWithBLOBs blob = dxxzspWebChildformMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_retWeb.add(blob);
//	    		System.out.println("================================");
//	    		System.out.print(list_ret);
//	    		System.out.println("================================");
	    	}
			for(Map<String,Object> tmp : list_DxxzspAppChildform ){
				DxxzspAppChildformWithBLOBs blob = dxxzspAppChildformMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_retApp.add(blob);
//	    		System.out.println("================================");
//	    		System.out.print(list_ret);
//	    		System.out.println("================================");
	    	}
			// System.out.println("================================");
			// System.out.print(list_agreement);
			// System.out.print(list_agreement1);
			// System.out.print(list_agreement2);
			// System.out.printf("================================");
			ret.put("APP_RELATED_CHANGE", list_AppRelatedChange);
			ret.put("DXXZSP_WEB_CHILDFORM", list_retWeb);
			ret.put("DXXZSP_APP_CHILDFORM", list_retApp);
		}	
		return ret;
	}
}
