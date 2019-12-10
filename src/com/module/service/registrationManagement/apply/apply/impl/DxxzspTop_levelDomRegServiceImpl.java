package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspDjymglxgxylistsMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspDjymglxgxylistsWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspTop_levelDomRegService;
import com.util.AppException;

@Service("DxxzspTop_levelDomRegService")
public class DxxzspTop_levelDomRegServiceImpl  implements DxxzspTop_levelDomRegService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDjymglxgxylistsMapper dxxzspDjymglxgxylistsMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DJYMGLXGXYLISTS where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			
			List<DxxzspDjymglxgxylistsWithBLOBs> list_ret = new ArrayList<DxxzspDjymglxgxylistsWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DJYMGLXGXYLISTS where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				DxxzspDjymglxgxylistsWithBLOBs blob = dxxzspDjymglxgxylistsMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from VERIFICATION_SYSTEM where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from EMERGENCY_HOST_ZONG where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement3 =  commonMapper.findManyData("select * from REGISTER_DATA_HOST where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement4 =  commonMapper.findManyData("select * from SYSTEM_BUILD where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement5 =  commonMapper.findManyData("select * from OFFICE_ADDRESS where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement6 =  commonMapper.findManyData("select * from SYSTEM_CONSTRUCTION where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement7 =  commonMapper.findManyData("select * from EXCLUSIVE_AGREEMENT where parentid = '"+parentid+"'");
			System.out.println("================================");
			System.out.print(list_ret);
			System.out.print(list_agreement1);
			System.out.print(list_agreement2);
			System.out.print(list_agreement3);
			System.out.print(list_agreement4);
			System.out.print(list_agreement5);
			System.out.print(list_agreement6);
			System.out.print(list_agreement7);
			System.out.printf("================================");
			ret.put("DJYMGLXGXYLISTS", list_ret);
			ret.put("VERIFICATION_SYSTEM", list_agreement1);
			ret.put("EMERGENCY_HOST_ZONG", list_agreement2);
			ret.put("REGISTER_DATA_HOST", list_agreement3);
			ret.put("SYSTEM_BUILD", list_agreement4);
			ret.put("OFFICE_ADDRESS", list_agreement5);
			ret.put("SYSTEM_CONSTRUCTION", list_agreement6);
			ret.put("EXCLUSIVE_AGREEMENT", list_agreement7);
//			System.out.println("================================");
//			System.out.println(ret);
//			 for (Entry<String, Object> entry : ret.entrySet()) {
//		            System.out.println("key= " + entry.getKey() + " and value= "
//		                    + entry.getValue());
//		        }
//			System.out.printf("================================");
		}
		return ret;
	}
	
}
