package com.module.service.domainRegistration.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.DxxzspAgencyPromiseMapper;
import com.module.domain.base.Page;
import com.module.domain.domain.DxxzspYewujiluUser;
import com.module.domain.query.XukeSearchQueryBean;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.comm.DxxzspAuditTaskCommonService;

@Service("DxxzspAuditTaskCommonService")
public class DxxzspAuditTaskCommonServiceImpl implements DxxzspAuditTaskCommonService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspAgencyPromiseMapper dxxzspAgencyPromiseMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid) throws Exception {
		//String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> yewujilu_list =  commonMapper.findManyData("select * from dxxzsp_yewujilu_user where rname= '河北中森科贸有限公司' "
				+ "limit 1 , 10 ");
		ret.put("yewujilu_list", yewujilu_list);
		return ret;
	}
	
	
	//根据主键查询业务数据 -- 查询总的记录数量
	@Override
    public int getRowCount(XukeSearchQueryBean obj_record, String param) throws Exception{
		
		Map<String,Object> list = this.getList(obj_record, param);
		int count_size = 0;
		if(list.size()>0){
			count_size = list.size();
		}
		return count_size;
	}
	
	//分页查询 --
	public Map<String,Object> getList(XukeSearchQueryBean obj_record, String param, int currentPage, int currentPageSize){
		
		
		Map<String,Object> ret = new HashMap<String,Object>();
		String mysql = getMysql(obj_record, param);
		
		if(currentPage > 0){
			int start_size = currentPage * currentPageSize + 1;
			int end_size = currentPageSize;
			mysql = mysql + " limit "+ start_size +" , "+ end_size;
			
		}
		
		System.out.println("\n\n********************************************\n\n");
		System.out.println("分页**mysql:"+mysql);
		System.out.println("\n\n********************************************\n\n");
		List<Map<String,Object>> yewujilu_list =  commonMapper.findManyData(mysql);
		//List<Map<String,Object>> yewujilu_list = this.getListWithinTask(list);
		ret.put("yewujilu_list", yewujilu_list);
		return ret;	
	} 
	
	//获取集合信息 -- 不分页
	//param（quanbu,kuadiqu,shengnei）
	public Map<String,Object> getList(XukeSearchQueryBean obj_record, String param){
		
		
		Map<String,Object> ret = new HashMap<String,Object>();
		String mysql = getMysql(obj_record, param);
		
		System.out.println("********************************************");
		System.out.println("不分页**mysql:"+mysql);
		System.out.println("********************************************");
		List<Map<String,Object>> yewujilu_list =  commonMapper.findManyData(mysql);
		ret.put("yewujilu_list", yewujilu_list);
		return ret;		
	} 
	
	//得到sql语句
	//param（quanbu,kuadiqu,shengnei）
	public String getMysql(XukeSearchQueryBean obj_record, String param){
		
		StringBuffer mysql = new StringBuffer("");
		
		mysql.append(" select d1.* , d3.* , d2.name as STATUS_NAME ");
		mysql.append(" from item_user_apply d1 left join dxxzsp_dict_code d2 on d1.task_status = d2.code ");
		mysql.append(" left join wetril_cnki_entbase d3 on d1.ent_id = d3.entid ");
		mysql.append(" where 1=1 and company_name is not null ");
		if("quanbu".equals(param)){
			//全查询
			mysql.append("");
		}
		if("shengnei".equals(param)){
			//省内查询
			mysql.append(" and (d1.flow_key != 'kdqxksq' or d1.flow_key is null) ");
		}
		if("kuadiqu".equals(param)){
			//跨地区查询
			mysql.append(" and d1.flow_key = 'kdqxksq' ");
		}
		if(obj_record != null){
			//企业名称查询
			if(obj_record.getCompanyName().trim() != null && !"".equals(obj_record.getCompanyName().trim())){
				mysql.append(" and d1.company_name like '%"+obj_record.getCompanyName().trim()+"%' ");
			}
			//许可证编号
			if(obj_record.getLicNum().trim() != null && !"".equals(obj_record.getLicNum().trim())){
				mysql.append(" and d1.lic_num = '"+obj_record.getLicNum().trim()+"' ");
			}
			
			//业务类型
			if(obj_record.getBusinessType().trim() != null && !"".equals(obj_record.getBusinessType().trim())){
				mysql.append(" and d1.business_type = '"+obj_record.getBusinessType().trim()+"' ");
			}
			
			//任务状态
			if(obj_record.getStatusName().trim() != null && !"".equals(obj_record.getStatusName().trim())){
				mysql.append(" and d2.name = '"+obj_record.getStatusName().trim()+"' ");
			}
			
			//注册地址
			if(obj_record.getRegAddress().trim() != null && !"".equals(obj_record.getRegAddress().trim())){
				mysql.append(" and d3.regaddress = '"+obj_record.getRegAddress().trim()+"' ");
			}
			
			//最后提交时间
			if(obj_record.getLastSubmissionTime().trim() != null && !"".equals(obj_record.getLastSubmissionTime().trim())){
				mysql.append(" and to_char(d1.last_submission_time,'yyyy-mm-dd') = '"+obj_record.getLastSubmissionTime().trim()+"' ");
			}
			
			//最后审核时间
			if(obj_record.getLastAuditTime().trim() != null && !"".equals(obj_record.getLastAuditTime().trim())){
				//mysql.append(" and d1.last_submission_time = '"+obj_record.getLastAuditTime().trim()+"' ");
			}
			
			//企业性质
			if(obj_record.getNature().trim() != null && !"-1".equals(obj_record.getNature().trim())){
				mysql.append(" and d3.nature = "+obj_record.getNature().trim());
			}
			
			//创建时间
			if(obj_record.getCreateTime().trim() != null && !"".equals(obj_record.getCreateTime().trim())){
				mysql.append(" and to_char(d1.create_time,'yyyy-mm-dd') = '"+obj_record.getCreateTime().trim()+"' ");
			}
			
			
			//法人
			if(obj_record.getCorporateName().trim() != null && !"".equals(obj_record.getCorporateName().trim())){
				mysql.append(" and d3.corporatename = '"+obj_record.getCorporateName().trim()+"' ");
			}
			
			//省
			if(obj_record.getProvinceName().trim() != null && !"".equals(obj_record.getProvinceName().trim())){
				//mysql.append(" and d3.corporatename = '"+obj_record.getProvinceName().trim()+"' ");
			}
			//市
			if(obj_record.getCityName().trim() != null && !"".equals(obj_record.getCityName().trim())){
				//mysql.append(" and d3.corporatename = '"+obj_record.getCityName().trim()+"' ");
			}
			//发证机构
			if(obj_record.getOrgName().trim() != null && !"".equals(obj_record.getOrgName().trim())){
				//mysql.append(" and d3.corporatename = '"+obj_record.getOrgName().trim()+"' ");
			}
			//当前节点
			if(obj_record.getNodeName().trim() != null && !"".equals(obj_record.getNodeName().trim())){
				//mysql.append(" and d3.corporatename = '"+obj_record.getNodeName().trim()+"' ");
			}
		}
		return mysql.toString();
	}
	
	
	
	//接收前台查询条件参数
	public XukeSearchQueryBean getXukeSearchQueryBean(HttpServletRequest request){
		XukeSearchQueryBean obj_record = new XukeSearchQueryBean();
		//接受前台参数
		String companyName = request.getParameter("companyName");//企业名称
		if(companyName != null && !"".equals(companyName)){
			obj_record.setCompanyName(companyName);
		}else{
			obj_record.setCompanyName("");
		}
		
		
		String licNum = request.getParameter("licNum");//许可证编号
		if(licNum != null && !"".equals(licNum)){
			obj_record.setLicNum(licNum);
		}else{
			obj_record.setLicNum("");
		}
		
		//业务类型
		String businessType = request.getParameter("businessType");
		if(businessType != null && !"".equals(businessType)){
			obj_record.setBusinessType(businessType);
		}else{
			obj_record.setBusinessType("");
		}
		
		//任务状态
		String statusName = request.getParameter("statusName");
		if(statusName != null && !"".equals(statusName)){
			obj_record.setStatusName(statusName);
		}else{
			obj_record.setStatusName("");
		}
		
		//注册地址
		String regAddress = request.getParameter("regAddress");
		if(regAddress != null && !"".equals(regAddress)){
			obj_record.setRegAddress(regAddress);
		}else{
			obj_record.setRegAddress("");
		}
		
		// lastSubmissionTime;//最后提交时间
		String lastSubmissionTime = request.getParameter("lastSubmissionTime");
		if(lastSubmissionTime != null && !"".equals(lastSubmissionTime)){
			obj_record.setLastSubmissionTime(lastSubmissionTime);
		}else{
			obj_record.setLastSubmissionTime("");
		}
		
		//lastAuditTime;//最后审核时间
		String lastAuditTime = request.getParameter("lastAuditTime");
		if(lastAuditTime != null && !"".equals(lastAuditTime)){
			obj_record.setLastAuditTime(lastAuditTime);
		}else{
			obj_record.setLastAuditTime("");
		}
		
		//属性
		String nature = request.getParameter("nature");
		if(nature != null && !"-1".equals(nature)){
			obj_record.setNature(nature);
		}else{
			obj_record.setNature("-1");
		}
		
		//创建日期
		String createTime = request.getParameter("createTime");
		if(createTime != null && !"".equals(createTime)){
			obj_record.setCreateTime(createTime);
		}else{
			obj_record.setCreateTime("");
		}
		
		//法人
		String corporateName = request.getParameter("corporateName");
		if(corporateName != null && !"".equals(corporateName)){
			obj_record.setCorporateName(corporateName);
		}else{
			obj_record.setCorporateName("");
		}
		
		//省
		String provinceName = request.getParameter("provinceName");
		if(provinceName != null && !"".equals(provinceName)){
			obj_record.setProvinceName(provinceName);
		}else{
			obj_record.setProvinceName("");
		}
	    
		//市
		String cityName = request.getParameter("cityName");
		if(cityName != null && !"".equals(cityName)){
			obj_record.setCityName(cityName);
		}else{
			obj_record.setCityName("");
		}
		
		//发证机构
		String orgName = request.getParameter("orgName");
		if(orgName != null && !"".equals(orgName)){
			obj_record.setOrgName(orgName);
		}else{
			obj_record.setOrgName("");
		}	
		
		//当前节点名称
		String nodeName = request.getParameter("nodeName");
		if(nodeName != null && !"".equals(nodeName)){
			obj_record.setNodeName(nodeName);
		}else{
			obj_record.setNodeName("");
		}
		
		return obj_record;
	}
	
	//填充当前节点信息
	public List<Map<String,Object>> getListWithinTask(List<Map<String,Object>> list){
		
		List<Map<String,Object>> after_list = new ArrayList();
		if(list.size()>0){
			Map<String, Object> map = null;
			for(int i=0;i<list.size();i++){
				
				map = after_list.get(i);
				String process_id = (String) map.get("STATUS_NAME");
				//getTaskInfoByProcessId(process_id);
			}
		}
		return null;
	}
	
	
}
