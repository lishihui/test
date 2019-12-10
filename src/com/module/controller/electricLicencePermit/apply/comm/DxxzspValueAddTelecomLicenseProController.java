package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.comm.DxxzspValueAddTelecomLicenseProService;
import com.util.AppException;



//增值电信业务经营许可证申请表(valueAddTelecomLicense)
@Controller
@RequestMapping("/DxxzspValueAddTelecomLicensePro")
public class DxxzspValueAddTelecomLicenseProController {
	@Resource
	private DxxzspValueAddTelecomLicenseProService dxxzspValueAddTelecomLicenseProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspValueAddTelecomLicensePro")
	public ModelAndView toDxxzspValueAddTelecomLicensePro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspValueAddTelecomLicensePro");
		//业务查询
		Map<String,Object> data = dxxzspValueAddTelecomLicenseProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
