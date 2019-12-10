package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.BussinessDevelopmentService;
import com.util.AppException;

//业务发展和实施计划专用表(bussinessDevelopment)
//张家玮
@Controller
@RequestMapping("/BussinessDevelopment")
public class BussinessDevelopmentController {
	
	@Resource
	private BussinessDevelopmentService bussinessDevelopmentService;
	
	//页面跳转
	@RequestMapping("/BussinessDevelopment")
	public ModelAndView toDxxzspDomainAgreement(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/bussinessDevelopment");
		//业务查询
		Map<String,Object> data = bussinessDevelopmentService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

