package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDomesticCallCenterProService;
import com.util.AppException;

//国内呼叫中心业务(domesticCallCenter)
@Controller
@RequestMapping("/DxxzspDomesticCallCenterPro")
public class DxxzspDomesticCallCenterProController {
	@Resource
	private DxxzspDomesticCallCenterProService DxxzspDomesticCallCenterProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomesticCallCenterPro")
	public ModelAndView toDxxzspDomesticCallCenter(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspDomesticCallCenterPro");
		//业务查询
		Map<String,Object> data = DxxzspDomesticCallCenterProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

