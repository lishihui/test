package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//网络与技术方案专用表格
@Controller
@RequestMapping("/networkTechnical")
public class NetworkTechnicalController {
	
	@Resource
	private NetworkTechnicalService networkTechnicalService;
 	
	//页面跳转
	@RequestMapping("/networkTechnical")
	public ModelAndView networkTechnical(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/networkTechnical");
		//业务查询
		Map<String,Object> data = networkTechnicalService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
