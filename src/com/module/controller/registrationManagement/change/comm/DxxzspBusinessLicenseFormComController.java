package com.module.controller.registrationManagement.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.change.comm.DxxzspBusinessLicenseFormComService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspBusinessLicenseFormCom")
public class DxxzspBusinessLicenseFormComController {
	@Resource
	private DxxzspBusinessLicenseFormComService DxxzspBusinessLicenseFormComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessLicenseFormCom")
	public ModelAndView toDxxzspBusinessLicenseFormCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/comm/DxxzspBusinessLicenseFormCom");
		//业务查询
		Map<String,Object> data = DxxzspBusinessLicenseFormComService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

