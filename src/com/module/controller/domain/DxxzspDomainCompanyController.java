package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainCompanyService;
import com.util.AppException;

//4、公司概况表
@Controller
@RequestMapping("/DxxzspDomainCompany")
public class DxxzspDomainCompanyController {
	
	@Resource
	private IDxxzspDomainCompanyService iDxxzspDomainCompanyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainCompany")
	public ModelAndView toDxxzspDomainCompany(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainCompany");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainCompanyService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
