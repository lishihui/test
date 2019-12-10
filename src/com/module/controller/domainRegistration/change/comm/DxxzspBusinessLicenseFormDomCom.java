package com.module.controller.domainRegistration.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.change.comm.DxxzspBusinessLicenseFormDomComService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspBusinessLicenseFormDomCom")
public class DxxzspBusinessLicenseFormDomCom {
	@Resource
	private DxxzspBusinessLicenseFormDomComService dxxzspBusinessLicenseFormDomComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessLicenseFormDomCom")
	public ModelAndView toDxxzspBusinessLicenseFormDomCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/comm/DxxzspBusinessLicenseFormDomCom");
		//业务查询
		Map<String,Object> data = dxxzspBusinessLicenseFormDomComService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
