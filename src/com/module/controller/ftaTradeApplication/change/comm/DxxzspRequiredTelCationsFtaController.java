package com.module.controller.ftaTradeApplication.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.comm.DxxzspRequiredTelCationsFtaService;
import com.util.AppException;

//1、电信主管部门要求提交的其他材料
@Controller
@RequestMapping("/DxxzspRequiredTelCationsFta")
public class DxxzspRequiredTelCationsFtaController {
	@Resource
	private DxxzspRequiredTelCationsFtaService dxxzspRequiredTelCationsFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRequiredTelCationsFta")
	public ModelAndView toDxxzspRequiredTelCationsFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/comm/DxxzspRequiredTelCationsFta");
		//业务查询
		Map<String,Object> data = dxxzspRequiredTelCationsFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}
}
