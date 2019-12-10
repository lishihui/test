package com.module.service.pub.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.pub.ItemFormUserHisMapper;
import com.module.domain.pub.ItemFormUserHis;
import com.module.service.pub.ItemFormUserHisService;
 
import com.util.StringUtils;


@Service
public class ItemFormUserHisServiceImpl implements ItemFormUserHisService {

    @Resource
    private ItemFormUserHisMapper itemFormUserHisMapper;
 
 
	@Resource
	private CommonMapper commonMapper;
    @Override
    public void save(ItemFormUserHis  itemFormUserHisT) {
    	//查询BPM_PRODUCT.bpm_bus_link    根据流程实例id  查询 
    	List<Map<String,Object>> bpmBusLinks =  commonMapper.findManyData("select  *  from  BPM_PRODUCT.bpm_bus_link   a  where  a.PROC_INST_ID_ = '"+itemFormUserHisT.getProcessId()+"'");
    	//取formid
    	List<Map<String,Object>> itemUserApplys =  commonMapper.findManyData("select  a.ITEM_ID   from  ITEM_USER_APPLY   a  where  a.process_id = '"+itemFormUserHisT.getProcessId()+"'");
    	String  itemid =(String)(itemUserApplys.get(0)).get("ITEM_ID");
        String  dormname = "";
    	for(Map<String,Object> tmp : bpmBusLinks ){
    		//得到意见表单名称    意见表单的唯一主键id
        	List<Map<String,Object>>  options =  commonMapper.findManyData(" select * from  FORM_PRODUCT."+ (String)tmp.get("BO_DEF_CODE_")+"  a  where  a.ID_ = '"+(String)tmp.get("BUSINESSKEY_STR_")+"'");
        	//将意见表插入   itemFormUser
        	for(Map<String,Object> tmpA : options ){
        		ItemFormUserHis itemFormUserHis = new  ItemFormUserHis();
        		itemFormUserHis.setId(UUID.randomUUID().toString());
        		//传入itemid
        		itemFormUserHis.setItemid(itemid);
        		//form 表单code
        		itemFormUserHis.setYewucode(((String)tmp.get("BO_DEF_CODE_")));
        		//表单名称
        		 //表单名称
        		/*List<Map<String,Object>>  options1 =  commonMapper.findManyData("select   NAME_ from   FORM_PRODUCT.FORM_DEFINITION  a  where  a.FORM_KEY_ = '"+(String)tmp.get("BO_DEF_CODE_")+"'");
                System.out.println("表单别名:"+(String)tmp.get("BO_DEF_CODE_"));
        		if (options1!=null&&options1.get(0)!=null){
        			dormname =  (String)(options1.get(0)).get("NAME_");
        			itemFormUserHis.setDormname(dormname);
        		}*/
        		//意见
    			Object formopinion = tmpA.get("FORMOPINION");
		        String formopinion1 = null;
		        if(formopinion instanceof Clob){
		        	formopinion1 = StringUtils.clobToStr((Clob)formopinion);
		        }else{
		        	formopinion1 = (String)formopinion;
		        }
				itemFormUserHis.setFormopinion(formopinion1);
        		//是否可以修改  同意  pass 修改  modify
        		itemFormUserHis.setFormstatus(StringUtils.isEmptyT((String)tmpA.get("FORMSTATUS"))?"pass": (String)tmpA.get("FORMSTATUS"));
        		Date now = new Date();
        		itemFormUserHis.setLastsubmittimes(now);
        		//任务id
        		itemFormUserHis.setTaskId(itemFormUserHisT.getTaskId());
        		//流程id
        		itemFormUserHis.setProcessId(itemFormUserHisT.getProcessId());
        		//操作员
        		itemFormUserHis.setOperator(itemFormUserHisT.getOperator());
        		itemFormUserHisMapper.insert(itemFormUserHis);
        	}
    	}
    }

	@Override
	public List<ItemFormUserHis> itemFormUserHis(String params) {
		// TODO Auto-generated method stub
		return itemFormUserHisMapper.selectByPrimaryKey(params);
	}
 
}
