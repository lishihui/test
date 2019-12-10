package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaFiveService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspTerminationChangeChaFive")
public class DxxzspTerminationChangeChaFiveController {
	@Resource
	private DxxzspTerminationChangeChaFiveService DxxzspTerminationChangeChaFiveService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationChangeChaFive")
	public ModelAndView toDxxzspTerminationChangeChaFive(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspTerminationChangeChaFive");
		//业务查询
		Map<String,Object> data = DxxzspTerminationChangeChaFiveService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
