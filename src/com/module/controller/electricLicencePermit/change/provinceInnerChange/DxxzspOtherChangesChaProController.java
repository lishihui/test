package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspOtherChangesChaProService;
import com.util.AppException;

//其他变更(otherChanges)
@Controller
@RequestMapping("/DxxzspOtherChangesChaPro")
public class DxxzspOtherChangesChaProController {
	@Resource
	private DxxzspOtherChangesChaProService DxxzspOtherChangesChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspOtherChangesChaPro")
	public ModelAndView toDxxzspChangeOfOperatingSubject(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspOtherChangesChaPro");
		//业务查询
		Map<String,Object> data = DxxzspOtherChangesChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

