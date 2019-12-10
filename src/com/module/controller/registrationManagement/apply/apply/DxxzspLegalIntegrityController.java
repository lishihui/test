package com.module.controller.registrationManagement.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.apply.apply.DxxzspLegalIntegrityService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalIntegrity")
public class DxxzspLegalIntegrityController {
	@Resource
	private DxxzspLegalIntegrityService DxxzspLegalIntegrityService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalIntegrity")
	public ModelAndView toDxxzspLegalIntegrity(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspLegalIntegrity");
		//业务查询
		Map<String,Object> data = DxxzspLegalIntegrityService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

