package com.module.controller.broadbandAccService.apply;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.runtime.directive.Break;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.module.service.broadbandAccService.apply.ReadAccessNetworkService;

@Controller
@RequestMapping("/readAccessNetwork")
public class ReadAccessNetworkController {
	@Resource
	private ReadAccessNetworkService readAccessNetworkService;
	
	/**
	 * 
	 * @param formid        表单id
	 * @param id     		流程id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/readAccessNetwork")
	public void readAccessNetwork(String id,String formid,String yewuCode,HttpServletResponse response) throws Exception {
		String  shijianid=null;
		//根据流程id 找事件id
		try {
			if(id != null && formid != null && yewuCode != null) {
				  shijianid = readAccessNetworkService.getShiJianId(id);
				  if(shijianid != null){
					 response.sendRedirect("http://192.168.100.190:8080/dxxzsp/horizon/template/form/default.wf?formId="+formid+"&dataid="+shijianid+"&yewucodekan="+yewuCode);
				  }
			}else {
				response.sendRedirect("http://192.168.100.191:8080/DXXZSP_TH/error/error.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("http://192.168.100.191:8080/DXXZSP_TH/error/error.jsp");
		}
	}
		
}
