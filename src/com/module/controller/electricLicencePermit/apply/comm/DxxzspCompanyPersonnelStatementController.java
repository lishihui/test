package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.comm.DxxzspCompanyPersonnelStatementService;
import com.util.AppException;

//公司及人员情况表(companyPersonnelStatement)
@Controller
@RequestMapping("/DxxzspCompanyPersonnelStatement")
public class DxxzspCompanyPersonnelStatementController {
	@Resource
	private DxxzspCompanyPersonnelStatementService DxxzspCompanyPersonnelStatementService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyPersonnelStatement")
	public ModelAndView toDxxzspValueAddTelecomLicense(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspCompanyPersonnelStatement");
		//业务查询
		Map<String,Object> data = DxxzspCompanyPersonnelStatementService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
