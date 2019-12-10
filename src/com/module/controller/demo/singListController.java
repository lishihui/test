package com.module.controller.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.velocity.runtime.directive.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.util.AppException;
import com.util.FinalClassUtil;
import com.util.HttpUtil;
import com.util.ToolUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.module.domain.base.WetrilCnkiLicenseInfo;
import com.module.service.demo.IDemoUserService;
import com.module.service.param.DxxzspTokenConfService;


//程序样例
@Controller
@RequestMapping("/DemoUser")
public class singListController {
	@Resource
	private IDemoUserService iDemoUserService;
	@Autowired
	DxxzspTokenConfService dxxzspTokenConfService;
	
	Logger log=Logger.getLogger(singListController.class);
	
//页面跳转到singDealtList
	@RequestMapping(value="/tosingList",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView tosingList(String id,String flowrunid)throws AppException{
		ModelAndView mv = new ModelAndView("electricLicencePermit/singDealtList");
		/*Map<String,Object> result=getList();
		String processId=result.get("processId").toString();
		processId=processId.substring(0, processId.length()-1);*/
		
		String processId="";
		HashMap<String, Object> tosingList = getTosingList();
		ArrayList<Object> list = (ArrayList<Object>) tosingList.get("processId");
		for (int i = 0; i < list.size(); i++) {
			processId+="'"+list.get(i)+"',";
		}
		processId=processId.substring(0, processId.length()-1);
		Map<String,Object> data= iDemoUserService.querySingList(processId);
		mv.addObject("data", data);
		return mv;
	}
	
		
	//singDealtList页面查询跳转singDetailedList
		@RequestMapping(value="/tosingDetailedListZp",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView tosingDetailedListZp(String Itemid) throws AppException, IOException{
			//http://192.168.100.120:8080/dxxzsp/qbaction/bjqbnew?dxxzspParamReq=+s
			/*String urlStr="http://192.168.100.120:8080/dxxzsp/qbaction/bjqbnew?dxxzspParamReq="+Itemid;
			HashMap<String, String> parameterMap = new HashMap<>();
			String post = HttpUtil.post(urlStr, parameterMap);
			System.err.println(post);*/
			
			ModelAndView mv = new ModelAndView("electricLicencePermit/singDetailedList");
			Itemid=Itemid.substring(0, Itemid.length()-1);
			String itemidi="";
			String[] result = Itemid.split(",");
			   for (int i = 0; i < result.length; i++) {
			      System.out.println(result[i]);
			      itemidi+="'"+result[i]+"',";
			   }
			   itemidi=itemidi.substring(0, itemidi.length()-1);
			   
			Map<String,Object> data= iDemoUserService.querysingDetailedList(itemidi);
			mv.addObject("data", data);
			return mv;
		}
		
		//修改DXXZSP_YEWU_QIANBAO_BJ表数据
		@RequestMapping(value="/saveJZDataZp",method=RequestMethod.POST)
		@ResponseBody
		public Boolean saveJZDataZp(String pcbh,String itemid,String qbnr){
			try {
				
				itemid=itemid.substring(0, itemid.length()-1);
				iDemoUserService.saveData(pcbh,itemid,qbnr);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		
		
		//跳转singDoneList
		@RequestMapping(value="/tosingDoneList",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView tosingDoneList(String id,String flowrunid)throws AppException{
			ModelAndView mv = new ModelAndView("electricLicencePermit/singDoneList");
			
			Map<String,Object> data= iDemoUserService.querySingDoneList();
			mv.addObject("data", data);
			return mv;
		}
		
		//singDoneList页面跳转singFourBrowse
		@RequestMapping(value="/tosingFourBrowse",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView tosingFourBrowse(String id) throws AppException{
			ModelAndView mv = new ModelAndView("electricLicencePermit/singFourBrowse");
			Map<String, Object> bjData=iDemoUserService.querySingFourBrowse(id);
			Object object = bjData.get("TODOID");
			String todoid = JSON.toJSONString(object);
			todoid=todoid.substring(1, todoid.length()-1);
			
			String[] split = todoid.split(",");
			String itemid="";
			for (int i = 0; i < split.length; i++) {
				//得到企业的itemid查询
				itemid+="'"+split[i]+"',";
			}
			itemid=itemid.substring(0, itemid.length()-1);
			Map<String,Object> data= iDemoUserService.querysingDetailedList(itemid);
			mv.addObject("data", data);
			mv.addObject("bjData", bjData);
			return mv;
		}
		
		//修改局长数据
		@RequestMapping(value="updatJZDataZp",method=RequestMethod.POST)
		@ResponseBody
		public Boolean updatJZDataZp(String id,String jzyi,String jzqzsj,String itemid){
			try {
				iDemoUserService.updatJZDataZp(id,jzyi,jzqzsj);//修改完在进行提交
				itemid=itemid.substring(0, itemid.length()-1);
				
				ArrayList<String> postTask = postTask(itemid);
				submitTaskid(postTask);
				
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
	//根据流程实例id拿到taskid
	private ArrayList<String> postTask(String itemid) {
		List<Map<String, Object>> list=iDemoUserService.findByItemId(itemid);
		//获取工作流中的任务实例id
		HashMap<String, Object> hashMap = getTosingList();
		ArrayList<String> processIdList = (ArrayList<String>) hashMap.get("processId");
		ArrayList<String> taskIdList =(ArrayList<String>) hashMap.get("tasckId");
		ArrayList<String> arrayList = new ArrayList<>();
		
		//循环企业的任务实例id
		for (int j = 0; j < list.size(); j++) {
			Object object = list.get(j).get("PROCESS_ID");
			String processId2 = JSON.toJSONString(object);//拿到企业的流程实例id
			
			//循环工作流中的任务实例id
			for (int i = 0; i < processIdList.size(); i++) {
				String string = '"'+processIdList.get(i)+'"';
				if(processId2.equals(string)){
					String taskid = taskIdList.get(i);
					arrayList.add(taskid);
				}
			}
		}
		
		System.err.println(arrayList);
		return arrayList;
		/*String getInstanceListUrl = "http://10.15.249.29:9086/runtime/task/v1/getTodoListWithVars?account=cp_leadermainsec&vars=proc_def_key_";
		String Authorization=tokenStr(2);
		Map<String, Map<String, Object>> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("page", 0);
		queryMap.put("pageSize", 0);
		queryMap.put("showTotal", true);
		map.put("pageBean", queryMap);
		String url = getInstanceListUrl;
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("Authorization", Authorization);
		headerMap.put("Content-Type", "application/json");
		String res = HttpUtil.postMap(url, headerMap, JSON.toJSONString(map));
		JSONObject jsonStr = JSON.parseObject(res);
		JSONArray jsonObj = JSON.parseArray(jsonStr.get("rows").toString());
		ArrayList<Object> arrayList = new ArrayList<>();
		String a="";
		//2、循环遍历这个数组
		for (int j = 0; j < list.size(); j++) {
			 Object object = list.get(j).get("PROCESS_ID");
			 String processId2 = JSON.toJSONString(object);
			 
			 for(int i=0;i<jsonObj.size();i++){
				 JSONObject job = jsonObj.getJSONObject(i);
				  if(job.get("PROC_DEF_KEY_").toString().equals("kdqxksq")&&job.get("NODE_ID_").toString().equals("UserTask19")){
					  a+=job.getString("PROC_INST_ID_")+",";
					  String processid='"'+job.getString("PROC_INST_ID_")+'"';
					  if (processid.equals(processId2)) {
						  arrayList.add(job.getString("TASK_ID_"));
					}
					 
				  }
			  }
		}*/
	}
	
	//根据taskid提交任务实例
	public void submitTaskid(ArrayList<String> arrayList){
			ArrayList<Map<String,Object>> list = new ArrayList<>();
			
			for (int i = 0; i < arrayList.size(); i++) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("account", "cp_leadermainsec");
				map.put("actionName", "agree");
				map.put("taskId",arrayList.get(i));
				list.add(map);
			}
			Map<String, Object>  result1=new HashMap<>();
			String getInstanceListUrl = "http://10.15.249.29:9086/runtime/task/v1/batchComplete";
			String Authorization=tokenStr(2);
			String url=getInstanceListUrl;
			Map<String,String> headerMap = new HashMap<>();
			headerMap.put("Authorization", Authorization);
			headerMap.put("Content-Type", "application/json");
			
			String ret = HttpUtil.postMap(url, headerMap, JSON.toJSONString(list));
			System.out.println(ret);
	}


	//根据用户账号获取代办实例
	public Map<String, Object> getList() {
		Map<String, Object>  result1=new HashMap<>();
		String getInstanceListUrl = "http://10.15.249.29:9086/runtime/task/v1/getTodoListWithVars?account=cp_leadermainsec&vars=proc_def_key_";
		String Authorization=tokenStr(2);
		Map<String, Map<String, Object>> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("page", 0);
		queryMap.put("pageSize", 0);
		queryMap.put("showTotal", true);
		map.put("pageBean", queryMap);
		String url = getInstanceListUrl;
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("Authorization", Authorization);
		headerMap.put("Content-Type", "application/json");
		String res = HttpUtil.postMap(url, headerMap, JSON.toJSONString(map));
		
		JSONObject jsonStr = JSON.parseObject(res);
		JSONArray jsonObj = JSON.parseArray(jsonStr.get("rows").toString());
		String processId="";
		String tasckId="";
		//2、循环遍历这个数组
		 for(int i=0;i<jsonObj.size();i++){
			 //3、把里面的对象转化为JSONObject
			  JSONObject job = jsonObj.getJSONObject(i);
			  if(job.get("PROC_DEF_KEY_").toString().equals("kdqxksq")&&job.get("NODE_ID_").toString().equals("UserTask19")){
				  processId+="'"+job.getString("PROC_INST_ID_")+"',";
				  tasckId+=job.getString("TASK_ID_")+",";
			  }
		  }
		 result1.put("processId", processId);
		 result1.put("tasckId", tasckId);
		return result1;
	}
	
	
	//根据节点名称获取当前用户的代办信息
	public HashMap<String,Object> getTosingList() {
		String getInstanceListUrl = "http://10.15.249.29:9086/runtime/task/v1/getTodoList";
		String Authorization = tokenStr(2);
		HashMap<Object, Object> map = new HashMap<>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("property", "node_id_");
		queryMap.put("value", "UserTask19");
		queryMap.put("group", "main");
		queryMap.put("operation", "LIKE");
		queryMap.put("relation", "AND");
		list.add(queryMap);
		
		HashMap<String, Object> pageBean = new HashMap<>();
		pageBean.put("page", 0);
		pageBean.put("pageSize", 0);
		pageBean.put("showTotal", true);
		
		map.put("querys", list);
		map.put("pageBean", pageBean);
		String url = getInstanceListUrl;
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("Authorization", Authorization);
		headerMap.put("Content-Type", "application/json");
		String res = HttpUtil.postMap(url, headerMap, JSON.toJSONString(map));
		
		
		JSONObject jsonStr = JSON.parseObject(res);
		JSONArray jsonObj = JSON.parseArray(jsonStr.get("rows").toString());
		ArrayList<Object> processId = new ArrayList<>();
		ArrayList<Object> tasckId = new ArrayList<>();
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		//2、循环遍历这个数组
		 for(int i=0;i<jsonObj.size();i++){
			 //3、把里面的对象转化为JSONObject
			  JSONObject job = jsonObj.getJSONObject(i); //procInstId
			  processId.add(job.getString("procInstId"));
			  tasckId.add(job.getString("taskId"));
		  }
		 hashMap.put("processId", processId);
		 hashMap.put("tasckId", tasckId);
		return hashMap;
	}
	
	/**
	 * 获取token
	 * @param flag 标识： 1.获取 2.更新
	 * @return
	 */
	public String tokenStr(int flag) {
		String userName = "cp_leadermainsec";
		String token = null;
		switch (flag) {
		case 1: // 查询
			token = dxxzspTokenConfService.getToken(userName); //用户名（目前写死）
			if(token == null) {
				token = ToolUtil.getARToken(userName, FinalClassUtil.EXPIRATION);
				dxxzspTokenConfService.addToken(userName, token);
			}
			break;
		case 2: // 更新
			token = ToolUtil.getARToken(userName, FinalClassUtil.EXPIRATION);
			dxxzspTokenConfService.updToken(userName, token);
			break;
		}
		return token.trim();
	}
	
	
	//下载
	@RequestMapping(value="/downLicence")
	public void downLicence(String workbj,String workbg,HttpServletRequest request, HttpServletResponse response){
		log.info("开始时间："+System.currentTimeMillis());
		String[] workbjArray = workbj.split(",");
		String[] workbgArray = workbg.split(",");
		if (workbjArray.length<=0 && workbgArray.length<=0) {
			return;
		}
		//申请workid存入数组
		List<String> dxxzspParamSq=new ArrayList();
		for (int i = 0; i < workbjArray.length; i++) {
			dxxzspParamSq.add(workbjArray[i]);
		}
		
		//变更workid存入数组
		List<String> dxxzspParamBg=new ArrayList();
		for (int i = 0; i < workbgArray.length; i++) {
			dxxzspParamBg.add(workbgArray[i]);
		}
		 List<List<String>> entbaseNameStr1=null;
	    	
    	 //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
        response.setContentType("multipart/form-data");   
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)   
        response.setHeader("Content-Disposition", "attachment;fileName="+"公司业务情况单.docx");   
        response.setCharacterEncoding("UTF-8");
    	Map map=iDemoUserService.downLicence(dxxzspParamSq,dxxzspParamBg);
    	List<WetrilCnkiLicenseInfo> listInfoSq=(List<WetrilCnkiLicenseInfo>) map.get("sq");
    	List<Map> listInfoBg=(List<Map>) map.get("bg");
    	if(listInfoSq!=null&& listInfoSq.size()>0){
    		this.export(listInfoSq,request,response);
    	}
    	if(listInfoBg!=null && listInfoBg.size()>0){
    		this.exportBg(listInfoBg,request,response);
    	}
    	
    	log.info("结束时间："+System.currentTimeMillis());
		
	}

	//申请模板拼接
	 private String export(List<WetrilCnkiLicenseInfo> listInfoSq,HttpServletRequest request, HttpServletResponse response) {
	    	//总表map
	    	try {
			    	Map maps=new HashMap();
			    	XWPFDocument xwpfDocument=iDemoUserService.exportDoc(request,listInfoSq);
		            String name = "公司业务情况单.docx";
			    	response.setHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("utf-8"), "ISO8859-1"));
			    	ServletOutputStream outputStream = response.getOutputStream();
			    	xwpfDocument.write(outputStream);
			    	outputStream.close();
				    	
	    	} catch (Exception e) {
	    			log.info(e.getMessage());
	    			e.printStackTrace();
	    	}
	      return "sucess";
		}

	//变更模板拼接
	 private String exportBg(List<Map> exportBg,HttpServletRequest request, HttpServletResponse response) {
	    	//总表map
	    	try {
			    	Map maps=new HashMap();
			    	XWPFDocument xwpfDocument=iDemoUserService.exportDocBg(request,exportBg);
		            String name = "公司业务情况单变更.docx";
			    	response.setHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("utf-8"), "ISO8859-1"));
			    	ServletOutputStream outputStream = response.getOutputStream();
			    	xwpfDocument.write(outputStream);
			    	outputStream.close();
				    	
	    	} catch (Exception e) {
	    			log.info(e.getMessage());
	    			e.printStackTrace();
	    	}
	      return "sucess";
		}

	
}
