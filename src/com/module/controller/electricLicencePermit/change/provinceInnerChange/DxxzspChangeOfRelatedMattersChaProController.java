package com.module.controller.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfRelatedMattersChaProService;
import com.util.AppException;

//网站（APP）相关事项变更(changeOfRelatedMatters)
@Controller
@RequestMapping("/DxxzspChangeOfRelatedMattersChaPro")
public class DxxzspChangeOfRelatedMattersChaProController {
	@Resource
	private DxxzspChangeOfRelatedMattersChaProService dxxzspChangeOfRelatedMattersChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfRelatedMattersChaPro")
	public ModelAndView toDxxzspChangeOfRelatedMattersChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspChangeOfRelatedMattersChaPro");
		//业务查询
		Map<String,Object> data = dxxzspChangeOfRelatedMattersChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}
