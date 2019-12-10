package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspContentDistrNetProService;
import com.util.AppException;
//内容分发网络业务(contentDistrNet)
@Controller
@RequestMapping("/DxxzspContentDistrNetPro")
public class DxxzspContentDistrNetProController {
	@Resource
	private DxxzspContentDistrNetProService dxxzspContentDistrNetProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspContentDistrNetPro")
	public ModelAndView toDxxzspContentDistrNetPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspContentDistrNetPro");
		//业务查询
		Map<String,Object> data = dxxzspContentDistrNetProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
