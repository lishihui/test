package com.module.controller.foreignInvestment;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.foreignInvestment.OtherAtachmentsUploadedService;
import com.util.AppException;

//外商投资其他附件上传（otherAtachmentsUploaded）
@Controller
@RequestMapping("/otherAtachmentsUploaded")
public class OtherAtachmentsUploadedController {
	
	@Resource
	private OtherAtachmentsUploadedService otherAtachmentsUploadedService;
	
	//页面跳转
	@RequestMapping("/otherAtachmentsUploaded")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("foreignInvestment/otherAtachmentsUploaded");
		//业务查询
		Map<String,Object> data = otherAtachmentsUploadedService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
