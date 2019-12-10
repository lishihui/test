package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaFourService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspTerminationChangeChaFour")
public class DxxzspTerminationChangeChaFourController {
	@Resource
	private DxxzspTerminationChangeChaFourService DxxzspTerminationChangeChaFourService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationChangeChaFour")
	public ModelAndView toDxxzspTerminationChangeChaFour(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspTerminationChangeChaFour");
		//业务查询
		Map<String,Object> data = DxxzspTerminationChangeChaFourService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
