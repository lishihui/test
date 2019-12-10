package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspBusinessCoverageChangeChaProService;
import com.util.AppException;

//业务覆盖范围变更(businessCoverageChange)
@Controller
@RequestMapping("/DxxzspBusinessCoverageChangeChaPro")
public class DxxzspBusinessCoverageChangeChaProController {
	@Resource
	private DxxzspBusinessCoverageChangeChaProService dxxzspBusinessCoverageChangeChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessCoverageChangeChaPro")
	public ModelAndView toDxxzspBusinessCoverageChangeChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspBusinessCoverageChangeChaPro");
		//业务查询
		Map<String,Object> data = dxxzspBusinessCoverageChangeChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
