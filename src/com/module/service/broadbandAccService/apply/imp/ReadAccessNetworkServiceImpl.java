package com.module.service.broadbandAccService.apply.imp;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.broadbandAccService.apply.ReadAccessNetworkService;
import com.util.AppException;


@Service("ReadAccessNetworkService")
public class ReadAccessNetworkServiceImpl implements ReadAccessNetworkService{
	@Resource
	private CommonMapper commonMapper;
	
	
	
	
	@Override
	public String  getShiJianId(String flowrunid) throws AppException {
    	   Map<String,Object> map = commonMapper.findOneData("select  SHIJIAN_ID from Item_User_Apply where PROCESS_ID ='"+flowrunid+"' ");
    	   if(map == null) {
    		   System.out.print("====事件Id获取失败====");
    	   }
    		return  (String)map.get("SHIJIAN_ID");
	  
	}

}
