package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaThreeService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspTerminationChangeChaThree")
public class DxxzspTerminationChangeChaThreeController {
	@Resource
	private DxxzspTerminationChangeChaThreeService dxxzspTerminationChangeChaThreeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationChangeChaThree")
	public ModelAndView toDxxzspTerminationChangeChaThree(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspTerminationChangeChaThree");
		//业务查询
		Map<String,Object> data = dxxzspTerminationChangeChaThreeService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
