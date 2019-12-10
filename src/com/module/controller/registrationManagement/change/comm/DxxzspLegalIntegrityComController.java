package com.module.controller.registrationManagement.change.comm;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.change.comm.DxxzspLegalIntegrityComService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalIntegrityCom")
public class DxxzspLegalIntegrityComController {
	@Resource
	private DxxzspLegalIntegrityComService DxxzspLegalIntegrityComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalIntegrityCom")
	public ModelAndView toDxxzspLegalIntegrityCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/comm/DxxzspLegalIntegrityCom");
		//业务查询
		Map<String,Object> data = DxxzspLegalIntegrityComService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}

