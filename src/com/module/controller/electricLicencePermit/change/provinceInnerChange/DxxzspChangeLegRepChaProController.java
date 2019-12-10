package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeLegRepChaProService;
import com.util.AppException;

//法定代表人变更(changeLegRep)
@Controller
@RequestMapping("/DxxzspChangeLegRepChaPro")
public class DxxzspChangeLegRepChaProController {
	@Resource
	private DxxzspChangeLegRepChaProService DxxzspChangeLegRepChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeLegRepChaPro")
	public ModelAndView toDxxzspChangeLegRepChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspChangeLegRepChaPro");
		//业务查询
		Map<String,Object> data = DxxzspChangeLegRepChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

