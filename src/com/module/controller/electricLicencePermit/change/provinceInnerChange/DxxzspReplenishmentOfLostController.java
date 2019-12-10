package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspReplenishmentOfLostChaProService;
import com.util.AppException;


//许可证遗失补办(replenishmentOfLost)
@Controller
@RequestMapping("/DxxzspReplenishmentOfLost")
public class DxxzspReplenishmentOfLostController {
	@Resource
	private DxxzspReplenishmentOfLostChaProService dxxzspReplenishmentOfLostService;
	
	//页面跳转
	@RequestMapping("/toDxxzspReplenishmentOfLost")
	public ModelAndView toDxxzspReplenishmentOfLost(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspReplenishmentOfLost");
		//业务查询
		Map<String,Object> data = dxxzspReplenishmentOfLostService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
