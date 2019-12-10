package com.module.controller.internetDomainRootServices.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.internetDomainRootServices.apply.apply.DxxzspInformationSafetyIntService;
import com.util.AppException;

//1、信息安全保障制度
@Controller
@RequestMapping("/DxxzspInformationSafetyInt")
public class DxxzspInformationSafetyIntController {
	@Resource
	private DxxzspInformationSafetyIntService DxxzspInformationSafetyIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInformationSafetyInt")
	public ModelAndView toDxxzspContentDistributionNetworkService(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspInformationSafetyInt");
		//业务查询
		Map<String,Object> data = DxxzspInformationSafetyIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}


