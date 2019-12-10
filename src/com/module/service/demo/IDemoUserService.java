package com.module.service.demo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.module.domain.base.Page;
import com.module.domain.base.WetrilCnkiLicenseInfo;
import com.module.domain.demo.DemoUser;
import com.util.AppException;

public interface IDemoUserService {
	
    //分页查询记录 进行维护
    public List<Map<String,Object>> getAllRow(Page<DemoUser> page) throws AppException;
	
    //根据主键查询业务数据
    public Map<String,Object> getRow(String uuid) throws AppException;
    
    //记录新增
    public Map<String,Object> insertRow(DemoUser demoUser) throws AppException;
    
    //记录修改
    public Map<String,Object> updateRow(DemoUser demoUser) throws AppException;
    
    //记录删除
    public Map<String,Object> deleteRow(String uuid) throws AppException;
    
    //查询签报列表
    public Map<String,Object> querySingList(String id) throws AppException;
    
    public Map<String,Object> querySingDoneList() throws AppException;
    
    public Map<String,Object> querysingDetailedList(String itemid) throws AppException;

	public void saveData(String pcbh, String itemid,String qbnr);

	public Map<String, Object> querySingFourBrowse(String id);

	public void updatJZDataZp(String id, String jzyi, String jzqzsj);

	public List<Map<String, Object>> findByItemId(String itemid);

	public Map downLicence(List<String> dxxzspParamSq,List<String> dxxzspParamBg);

	public XWPFDocument exportDoc(HttpServletRequest request,
			List<WetrilCnkiLicenseInfo> listInfoSq)throws Exception;

	public XWPFDocument exportDocBg(HttpServletRequest request,
			List<Map> exportBg)throws Exception;

	

	

}
