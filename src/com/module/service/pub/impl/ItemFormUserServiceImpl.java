package com.module.service.pub.impl;

import com.module.dao.base.CommonMapper;
import com.module.dao.pub.DxxzspPublicCommentsMapper;
import com.module.dao.pub.FormDefinitionMapper;
import com.module.dao.pub.FormMetaMapper;
import com.module.dao.pub.ItemFormUserMapper;
import com.module.domain.domain.DxxzspYfjykdjrwyeWithBLOBs;
import com.module.domain.domain.FormDefinitionWithBLOBs;
import com.module.domain.domain.FormMetaWithBLOBs;
import com.module.domain.pub.DxxzspPublicComments;
import com.module.domain.pub.ItemFormUser;
import com.module.domain.pub.ItemFormUserT;
import com.module.service.pub.IPublicCommentsService;
import com.module.service.pub.ItemFormUserService;
 

import com.util.StringUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ItemFormUserServiceImpl implements ItemFormUserService {

    @Resource
    private ItemFormUserMapper itemFormUserMapper;
    @Resource
    private   FormDefinitionMapper  formDefinitionMapper;
    @Resource
    private   FormMetaMapper  formMetaMapper;
	@Resource
	private CommonMapper commonMapper;
    @Override
    public void save(ItemFormUserT itemFormUserT) {
    	//查询BPM_PRODUCT.bpm_bus_link    根据流程实例id  查询 
    	List<Map<String,Object>> bpmBusLinks =  commonMapper.findManyData("select  *  from  BPM_PRODUCT.bpm_bus_link   a  where  a.PROC_INST_ID_ = '"+itemFormUserT.getProInstId()+"'");
    	//取formid
    	List<Map<String,Object>> itemUserApplys =  commonMapper.findManyData("select  a.ITEM_ID ,a.SUBMIT_NUM  from  ITEM_USER_APPLY   a  where  a.process_id = '"+itemFormUserT.getProInstId()+"'");
        String  itemid =(String)(itemUserApplys.get(0)).get("ITEM_ID");
        String  dormname = "";
        String  submitNum =(String)(itemUserApplys.get(0)).get("SUBMIT_NUM");
    	for(Map<String,Object> tmp : bpmBusLinks ){
    		//得到意见表单名称    意见表单的唯一主键id
        	List<Map<String,Object>>  options =  commonMapper.findManyData(" select * from  FORM_PRODUCT."+ (String)tmp.get("BO_DEF_CODE_")+"  a  where  a.ID_ = '"+(String)tmp.get("BUSINESSKEY_STR_")+"'");
        	//将意见表插入   itemFormUser
        	for(Map<String,Object> tmpA : options ){
        		ItemFormUser itemFormUser = new  ItemFormUser();
        		itemFormUser.setId(UUID.randomUUID().toString());
        		//传入itemid
        		itemFormUser.setItemid(itemid);
        		//form 表单code
        		itemFormUser.setYewucode((String)tmp.get("BO_DEF_CODE_"));
        		 //表单名称
        		/*List<Map<String,Object>>  options1 =  commonMapper.findManyData("select   NAME_ from   FORM_PRODUCT.FORM_DEFINITION  a  where  a.FORM_KEY_ = '"+(String)tmp.get("BO_DEF_CODE_")+"'");
                dormname =  (String)(options1.get(0)).get("NAME_");
            	if (options1!=null&&options1.get(0)!=null){
        			dormname =  (String)(options1.get(0)).get("NAME_");
        			itemFormUser.setDormname(dormname);
        		}*/
        		//表单意见
        		//意见
   			    Object formopinion = tmpA.get("FORMOPINION");
		        String formopinion1 = null;
		        if(formopinion instanceof Clob){
		        	formopinion1 = StringUtils.clobToStr((Clob)formopinion);
		        }else{
		        	formopinion1 = (String)formopinion;
		        }
        		itemFormUser.setFormopinion(formopinion1);
        		//是否可以修改  同意  pass 修改  modify
        		itemFormUser.setFormstatus( StringUtils.isEmptyT((String)tmpA.get("FORMSTATUS"))?"pass": (String)tmpA.get("FORMSTATUS"));
        		//退回次数
        		itemFormUser.setRevokenum(submitNum);
        		Date now = new Date();
        		itemFormUser.setLastsubmittimes(now);
        		itemFormUserMapper.insert(itemFormUser);
        	}
    	}
    }
     
 
}
