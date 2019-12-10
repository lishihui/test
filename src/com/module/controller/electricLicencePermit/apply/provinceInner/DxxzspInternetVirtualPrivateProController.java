package com.module.controller.electricLicencePermit.apply.provinceInner;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInternetVirtualPrivateProService;
import com.util.AppException;

//国内互联网虚拟专用网业务(internetVirtualPrivate)
@Controller
@RequestMapping("/DxxzspInternetVirtualPrivatePro")
public class DxxzspInternetVirtualPrivateProController {
	@Resource
	private DxxzspInternetVirtualPrivateProService DxxzspInternetVirtualPrivateProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInternetVirtualPrivatePro")
	public ModelAndView toDxxzspSmallApertureEarthCommunication(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspInternetVirtualPrivatePro");
		//业务查询
		Map<String,Object> data = DxxzspInternetVirtualPrivateProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

