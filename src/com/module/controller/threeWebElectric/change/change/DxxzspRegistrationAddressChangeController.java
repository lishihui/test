package com.module.controller.threeWebElectric.change.change;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.change.DxxzspRegistrationAddressChangeService;
import com.util.AppException;

//注册地址变更
@Controller
@RequestMapping("/DxxzspRegistrationAddressChange")
public class DxxzspRegistrationAddressChangeController {
	@Resource
	private DxxzspRegistrationAddressChangeService DxxzspRegistrationAddressChangeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRegistrationAddressChange")
	public ModelAndView toDxxzspRegistrationAddressChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspRegistrationAddressChange");
		//业务查询
		Map<String,Object> data = DxxzspRegistrationAddressChangeService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}
