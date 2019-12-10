package com.module.controller.internetDomainRootServices.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.internetDomainRootServices.apply.apply.DxxzspNetworkSecuritySystemIntService;
import com.util.AppException;

//1、网络安全保障制度
@Controller
@RequestMapping("/DxxzspNetworkSecuritySystemInt")
public class DxxzspNetworkSecuritySystemIntController {
	@Resource
	private DxxzspNetworkSecuritySystemIntService DxxzspNetworkSecuritySystemIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkSecuritySystemInt")
	public ModelAndView toDxxzspNetworkSecuritySystem(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspNetworkSecuritySystemInt");
		//业务查询
		Map<String,Object> data = DxxzspNetworkSecuritySystemIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



