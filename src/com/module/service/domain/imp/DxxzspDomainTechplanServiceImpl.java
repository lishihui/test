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
import com.module.dao.domain.DxxzspDomainTechplanMapper;
import com.module.domain.domain.DxxzspDomainTechplanWithBLOBs;
import com.module.service.domain.IDxxzspDomainTechplanService;
import com.util.AppException;

//5、 技术实施方案表
@Service("DxxzspDomainTechplanService")
public class DxxzspDomainTechplanServiceImpl implements IDxxzspDomainTechplanService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspDomainTechplanMapper dxxzspDomainTechplanMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_DOMAIN_APPLYTASK where  itemid = '"+id+"' or id = '"+id+"' or flowrunid_ = '"+flowrunid+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<DxxzspDomainTechplanWithBLOBs> list_ret = new ArrayList<DxxzspDomainTechplanWithBLOBs>();
	    	List<Map<String,Object>> list_Techplan =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_TECHPLAN where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_Techplan ){
	    		DxxzspDomainTechplanWithBLOBs blob = dxxzspDomainTechplanMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("techplan", list_ret);
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainTechplanService test = (IDxxzspDomainTechplanService) ac.getBean("DxxzspDomainTechplanService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
