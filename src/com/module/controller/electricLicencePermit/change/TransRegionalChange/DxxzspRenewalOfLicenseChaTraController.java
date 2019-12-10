package com.module.controller.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspRenewalOfLicenseChaTraService;
import com.util.AppException;

//许可证续期(renewalOfLicense)
@Controller
@RequestMapping("/DxxzspRenewalOfLicenseChaTra")
public class DxxzspRenewalOfLicenseChaTraController {
	@Resource
	private DxxzspRenewalOfLicenseChaTraService DxxzspRenewalOfLicenseChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRenewalOfLicenseChaTra")
	public ModelAndView toDxxzspChangeOfOperatingSubject(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspRenewalOfLicenseChaTra");
		//业务查询
		Map<String,Object> data = DxxzspRenewalOfLicenseChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

