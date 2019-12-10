package com.module.controller.electricLicencePermit.change.commChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.change.commChange.DxxzspLicenseOfLegalPersonChaComService;
import com.util.AppException;

//企业法人营业执照(licenseOfLegalPerson)
@Controller
@RequestMapping("/DxxzspLicenseOfLegalPersonChaCom")
public class DxxzspLicenseOfLegalPersonChaComController {
	@Resource
	private DxxzspLicenseOfLegalPersonChaComService DxxzspLicenseOfLegalPersonChaComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLicenseOfLegalPersonChaCom")
	public ModelAndView toDxxzspLicenseOfLegalPersonChaCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/commChange/DxxzspLicenseOfLegalPersonChaCom");
		//业务查询
		Map<String,Object> data = DxxzspLicenseOfLegalPersonChaComService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

