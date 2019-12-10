package com.module.controller.pub;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.module.annotation.SystemControllerLog;
import com.module.domain.pub.DxxzspPublicComments;
import com.module.domain.pub.ItemFormUser;
import com.module.domain.pub.ItemFormUserHis;
import com.module.domain.pub.ItemFormUserT;
import com.module.service.pub.IPublicCommentsService;
import com.module.service.pub.ItemFormUserHisService;
import com.module.service.pub.ItemFormUserService;
import com.util.AppException;
 











import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.json.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ItemFormUser")
@RestController
public class ItemFormUserController {
	private static final Logger logger = LoggerFactory.getLogger(ItemFormUserController. class);
	
	@Resource
	private ItemFormUserService itemFormUserService;
	
	@Resource
	private ItemFormUserHisService itemFormUserHisService;
/**
 * 记录每个业务表的状态，当审核端返回驳回状态的时候，控制互联网端可以修改
 * @param jsonStr
 * @return
 * @throws AppException
 */
	@SystemControllerLog(description="保存数据")
	@RequestMapping(value = "/save",method=RequestMethod.POST )
	public Map<String,Object> save(@RequestBody String params) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject jsonObject = JSON.parseObject(params);
		//驳回发起人，驳回到指定节点
		 String  processId =  JSON.parseObject(jsonObject.getString("vars")).getString("instanceId_");
		 String  operator =  JSON.parseObject(jsonObject.getString("assignee")).getString("name");
		 System.out.println("传入总参数"+params);
		if ("reject".equals(jsonObject.getString("actionName"))){
			ItemFormUserT itemFormUserT= new  ItemFormUserT();
			//获得流程id
			itemFormUserT.setProInstId(processId); 
			itemFormUserService.save(itemFormUserT); 
			 System.out.println("传入 总参数1111");
		}
		//历史意见表
		String  taskId =   jsonObject.getString("taskId");
		ItemFormUserHis  itemFormUserHisT = new ItemFormUserHis();
		itemFormUserHisT.setProcessId(processId);
		itemFormUserHisT.setTaskId(taskId);
		itemFormUserHisT.setOperator(operator);
		itemFormUserHisService.save(itemFormUserHisT); 
		 System.out.println("传入总参数2222");
		map.put("flag", "1");
		map.put("msg", "保存成功");
		return map;
	}
	
	
	
	@RequestMapping(value = "/itemFormUserHis")
	@ResponseBody
	public List<ItemFormUserHis> itemFormUserHis(@RequestParam(value="params")String params) throws AppException {
		//Map<String,Object> map = new HashMap<String,Object>();
		//JSONObject jsonObject = JSON.parseObject(params);
		//驳回发起人，驳回到指定节点
		List<ItemFormUserHis> list=itemFormUserHisService.itemFormUserHis(params);
		return list;
	}
	
	public static void main(String[] args) {
		
	}

	 
}
