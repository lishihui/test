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
@RequestMapping("/DxxzspTerminationOfOperation")
public class DxxzspTerminationOfOperationController {
	@Resource
	private DxxzspTerminationOfOperationService dxxzspTerminationOfOperationService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationOfOperation")
	public ModelAndView toDxxzspTerminationOfOperation(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspTerminationOfOperation");
		//业务查询
		Map<String,Object> data = dxxzspTerminationOfOperationService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

