package com.module.service.demo.imp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import cn.afterturn.easypoi.word.WordExportUtil;




import com.module.dao.base.CommonMapper;
import com.module.domain.base.Page;
import com.module.domain.base.WetrilCnkiLicenseInfo;
import com.util.AppException;
import com.util.PageUtil;
import com.util.StringUtils;
import com.module.service.demo.IDemoUserService;
import com.module.dao.demo.DemoUserMapper;
import com.module.dao.demo.WetrilCnkiLicenseMapper;
import com.module.domain.demo.DemoUser;
import com.mysql.jdbc.Clob;

@Service("demoUserService")
public class DemoUserServiceImpl implements IDemoUserService {
	
	Logger log=Logger.getLogger(DemoUserServiceImpl.class);
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DemoUserMapper demoUserMapper;
	
	@Resource
	private WetrilCnkiLicenseMapper wetrilCnkiLicenseMapper;
	
	//分页查询记录  进行维护
	@Override
    public List<Map<String,Object>> getAllRow(Page<DemoUser> page) throws AppException{
		/*
		//方法一  使用mybatis 分页
		try{
			return demoUserMapper.getAllDemoUser(page);
		}catch(Exception e){
    		throw new AppException("查询出错",e.toString());
    	}	
    	*/
		
		//方法二 直接写sql
		try{
			Map<String,Object> param = page.getParams();		
			String f_staffid = (String)param.get("f_staffid");
			String f_staffname = (String)param.get("f_staffname");
			String sql =" select rownum as rnum,uuid as \"uuid\", "+
						"		staffid as \"staffid\", "+
						"		staffname as \"staffname\", "+
						"		sex as \"sex\", "+
						"		email as \"email\", "+
						"		linktel as \"linktel\", "+
						"		birthday as \"birthday\", "+
						"		birthtime as \"birthtime\" "+
						"   from demo_user " +
						"  where 1 = 1 ";
			//用户ID
			if ( f_staffid != null && !f_staffid.equals("")){
				sql = sql + "and staffid like  '%"+f_staffid+"%'  ";
			}
			//用户名
			if ( f_staffname != null && !f_staffname.equals("")){
				sql = sql + "and staffname like '%"+f_staffname+"%' ";
			}
			
			// 必须先取得总行数 再查询当前页记录
		    Long totalRecord = commonMapper.findCount(PageUtil.getCountsql(sql));
		    page.setTotalRecord(totalRecord);
		    List<Map<String, Object>> list = commonMapper.findManyData(PageUtil.getPagesql(sql, page));
		    return list;
		}catch(Exception e){
    		throw new AppException("查询出错",e.toString());
    	}
    }
    
    //根据主键查询业务数据
    public Map<String,Object> getRow(String uuid) throws AppException{
    	try{
	    	String sql =" select rownum as rnum,uuid as \"uuid\", "+
						"		staffid as \"staffid\", "+
						"		staffname as \"staffname\", "+
						"		sex as \"sex\", "+
						"		email as \"email\", "+
						"		linktel as \"linktel\", "+
						"		birthday as \"birthday\", "+
						"		birthtime as \"birthtime\" "+
						"   from demo_user " +
						"  where uuid = '"+uuid+"' ";
	    	return commonMapper.findOneData(sql);
    	}catch(Exception e){
    		throw new AppException("根据主键查询业务数据出错",e.toString());
    	}
    }
    
    //记录新增
	@Override
    public Map<String,Object> insertRow(DemoUser demoUser) throws AppException{
    	Map<String,Object> map = new HashMap<String,Object>(); 
    	try{
			demoUser.setUuid(StringUtils.getUUID());//生成主键UUID
			demoUserMapper.insertSelective(demoUser);
			map.put("flag", "1");
	        map.put("msg", "新增成功");  
	        return map;  
    	}catch(Exception e){
    		throw new AppException("记录新增出错",e.toString());
    	}
    }
    
