package com.module.controller.broadbandAccService.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.comm.OperationExperienceService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//企业3年以上运营经验的证明材料
@Controller
@RequestMapping("/operationExperience")
public class OperationExperienceController {
	
	@Resource
	private OperationExperienceService operationExperienceService;
	
	//页面跳转
	@RequestMapping("/operationExperience")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/comm/operationExperience");
		//业务查询
		Map<String,Object> data = operationExperienceService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
