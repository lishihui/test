package com.module.service.domain.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.module.dao.base.CommonMapper;
import com.module.dao.domain.DxxzspDomainCommentsMapper;
import com.module.domain.domain.DxxzspDomainComments;
import com.module.service.domain.IDxxzspDomainCommentsService;
import com.util.AppException;
import com.util.StringUtils;

//娴佺▼鑺傜偣琛ㄥ崟鎰忚琛�
@Service("DxxzspDomainCommentsService")
public class DxxzspDomainCommentsServiceImpl implements IDxxzspDomainCommentsService{
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspDomainCommentsMapper dxxzspDomainCommentsMapper;
	
	//淇濆瓨娴佺▼鑺傜偣琛ㄥ崟鎰忚
    public Map<String,Object> saveRow(String jsonStr) throws AppException{
    	Map<String,Object> map = new HashMap<String,Object>(); 
    	
    	DxxzspDomainComments record = JSON.parseObject(jsonStr, DxxzspDomainComments.class);
    	if ( record != null){
	    	record.setId(StringUtils.getUUID());//鐢熸垚涓婚敭
	    	dxxzspDomainCommentsMapper.insertSelective(record);
	    	map.put("flag", "1");
	        map.put("msg", "鏂板鎴愬姛");  
    	}else{
    		map.put("flag", "0");
	        map.put("msg", "鎻愪氦鏁版嵁杞崲鍑洪敊");
    	}
        return map;  
    }
    
	//鏍规嵁鏉′欢鏌ヨ娴佺▼鑺傜偣琛ㄥ崟鎰忚  (琛ㄥ崟琛ㄥ悕  鏁版嵁id)
    public Map<String,Object> getData(String formname,String itemid) throws AppException{ 
    	Map<String,Object> ret = new HashMap<String,Object>();	
    	//(瀹℃牳閫氳繃=pass 瀹℃牳涓嶉�杩� Fail 閫�洖浼佷笟琛ユ=modify)
    	List<Map<String,Object>> list_ret =  commonMapper.findManyData("select DXXZSP_DOMAIN_COMMENTS.*," +
    																   " 	   decode(AUDITSTATUS,'pass','瀹℃牳閫氳繃','Fail','瀹℃牳涓嶉�杩�,'modify','閫�洖浼佷笟琛ユ') AUDITSTATUS_T " +
    																   "  from DXXZSP_DOMAIN_COMMENTS where itemid = '"+itemid+"' and formname = '"+formname+"' " +
    																   " order by AUDITTIME desc");
    	ret.put("comments", list_ret);
    	return ret;
    }
     
    //娴嬭瘯
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		IDxxzspDomainCommentsService test = (IDxxzspDomainCommentsService) ac.getBean("DxxzspDomainCommentsService");
   		/*try {
   			//鏌ヨ鏁版嵁
   			//Map<String,Object> map = test.saveRow("{\"flowrunid\": \"f1001\",\"flowrunsubject\": \"820鍩熷悕绠＄悊鏈烘瀯娉ㄥ唽鐢宠\",\"nodeid\": \"n1001\",\"nodename\": \"瀹夊叏鍛樺鎵筡",\"formname\": \"dn01\",\"itemid\": \"15668047047207673586631487218801\",\"auditstatus\": \"pass\",\"auditcomments\": \"閫氳繃\",\"audittime\": \"2019-01-01 12:01:01\",\"auditor\": \"寮犱笁\"}");
   			//System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	*/    
   	}
}
