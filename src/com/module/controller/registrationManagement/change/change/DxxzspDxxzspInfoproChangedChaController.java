package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDxxzspInfoproChangedChaService;
import com.util.AppException;

//1、公司技术后台变更--信息安全保障措施表
@Controller
@RequestMapping("/DxxzspDxxzspInfoproChangedCha")
public class DxxzspDxxzspInfoproChangedChaController {
	@Resource
	private DxxzspDxxzspInfoproChangedChaService dxxzspDxxzspInfoproChangedChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDxxzspInfoproChangedCha")
	public ModelAndView toDxxzspDxxzspInfoproChangedCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDxxzspInfoproChangedCha");
		//业务查询
		Map<String,Object> data =dxxzspDxxzspInfoproChangedChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}
