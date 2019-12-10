package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.apply.apply.DxxzspDomainNameRegistrationAgencyDomService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspDomainNameRegistrationAgencyDom")
public class DxxzspDomainNameRegistrationAgencyDomController {
	@Resource
	private DxxzspDomainNameRegistrationAgencyDomService dxxzspDomainNameRegistrationAgencyDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainNameRegistrationAgencyDom")
	public ModelAndView toDxxzspDomainNameRegistrationAgencyDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspDomainNameRegistrationAgencyDom");
		//业务查询
		Map<String,Object> data = dxxzspDomainNameRegistrationAgencyDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

