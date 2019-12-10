package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspChangeOfCompanyChaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspChangeOfCompanyCha")
public class DxxzspChangeOfCompanyChaController {
	@Resource
	private DxxzspChangeOfCompanyChaService dxxzspChangeOfCompanyChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfCompanyCha")
	public ModelAndView toDxxzspChangeOfCompanyCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspChangeOfCompanyCha");
		//业务查询
		Map<String,Object> data = dxxzspChangeOfCompanyChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
