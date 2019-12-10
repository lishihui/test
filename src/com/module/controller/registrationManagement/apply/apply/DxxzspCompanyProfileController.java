package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspCompanyProfileService;
import com.util.AppException;

//1、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspCompanyProfile")
public class DxxzspCompanyProfileController {
	@Resource
	private DxxzspCompanyProfileService dxxzspCompanyProfileService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyProfile")
	public ModelAndView toDxxzspCompanyProfile(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspCompanyProfile");
		//业务查询
		Map<String,Object> data = dxxzspCompanyProfileService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
