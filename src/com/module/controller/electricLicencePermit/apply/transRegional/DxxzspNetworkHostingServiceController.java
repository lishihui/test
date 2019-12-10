package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspNetworkHostingService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspNetworkHostingServ")
public class DxxzspNetworkHostingServiceController {
	@Resource
	private DxxzspNetworkHostingService DxxzspNetworkHostingService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkHostingServ")
	public ModelAndView toDxxzspNetworkHostingServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspNetworkHostingService");
		//业务查询
		Map<String,Object> data = DxxzspNetworkHostingService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

