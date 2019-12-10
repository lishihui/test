package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspDomainRegistrationService;
import com.util.AppException;

//1、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspDomainRegistration")
public class DxxzspDomainRegistrationController {
	@Resource
	private DxxzspDomainRegistrationService dxxzspDomainRegistrationService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainRegistration")
	public ModelAndView toDxxzspDomainRegistration(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspDomainRegistration");
		//业务查询
		Map<String,Object> data = dxxzspDomainRegistrationService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}
}
