package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspAuthorizedSubsidiaryChaProService;
import com.util.AppException;

//授权子公司(authorizedSubsidiary)
@Controller
@RequestMapping("/DxxzspAuthorizedSubsidiaryChaPro")
public class DxxzspAuthorizedSubsidiaryChaProController {
	@Resource
	private DxxzspAuthorizedSubsidiaryChaProService dxxzspAuthorizedSubsidiaryChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspAuthorizedSubsidiaryChaPro")
	public ModelAndView toDxxzspAuthorizedSubsidiaryChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspAuthorizedSubsidiaryChaPro");
		//业务查询
		Map<String,Object> data = dxxzspAuthorizedSubsidiaryChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
