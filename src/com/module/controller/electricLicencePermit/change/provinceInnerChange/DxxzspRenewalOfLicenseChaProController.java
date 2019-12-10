package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspRenewalOfLicenseChaProService;
import com.util.AppException;

//许可证续期(renewalOfLicense)
@Controller
@RequestMapping("/DxxzspRenewalOfLicenseChaPro")
public class DxxzspRenewalOfLicenseChaProController {
	@Resource
	private DxxzspRenewalOfLicenseChaProService DxxzspRenewalOfLicenseChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRenewalOfLicenseChaPro")
	public ModelAndView toDxxzspChangeOfOperatingSubject(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspRenewalOfLicenseChaPro");
		//业务查询
		Map<String,Object> data = DxxzspRenewalOfLicenseChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

