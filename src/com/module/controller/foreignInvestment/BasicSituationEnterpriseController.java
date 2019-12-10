package com.module.controller.foreignInvestment;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.foreignInvestment.BasicSituationEnterpriseService;
import com.util.AppException;

//外商投资股东追溯及其相关材料证明
@Controller
@RequestMapping("/basicSituationEnterprise")
public class BasicSituationEnterpriseController {
	
	@Resource
	private BasicSituationEnterpriseService basicSituationEnterpriseService;
	
	//页面跳转
	@RequestMapping("/basicSituationEnterprise")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("foreignInvestment/basicSituationEnterprise");
		//业务查询
		Map<String,Object> data = basicSituationEnterpriseService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
