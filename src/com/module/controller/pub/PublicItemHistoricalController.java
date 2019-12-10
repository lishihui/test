package com.module.controller.pub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.module.annotation.SystemControllerLog;
import com.module.domain.pub.PublicItemHistorical;
import com.module.service.pub.PublicItemHistoricalService;
import com.util.AppException;

@RequestMapping("/PublicItem")
@RestController
public class PublicItemHistoricalController{
	@Resource
	private PublicItemHistoricalService publicItemService;
	
	/**
	 * 保存历史意见表单方法，保存按钮触发
	 * @param jsonStr
	 * @return
	 * @throws AppException
	 */
	@SystemControllerLog(description="保存数据")
	@RequestMapping(value = "/saveItem")
	public Map<String,Object> saveItem(@RequestBody String jsonStr) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>();
        PublicItemHistorical publicItems = JSON.parseObject(jsonStr, PublicItemHistorical.class);
        publicItemService.save(publicItems);
		map.put("flag", "1");
		map.put("msg", "保存成功");
		return map;
	}
	@RequestMapping("/listItem")
	public Map<String,Object> listItem(String workid, String formid) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>();
		//List<PublicItemHistorical> listItem=publicItemService.listItem(workid,formid);
		//map.put("data", listItem);
		return map;
		
	}
}