package com.module.controller.foreignInvestment;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.module.service.foreignInvestment.BasicSituationApplicantService;
import com.util.AppException;

//外商投资申请企业基本情况表
@Controller
@RequestMapping("/basicSituationApplicant")
public class BasicSituationApplicantController {
	
	@Resource
	private BasicSituationApplicantService basicSituationApplicantService;
	
	//页面跳转
	@RequestMapping("/basicSituationApplicant")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("foreignInvestment/basicSituationApplicant");
		//业务查询
		Map<String,Object> data = basicSituationApplicantService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
