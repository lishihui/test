package com.module.service.domain.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//9、顶级域注册管理系统相关协议列表
@Service("DxxzspDomainAgreementService")
public class DxxzspDomainAgreementServiceImpl implements IDxxzspDomainAgreementService {
	
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
	    	List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT where itemid = '"+itemid+"'");
	    	List<Map<String,Object>> list_agreement_exclusive =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_EXCLUSIVE where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_construction =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_CONSTRUCTION where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_office =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_OFFICE where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_build =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_BUILD where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_datahost =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_DATAHOST where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_emergency =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_EMERGENCY where itemid = '"+itemid+"' ");
	    	List<Map<String,Object>> list_agreement_realname =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_AGREEMENT_REALNAME where itemid = '"+itemid+"' ");
	    	
	    	ret.put("agreement", list_agreement);
	    	ret.put("agreement_exclusive", list_agreement_exclusive);
	    	ret.put("agreement_construction", list_agreement_construction);
	    	ret.put("agreement_office", list_agreement_office);
	    	ret.put("agreement_build", list_agreement_build);
	    	ret.put("agreement_datahost", list_agreement_datahost);
	    	ret.put("agreement_emergency", list_agreement_emergency);
	    	ret.put("agreement_realname", list_agreement_realname);
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainAgreementService test = (IDxxzspDomainAgreementService) ac.getBean("DxxzspDomainAgreementService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