    //记录修改
	@Override
    public Map<String,Object> updateRow(DemoUser demoUser) throws AppException{
    	Map<String,Object> map = new HashMap<String,Object>();  
    	try{
			//demoUserMapper.updateByPrimaryKeySelective(demoUser);   		
	    	commonMapper.updateSQL(" update demo_user set staffname = 'abc' where 1staffid = '1' ");
			map.put("flag", "1");
	        map.put("msg", "修改成功");  
	        return map;  
    	}catch(Exception e){
    		throw new AppException("记录修改出错",e.toString());
    	}
    }
    
    //记录删除
	@Override
    public Map<String,Object> deleteRow(String uuid) throws AppException{
    	Map<String,Object> map = new HashMap<String,Object>(); 				
    	try{
    		//demoUserMapper.deleteByPrimaryKey(uuid);
    		commonMapper.updateSQL(" update demo_user set staffname = 'abc' where 1staffid = '1' ");
			map.put("flag", "1");
	        map.put("msg", "删除成功");  
	    	return map;  
    	}catch(Exception e){
    		throw new AppException("记录删除出错",e.toString());
    	}
    }

    //测试
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		IDemoUserService iDemoUserService = (IDemoUserService) ac.getBean("demoUserService");
		try {
			//删除浪程
			iDemoUserService.getRow("11");
			System.out.println("1");
		} catch (AppException e) {
			e.printStackTrace();
		}	    
	}
	
	//查询已办数据
	 @Override
	 public Map<String, Object> querySingDoneList()
	   throws AppException {
	  Map<String,Object> ret = new HashMap<String,Object>();
	  try{
		 /* String sql =" select a.item_id,a.company_name,a.business_type,a.lic_num,a.business_name,a.create_time from item_user_apply a   "+
			        "  where a.item_id in ("+itemid+") " ;*/
		  String sql="select id, ITEMID,PCBH,CREATED from DXXZSP_YEWU_QIANBAO_BJ where status=1";
		  
	      List<Map<String,Object>> singList=commonMapper.findManyData(sql);
	      ret.put("SingList", singList);
	      return ret;
	     }catch(Exception e){
	      throw new AppException("查询数据出错",e.toString());
	     }
	 }
	 
	//查询已办数据
		 @Override
		 public Map<String, Object> querysingDetailedList(String itemid)
		   throws AppException {
		  Map<String,Object> ret = new HashMap<String,Object>();
		  try{
			  
			  String sql1="select w.contact_tel,w.item_id,a.parentid,a.sqqy,a.qytjsj,a.num,a.rwlb,a.rwmc,a.workid from DXXZSP_YEWU_QIANBAO_BJDT a , item_user_apply w"+
					  		" where a.workid=w.item_id and a.workid in ("+itemid+") ";
			  String sql2="select w.contact_tel,w.item_id,a.parentid,a.sqqy,a.qytjsj,a.num,a.rwlb,a.rwmc,a.workid from DXXZSP_YEWU_QIANBAO_BGDT a , item_user_apply w"+
					  		" where a.workid=w.item_id and a.workid in ("+itemid+") ";
			  String bjdtCount="select count(*) from DXXZSP_YEWU_QIANBAO_BJDT a , item_user_apply w where a.workid=w.item_id and a.workid in ("+itemid+") ";
			  String bgdtCount="select count(*) from DXXZSP_YEWU_QIANBAO_BGDT a , item_user_apply w where a.workid=w.item_id and a.workid in ("+itemid+") ";
			  long bgdtNumber = commonMapper.findCount(bgdtCount);//变更企业数
			  long bjdtNumber = commonMapper.findCount(bjdtCount);//申请企业数
		      List<Map<String,Object>> singList=commonMapper.findManyData(sql1);
		      List<Map<String,Object>> singList1=commonMapper.findManyData(sql2);
		      ret.put("SingListzp", singList);//可申请
		      ret.put("SingListzp1", singList1);//可变更
		      ret.put("number", "变更企业的一共"+bgdtNumber+"家,   申请的企业一共"+bjdtNumber+"家");
		      return ret;
		     }catch(Exception e){
		      throw new AppException("查询数据出错",e.toString());
		     }
		 }
		 
	 
	//查询系统签报
	  @Override
	     public Map<String,Object> querySingList(String uuid) throws AppException{
	   Map<String,Object> ret = new HashMap<String,Object>();
	   try{
		   /*String sql =" select a.process_id, a.item_id,a.company_name,a.business_type,a.lic_num,a.business_name,a.create_time from item_user_apply a   "+
			        "  where a.process_id in ("+uuid+") " ;*/
		  String sql="select a.process_id, a.item_id,a.company_name,a.business_type,a.lic_num,a.business_name,a.create_time from item_user_apply a where a.item_id not in "+ 
						" (select a.item_id from item_user_apply a,DXXZSP_YEWU_QIANBAO_BJDT w where a.item_id=w.workid ) "+ 
						" and  a.process_id in ("+uuid+") ";
			       List<Map<String,Object>> singList=commonMapper.findManyData(sql);
			       ret.put("SingList", singList);
	       return ret;
	      }catch(Exception e){
	       throw new AppException("查询数据出错",e.toString());
	      }
	  }

	@Override
	public void saveData(String pcbh, String itemid,String qbnr) {
		
		String sql="update DXXZSP_YEWU_QIANBAO_BJ set pcbh='"+pcbh+"',des='"+qbnr+"'  where todoid like '"+itemid+"' ";
		commonMapper.updateSQL(sql);
		
	}

	@Override
	public Map<String, Object> querySingFourBrowse(String id) {
		
		String sql="select id,todoid,pcbh,des from DXXZSP_YEWU_QIANBAO_BJ where id='"+id+"'";
		Map<String, Object> findOneData = commonMapper.findOneData(sql);
		return findOneData;
	}

	@Override
	public void updatJZDataZp(String id, String jzyi, String jzqzsj) {
		String sql="update DXXZSP_YEWU_QIANBAO_BJ set jzyi='"+jzyi+"',jzqzsj='"+jzqzsj+"',status='2' where id='"+id+"'";
		commonMapper.insertSQL(sql);
		
	}

	@Override
	public List<Map<String, Object>> findByItemId(String itemid) {
		/*HashMap<String, Object> result = new HashMap<>();*/
		String sql="select item_id,process_id from item_user_apply where item_id in ("+itemid+")";
		List<Map<String, Object>> findManyData = commonMapper.findManyData(sql);
		/*result.put("sql1", findManyData);*/
		return findManyData;
	}

	@Override
	public Map downLicence(List<String> workidSQ,List<String> workidBG) {
		Map map=new HashMap();
		List<String> workidSQ1=new ArrayList<>();
		List<String> workidBG2=new ArrayList<>();
		//去空
		if(workidSQ!=null){
			for (String workid : workidSQ) {
				if(StringUtils.isNotBlank(workid)){
					workidSQ1.add(workid);
				}
			}
			if(workidSQ1!=null&&workidSQ1.size()>0){
				//去整理数据
				List<WetrilCnkiLicenseInfo> liceEntity=wetrilCnkiLicenseMapper.downLicence(workidSQ1);
				map.put("sq", liceEntity);
			}
		}
		if(workidBG!=null){
			for (String workid : workidBG) {
				if(StringUtils.isNotBlank(workid)){
					workidBG2.add(workid);
				}
			}
			if(workidBG2!=null && workidBG2.size()>0){
				//变更
				List<Map> liceEntity=wetrilCnkiLicenseMapper.downLicenceBg(workidBG2);
				map.put("bg",liceEntity);
			}
		}
		
		return map;
	}

	//整理申请模板
	@Override
	public XWPFDocument exportDoc(HttpServletRequest request,List<WetrilCnkiLicenseInfo> listInfoSq) throws Exception {
		Map maps=new HashMap();
		Map <String,String> companyNum=new HashMap<>();
		//整理数据，一个公司名字，对应多个业务。
		Map <String,List<WetrilCnkiLicenseInfo>> companyLicenseList=new HashMap<>();
		if(listInfoSq!=null && listInfoSq.size()>0){
			for (WetrilCnkiLicenseInfo wetrilLicenseInfo : listInfoSq){
				String name=wetrilLicenseInfo.getName();
				if(!companyLicenseList.containsKey(wetrilLicenseInfo.getName())){
					List list=new ArrayList();
					list.add(wetrilLicenseInfo);
					companyLicenseList.put(name, list);
					companyNum.put(name, wetrilLicenseInfo.getNum()==null?"":wetrilLicenseInfo.getNum());
				}else{
					List nameList=companyLicenseList.get(name);
					nameList.add(wetrilLicenseInfo);
					companyLicenseList.put(name,nameList);
				}
			}
		}
		Map  map = new HashMap(); 
		  //获取服务器绝对路径, 一般在项目下target路径 
	    String rootPath = request.getSession().getServletContext().getRealPath("/");
	    log.info("rootpath="+rootPath);
//	    System.err.println("rootpath="+rootPath);
//	    System.err.print("allpath:"+rootPath+"\\signreport\\ywqksq.docx");
		XWPFDocument doc = WordExportUtil.exportWord07(rootPath+"/signreport/ywqksq.docx", map);
		if(companyLicenseList!=null){
			int comnum=1;
			for (Map.Entry entry : companyLicenseList.entrySet()) {
				String compName=(String) entry.getKey();
				
				doc.createParagraph().createRun().setText(Integer.toString(comnum++)+"、"+compName+"("+companyNum.get(compName)+")");
	    		List<WetrilCnkiLicenseInfo> wetrilList=(List<WetrilCnkiLicenseInfo>) entry.getValue();
	    		if(wetrilList!=null && wetrilList.size()>0){
	    			int ywnum=1;
	    			//XWPFParagraph  xWPFParagraph1 =doc.createParagraph();
	    			for (WetrilCnkiLicenseInfo wetrilCnkiLicenseInfo : wetrilList) {
	    				if(wetrilCnkiLicenseInfo!=null){
	    					//判断业务，生成行
	    					String ywfw=wetrilCnkiLicenseInfo.getYwfw();
	    					String ycffw=wetrilCnkiLicenseInfo.getWcfFanwei();
	    					String strfw="";
	    				    if(StringUtils.isEmpty(ycffw)){
	    				    	strfw= (ywfw==null?"":ywfw);
	    				    }else{
	    				    	strfw=ycffw;
	    				    }
	    					doc.createParagraph().createRun().setText("("+Integer.toString(ywnum++)+")"+wetrilCnkiLicenseInfo.getYeWuName());
	    					if(StringUtils.trim(wetrilCnkiLicenseInfo.getYeWuName()).equals("通过转售方式提供的蜂窝移动通信业务")){
	    						doc.createParagraph().createRun().setText("合作运行商"+wetrilCnkiLicenseInfo.getChinaNet());
	    						doc.createParagraph().createRun().setText("业务覆盖范围："+strfw);

	    					}else  if(StringUtils.trim(wetrilCnkiLicenseInfo.getYeWuName()).equals("互联网数据中心业务")){
	    						doc.createParagraph().createRun().setText("服务项目："+wetrilCnkiLicenseInfo.getServerName());
	    						doc.createParagraph().createRun().setText("业务覆盖范围："+strfw);
	    					}else  if(StringUtils.trim(wetrilCnkiLicenseInfo.getYeWuName()).equals("互联网接入服务业务")){
	    						doc.createParagraph().createRun().setText("服务项目："+wetrilCnkiLicenseInfo.getServerName());
	    						doc.createParagraph().createRun().setText("业务覆盖范围："+strfw);
	    					}else{
	    						doc.createParagraph().createRun().setText("业务覆盖范围："+strfw);
	    					}
	    				}
	    			}
	    		}
               
			}
		}
		 return doc;
	}
	
	
