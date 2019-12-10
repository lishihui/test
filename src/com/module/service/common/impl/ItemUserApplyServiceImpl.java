package com.module.service.common.impl;

import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;
@Service("ItemUserApplyService")
public class ItemUserApplyServiceImpl implements ItemUserApplyService {
	@Resource
	private CommonMapper commonMapper;
	@Override
	public String getProcessId(String id)
			throws AppException {
		// TODO Auto-generated method stub
	
		List<Map<String, Object>> list_agreement =commonMapper.findManyData("select item_id from item_user_apply where process_id = '"+id+"'");
         if(list_agreement != null && list_agreement.size()>0){
        	 String  result = list_agreement.get(0).get("ITEM_ID").toString();
        	 return result;
         }else{
        	 return null;
         }
	}

}
  