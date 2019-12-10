package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDataCenterBusinessService;
import com.util.AppException;

//1、互联网数据中心业务
@Controller
@RequestMapping("/DxxzspDataCenterBusinessServ")
public class DxxzspDataCenterBusinessController {
	@Resource
	private DxxzspDataCenterBusinessService DxxzspDataCenterBusinessService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDataCenterBusinessServ")
	public ModelAndView toDxxzspDataCenterBusinessService(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspDataCenterBusiness");
		//业务查询
		Map<String,Object> data = DxxzspDataCenterBusinessService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

