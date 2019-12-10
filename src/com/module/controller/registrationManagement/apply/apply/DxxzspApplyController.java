package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspApplyService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspApply")
public class DxxzspApplyController {
	@Resource
	private DxxzspApplyService dxxzspApplyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspApply")
	public ModelAndView toDxxzspApply(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspApply");
		//业务查询
		Map<String,Object> data = dxxzspApplyService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
