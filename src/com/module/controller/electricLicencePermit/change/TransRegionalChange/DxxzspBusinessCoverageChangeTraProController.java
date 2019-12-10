package com.module.controller.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspBusinessCoverageChangeChaTraService;
import com.util.AppException;


//业务覆盖范围变更(businessCoverageChange)
@Controller
@RequestMapping("/DxxzspBusinessCoverageChangeChaTra")
public class DxxzspBusinessCoverageChangeTraProController {
	@Resource
	private DxxzspBusinessCoverageChangeChaTraService DxxzspBusinessCoverageChangeChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessCoverageChangeChaTra")
	public ModelAndView toDxxzspBusinessCoverageChangeChaTra(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspBusinessCoverageChangeChaTra");
		//业务查询
		Map<String,Object> data = DxxzspBusinessCoverageChangeChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
