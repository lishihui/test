package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.threeWebElectric.change.change.DxxzspBusinessCoverageChangeService;
import com.util.AppException;

//1、业务覆盖范围变更
@Controller
@RequestMapping("/DxxzspBusinessCoverageChange")
public class DxxzspBusinessCoverageChangeController {
	@Resource
	private DxxzspBusinessCoverageChangeService dxxzspBusinessCoverageChangeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessCoverageChange")
	public ModelAndView toDxxzspBusinessCoverageChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspBusinessCoverageChange");
		//业务查询
		Map<String,Object> data = dxxzspBusinessCoverageChangeService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
