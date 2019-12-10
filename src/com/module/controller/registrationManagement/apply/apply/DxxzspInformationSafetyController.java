package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspInformationSafetyService;
import com.util.AppException;


//1、信息安全保障措施
@Controller
@RequestMapping("/DxxzspInformationSafety")
public class DxxzspInformationSafetyController {
	@Resource
	private DxxzspInformationSafetyService dxxzspInformationSafetyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInformationSafety")
	public ModelAndView toDxxzspInformationSafety(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspInformationSafety");
		//业务查询
		Map<String,Object> data = dxxzspInformationSafetyService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
