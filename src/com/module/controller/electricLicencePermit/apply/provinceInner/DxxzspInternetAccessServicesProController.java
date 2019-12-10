package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInternetAccessServicesProService;
import com.util.AppException;

//互联网接入服务业务(internetAccessServices)
@Controller
@RequestMapping("/DxxzspInternetAccessServicePro")
public class DxxzspInternetAccessServicesProController {
	@Resource
	private DxxzspInternetAccessServicesProService dxxzspInternetAccessServicesProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInternetAccessServicePro")
	public ModelAndView toDxxzspInternetAccessServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspInternetAccessServicesPro");
		//业务查询
		Map<String,Object> data = dxxzspInternetAccessServicesProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
