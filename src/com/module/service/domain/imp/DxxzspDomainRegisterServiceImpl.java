package com.module.service.domain.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspDomainRegisterMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspDomainRegisterWithBLOBs;
import com.module.service.domain.IDxxzspDomainRegisterService;
import com.util.AppException;

//3、域名注册管理机构申请表
@Service("DxxzspDomainRegisterService")
public class DxxzspDomainRegisterServiceImpl implements IDxxzspDomainRegisterService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspDomainRegisterMapper dxxzspDomainRegisterMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_DOMAIN_APPLYTASK where  itemid = '"+id+"' or id = '"+id+"' or flowrunid_ = '"+flowrunid+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<DxxzspDomainRegisterWithBLOBs> list_ret = new ArrayList<DxxzspDomainRegisterWithBLOBs>();
	    	List<Map<String,Object>> list_tmp =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_REGISTER where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_tmp ){
	    		DxxzspDomainRegisterWithBLOBs blob = dxxzspDomainRegisterMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("register", list_ret);
	    	//股东
	    	List<Map<String,Object>> list_register_stockright =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_REGISTER_STOCKRIGHT where itemid = '"+itemid+"' ");
	    	ret.put("register_stockright", list_register_stockright);
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainRegisterService test = (IDxxzspDomainRegisterService) ac.getBean("DxxzspDomainRegisterService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
