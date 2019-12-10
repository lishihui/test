package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspSmallApertureEarthCommunicationService;
import com.util.AppException;

//1、国内甚小口径终端地球站通信业务
@Controller
@RequestMapping("/DxxzspSmallApertureEarthCommunication")
public class DxxzspSmallApertureEarthCommunicationController {
	@Resource
	private DxxzspSmallApertureEarthCommunicationService dxxzspSmallApertureEarthCommunicationService;
	
	//页面跳转
	@RequestMapping("/toDxxzspSmallApertureEarthCommunication")
	public ModelAndView toDxxzspSmallApertureEarthCommunication(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspSmallApertureEarthCommunication");
		//业务查询
		Map<String,Object> data = dxxzspSmallApertureEarthCommunicationService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}
