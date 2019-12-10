package com.module.controller.internetDomainRootServices.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.internetDomainRootServices.apply.apply.DxxzspLegalIntegrityIntService;
import com.util.AppException;

//1、依法经营和诚信经营承诺书
@Controller
@RequestMapping("/DxxzspLegalIntegrityInt")
public class DxxzspLegalIntegrityIntController {
	@Resource
	private DxxzspLegalIntegrityIntService DxxzspLegalIntegrityIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalIntegrityInt")
	public ModelAndView toDxxzspLegalIntegrity(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspLegalIntegrityInt");
		//业务查询
		Map<String,Object> data = DxxzspLegalIntegrityIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



