package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInformationServicesExcludingInternetService;
import com.util.AppException;

	//1����Ϣ���񣨲�����������Ϣ����ҵ��
	@Controller
	@RequestMapping("/DxxzspInformationServicesExcludingInternet")
	public class DxxzxpInformationServicesExcludingInternetController {
		@Resource
		private DxxzspInformationServicesExcludingInternetService dxxzspInformationServicesExcludingInternetService;
		
		//ҳ����ת
		@RequestMapping("/toDxxzspInformationServicesExcludingInternet")
		public ModelAndView toDxxzspInformationServicesExcludingInternet(String id,String flowrunid) throws AppException {
			ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspInformationServicesExcludingInternet");
			//ҵ���ѯ
			Map<String,Object> data = dxxzspInformationServicesExcludingInternetService.getRow(id, flowrunid);
			mv.addObject("data", data);
//			System.out.println("**************************************");
//			System.out.println(mv);
//			System.out.println("**************************************");
			return mv;
		}

}
