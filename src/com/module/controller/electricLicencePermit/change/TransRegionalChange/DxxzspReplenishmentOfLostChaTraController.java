package com.module.controller.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspReplenishmentOfLostChaTraService;
import com.util.AppException;


//许可证遗失补办(replenishmentOfLost)

@Controller
@RequestMapping("/DxxzspReplenishmentOfLostChaTra")
public class DxxzspReplenishmentOfLostChaTraController {
	@Resource
	private DxxzspReplenishmentOfLostChaTraService dxxzspReplenishmentOfLostChaTraService;
	
	//页面跳转
	@RequestMapping("/toDxxzspReplenishmentOfLostChaTra")
	public ModelAndView toDxxzspReplenishmentOfLostChaTra(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/TransRegionalChange/DxxzspReplenishmentOfLostChaTra");
		//业务查询
		Map<String,Object> data = dxxzspReplenishmentOfLostChaTraService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
