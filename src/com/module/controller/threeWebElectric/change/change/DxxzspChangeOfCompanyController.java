package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.threeWebElectric.change.change.DxxzspChangeOfCompanyService;
import com.util.AppException;
//公司名称变更
@Controller
@RequestMapping("/DxxzspChangeOfCompany")
public class DxxzspChangeOfCompanyController {
	@Resource
	private DxxzspChangeOfCompanyService dxxzspChangeOfCompanyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfCompany")
	public ModelAndView toDxxzspChangeOfCompany(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspChangeOfCompany");
		//业务查询
		Map<String,Object> data = dxxzspChangeOfCompanyService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
