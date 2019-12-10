package com.module.service.domain.imp;

import com.module.dao.base.CommonMapper;
import com.module.service.domain.IDxxzspDomainPlaceService;
import com.util.AppException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DxxzspDomainPlaceServiceImpl implements IDxxzspDomainPlaceService {

    @Resource
    private CommonMapper commonMapper;

    //根据主键查询业务数据
    @Override
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{
        Map<String,Object> ret = new HashMap<String,Object>();
        //查询业务主表记录ID
        
        List<Map<String,Object>> list =	commonMapper.findManyData("select * from DXXZSP_DOMAIN_PLACE where  itemid = '"+id+"' or id = '"+id+"'");
        
        if(list.size()>0){
        	Map<String,Object> map = list.get(0);
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");

	        //查询展示数据
	        List<Map<String,Object>> list_addr_data =  commonMapper.findManyData("select p.ID AS PARENTID,p.ADDR_P,p.ADDR_S,p.ADDR_X,p.PROVIDER," +
	                "t.ID,t.IPV4,t.IPV6 " +
	                "from DXXZSP_DOMAIN_PLACE_ADDR p, DXXZSP_DOMAIN_PLACE_ADDR_DATA t " +
	                "where p.id = t.parentid and p.itemid = '"+itemid+"'");
	        List<Map<String,Object>> list_addr_databack =  commonMapper.findManyData("select p.ID AS PARENTID,p.ADDR_P,p.ADDR_S,p.ADDR_X,p.PROVIDER," +
	                "t.ID,t.IPV4,t.IPV6 " +
	                "from DXXZSP_DOMAIN_PLACE_ADDR p, DXXZSP_DOMAIN_PLACE_ADDR_DATABACK t " +
	                "where p.id = t.parentid and p.itemid = '"+itemid+"'");
	        List<Map<String,Object>> list_addr_dns =  commonMapper.findManyData("select p.ID AS PARENTID,p.ADDR_P,p.ADDR_S,p.ADDR_X,p.PROVIDER," +
	                "t.ID,t.IPV4,t.IPV6 " +
	                "from DXXZSP_DOMAIN_PLACE_ADDR p, DXXZSP_DOMAIN_PLACE_ADDR_DNS t " +
	                "where p.id = t.parentid and p.itemid = '"+itemid+"'");
	        List<Map<String,Object>> list_addr_dnsback =  commonMapper.findManyData("select p.ID AS PARENTID,p.ADDR_P,p.ADDR_S,p.ADDR_X,p.PROVIDER," +
	                "t.ID,t.IPV4,t.IPV6 " +
	                "from DXXZSP_DOMAIN_PLACE_ADDR p, DXXZSP_DOMAIN_PLACE_ADDR_DNSBACK t " +
	                "where p.id = t.parentid and p.itemid = '"+itemid+"'");
	        List<Map<String,Object>> list_addr_parsing =  commonMapper.findManyData("select p.ID AS PARENTID,p.ADDR_P,p.ADDR_S,p.ADDR_X,p.PROVIDER," +
	                "t.ID,t.IPV4,t.IPV6 " +
	                "from DXXZSP_DOMAIN_PLACE_ADDR p, DXXZSP_DOMAIN_PLACE_ADDR_PARSING t " +
	                "where p.id = t.parentid and p.itemid = '"+itemid+"'");
	
	        ret.put("list_addr_data", process(list_addr_data));
	        ret.put("list_addr_databack", process(list_addr_databack));
	        ret.put("list_addr_dns", process(list_addr_dns));
	        ret.put("list_addr_dnsback", process(list_addr_dnsback));
	        ret.put("list_addr_parsing", process(list_addr_parsing));
        }
        return ret;
    }

    private List<Map<String,Object>> process(List<Map<String,Object>> oldList) {
        List<Map<String,Object>> newList = new ArrayList<Map<String,Object>>();
        String temp = "-1";
        Map<String,Object> parent;
        List<Map<String,Object>> childList = new ArrayList<Map<String,Object>>();
        if (oldList != null && oldList.size() > 0) {
            for(int i = 0; i < oldList.size(); i++) {
                Map<String,Object> e = oldList.get(i);
                if (e.get("PARENTID").toString().equals(temp)) {
                    childList.add(e);
                } else {
                    temp = e.get("PARENTID").toString();
                    parent = e;
                    childList.clear();
                    childList.add(e);
                    parent.put("childList", childList);
                    newList.add(parent);
                }
            }
        }
        return newList;
    }

}
