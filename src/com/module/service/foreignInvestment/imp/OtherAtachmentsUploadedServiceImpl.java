package com.module.service.foreignInvestment.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.foreignInvestment.OtherAtachmentsUploadedService;
import com.util.AppException;

//外商投资其他附件上传（otherAtachmentsUploaded）
@Service("OtherAtachmentsUploadedService")
public class OtherAtachmentsUploadedServiceImpl implements OtherAtachmentsUploadedService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_QITAFUJIAN where itemid = '"+Itemid+"' or id = '"+id+"' ");

    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_DTBGQTFJSC =  commonMapper.findManyData("select * from DXXZSP_QITAFUJIAN where id = '"+ywid+"'");
    	
	    	ret.put("list_DTBGQTFJSC", list_DTBGQTFJSC);
	    
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		OtherAtachmentsUploadedService test = (OtherAtachmentsUploadedService) ac.getBean("OtherAtachmentsUploadedService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
