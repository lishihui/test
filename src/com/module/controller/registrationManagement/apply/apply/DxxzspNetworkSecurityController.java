package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.registrationManagement.apply.apply.DxxzspNetworkSecurityService;
import com.util.AppException;

//1、网络安全保障措施
@Controller
@RequestMapping("/DxxzspNetworkSecurity")
public class DxxzspNetworkSecurityController {
	@Resource
	private DxxzspNetworkSecurityService DxxzspNetworkSecurityService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkSecurity")
	public ModelAndView toDxxzspSmallApertureEarthCommunication(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspNetworkSecurity");
		//业务查询
		Map<String,Object> data = DxxzspNetworkSecurityService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}
