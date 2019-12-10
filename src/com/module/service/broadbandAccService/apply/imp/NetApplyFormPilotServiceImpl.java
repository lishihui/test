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
import com.module.dao.domain.DXXZSPYwsdsqbMapper;
import com.module.domain.domain.DXXZSPYwsdsqbWithBLOBs;
import com.module.domain.domain.DxxzspTGCQFWHZLBZCSWithBLOBs;
import com.module.service.broadbandAccService.apply.BussinessDevelopmentService;
import com.module.service.broadbandAccService.apply.NetApplyFormPilotService;
import com.module.service.broadbandAccService.apply.ProvideServiceMeasuresService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//宽带接入网试点申请表
@Service("NetApplyFormPilotService")
public class NetApplyFormPilotServiceImpl implements NetApplyFormPilotService {

	@Resource
	private CommonMapper commonMapper;
    @Resource 
	private DXXZSPYwsdsqbMapper dXXZSPYwsdsqbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	// 根据主键查询业务数据
	public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
		String Itemid=itemUserApplyService.getProcessId(id);
		Map<String, Object> ret = new HashMap<String, Object>();
		// 查询业务主表记录ID
		Map<String, Object> map = commonMapper.findOneData("select * from DXXZSP_YWSDSQB where itemid = '"+ Itemid + "' or id = '" + id + "' ");
		if (map != null) {
			String ywid = (String) map.get("ID");
			String itemid = (String) map.get("ITEMID");
			// 查询展示数据
			List<Map<String, Object>> list_KDJRWSD = commonMapper.findManyData("select * from DXXZSP_YWSDSQB where id = '"+ ywid + "'");
			List<Map<String, Object>> list_KDJRWSDSQB = commonMapper.findManyData("select * from GQJG_KDJRSDSQ where parentid = '"+ ywid + "'");
			List<Map<String, Object>> list_XKZPWH = commonMapper.findManyData("select * from DXXZSP_XKZPWH where parentid = '"+ ywid + "'");
			List<DXXZSPYwsdsqbWithBLOBs> list_ret = new ArrayList<DXXZSPYwsdsqbWithBLOBs>();
			for(Map<String,Object> tmp : list_KDJRWSD ){
				DXXZSPYwsdsqbWithBLOBs blob = dXXZSPYwsdsqbMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob); 
	    	}
	    	ret.put("list_KDJRWSD",list_ret);
			ret.put("list_KDJRWSDSQB", list_KDJRWSDSQB);
			ret.put("list_XKZPWH", list_XKZPWH);
		}
		return ret;
	}
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		NetApplyFormPilotService test = (NetApplyFormPilotService) ac.getBean("NetApplyFormPilotService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}
