package com.module.controller.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspChangeOfCompanyChaTraService;
import com.util.AppException;

//公司名称变更(changeOfCompany)
@Controller
@RequestMapping("/DxxzspChangeOfCompanyChaTra")
public class DxxzspChangeOfCompanyChaTraController {
	@Resource
	private DxxzspChangeOfCompanyChaTraService DxxzspChangeOfCompanyChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfCompanyChaTra")
	public ModelAndView toDxxzspChangeOfCompanyChaTra(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspChangeOfCompanyChaTra");
		//业务查询
		Map<String,Object> data = DxxzspChangeOfCompanyChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
