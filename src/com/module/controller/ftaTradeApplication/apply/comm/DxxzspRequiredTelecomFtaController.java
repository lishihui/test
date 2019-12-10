package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.ftaTradeApplication.apply.comm.DxxzspRequiredTelecomFtaService;
import com.util.AppException;

//1、电信主管部门要求提交的其他材料
@Controller
@RequestMapping("/DxxzspRequiredTelecomFat")
public class DxxzspRequiredTelecomFtaController {
	@Resource
	private DxxzspRequiredTelecomFtaService DxxzspRequiredTelecomFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRequiredTelecomFat")
	public ModelAndView toDxxzspRequiredTelecomm(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspRequiredTelecomFta");
		//业务查询
		Map<String,Object> data = DxxzspRequiredTelecomFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


