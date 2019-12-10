package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.comm.DxxzspInformationSecurityMeasuresProService;
import com.util.AppException;

//网络与信息安全保障措施(informationSecurityMeasures)
@Controller
@RequestMapping("/DxxzspInformationSecurityMeasuresPro")
public class DxxzspInformationSecurityMeasuresProController {
	@Resource
	private DxxzspInformationSecurityMeasuresProService DxxzspInformationSecurityMeasuresProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInformationSecurityMeasuresPro")
	public ModelAndView toDxxzspInformationSecurityMeasuresPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspInformationSecurityMeasuresPro");
		//业务查询
		Map<String,Object> data = DxxzspInformationSecurityMeasuresProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

