package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspOtherMaterialsMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspOtherMaterialsWithBLOBs;

import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspTelecommManaReqIntService;
import com.util.AppException;

@Service("DxxzspTelecommManaReqIntService")
public class DxxzspTelecommManaReqIntServiceImpl implements DxxzspTelecommManaReqIntService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspOtherMaterialsMapper dxxzspOtherMaterialsMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_TelecommManaReqInt =  commonMapper.findOneData("select * from DXXZSP_OTHER_MATERIALS where itemid = '"+itemid+"'");
		if(list_TelecommManaReqInt != null){
			String ywid = (String) list_TelecommManaReqInt.get("ID");
		
			List<DxxzspOtherMaterialsWithBLOBs> list_ret = new ArrayList<DxxzspOtherMaterialsWithBLOBs>();
			
			
			List<Map<String,Object>> list_DxxzspOtherMaterials =  commonMapper.findManyData("select * from DXXZSP_OTHER_MATERIALS where id = '"+ywid+"'");
			
			for(Map<String,Object> tmp : list_DxxzspOtherMaterials ){
				DxxzspOtherMaterialsWithBLOBs blob = dxxzspOtherMaterialsMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret.add(blob);
	    		
	    	}
			ret.put("DXXZSP_OTHER_MATERIALS", list_ret);
			
		}	
		return ret;
	}
	
}

