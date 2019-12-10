package com.module.controller.broadbandAccService.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.comm.CommunicationsAdministrationService;
import com.util.AppException;

//省通信管理局要求提交的其他材料
@Controller
@RequestMapping("/communicationsAdministration")
public class CommunicationsAdministrationController {
	
	@Resource
	private CommunicationsAdministrationService communicationsAdministrationService;
	
	//页面跳转
	@RequestMapping("/communicationsAdministration")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/comm/communicationsAdministration");
		//业务查询
		Map<String,Object> data = communicationsAdministrationService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
