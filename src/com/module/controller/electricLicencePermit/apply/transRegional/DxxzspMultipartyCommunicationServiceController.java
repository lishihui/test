package com.module.controller.electricLicencePermit.apply.transRegional;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.transRegional.DxxzspMultipartyCommunicationService;
import com.util.AppException;

//1、国内多方通信服务业务
@Controller
@RequestMapping("/DxxzspMultipartyCommunicationServ")
public class DxxzspMultipartyCommunicationServiceController {
	@Resource
	private DxxzspMultipartyCommunicationService DxxzspMultipartyCommunicationService;
	
	//页面跳转
	@RequestMapping("/toDxxzspMultipartyCommunicationServ")
	public ModelAndView toDxxzspMultipartyCommunicationServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspMultipartyCommunicationService");
		//业务查询
		Map<String,Object> data = DxxzspMultipartyCommunicationService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

