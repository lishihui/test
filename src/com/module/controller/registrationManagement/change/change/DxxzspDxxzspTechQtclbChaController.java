package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDxxzspTechQtclbChaService;
import com.util.AppException;

//1、公司技术后台变更--电信管理机构要求的其他材料表
@Controller
@RequestMapping("/DxxzspDxxzspTechQtclbCha")

public class DxxzspDxxzspTechQtclbChaController {
	@Resource
	private DxxzspDxxzspTechQtclbChaService dxxzspDxxzspTechQtclbChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDxxzspTechQtclbCha")
	public ModelAndView toDxxzspDxxzspTechQtclbCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDxxzspTechQtclbCha");
		//业务查询
		Map<String,Object> data =dxxzspDxxzspTechQtclbChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}
