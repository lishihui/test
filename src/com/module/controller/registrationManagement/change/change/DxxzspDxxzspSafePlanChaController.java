package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDxxzspSafePlanChaService;
import com.util.AppException;

//1、公司技术后台变更--网络安全保障措施表
@Controller
@RequestMapping("/DxxzspDxxzspSafePlanCha")
public class DxxzspDxxzspSafePlanChaController {
	@Resource
	private DxxzspDxxzspSafePlanChaService dxxzspDxxzspSafePlanChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDxxzspSafePlanCha")
	public ModelAndView toDxxzspDxxzspSafePlanCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDxxzspSafePlanCha");
		//业务查询
		Map<String,Object> data =dxxzspDxxzspSafePlanChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}
