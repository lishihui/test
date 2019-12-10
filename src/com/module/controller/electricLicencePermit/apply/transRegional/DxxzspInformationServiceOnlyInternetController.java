package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInformationServiceOnlyInternetService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspInformationServiceOnlyInternetServ")
public class DxxzspInformationServiceOnlyInternetController {
	@Resource
	private DxxzspInformationServiceOnlyInternetService DxxzspInformationServiceOnlyInternetService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInformationServiceOnlyInternetServ")
	public ModelAndView toDxxzspInformationServiceOnlyInternetServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspInformationServiceOnlyInternet");
		//业务查询
		Map<String,Object> data = DxxzspInformationServiceOnlyInternetService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

