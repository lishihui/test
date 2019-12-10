package com.module.service.domainRegistration.change.comm;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.module.domain.base.Page;
import com.module.domain.domain.DxxzspYewujiluUser;
import com.module.domain.query.XukeSearchQueryBean;
import com.util.AppException;

public interface DxxzspAuditTaskCommonService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws Exception;
    
    //根据主键查询业务数据 -- 查询总的记录数量
    public int getRowCount(XukeSearchQueryBean obj_record, String param) throws Exception;
    
    public Map<String,Object> getList(XukeSearchQueryBean obj_record, String param, int currentPage, int currentPageSize);
    
    public Map<String,Object> getList(XukeSearchQueryBean obj_record, String param);
    //接收前台查询条件参数
  	public XukeSearchQueryBean getXukeSearchQueryBean(HttpServletRequest request);
    
}
