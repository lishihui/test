package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetApplyFormPilotService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//宽带接入网业务试点申请表
@Controller
@RequestMapping("/netApplyFormPilot")
public class NetApplyFormPilotController {
	
	@Resource
	private NetApplyFormPilotService netApplyFormPilotService;
 	
	//页面跳转
	@RequestMapping("/netApplyFormPilot")
	public ModelAndView netApplyFormPilot(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/netApplyFormPilot");
		//业务查询
		Map<String,Object> data = netApplyFormPilotService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
