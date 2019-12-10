package com.module.controller.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.module.annotation.SystemControllerLog;
import com.module.service.domain.IDxxzspDomainCommentsService;
import com.util.AppException;

//流程节点表单意见表
@Controller
@RequestMapping("/DxxzspDomainComments")
public class DxxzspDomainCommentsController {
	
	@Resource
	private IDxxzspDomainCommentsService iDxxzspDomainCommentsService;
	
	//页面跳转 测试页面
	@RequestMapping("/toTest")
	public ModelAndView toTest() throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainCommentsTest");
		return mv;
	}
	
	//新增流程节点表单意见
	@SystemControllerLog(description="新增流程节点表单意见")
	@RequestMapping(value = "/toSaveRow")
	public void cardRecharge(HttpServletRequest request,HttpServletResponse response, String jsonStr) throws AppException{
		try {				
			Map<String,Object> map  = new HashMap<String,Object>();
			JSONObject ret = new JSONObject();
			map = iDxxzspDomainCommentsService.saveRow(jsonStr);
			ret.put("flag", map.get("flag"));
			ret.put("msg", map.get("msg"));
			//返回值
			String jj = "successCallback("+ret+")";
			InputStream is = new ByteArrayInputStream(jj.toString().getBytes("UTF-8"));
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();		
		} catch (Exception e) {
			throw new AppException("新增流程节点表单意见错误",e.toString());
		}
		return;
	}
	
	//页面跳转   同时根据条件查询流程节点表单意见  (表单表名  数据id)
	@RequestMapping("/toDxxzspDomainComments")
	public ModelAndView toDxxzspDomainCompany(String formname,String itemid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainComments");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainCommentsService.getData(formname, itemid);
		mv.addObject("data", data);
		return mv;
	}
		
}
