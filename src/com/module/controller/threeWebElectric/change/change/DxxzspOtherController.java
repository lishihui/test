package com.module.controller.threeWebElectric.change.change;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.change.DxxzspOtherService;
import com.util.AppException;

//其他
@Controller
@RequestMapping("/DxxzspOther")
public class DxxzspOtherController {
	@Resource
	private DxxzspOtherService DxxzspOtherService;
	
	//页面跳转
	@RequestMapping("/toDxxzspOther")
	public ModelAndView toDxxzspOther(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspOther");
		//业务查询
		Map<String,Object> data = DxxzspOtherService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

