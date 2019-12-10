package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInternetAccessServicesService;
import com.util.AppException;

//7、互联网接入服务业务
@Controller
@RequestMapping("/DxxzspInternetAccessServ")
public class DxxzspInternetAccessServicesController {
	@Resource
	private DxxzspInternetAccessServicesService dxxzspInternetAccessServicesService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInternetAccessServ")
	public ModelAndView toDxxzspInternetAccessServ(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspInternetAccessServices");
		//业务查询
		Map<String,Object> data = dxxzspInternetAccessServicesService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
