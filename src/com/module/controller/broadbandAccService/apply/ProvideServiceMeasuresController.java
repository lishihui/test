package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.broadbandAccService.apply.ProvideServiceMeasuresService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//为用户提供长期服务和质量保障措施
@Controller
@RequestMapping("/provideServiceMeasures")
public class ProvideServiceMeasuresController {
	
	@Resource
	private ProvideServiceMeasuresService provideServiceMeasuresService;
 	
	//页面跳转
	@RequestMapping("/provideServiceMeasures")
	public ModelAndView provideServiceMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/provideServiceMeasures");
		//业务查询
		Map<String,Object> data = provideServiceMeasuresService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
