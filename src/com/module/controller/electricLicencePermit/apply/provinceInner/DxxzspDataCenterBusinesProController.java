package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDataCenterBusinesProService;
import com.util.AppException;

//互联网数据中心业务(dataCenterBusiness)
@Controller
@RequestMapping("/DxxzspDataCenterBusinesPro")
public class DxxzspDataCenterBusinesProController {
	@Resource
	private DxxzspDataCenterBusinesProService dxxzspDataCenterBusinesProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDataCenterBusinesPro")
	public ModelAndView toDxxzspDataCenterBusinesPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspDataCenterBusinesPro");
		//业务查询
		Map<String,Object> data = dxxzspDataCenterBusinesProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

