package com.module.controller.ftaTradeApplication.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.apply.DxxzspDomesticCallCenterFtaService;
import com.util.AppException;


//1、国内呼叫中心业务
@Controller
@RequestMapping("/DxxzspDomesticCallCenterFta")
public class DxxzspDomesticCallCenterFtaController {
	@Resource
	private DxxzspDomesticCallCenterFtaService dxxzspDomesticCallCenterFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomesticCallCenterFta")
	public ModelAndView toDxxzspDomesticCallCenterFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/apply/DxxzspDomesticCallCenterFta");
		//业务查询
		Map<String,Object> data = dxxzspDomesticCallCenterFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}
