package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspTerminationOfOperationService;
import com.util.AppException;


//终止经营(terminationOfOperation)
@Controller
@RequestMapping("/DxxzspTerminationOfOperationTwo")
public class DxxzspTerminationOfOperationTwoController {
	@Resource
	private DxxzspTerminationOfOperationService dxxzspTerminationOfOperationTwoService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationOfOperationTwo")
	public ModelAndView toDxxzspTerminationOfOperationTwo(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspTerminationOfOperationTwo");
		//业务查询
		Map<String,Object> data = dxxzspTerminationOfOperationTwoService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
