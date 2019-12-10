package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.electricLicencePermit.apply.comm.DxxzspRequiredTelecommService;
import com.util.AppException;

//电信主管部门要求提交的其他材料(requiredTelecomm)
@Controller
@RequestMapping("/DxxzspRequiredTelecomm")
public class DxxzspRequiredTelecommController {
	@Resource
	private DxxzspRequiredTelecommService DxxzspRequiredTelecommService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRequiredTelecomm")
	public ModelAndView toDxxzspRequiredTelecomm(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspRequiredTelecomm");
		//业务查询
		Map<String,Object> data = DxxzspRequiredTelecommService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

