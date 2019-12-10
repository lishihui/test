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
import com.module.dao.domain.DxxzspDomainNetworksafetyMapper;
import com.module.domain.domain.DxxzspDomainNetworksafetyWithBLOBs;
import com.module.service.domain.IDxxzspDomainNetworksafetyService;
import com.util.AppException;

//7、网络安全保障措施
@Service("DxxzspDomainNetworksafetyService")
public class DxxzspDomainNetworksafetyServiceImpl implements IDxxzspDomainNetworksafetyService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspDomainNetworksafetyMapper dxxzspDomainNetworksafetyMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_DOMAIN_APPLYTASK where  itemid = '"+id+"' or id = '"+id+"' or flowrunid_ = '"+flowrunid+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<DxxzspDomainNetworksafetyWithBLOBs> list_ret = new ArrayList<DxxzspDomainNetworksafetyWithBLOBs>();
	    	List<Map<String,Object>> list_Networksafety =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_NETWORKSAFETY where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_Networksafety ){
	    		DxxzspDomainNetworksafetyWithBLOBs blob = dxxzspDomainNetworksafetyMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("networksafety", list_ret);
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainNetworksafetyService test = (IDxxzspDomainNetworksafetyService) ac.getBean("DxxzspDomainNetworksafetyService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
