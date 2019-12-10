package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspToplevelDomRegSitService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspToplevelDomRegSit")
public class DxxzspToplevelDomRegSitController {
	@Resource
	private DxxzspToplevelDomRegSitService dxxzspToplevelDomRegSitService;
	
	//页面跳转
	@RequestMapping("/toDxxzspToplevelDomRegSit")
	public ModelAndView toDxxzspToplevelDomRegSit(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspToplevelDomRegSit");
		//业务查询
		Map<String,Object> data = dxxzspToplevelDomRegSitService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
