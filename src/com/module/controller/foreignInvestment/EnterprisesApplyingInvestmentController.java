package com.module.controller.foreignInvestment;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.foreignInvestment.EnterprisesApplyingInvestmentService;
import com.util.AppException;

//公司章程(加盖工商局档案查询章原件)(bylawScript)
@Controller
@RequestMapping("/enterprisesApplyingInvestment")
public class EnterprisesApplyingInvestmentController {
	
	@Resource
	private EnterprisesApplyingInvestmentService enterprisesApplyingInvestmentService;
	
	//页面跳转
	@RequestMapping("/enterprisesApplyingInvestment")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("foreignInvestment/enterprisesApplyingInvestment");
		//业务查询
		Map<String,Object> data = enterprisesApplyingInvestmentService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
