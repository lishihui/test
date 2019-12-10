package com.module.controller.broadbandAccService.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.comm.StructureChartService;
import com.util.AppException;

//完整详细的股权结构图
@Controller
@RequestMapping("/structureChart")
public class StructureChartController {
	
	@Resource
	private StructureChartService structureChartService;
	
	//页面跳转
	@RequestMapping("/structureChart")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/comm/structureChart");
		//业务查询
		Map<String,Object> data = structureChartService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}
