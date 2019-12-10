package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfOperatingSubjectChaProService;
import com.util.AppException;

//经营主体变更(changeOfOperatingSubject)
@Controller
@RequestMapping("/DxxzspChangeOfOperatingSubjectChaPro")
public class DxxzspChangeOfOperatingSubjectChaProController {
	@Resource
	private DxxzspChangeOfOperatingSubjectChaProService DxxzspChangeOfOperatingSubjectChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfOperatingSubjectChaPro")
	public ModelAndView toDxxzspChangeOfOperatingSubjectChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspChangeOfOperatingSubjectChaPro");
		//业务查询
		Map<String,Object> data = DxxzspChangeOfOperatingSubjectChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

