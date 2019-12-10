package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspDnsDeployInfoWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspNetworkteccianficIntService;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspDnsDeployInfoMapper;
import com.util.AppException;

@Service("DxxzspNetworkteccianficIntService")
public class DxxzspNetworkteccianficIntServiceImpl implements DxxzspNetworkteccianficIntService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDnsDeployInfoMapper dxxzspDnsDeployInfoMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_DNS_DEPLOY_INFO where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			
			List<DxxzspDnsDeployInfoWithBLOBs> list_ret = new ArrayList<DxxzspDnsDeployInfoWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_DNS_DEPLOY_INFO where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				DxxzspDnsDeployInfoWithBLOBs blob = dxxzspDnsDeployInfoMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    		System.out.println("================================");
	    		System.out.print(list_ret);
	    		System.out.println("================================");
	    	}
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from REMOTE_IPADDRESS where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DATA_TRANSCATION where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement3 =  commonMapper.findManyData("select * from DNS_IPV where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement4 =  commonMapper.findManyData("select * from DEPLOY_LOCATION where parentid = '"+parentid+"'");
			ret.put("DXXZSP_DNS_DEPLOY_INFO", list_ret);
			ret.put("REMOTE_IPADDRESS", list_agreement1);
			ret.put("DATA_TRANSCATION", list_agreement2);
			ret.put("DNS_IPV", list_agreement3);
			ret.put("DEPLOY_LOCATION", list_agreement4);

		}
		return ret;
	}
	
}

