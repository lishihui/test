package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspContentDistributionNetworkService;
import com.util.AppException;

//1、内容分发网络业务
@Controller
@RequestMapping("/DxxzspContentDistributionNetworkServ")
public class DxxzspContentDistributionNetworkController {
	@Resource
	private DxxzspContentDistributionNetworkService DxxzspContentDistributionNetworkService;
	
	//页面跳转
	@RequestMapping("/toDxxzspContentDistributionNetworkServ")
	public ModelAndView toDxxzspContentDistributionNetworkService(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspContentDistributionNetwork");
		//业务查询
		Map<String,Object> data = DxxzspContentDistributionNetworkService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(data);
//		System.out.println("**************************************");
		return mv;
	}

}