//	整理变更模板
	@Override
	public XWPFDocument exportDocBg(HttpServletRequest request,List<Map> listInfoBg) throws java.lang.Exception {
		Map maps=new HashMap();
		Map <String,String> companyNum=new HashMap<>();
		//整理数据，一个公司名字，对应多个业务。
		Map <String,List<WetrilCnkiLicenseInfo>> companyLicenseList=new HashMap<>();
		if(listInfoBg!=null && listInfoBg.size()>0){
			for (Map wetrilLicenseInfo : listInfoBg){
				String name=(String) wetrilLicenseInfo.get("RNAME");
				if(!companyLicenseList.containsKey(name)){
					List list=new ArrayList();
					list.add(wetrilLicenseInfo);
					companyLicenseList.put(name, list);
					companyNum.put(name, wetrilLicenseInfo.get("TITLE")==null?"":(String)wetrilLicenseInfo.get("TITLE"));
				}else{
					List nameList=companyLicenseList.get(name);
					nameList.add(wetrilLicenseInfo);
					companyLicenseList.put(name,nameList);
				}
			}
		}
		Map  map = new HashMap(); 
		String rootPath = request.getSession().getServletContext().getRealPath("/");
	    log.info("rootpath="+rootPath);
//	    System.err.print("allpath:"+rootPath+"\\signreport\\ywqkbg.docx");
		XWPFDocument doc = WordExportUtil.exportWord07(rootPath+"/signreport/ywqkbg.docx", map);

		if(companyLicenseList!=null){
			int comnum=1;
			for (Map.Entry entry : companyLicenseList.entrySet()) {
				String compName=(String) entry.getKey();
				
				doc.createParagraph().createRun().setText(Integer.toString(comnum++)+"、"+compName+"("+companyNum.get(compName)+")");
				List<Map> wetrilList=(List<Map>) entry.getValue();
	    		if(wetrilList!=null && wetrilList.size()>0){
	    			int ywnum=1;
	    			for (Map wetrilCnkiLicenseInfoMap : wetrilList) {
	    				if(wetrilCnkiLicenseInfoMap!=null){
	    					//判断业务，生成行
	    					doc.createParagraph().createRun().setText("("+Integer.toString(ywnum++)+")"+wetrilCnkiLicenseInfoMap.get("SJYW"));
	    					Object info=wetrilCnkiLicenseInfoMap.get("变更事项");
	    					String ywstr="";
	    					if(info.getClass().isInstance(Clob.class)){
	    						ywstr =clobToStr((Clob)info);
	    					}else{
	    						ywstr=(String) wetrilCnkiLicenseInfoMap.get("变更事项");
	    					}
	    					if(StringUtils.isNotBlank(ywstr)){
	    						String [] str=ywstr.split(" ");
	    						if(str.length>0){
	    							for(int i=0;i<str.length;i++){
	    								if( StringUtils.isNotBlank(str[i])){
	    									doc.createParagraph().createRun().setText(str[i]);
	    								}
	    							}
	    						}
	    					}else{
	    						log.info("ywstr 为空");
	    						continue;
	    					}
	    				}
	    			}
	    		}
               
			}
		}
		 return doc;
	}
	
	private static String clobToStr(Clob clob) {
		String content="";
		Reader is=null;
	
			try {
				try {
					is = clob.getCharacterStream();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader buf=new BufferedReader(is);
				String line=buf.readLine();
				StringBuffer sb = new StringBuffer(); 
				while (line != null) {
				sb.append(line); 
				line = buf.readLine();
				content = sb.toString();
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return content; 
		
		
	}

	
     
}
