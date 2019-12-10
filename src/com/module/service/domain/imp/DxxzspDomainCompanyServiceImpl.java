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
import com.module.dao.domain.DxxzspDomainCompanyManagerMapper;
import com.module.dao.domain.DxxzspDomainCompanyMapper;
import com.module.dao.domain.DxxzspDomainCompanyTechMapper;
import com.module.domain.domain.DxxzspDomainCompanyManager;
import com.module.domain.domain.DxxzspDomainCompanyTech;
import com.module.domain.domain.DxxzspDomainCompanyWithBLOBs;
import com.module.service.domain.IDxxzspDomainCompanyService;
import com.util.AppException;

//4、 公司概况表
@Service("DxxzspDomainCompanyService")
public class DxxzspDomainCompanyServiceImpl implements IDxxzspDomainCompanyService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspDomainCompanyMapper dxxzspDomainCompanyMapper;
	
	@Resource
	private DxxzspDomainCompanyManagerMapper dxxzspDomainCompanyManagerMapper;
	
	@Resource
	private DxxzspDomainCompanyTechMapper dxxzspDomainCompanyTechMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_DOMAIN_APPLYTASK where itemid = '"+id+"' or  id = '"+id+"' or flowrunid_ = '"+flowrunid+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<DxxzspDomainCompanyWithBLOBs> list_company_ret = new ArrayList<DxxzspDomainCompanyWithBLOBs>();
	    	List<Map<String,Object>> list_company =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_COMPANY where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_company ){
	    		DxxzspDomainCompanyWithBLOBs blob = dxxzspDomainCompanyMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_company_ret.add(blob);
	    	}
	    	ret.put("company", list_company_ret);
	
	    	//公司主要管理人员名单
	    	List<DxxzspDomainCompanyManager> list_company_manager_ret = new ArrayList<DxxzspDomainCompanyManager>();
	    	List<Map<String,Object>> list_company_manager =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_COMPANY_MANAGER where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_company_manager ){
	    		DxxzspDomainCompanyManager blob = dxxzspDomainCompanyManagerMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_company_manager_ret.add(blob);
	    	}
	    	ret.put("company_manager", list_company_manager_ret);
	    	
	    	//公司境内技术人员名单
	    	List<DxxzspDomainCompanyTech> list_company_tech_ret = new ArrayList<DxxzspDomainCompanyTech>();
	    	List<Map<String,Object>> list_company_tech =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_COMPANY_TECH where itemid = '"+itemid+"'");
	    	for(Map<String,Object> tmp : list_company_tech ){
	    		DxxzspDomainCompanyTech blob = dxxzspDomainCompanyTechMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_company_tech_ret.add(blob);
	    	}
	    	ret.put("company_tech", list_company_tech_ret);
    	}

    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainCompanyService test = (IDxxzspDomainCompanyService) ac.getBean("DxxzspDomainCompanyService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
