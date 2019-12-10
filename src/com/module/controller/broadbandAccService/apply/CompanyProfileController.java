package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.CompanyProfileService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.util.AppException;

//公司概况表
@Controller
@RequestMapping("/companyProfile")
public class CompanyProfileController {
	
	@Resource
	private CompanyProfileService companyProfileService ;
 	
	//页面跳转
	@RequestMapping("/companyProfile")
	public ModelAndView CompanyProfile(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/companyProfile");
		//业务查询
		Map<String,Object> data = companyProfileService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
