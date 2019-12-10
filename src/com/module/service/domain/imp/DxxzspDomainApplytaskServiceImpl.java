package com.module.service.domain.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.service.domain.IDxxzspDomainApplytaskService;
import com.util.AppException;

//1、申请表单
@Service("DxxzspDomainApplytaskService")
public class DxxzspDomainApplytaskServiceImpl implements IDxxzspDomainApplytaskService {
	
	@Resource
	private CommonMapper commonMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_DOMAIN_APPLYTASK where itemid = '"+id+"' or id = '"+id+"' or flowrunid_ = '"+flowrunid+"'");
    	if(map !=null){	
    		String ywid = (String)map.get("ID");
    		String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_applytask =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_APPLYTASK where id = '"+ywid+"'");
	    	List<Map<String,Object>> list_applytask_dns =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_APPLYTASK_DNS where parentid = '"+ywid+"' order by XH");
	    	
	    	ret.put("applytask", list_applytask);
	    	ret.put("applytask_dns", list_applytask_dns);
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainApplytaskService test = (IDxxzspDomainApplytaskService) ac.getBean("DxxzspDomainApplytaskService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
