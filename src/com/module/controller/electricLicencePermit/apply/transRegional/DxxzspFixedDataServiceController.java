package com.module.controller.electricLicencePermit.apply.transRegional;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspFixedDataService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspFixedDataServ")
public class DxxzspFixedDataServiceController {
	@Resource
	private DxxzspFixedDataService DxxzspFixedDataService;
	
	//页面跳转
	@RequestMapping("/toDxxzspFixedDataServ")
	public ModelAndView toDxxzspFixedDataServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspFixedDataService");
		//业务查询
		Map<String,Object> data = DxxzspFixedDataService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

