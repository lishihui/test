package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.comm.DxxzspCompanyForInvStaFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspCompanyForInvStaFta")
public class DxxzspCompanyForInvStaFtaController {
	@Resource
	private DxxzspCompanyForInvStaFtaService dxxzspCompanyForInvStaFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyForInvStaFta")
	public ModelAndView toDxxzspCompanyForInvStaFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspCompanyForInvStaFta");
		//业务查询
		Map<String,Object> data = dxxzspCompanyForInvStaFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}
