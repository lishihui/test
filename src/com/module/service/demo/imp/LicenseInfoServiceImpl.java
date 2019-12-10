package com.module.service.demo.imp;


import horizon.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.CommonConstant;
import com.module.dao.base.CommonMapper;
import com.util.DiQuUtil;
import com.util.RiCHangUtil;
import com.util.StringUtil;
import com.util.StringUtils;
import com.module.service.demo.ILicenseInfoService;

@Service("licenseInfoService")
public class LicenseInfoServiceImpl implements ILicenseInfoService {
	
	@Resource
	private CommonMapper commonMapper;
	
	public String getA12AndA08ServerAppinfo(String num){
		//根据许可证号码，查询许可证相关信息
		String querylicenseInfo = "select * from WETRIL_CNKI_LICENSE where num = '"+ num + "' and version='1' and flag='1'";
		List<Map<String, Object>> list = commonMapper.findManyData(querylicenseInfo);
		Map<String, Object> licenseInfoMap = null;
		//判断
		if(list != null && list.size()>0){
			licenseInfoMap = list.get(0);
			//赋值
			String licid = licenseInfoMap.get("LICID") == null ? "" : licenseInfoMap.get("LICID").toString();
			String mugs = licenseInfoMap.get("GSMC") == null ? "" : licenseInfoMap.get("GSMC").toString();
			
			/*** 查询业务种类 **/
			String serverCodeInfo = "select * from DXXZSP_CNKI_APPWEBSITE where licid = '"+ licid + "' and type='WZ' and (yewubh='A12' or yewubh='K12') and version='1'";
			
			//List<Map<String, Object>> A12serverInfo = Access.getMultiMap(serverCodeInfo,null);
			List<Map<String, Object>> A12serverInfo = commonMapper.findManyData(serverCodeInfo);
			/*** 查询业务种类 **/
			String appCodeInfo = "select * from DXXZSP_CNKI_APPWEBSITE where licid = '"+ licid + "' and type='APP' and (yewubh='A12' or yewubh='K12') and version='1'";
			
			//List<Map<String, Object>> A12appInfo = Access.getMultiMap(appCodeInfo,null);  
			List<Map<String, Object>> A12appInfo = commonMapper.findManyData(appCodeInfo);
			
			Map<String,Object> map =new HashMap<String, Object>();
			map.put("mugs", mugs);
			map.put("A12servers", A12serverInfo);
			map.put("A12apps", A12appInfo);
			if((A12serverInfo!=null &&A12serverInfo.size()!=0)||(A12appInfo!=null&&A12appInfo.size()!=0)){
				map.put("A12", "true");
			}else{
				map.put("A12", "false");
			}
			
			String querylicenseInfoA08 = "select * from WETRIL_CNKI_LICENSE where num = '"+ num + "' and version='1' and flag='1'";
			//Map<String, Object> licenseInfoMapA08 = Access.getSingleMap(querylicenseInfoA08, null);
			List<Map<String, Object>> list1 = commonMapper.findManyData(querylicenseInfoA08);
			Map<String, Object> licenseInfoMapA08 = null;
			if(list1 != null && list1.size()>0){
				licenseInfoMapA08 = list1.get(0);

				// id
				String idA08 = licenseInfoMapA08.get("LICID") == null ? "" : licenseInfoMap.get("LICID").toString();
				
				/*** 查询业务种类 **/
				String serverCodeInfoA08 = "select * from DXXZSP_CNKI_APPWEBSITE where licid = '"+ idA08 + "' and type='WZ' and (yewubh='A08' or yewubh='K08') and version='1'";
				
				//List<Map<String, Object>> A08serverInfo = Access.getMultiMap(serverCodeInfoA08,null);
				List<Map<String, Object>> A08serverInfo = commonMapper.findManyData(serverCodeInfoA08);
				
				/*** 查询业务种类 **/
				String appCodeInfoA08 = "select * from DXXZSP_CNKI_APPWEBSITE where licid = '"
						+ licid + "' and type='APP' and (yewubh='A08' or yewubh='K08') and version='1'";
				
				//List<Map<String, Object>> A08appInfo = Access.getMultiMap(appCodeInfoA08,null);
				List<Map<String, Object>> A08appInfo = commonMapper.findManyData(appCodeInfoA08);
				
				map.put("A08servers", A08serverInfo);
				map.put("A08apps", A08appInfo);
				boolean reuslt=(A08serverInfo!=null &&A08serverInfo.size()!=0)||(A08appInfo!=null&&A08appInfo.size()!=0);
				if(reuslt){
					map.put("A08", "true");
				}else{
					map.put("A08", "false");
				}
				String infos =JSONObject.fromObject(map).toString();
				
				return infos;
			}
			
			return null;
		}
		
		return null;
		
	}
	
	
	public String changLicenseinfo(String num){
		String sql ="update WETRIL_CNKI_LICENSE set APPOINT_STATUS= '3' where num = '"+num+"' ";
		
		//Access.executeUpdate(sql,  Arrays.asList(num));
		commonMapper.updateSQL(sql);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "ok");
		String result =JSONObject.fromObject(map).toString();
		return result;
	}
	/**
	 * 查询许可证相关信息
	 * 
	 * @param num
	 *            许可证编号查询
	 * @return
	 */
	@Override
	public Map<String, Object> queryLiLicenseInfo(String num) {
		
		/** 查询许可证的相关信息 **/
		String querylicenseInfo = "select * from WETRIL_CNKI_LICENSE where num = '"+ num + "' and version='1' and  flag='1'";
		//Map<String, Object> licenseInfoMap = Access.getSingleMap(querylicenseInfo, null);
		List<Map<String, Object>> list = commonMapper.findManyData(querylicenseInfo);
		Map<String, Object> licenseInfoMap = null;
		if(list != null && list.size()>0){
			licenseInfoMap = list.get(0);
		}
		if(null==licenseInfoMap){
		    return null;
		}
		return queryLiLicenseInfogg(licenseInfoMap);
	}	
	
	
	//查询许可证相关信息公共方法
		public Map<String, Object> queryLiLicenseInfogg(Map<String, Object> licenseInfoMap){	
			
			String num= licenseInfoMap.get("NUM").toString();
			Map<String, Object> returnMap = new HashMap<String, Object>();
			// id
			String licid = licenseInfoMap.get("LICID") == null ? "" : licenseInfoMap.get("LICID").toString();
			returnMap.put("liscenseid", licid);
			returnMap.put("num", num);
			// 人员id
			String entid = licenseInfoMap.get("ENTID") == null ? "": licenseInfoMap.get("ENTID").toString();
			returnMap.put("entid", entid);
			String gsmc = licenseInfoMap.get("GSMC") == null ? "": licenseInfoMap.get("GSMC").toString();
			returnMap.put("gsmc", gsmc);
			//getLicInfo(returnMap, num);
			getLicInfogg(returnMap,licenseInfoMap);
			/*** 查询业务种类 **/
			
			getYewuinfo(returnMap, licid);//

			/** 查询公司相关信息 ***/
			getEntInfo(returnMap, entid);
			//授权子公司
			getSqzgsinfo(returnMap, num);
			/*** 查询股权结构 **/
			String queryGqjg = "select * from WETRIL_CNKI_ENTHOLDERS n where n.entid='"+ entid + "' and  n.version = '1'";

			
			List<Map<String, Object>> gqjgList = commonMapper.findManyData(queryGqjg);//Access.getMultiMap(queryGqjg, null);
			
			returnMap.put("gqjgList", gqjgList);
			//网站信息
			//修改许可证信息中网站app显示过期信息的情况，添加select条件version='1'--jxq
			String websql = "select mc,ym,fzd,sddw from DXXZSP_CNKI_APPWEBSITE where licid= '"+licid+"' and version='1' ";
			List<Map<String, Object>> weblist = commonMapper.findManyData(websql);//Access.getMultiMap(websql, Arrays.asList(licid));
			returnMap.put("weblist", weblist);
			String blsql = "select to_char(enroldate) enroldate,name,enrolreason,to_char(removedate) removedate from CREDIT_UNHEALTHY_DISHONESTY_INFO where removestate = '1' and blsxtype = '0' and entid = '"+entid+"' ";
			String sxsql = "select to_char(enroldate) enroldate,name,enrolreason,to_char(removedate) removedate from CREDIT_UNHEALTHY_DISHONESTY_INFO where removestate = '1' and blsxtype = '1' and entid = '"+entid+"' ";
			List<Map<String, Object>> bllist= commonMapper.findManyData(blsql);//Access.getMultiMap(blsql, Arrays.asList(entid));
			List<Map<String, Object>> sxlist= commonMapper.findManyData(sxsql);//Access.getMultiMap(sxsql, Arrays.asList(entid));
			Map<String, Object> map=new HashMap<String, Object>();
			returnMap.put("bllist", bllist);
			returnMap.put("sxlist", sxlist);
			
			String xkrwsql = "select b.workid ,a.licid,a.num,wm_concat(b.yewuname) yewuname,a.gsmc,b.created from WETRIL_CNKI_LICENSE A,WETRIL_CNKI_LICBUS B "
					+ "where a.licid=b.licid and a.version=1 and a.flag=1 and b.version='1' and a.licid= '"+licid+"' and b.workid is not null group by b.workid ,a.licid,a.num,a.gsmc,b.created";
			/*String xkrwsql = "select distinct b.* from  BXXZSP_YEWUKE_SJ_VIEW b left join WETRIL_CNKI_LICBUS a "
					+ "on b.workid=a.workid where a.licid=? ";*/
			List<Map<String, Object>> xkrw= commonMapper.findManyData(xkrwsql);//Access.getMultiMap(xkrwsql, Arrays.asList(licid));
			returnMap.put("xkrw", xkrw);
			
			/*String bgrwsql = "select b.workid ,a.licid,a.num,wm_concat(b.yewuname) yewuname,a.gsmc,b.created from WETRIL_CNKI_LICENSE A,WETRIL_CNKI_LICBUS B "
					+ "where a.licid=b.licid and a.version=1 and a.flag=1 and b.version='1' and a.licid=? and "
					+ "((b.yewucode like 'S%' and b.yewucode != 'S00') or (b.yewucode like 'B%' and b.yewucode !='B00')) group by b.workid ,a.licid,a.num,a.gsmc,b.created";
			List<Map> bgrw = Access.getMultiMap(bgrwsql, Arrays.asList(licid));*/
			String bgrwsql = "select workid,rname, wm_concat(sjyw) as yewuname,  (select max(actiontime) from tw_hz_log where workid=dxxzsp_yewujilu_user.workid "
					+ "and (select  ','||audited||',' from flowdata_node where flowdata_node.flowid=tw_hz_log.flowid) like '%,'||nodeid||',%' )  as created  "
					+ "from dxxzsp_yewujilu_user where workid in ( select workid from dxxzsp_yewujilu_user where dataid in ( "
					+ "select id from change_public_forms where title in (select num from WETRIL_CNKI_LICENSE where licid= '"+licid+"' ) "
					+ ") and workid is not null and status='F10')  "
					+ "and yewucode not like '%YD' and (yewucode like 'B__' or yewucode like 'S__') and yewucode not in ('B00','S00') group by workid,rname ";
			List<Map<String, Object>> bgrw = commonMapper.findManyData(bgrwsql);//Access.getMultiMap(bgrwsql, Arrays.asList(licid));
			returnMap.put("bgrw", bgrw);
			
			String nbsql = "select rpt_status,rpt_year from report_y where ent_id = '"+entid+"' and  lic_num = '"+num+"' ";
			List<Map<String, Object>> nblist= commonMapper.findManyData(nbsql);//Access.getMultiMap(nbsql, Arrays.asList(entid,num));
			returnMap.put("nblist", nblist);
			//gyh -- start
			String otherLinkMan = "SELECT * FROM WETRIL_CNKL_ENTLINKMAN WHERE CREATOR IN (SELECT ID FROM TO_HORIZON_USER WHERE LOGIN_NAME IN (SELECT ACCOUNT FROM WETRIL_CNKI_ENTBASE WHERE ENTID = '"+entid+"' AND VERSION = '1') AND LOGIN_NAME IS NOT NULL) ORDER BY LXTYPE DESC";
			List<Map<String, Object>> otlist= commonMapper.findManyData(otherLinkMan);//Access.getMultiMap(otherLinkMan, Arrays.asList(entid));
			returnMap.put("otlist", otlist);
			//gyh -- end
			return returnMap;
		}
	
		
		public void getLicInfogg(Map<String, Object> returnMap,Map<String, Object> licenseInfo){
			String licpkid =licenseInfo.get("LICPKID").toString();
			String querylicenseInfo = "select * from WETRIL_CNKI_LICENSE where licpkid = '"+ licpkid + "'";

			List<Map<String, Object>> list = commonMapper.findManyData(querylicenseInfo);
			Map<String, Object> licenseInfoMap = null;
			if(list != null && list.size()>0){
				licenseInfoMap = list.get(0);
			}
			//Map<String, Object> licenseInfoMap = commonMapper.findManyData(querylicenseInfo);//Access.getSingleMap(querylicenseInfo, null);
			// id
			String licid = licenseInfoMap.get("LICID") == null ? "" : licenseInfoMap.get("LICID").toString();
			returnMap.put("liscenseid", licid);
			// 人员id
			String entid = licenseInfoMap.get("ENTID") == null ? "": licenseInfoMap.get("ENTID").toString();
			// 公司名称
			String corpName = licenseInfoMap.get("GSMC") == null ? "": licenseInfoMap.get("GSMC").toString();
			returnMap.put("corpName", corpName);
			// 许可证状态
			String licenseStatus = licenseInfoMap.get("FLAG").equals("1") ? "正常": "无效";
			returnMap.put("licenseStatus", licenseStatus);
			// 公司法人
			String corpRepresent = licenseInfoMap.get("FRDB") == null ? ""	: licenseInfoMap.get("FRDB").toString();
			returnMap.put("corpRepresent", corpRepresent);
			// 注册资本
			// 注册住所
			// 发证日期
			String regdate = licenseInfoMap.get("REGDATE") == null ? "": licenseInfoMap.get("REGDATE").toString().substring(0, 10);
			returnMap.put("regdate", regdate);
			// 有效期至
			String validity = licenseInfoMap.get("VALIDITY") == null ? ""	: licenseInfoMap.get("VALIDITY").toString().substring(0, 10);
			returnMap.put("validity", validity);
			// 是否通知领证
			if(licenseInfoMap.get("ISNOTICE") != null && licenseInfoMap.get("ISNOTICE").equals("1")){
				returnMap.put("isnotice", "是");
			}else{
				returnMap.put("isnotice", "否");
			}
			
			// 通知时间
			if(licenseInfoMap.get("NOTICEDATE") == null || licenseInfoMap.get("NOTICEDATE").equals("1-01-01 00:00:00")){
				returnMap.put("noticedate", "");
			}else{
				returnMap.put("noticedate", licenseInfoMap.get("NOTICEDATE").toString());
			}
			
			// 只有预核准通知书
			// 是否已领证
			//String islicensing = licenseInfoMap.get("islicensing").equals("1") ? "是": "否";
			if(licenseInfoMap.get("ISLICENSING") != null && licenseInfoMap.get("ISLICENSING").equals("1")){
				returnMap.put("islicensing", "是");
			}else{
				returnMap.put("islicensing", "否");
			}
			//returnMap.put("islicensing", islicensing);
			// 领证时间
			//String licensingdate = licenseInfoMap.get("licensingdate") == null ?  ""	: licenseInfoMap.get("licensingdate").toString();
			if(licenseInfoMap.get("LICENSINGDATE") == null || licenseInfoMap.get("LICENSINGDATE").equals("1-01-01 00:00:00")){
				returnMap.put("licensingdate", "");
			}else{
				returnMap.put("licensingdate", licenseInfoMap.get("LICENSINGDATE").toString());
			}
			// 领证人
			String licensingpersonname = licenseInfoMap.get("LICENSINGPERSONNAME") == null ? "": licenseInfoMap.get("LICENSINGPERSONNAME").toString();
			returnMap.put("licensingpersonname", licensingpersonname);
			// 领证人证件号
			String licensingpersoncode = licenseInfoMap.get("LICENSINGPERSONCODE") == null ? ""	: licenseInfoMap.get("LICENSINGPERSONCODE").toString();
			returnMap.put("licensingpersoncode", licensingpersoncode);
			// 领证人联系方式
			String licensingmobile = licenseInfoMap.get("LICENSINGMOBILE") == null ? "" : licenseInfoMap.get("LICENSINGMOBILE").toString();
			returnMap.put("licensingmobile", licensingmobile);
			// 材料是否齐备
			String datacomplete = licenseInfoMap.get("DATECOMPLETE") == null ? "" : licenseInfoMap.get("DATECOMPLETE").toString();
			if(datacomplete.equals("0")){
				datacomplete="是";
			}else if(datacomplete.equals("1")){
				datacomplete="否";
			}
			returnMap.put("datacomplete", datacomplete);
			// 是否需要扫描件
		//	String needfile = licenseInfoMap.get("needfile").equals("0")  ? "需要" : "不需要";
			if(licenseInfoMap.get("NEEDFILE") != null && licenseInfoMap.get("NEEDFILE").equals("0")){
				returnMap.put("needfile", "需要");
			}else{
				returnMap.put("needfile", "不需要");
			}
			// 扫描件
			// 备注
			String note = licenseInfoMap.get("NOTE") == null ? "" : licenseInfoMap.get("NOTE").toString();
			returnMap.put("note", note);
			String flag = licenseInfoMap.get("FLAG") == null ? "" : licenseInfoMap.get("FLAG").toString();
			returnMap.put("flag", flag);
			String cancelreason = licenseInfoMap.get("CANCELREASON") == null ? "" : licenseInfoMap.get("CANCELREASON").toString();
			returnMap.put("cancelreason", cancelreason);
		}
		
		
		/**
		 * @title: 许可证打印信息封装
		 * 互联网数据中心业务 K04 A04
		 * 互联网接入服务业务 K07 A07
		 * 在线数据处理与交易处理业务 K08 A08
		 * 信息服务业务（不含互联网信息服务） A13 K13 不做修改
		 * 信息服务业务（仅限互联网信息服务） A12 K12 
		 * 将进入相关的服务以及服务子项目来生成相关数据
		 * 需要特殊处理的打印的业务
		 * @param returnMap
		 * @param id
		 */
		public void getYewuinfo(Map<String, Object> returnMap,String id){//my
			
			//System.out.println(id);
			
			//System.out.println("just _______ do  _________   it");
			//String queryCodeIntfo = "select  a.ID,a.yewucode,a.yewuname, wm_concat(distinct (c.name)) as ywfw from  WETRIL_CNKI_LICBUS a, WETRIL_CNKI_LICBUSAREA b , ( select id, name from DXXZSP_AREA union all  select '000000' as id, '全国' as name from dual ) c where a.licid  ='"	+ id + "'  and a.version='1' and b.version='1' and b.LICID=a.licid and a.bussinessid=b.bussinessid and b.PROVICEID=c.id group by  a.ID,a.yewucode,a.yewuname";
			String queryCodeInfo ="   select ID,YEWUCODE,YEWUNAME,YWFW,replace(substr(yewucode,2),'15','00') cc from WETRIL_CNKI_LICBUS where licid = '"	+ id + "' and version='1' and yewuname is not null  order by yewulbbh asc,cc asc    ";
			List<Map<String, Object>> codeList = commonMapper.findManyData(queryCodeInfo);//Access.getMultiMap(queryCodeInfo,null); 
			List codelist2 = new ArrayList();
			DiQuUtil diquUtil =new DiQuUtil();
			// 多个业务
			for (Map code : codeList) {
				String codeid = code.get("YEWUCODE").toString();
				String yewuname = code.get("YEWUNAME") + "";
				//System.out.println("业务代码："+codeid+"业务种类名称："+yewuname+"业务范围："+code.get("ywfw"));
				String diqus =StringUtil.isAllProvince(StringUtil.deleteChar(code.get("YWFW")+""));
				//20190810 业务范围中不包含省、市，自治区等   
				code.put("ywfw",diqus.replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
				
				boolean issempt =false;
				List<Map<String, Object>> fuwuinfozs = new ArrayList<Map<String, Object>>();
				if (codeid.equals("K04") || codeid.equals("A04") || codeid.equals("K07") || codeid.equals("A07")) {
					//System.out.println(id+","+codeid);
					String sqlfuwustr = "select SERVERNAME,YEUWCODE,FANWEI from WETRIL_CNKI_FUWU where licid ='"
							+ id + "' and yewucode='"+codeid+"'";
					
					List<Map<String, Object>> fuwuinfos = commonMapper.findManyData(sqlfuwustr);//Access.getMultiMap(sqlfuwustr, null);
					
					// code.put("sijinjie","true");
					if (fuwuinfos == null||fuwuinfos.isEmpty()) {
						issempt=true;
						code.put("sijinjie", "false");
						codelist2.add(code);
						continue;
					}
					if (fuwuinfos.size() == 1) {
						Map<String, Object> map = fuwuinfos.get(0);
						String servername = yewuname + "(" + map.get("SERVERNAME") + ")";
						if(codeid.equals("K07") || codeid.equals("A07")){
//							if(servername.indexOf("为互联网平台提供接入服务")>0){
//								servername = servername.replace("仅为互联网平台提供接入服务", "仅限为上网用户提供接入服务");
//								
//							}else{
//								servername  = servername.replace("为上网用户提供接入服务", "`为上网用户提供接入服务");
//							}
						}
						map.put("servername", servername);
						//System.out.println("业务名称："+map.get("servername")+",数据大小："+fuwuinfos.size());
						
						//System.out.println("测试K07+A07-------------"+map.put("servername", servername));
						
						String diqus2 =StringUtil.deleteChar(map.get("FANWEI")+"");
						map.put("fanwei",
								(StringUtil.isAllProvince(diqus2)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
						fuwuinfozs.add(map);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}else if (fuwuinfos.size() > 1) {// 因为只有两个
						Map<String, Object> map0 = fuwuinfos.get(0);
						String fanwei0 = StringUtil.deleteChar(map0.get("FANWEI") + "");
						Map<String, Object> map1 = fuwuinfos.get(1);
						String fanwei1 = StringUtil.deleteChar(map1.get("FANWEI") + "");
						String fanweizong = fanwei0 +","+ fanwei1;
						String[] fanweizongs = fanweizong.split(",");
						String[] fanwei0d = fanwei0.split(",");
						String[] fanwei1d = fanwei1.split(",");
						List result = RiCHangUtil.stringZU2QuChong(fanweizong, 0,",");
						int count = result.size();
						int count0 = fanwei0d.length;
						int count1 = fanwei1d.length; 
						// 当地区一样的时候
						if (count == count0 &&count==count1) {
							//String diqus2 =diquUtil.getAreaByorder(map0.get("fanwei")+"");
							if(!"".equals(fanwei0)&&fanwei0!=null){
								map0.put("servername", yewuname);
								//System.out.println("测试互联网连接服务"+map0.put("servername", yewuname));
								map0.put("fanwei",
										(StringUtil.isAllProvince(fanwei0)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
								fuwuinfozs.add(map0);
								//System.out.println("测试互联网接入服务：-------"+fuwuinfozs.add(map0));
								code.put("sijinjie", "true");
								code.put("fuwulist", fuwuinfozs);
								codelist2.add(code);
							}
							
							//不同的diq	
						} else {
							//20190809修改 mhl
							StringBuffer fanwei00 = new StringBuffer();
							String fanwei01="";
							String fanwei02="";
							int xtcd = 0;
							//相同的数据提取出来，单独罗列，不同的单独区分  需要判断fw1和fw2只有一个地区的情况
							for(String fw1 :fanwei0d){
								for(String fw2 :fanwei1d){
									if(fw1.trim().equals(fw2.trim())){
										fanwei00.append(fw1.trim()+",");
										fanwei0 = fanwei0.replaceAll(fw2+",", "").replaceAll(fw2, "");
										fanwei1 = fanwei1.replaceAll(fw2+",", "").replaceAll(fw2, "");
										xtcd++;
									}
								}
							}
							//存在相同的范围 
							if(xtcd>0){
								//截取拼接范围字符串最后一个，
								String fanwei000 = StringUtil.deleteChar(fanwei00.toString());
								Map<String, Object> map00 =  new HashMap<String,Object>();
								map00.put("servername",yewuname);
								String diqus10 =fanwei000;
								map00.put("fanwei",
										(StringUtil.isAllProvince(diqus10)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
								fuwuinfozs.add(map00);
								String diqus2 =StringUtil.deleteChar(fanwei0+"");
								fanwei0 = StringUtil.deleteChar(fanwei0);
								if(!"".equals(fanwei0)&&fanwei0!=null){
									String servername = map0.get("SERVERNAME")+"";
									
									if("互联网资源协作服务".equals(servername)) servername = "仅限"+servername;
									map0.put("servername",
											yewuname + "(" + servername.replace("服务", "") + "服务)");
									//System.out.println("业务名称："+yewuname+map0.get("servername")+"fanwei2:"+diqus2);
									map0.put("fanwei",
											(StringUtil.isAllProvince(fanwei0)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
									fuwuinfozs.add(map0);
								}
								
								  /* if(codeid.equals("K07") || codeid.equals("A07")){
									   
								   }*/
								fanwei1 = StringUtil.deleteChar(fanwei1); 
								if(!"".equals(fanwei1)&&fanwei1!=null){
									String servername = map1.get("SERVERNAME")+"";
									if("互联网资源协作服务".equals(servername)) servername = "仅限"+servername;
									map1.put("servername",
											yewuname + "(" + servername.replace("服务", "") + "服务)");
									map1.put("fanwei",
											(StringUtil.isAllProvince(fanwei1)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
									fuwuinfozs.add(map1);
								}
								code.put("fuwulist", fuwuinfozs);
								code.put("sijinjie", "true");
								codelist2.add(code);
								
							}else{//不存在相同的范围
								String servername = map0.get("SERVERNAME")+"";
								if("互联网资源协作服务".equals(servername)) servername = "仅限"+servername;
								
								//replace()后修改半个")"    后面replace后也去掉了半个)
								
								map0.put("servername",
										yewuname +"("+ (map0.get("SERVERNAME")+"").replace("服务", "") + "服务)");
								String diqus2 =diquUtil.getAreaByorder(map0.get("FANWEI")+"");
								map0.put("fanwei",
										(StringUtil.isAllProvince(diqus2)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
								fuwuinfozs.add(map0);
								
								servername = map1.get("SERVERNAME")+"";
								if("互联网资源协作服务".equals(servername)) servername = "(仅"+servername+")";
								
								
								map1.put("servername",
										yewuname + "(仅" + servername.replace("服务", "") + "服务)");
								String diqus3 =diquUtil.getAreaByorder(map1.get("FANWEI")+"");
								map1.put("fanwei",
										(StringUtil.isAllProvince(diqus3)).replaceAll(",", "、").replaceAll("市", "").replaceAll("省", "").replaceAll("自治区", "").replaceAll("壮族", "").replaceAll("回族", "").replaceAll("维吾尔", ""));
								fuwuinfozs.add(map1);
								code.put("fuwulist", fuwuinfozs);
								code.put("sijinjie", "true");
								codelist2.add(code);
							}
						}
					}
				}else if (codeid.equals("A08") || codeid.equals("K08")) {
					String sqlfuwustr = "select servername,yewucode,fanwei from WETRIL_CNKI_FUWU where licid ='"
							+ id + "' and yewucode='"+codeid+"'";
					List<Map<String, Object>> fuwuinfos = commonMapper.findManyData(sqlfuwustr);//Access.getMultiMap(sqlfuwustr, null);
					// code.put("sijinjie","true");
					if (fuwuinfos == null||fuwuinfos.isEmpty()) {
						issempt=true;
						code.put("sijinjie", "false");
						codelist2.add(code);
						
						continue;
					}

					int sizes = fuwuinfos.size();
					//System.out.println("结果大小："+sizes);

					String fuwuname = "";
					for (int i = 0; i < sizes; i++) {
						Map<String, Object> map = fuwuinfos.get(i);
						fuwuname = fuwuname + "," + map.get("SERVERNAME");
					}
					if (sizes == 2 && fuwuname.contains("交易处理业务")
							&& fuwuname.contains("含网络借贷信息中介类的互联网金融业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务（仅限经营类电子商务）");
						map1.put("fanwei",
								"含网络借贷信息中介类的互联网金融业务。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);

					}

					if (sizes == 2 && !fuwuname.contains("交易处理业务")
							&& !fuwuname.contains("含网络借贷信息中介类的互联网金融业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务");
						map1.put("fanwei", "在线数据处理与交易处理业务（不含经营类电子商务）");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}

					if (sizes == 2 && fuwuname.contains("交易处理业务")
							&& !fuwuname.contains("含网络借贷信息中介类的互联网金融业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务（仅限经营类电子商务）");
						map1.put("fanwei",
								"不含网络借贷信息中介类的互联网金融业务。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}

					if (sizes == 3 && fuwuname.contains("交易处理业务")
							&& !fuwuname.contains("含网络借贷信息中介类的互联网金融业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务（仅限经营类电子商务）");
						map1.put("fanwei",
								"不含网络借贷信息中介类的互联网金融业务。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);

					}

					if (sizes == 4 && fuwuname.contains("交易处理业务")
							&& fuwuname.contains("含网络借贷信息中介类的互联网金融业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务（仅限经营类电子商务）");
						map1.put("fanwei",
								"含网络借贷信息中介类的互联网金融业务。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}
					if (sizes == 1 && fuwuname.contains("交易处理业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务（仅限经营类电子商务）");
						map1.put("fanwei",
								"不含网络借贷信息中介类的互联网金融业务。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}
					//System.out.println("结果大小："+sizes);
					if (sizes == 1 && !fuwuname.contains("交易处理业务")) {
						Map<String, Object> map1 = fuwuinfos.get(0);
						map1.put("servername", "在线数据处理与交易处理业务");
						map1.put("fanwei",
								"在线数据处理与交易处理业务（不含经营类电子商务）");
						fuwuinfozs.add(map1);
						code.put("fuwulist", fuwuinfozs);
						code.put("sijinjie", "true");
						codelist2.add(code);
					}

				}else if (codeid.equals("A12") || codeid.equals("K12")){
					
					String sqlfuwustr = "select servername,yewucode,fanwei from WETRIL_CNKI_FUWU where licid ='"
							+ id + "' and yewucode='"+codeid+"'";
					List<Map<String, Object>> fuwuinfos = commonMapper.findManyData(sqlfuwustr);//Access.getMultiMap(sqlfuwustr, null);
					// code.put("sijinjie","true");
					if (fuwuinfos == null||fuwuinfos.isEmpty()) {
						issempt=true;
						code.put("sijinjie", "false");
						codelist2.add(code);
						continue;
					}
					int sizes = fuwuinfos.size();
					String fuwuname = "";
					String yewumings ="";
					String yewumuban=CommonConstant.A12zheng;
					String yewubuxuan=CommonConstant.A12fan;
					for (int i = 0; i < sizes; i++) {

						Map<String, Object> map = fuwuinfos.get(i);
						String yewuming = map.get("SERVERNAME")+"";
					
						if(yewumuban.contains(yewuming)){
							yewumings=yewumings+"/"+yewuming;
						}
						yewubuxuan =yewubuxuan.replace(yewuming+"、", "");
						
						
					}
					yewubuxuan =yewubuxuan.substring(1,yewubuxuan.length()-1);
				    String[] yewubuxuans =yewubuxuan.split("、");
				    String yewubuxuanw ="";
				    //yewumings="含"+ yewumings.substring(1)+"。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】";
				    if(yewubuxuan.trim().length()==0){
				    	if (StringUtils.isBlank(yewumings)){
				    		
				    		yewumings="【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】";//有问题！！！
				    	}else{
				    		yewumings="含"+ yewumings.substring(1)+"。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】";
				    	}
				    	
				    }else{
				    	
				    	for (int i = 0; i < yewubuxuans.length; i++) {
				    		if(i==yewubuxuans.length-1){
				    			yewubuxuanw =yewubuxuanw+yewubuxuans[i];
				    		}else if(i==yewubuxuans.length-2){
				    			yewubuxuanw =yewubuxuanw+yewubuxuans[i]+"和";
				    		}else{
				    			yewubuxuanw =yewubuxuanw+yewubuxuans[i]+"、";
				    		}
				    		
						}
				    	if (StringUtils.isBlank(yewumings)){
				    		yewumings="不含"+yewubuxuanw+"。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】";
				    	}else{  
				    		yewumings="含"+ yewumings.substring(1).replace("/", "、")+",不含"+yewubuxuanw+"。【依法须经批准的项目，经相关部门批准后方可开展相应经营活动】";
				    	}
				    	
				    }
					
					Map<String, Object> map1 = fuwuinfos.get(0);
					map1.put("servername", "信息服务业务（仅限互联网信息服务）");
					map1.put("fanwei",
							yewumings);
					//当未外资企业，当子业务中只有应用商店或变更仅限应用商店
					String entid =returnMap.get("ENTID")+"";
					String dwl="select czbl from WETRIL_CNKI_WSTRANSFER where entid='"+entid+"'";
					List<Map<String, Object>> mss_list = commonMapper.findManyData(dwl);
					Map mss = null;
					if(mss_list != null && mss_list.size()>0){
						mss = mss_list.get(0);
					}
					
					//Map mss =Access.getSingleMap(dwl, null);
	                float bili =0;
					if(mss !=null ){
						String czbl =mss.get("CZBL")+"";
						String[] czbls =czbl.split(";");
						String czbls22="";
						for(int c =0;c<czbls.length;c++){						
							String cc = czbls[c].replace("%", "").trim();	
							czbls22=cc.substring(2);
						}										
						//String czbls22 = czbls[2].replace("%", "").trim();
						bili=Float.parseFloat(czbls22);
					}
					if(bili>=50){
						//获取相关业务
						String sqlzifuwu ="select fwname,entid from WETRIL_CNKISD_ZIFUWU where licid='"+id+"' and fwname like '%应用商店%'";
						List<Map<String, Object>> mapzifus = commonMapper.findManyData(sqlzifuwu);//Access.getMultiMap(sqlzifuwu, null);
						//获取该单位的的外伤比例
						if(mapzifus.size()==1&&(mapzifus.get(0).get("WNAME")+"").contains("应用商店")){
							map1.put("servername", "信息服务业务（仅限互联网信息服务）");
							map1.put("fanwei","仅限应用商店");
						}
					}
					
					fuwuinfozs.add(map1);
					code.put("fuwulist", fuwuinfozs);
					code.put("sijinjie", "true");
					codelist2.add(code);
				
				}else if (codeid.equals("K05") || codeid.equals("A05")) {
					String fanwei = code.get("YWFW").toString();
					code.put("ywfw", StringUtil.isAllProvince(fanwei));
					code.put("fuwulist", fuwuinfozs);
					code.put("sijinjie", "false");
					codelist2.add(code);
				}else if(codeid.equals("K15") || codeid.equals("A15")){
					try{
						String sqljcwys = "select chinanet,chinamobile,chinaunion from DXXZSP_FWYDYW where id=(select b.dataid from WETRIL_CNKI_LICENSE a inner join dxxzsp_yewujilu_user b on a.gsmc=b.rname where a.licid='"+id+"' and a.flag='1' and a.version='1' and b.sjyw='通过转售方式提供的蜂窝移动通信业务')";
						List<Map<String, Object>> jcwysMap_list = commonMapper.findManyData(sqljcwys);
						Map jcwysMap = null;//Access.getSingleMap(sqljcwys, null);
						if(jcwysMap_list != null && jcwysMap_list.size()>0){
							jcwysMap = jcwysMap_list.get(0);
						}
						String chinanet    = jcwysMap.get("chinanet")==null?"":jcwysMap.get("chinanet").toString();
						String chinamobile = jcwysMap.get("chinamobile")==null?"":jcwysMap.get("chinamobile").toString();
						String chinaunion  = jcwysMap.get("chinaunion")==null?"":jcwysMap.get("chinaunion").toString();
						code.put("chinanet", chinanet);
						code.put("chinamobile", chinamobile);
						code.put("chinaunion", chinaunion);
						code.put("sijinjie", "false");
						codelist2.add(code);
					}catch(NullPointerException e){
						e.printStackTrace();
					}
				}
				else { 
					code.put("sijinjie", "false");
					code.put("fuwulist", fuwuinfozs);
					codelist2.add(code);

				}
			}
			//System.out.println("结果大小："+codelist2.size());
			returnMap.put("codelist", codelist2);
			returnMap.put("codelist2", codeList);

		}
		

		public void getEntInfo(Map<String, Object> returnMap,String entid){
			String queryCorpInfo = "select t.* from WETRIL_CNKI_ENTBASE t  where t.entid ='"
					+ entid + "' and version ='1'  ";
			List<Map<String, Object>> list = commonMapper.findManyData(queryCorpInfo);
			Map corpMap = null;//Access.getSingleMap(queryCorpInfo, null);
			if(list!=null && list.size()>0){
				corpMap = list.get(0);
			}
			// 企业法人营业执照注册号
			// 注册机关
			if (corpMap != null) {
				String regcapital = corpMap.get("REGCAPITAL") == null ? "" : corpMap.get("REGCAPITAL").toString();
				returnMap.put("regcapital", regcapital);
				String currencytype = corpMap.get("CURRENCYTYPE") == null ? "" : corpMap.get("CURRENCYTYPE").toString();
				returnMap.put("currencytype", currencytype);
				String regorgan = corpMap.get("REGORGAN") == null ? "" : corpMap.get("REGORGAN").toString();
				returnMap.put("regorgan", regorgan);
				String regcode = corpMap.get("REGCODE") == null ? "" : corpMap.get("REGCODE").toString();
				returnMap.put("regcode", regcode);
				// 成立日期
				//String founddate = corpMap.get("founddate") == null ? "" : corpMap.get("founddate").toString();
				if(corpMap.get("FOUNDDATE") == null || corpMap.get("FOUNDDATE").equals("1-01-01 00:00:00")){
					returnMap.put("founddate", "");
				}else{
					returnMap.put("founddate", corpMap.get("FOUNDDATE").toString());
				}
				//returnMap.put("founddate", founddate);
				// 有效期
				//String validitydate = corpMap.get("validitydate") == null ? "": corpMap.get("validitydate").toString();
				if(corpMap.get("VALIDITYDATE") == null || corpMap.get("VALIDITYDATE").equals("1-01-01 00:00:00")){
					returnMap.put("validitydate", "");
				}else{
					returnMap.put("validitydate", corpMap.get("VALIDITYDATE").toString());
				}
				// IARA ID
				// 英文全称
				// 法定代表人姓名
				String corporatename = corpMap.get("CORPORATENAME") == null ? "": corpMap.get("CORPORATENAME").toString();
				returnMap.put("corporatename", corporatename);
				// 法人身份证号
				String corporatecode = corpMap.get("CORPORATECODE") == null ? "": corpMap.get("CORPORATECODE").toString();
				returnMap.put("corporatecode", corporatecode);
				// 法定代表人手机
				String corporatemobile = corpMap.get("CORPORATEMOBILE") == null ? "": corpMap.get("CORPORATEMOBILE").toString();
				returnMap.put("corporatemobile", corporatemobile);
				// 法定代表人固话
				String corporatephone = corpMap.get("CORPORATEPHONE") == null ? "": corpMap.get("CORPORATEPHONE").toString();
				returnMap.put("corporatephone", corporatephone);
				// 法定代表人传真
				// 法人邮箱
				String corporatemail = corpMap.get("CORPORATEMAIL") == null ? "": corpMap.get("CORPORATEMAIL").toString();
				returnMap.put("corporatemail", corporatemail);
				// 地址
				String regaddress = corpMap.get("REGADDRESS") == null ? "": corpMap.get("REGADDRESS").toString();
				returnMap.put("regaddress", regaddress);
				// 邮编通信
				String postcode = corpMap.get("POSTCODE") == null ? "" : corpMap.get("POSTCODE").toString();
				returnMap.put("postcode", postcode);
				// 负责人姓名
				String chargename = corpMap.get("CHARGENAME") == null ? "": corpMap.get("CHARGENAME").toString();
				returnMap.put("chargename", chargename);
				// 负责人手机
				String chargemobile = corpMap.get("CHARGEMOBILE") == null ? "": corpMap.get("CHARGEMOBILE").toString();
				returnMap.put("chargemobile", chargemobile);
				// 负责人固话：
				String chargephone = corpMap.get("CHARGEPHONE") == null ? "": corpMap.get("CHARGEPHONE").toString();
				returnMap.put("chargephone", chargephone);
				// 负责人电子邮箱
				String chargeemail = corpMap.get("CHARGEEMAIL") == null ? "": corpMap.get("CHARGEEMAIL").toString();
				returnMap.put("chargeemail", chargeemail);
				// 联系人姓名
				String linkman = corpMap.get("LINKMAN") == null ? "" : corpMap.get("LINKMAN").toString();
				returnMap.put("linkman", linkman);
				// 联系人手机
				String linkmobile = corpMap.get("LINKMOBILE") == null ? ""	: corpMap.get("LINKMOBILE").toString();
				returnMap.put("linkmobile", linkmobile);
				// 联系人固话
				String linkphone = corpMap.get("LINKPHONE") == null ? "" : corpMap.get("LINKPHONE").toString();
				returnMap.put("linkphone", linkphone);
				// 联系人电子邮箱
				String linkemail = corpMap.get("LINKEMAIL") == null ? "" : corpMap.get("LINKEMAIL").toString();
				returnMap.put("linkemail", linkemail);
				// 企业性质
				String nature = corpMap.get("BQ") == null ? "" : corpMap.get("BQ").toString();
				if(nature.equals("1")){
					nature="国有控股";
				}else if (nature.equals("2")){
					nature="民营控股";
				}else if (nature.equals("3")){
					nature="外商投资";
				}
				returnMap.put("nature", nature);
				// 上市情况
				//String islisted = corpMap.get("islisted") == null ? "" : corpMap.get("islisted").toString();
				
				if(corpMap.get("ISLISTED") == null || corpMap.get("ISLISTED").equals("1")){
					returnMap.put("islisted", "未上市");
				}else{
					returnMap.put("islisted", "已上市");
				}
			} else {
				returnMap.put("regorgan", "");
				returnMap.put("founddate", "");
				returnMap.put("validitydate", "");
				returnMap.put("corporatename", "");
				returnMap.put("corporatecode", "");
				returnMap.put("corporatemobile", "");
				returnMap.put("corporatephone", "");
				returnMap.put("corporatemail", "");
				returnMap.put("regaddress", "");
				returnMap.put("postcode", "");
				returnMap.put("chargename", "");
				returnMap.put("chargemobile", "");
				returnMap.put("chargephone", "");
				returnMap.put("chargeemail", "");
				returnMap.put("linkman", "");
				returnMap.put("linkmobile", "");
				returnMap.put("linkphone", "");
				returnMap.put("linkemail", "");
				returnMap.put("nature", "");
				returnMap.put("islisted", "");
			}
		}
		

		public void getSqzgsinfo(Map<String, Object> returnMap,String num){
			String querylicenseInfo = "select * from WETRIL_CNKI_LICENSE where num = '"+ num + "'";
			List<Map<String, Object>> list = commonMapper.findManyData(querylicenseInfo);
			Map<String, Object> licenseInfoMap = null;//Access.getSingleMap(querylicenseInfo, null);
			if(list != null && list.size()>0){
				licenseInfoMap = list.get(0);
			}
			// id
			String licid = licenseInfoMap.get("LICID") == null ? "" : licenseInfoMap.get("LICID").toString();
			
			//通过证件id来查找相关的子公司
			String sqlstr ="select distinct a.frdb,a.ID, a.ppercent,a.subsidiary, a.registered_capital from dxxzsp_sqzgs a ,dxxzsp_sqzgs_yw b where b.licid='"+licid+"' and a.id=b.zgsid";
		
			List<Map<String, Object>> subInfos= commonMapper.findManyData(sqlstr);//Access.getMultiMap(sqlstr, null);
			if(subInfos==null){
				return;
			}
			List<Map> newsubInfos=new ArrayList<Map>();
			for (int i = 0; i < subInfos.size(); i++) {
				Map xunMap=subInfos.get(i);
				String sqlstro="select a.YEWUNAME,a.YWFW from dxxzsp_sqzgs_yw a where a.licid= '"+licid+"'  and a.zgsid='"+xunMap.get("ID")+"'";
				List<Map<String, Object>> subInfoso= commonMapper.findManyData(sqlstro);//Access.getMultiMap(sqlstro, null);
				if(subInfoso  ==null){
					continue;
				}
				//已公司为中心，收索业务和范围，一个循环代表一个业务
				String yewu = "";
				for (Map map : subInfoso) {//yewu +fanwei 
					String ywfw=map.get("YWFW")+"";
					ywfw =ywfw.replaceAll("市", "").replaceAll("省", "");
					String yewuname =map.get("YEWUNAME")+"";
					yewu+=yewuname+":"+ywfw+",";
				}
				xunMap.put("ziinfo",yewu);
				//重新填装数据
				newsubInfos.add(xunMap);
			}
			returnMap.put("zgsinfos", newsubInfos);
		}
		
		
		public String getZgsinfo(String num){
			
			String listcity ="select wm_concat(DISTINCT name)AS  NAME from dxxzsp_area order by id";
			List<Map<String, Object>> list1 = commonMapper.findManyData(listcity);
			Map<String, Object> citys =  null;
			if(list1 != null && list1.size()>0){
				citys = list1.get(0);
			}
			//Map citys= Access.getSingleMap(listcity, null);
			String citystr =citys+"";
			String[] citystrs=citystr.split(",");
			Map<String ,Integer>  mapcitys =new HashMap<String ,Integer>();
			for (int i = 0; i < citystrs.length; i++) {
				mapcitys.put(citystrs[i], i);
			}
			
			String citysstr =citys.get("NAME")+"";
			
			
			
			String querylicenseInfo = "select * from WETRIL_CNKI_LICENSE where num = '"
					        + num + "' and version='1' and flag='1'";
			//Map<String, Object> licenseInfoMap = Access.getSingleMap(querylicenseInfo, null);
			List<Map<String, Object>> list = commonMapper.findManyData(querylicenseInfo);
			Map<String, Object> licenseInfoMap = null;
			if(list != null && list.size()>0){
				licenseInfoMap = list.get(0);
				// id
				String id = licenseInfoMap.get("LICID") == null ? "" : licenseInfoMap.get(
						"LICID").toString();
				String mugs = licenseInfoMap.get("GSMC") == null ? "" : licenseInfoMap.get(
						"GSMC").toString();
				
				//通过证件id来查找相关的子公司
				String sqlstr ="select distinct a.frdb,a.ID, a.ppercent,a.subsidiary, a.registered_capital from dxxzsp_sqzgs a ,dxxzsp_sqzgs_yw b where b.licid='"+id+"' and a.id=b.zgsid";
			
				//List<Map> subInfos= Access.getMultiMap(sqlstr, null);
				List<Map<String, Object>> subInfos = commonMapper.findManyData(sqlstr);
				if(subInfos==null){
					return null;
				}
				
				List<Map> newsubInfos=new ArrayList<Map>();
				ArrayList<Map> yewuinfo =new ArrayList<Map>();
				//通过第一轮的sql 获取一公司为中心的数据，不涉及具体业务，保证城市不重复，以进行下一轮，一城市为中心搜索业务和范围，此一个循环代表一个城市
				for (int i = 0; i < subInfos.size(); i++) {
					Map xunMap = subInfos.get(i);
					Map<String,String> mapcity =new HashMap<String, String>();
					String sqlstro="select a.YEWUNAME,a.YWFW from dxxzsp_sqzgs_yw a where a.licid= '"+id+"'  and a.zgsid='"+xunMap.get("ID")+"'";
					//List<Map> subInfoso= Access.getMultiMap(sqlstro, null);
					List<Map<String, Object>> subInfoso = commonMapper.findManyData(sqlstro);
					
					if(subInfoso  ==null){
						return null;
					}
					//已公司为中心，收索业务和范围，一个循环代表一个业务
					for (Map map : subInfoso) {//yewu +fanwei 
						String ywfw=map.get("YWFW")+"";
						String yewuname =map.get("YEWUNAME")+"";
						String[] fwfws =ywfw.split(",");
						int[] cc =new int[fwfws.length];
						for (int j=0;j<fwfws.length;j++) {
							int indexitem =0;
							 Integer shu =mapcitys.get(fwfws[j].trim());
							   if(shu==null){
								  indexitem=0;
							   }else{
								 indexitem =mapcitys.get(fwfws[j].trim());
							   }
								cc[j]=indexitem;
							cc[j]=indexitem;
						}
						 Arrays.sort(cc);
						 String cityindex="";
						for (int ccitem : cc) {
								cityindex=cityindex+citystrs[ccitem]+",";
						}
						cityindex =cityindex.substring(0, cityindex.length()-1);
						//对相同范围的业务，使之合并成，形成行专列
					   mapcity.put(cityindex,(mapcity.get(cityindex)+","+yewuname).replaceAll("null", ""));
					   Set kSet = mapcity.keySet();
						Iterator it = kSet.iterator();
						//将行专列后，仍有多个数据时放入list
						List<Map> newsubInfosli=new ArrayList<Map>();
						
						while(it.hasNext()){
							HashMap<String, String> hashmap =new HashMap<String, String>();
							String key = (String) it.next();
							hashmap.put("zifw", key.replaceAll("\\{name=", ""));
							hashmap.put("ziyf", mapcity.get(key));
							newsubInfosli.add(hashmap);
						}
						//已公司为单位，添加器业务，这个业务已经是经过地区行转列过的业务
						xunMap.put("ziinfo",newsubInfosli);
						
					}
					//重新填装数据
					newsubInfos.add(xunMap);
				}
				Map haspMap =new HashMap<String, String>();
				haspMap.put("mugs", mugs);
				haspMap.put("infos", newsubInfos);
				String result =JSONObject.fromObject(haspMap).toString();
				return result;
				
			}
			return null;
			
		}
     
	
}
