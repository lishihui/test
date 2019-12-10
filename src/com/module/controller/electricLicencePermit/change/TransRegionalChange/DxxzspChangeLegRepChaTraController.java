package com.module.controller.electricLicencePermit.change.TransRegionalChange;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspChangeLegRepChaTraService;
import com.util.AppException;


//法定代表人变更
@Controller
@RequestMapping("/DxxzspChangeLegRepChaTra")
public class DxxzspChangeLegRepChaTraController {
	@Resource
	private DxxzspChangeLegRepChaTraService dxxzspChangeLegRepChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeLegRepChaTra")
	public ModelAndView toDxxzspChangeLegRepChaTra(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspChangeLegRepChaTra");
		//业务查询
		Map<String,Object> data = dxxzspChangeLegRepChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
