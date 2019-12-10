package com.module.controller.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspTerminationOfOperationChaTraService;
import com.util.AppException;


//终止经营(terminationOfOperation)
@Controller
@RequestMapping("/DxxzspTerminationOfOperationChaTra")
public class DxxzspTerminationOfOperationChaTraController {
	@Resource
	private DxxzspTerminationOfOperationChaTraService dxxzspTerminationOfOperationChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationOfOperationChaTra")
	public ModelAndView toDxxzspTerminationOfOperationChaTra(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspTerminationOfOperationChaTra");
		//业务查询
		Map<String,Object> data = dxxzspTerminationOfOperationChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
