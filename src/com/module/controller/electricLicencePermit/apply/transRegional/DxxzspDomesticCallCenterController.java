package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDomesticCallCenterService;
import com.util.AppException;

//1、国内呼叫中心业务
@Controller
@RequestMapping("/DxxzspDomesticCallCenterServ")
public class DxxzspDomesticCallCenterController {
	@Resource
	private DxxzspDomesticCallCenterService DxxzspDomesticCallCenterService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomesticCallCenterServ")
	public ModelAndView toDxxzspDomesticCallCenterServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspDomesticCallCenter");
		//业务查询
		Map<String,Object> data = DxxzspDomesticCallCenterService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

