package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfCompanyChaProService;
import com.util.AppException;

//公司名称变更(changeOfCompany)
@Controller
@RequestMapping("/DxxzspChangeOfCompanyChaPro")
public class DxxzspChangeOfCompanyChaProController {
	@Resource
	private DxxzspChangeOfCompanyChaProService dxxzspChangeOfCompanyChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfCompanyChaPro")
	public ModelAndView toDxxzspChangeOfCompanyChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspChangeOfCompanyChaPro");
		//业务查询
		Map<String,Object> data = dxxzspChangeOfCompanyChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
