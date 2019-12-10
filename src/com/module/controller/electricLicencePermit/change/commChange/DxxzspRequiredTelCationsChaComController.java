package com.module.controller.electricLicencePermit.change.commChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.module.service.electricLicencePermit.change.commChange.DxxzspRequiredTelCationsChaComService;
import com.util.AppException;

//电信主管部门要求的其他材料(requiredTelCations)
@Controller
@RequestMapping("/DxxzspRequiredTelCationsChaCom")
public class DxxzspRequiredTelCationsChaComController {
	@Resource
	private DxxzspRequiredTelCationsChaComService DxxzspRequiredTelCationsChaComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRequiredTelCationsChaCom")
	public ModelAndView toDxxzspRequiredTelCationsChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/commChange/DxxzspRequiredTelCationsChaCom");
		//业务查询
		Map<String,Object> data = DxxzspRequiredTelCationsChaComService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

