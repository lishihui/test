package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.threeWebElectric.change.change.DxxzspChangeRegisteredCapitalService;
import com.util.AppException;

//1、注册资本变更
@Controller
@RequestMapping("/DxxzspChangeRegisteredCapital")
public class DxxzspChangeRegisteredCapitalController {
	@Resource
	private DxxzspChangeRegisteredCapitalService DxxzspChangeRegisteredCapitalService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeRegisteredCapital")
	public ModelAndView toCompanyMerger(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspChangeRegisteredCapital");
		//业务查询
		Map<String,Object> data = DxxzspChangeRegisteredCapitalService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}
