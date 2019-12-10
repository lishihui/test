package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//网络与信息安全保障措施
@Controller
@RequestMapping("/informatSecurityMeasures")
public class InformatSecurityMeasuresController {
	
	@Resource
	private InformatSecurityMeasuresService informatSecurityMeasuresService;
	
	//页面跳转
	@RequestMapping("/informatSecurityMeasures")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/informatSecurityMeasures");
		//业务查询
		Map<String,Object> data = informatSecurityMeasuresService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
