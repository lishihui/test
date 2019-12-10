package com.module.controller.threeWebElectric.change.change;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.change.DxxzspChangeLegRepService;
import com.util.AppException;

//法定代表人变更
@Controller
@RequestMapping("/DxxzspChangeLegRep")
public class DxxzspChangeLegRepController {
	@Resource
	private DxxzspChangeLegRepService DxxzspChangeLegRepService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeLegRep")
	public ModelAndView toDxxzspChangeLegRep(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspChangeLegRep");
		//业务查询
		Map<String,Object> data = DxxzspChangeLegRepService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

