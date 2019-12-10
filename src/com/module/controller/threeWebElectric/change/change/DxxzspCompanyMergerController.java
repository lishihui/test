package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.threeWebElectric.change.change.DxxzspCompanyMergerService;
import com.util.AppException;

//1、公司合并变更
@Controller
@RequestMapping("/DxxzspCompanyMerger")
public class DxxzspCompanyMergerController {
	@Resource
	private DxxzspCompanyMergerService DxxzspCompanyMergerService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyMerger")
	public ModelAndView toCompanyMerger(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspCompanyMerger");
		//业务查询
		Map<String,Object> data = DxxzspCompanyMergerService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}
