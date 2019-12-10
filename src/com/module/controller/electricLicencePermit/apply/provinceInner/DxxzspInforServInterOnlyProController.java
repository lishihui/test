package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInforServInterOnlyProService;
import com.util.AppException;
//信息服务（仅限互联网信息服务）业务(inforServInterOnly)
@Controller
@RequestMapping("/DxxzspInforServInterOnlyPro")
public class DxxzspInforServInterOnlyProController {
	@Resource
	private DxxzspInforServInterOnlyProService dxxzspInforServInterOnlyProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInforServInterOnlyPro")
	public ModelAndView toDxxzspInforServInterOnlyPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspInforServInterOnlyPro");
		//业务查询
		Map<String,Object> data = dxxzspInforServInterOnlyProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
