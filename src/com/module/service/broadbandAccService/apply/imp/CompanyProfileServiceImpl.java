package com.module.service.broadbandAccService.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.dao.domain.DXXZSPGsgkbMapper;
import com.module.dao.domain.DxxzspWlyjsfaZybMapper;
import com.module.domain.domain.DXXZSPGsgkbWithBLOBs;
import com.module.domain.domain.DXXZSPYwsdsqbWithBLOBs;
import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;
import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;
import com.module.service.broadbandAccService.apply.CompanyProfileService;
import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetApplyFormPilotService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//公司概况表
@Service("CompanyProfileService")
public class CompanyProfileServiceImpl implements CompanyProfileService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DXXZSPGsgkbMapper dXXZSPGsgkbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_GSGKB where itemid = '"+Itemid+"' or id = '"+id+"' ");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_GSGK =  commonMapper.findManyData("select * from DXXZSP_GSGKB where id = '"+ywid+"'");
	    	List<DXXZSPGsgkbWithBLOBs> list_ret = new ArrayList<DXXZSPGsgkbWithBLOBs>();
			for(Map<String,Object> tmp : list_GSGK ){
				DXXZSPGsgkbWithBLOBs blob = dXXZSPGsgkbMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob); 
	    	}
	    	ret.put("list_GSGK",list_ret);
	    	      		    	
            List<Map<String,Object>> list_KFRYMD =  commonMapper.findManyData("select * from DXXZSP_KFRYMD where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_ZYJSRYLCT =  commonMapper.findManyData("select * from DXXZSP_ZYJSRYLCT where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_ZYGLRYDTT =  commonMapper.findManyData("select * from DXXZSP_ZYGLRYDTT where parentid = '"+ywid+"' ");
	    	 	    
	 	    	ret.put("list_KFRYMD", list_KFRYMD);
	 	    	ret.put("list_ZYJSRYLCT", list_ZYJSRYLCT);
	 	    	ret.put("list_ZYGLRYDTT", list_ZYGLRYDTT);
    	}
    	return ret;
    }
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		CompanyProfileService test = (CompanyProfileService) ac.getBean("CompanyProfileService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
