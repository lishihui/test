package com.util;

import com.module.domain.base.Page;
/**
 * 分页查询直接SQL处理公共类
 * lhy
 */
public class PageUtil {
	 /**
	 * 取总记录数的查询SQL
	 * @param sql 
	 * @return 
	 */  
	public static String getCountsql(String sql) {  
		int index = sql.indexOf("from");
	    return "select count(*) " + sql.substring(index);
	}

	public static String getSqlCount(String sql) {
		String sqlCount = "select count(*) from ("+ sql +")";
		return sqlCount;
	}
	/**
	 * 分页查询SQL
	 * @param sql page
	 * @return 
	 */  
	@SuppressWarnings("rawtypes")
	public static String getPagesql(String sql,Page page) {  
	
		StringBuffer sqlBuffer = new StringBuffer(sql);
	    int offset = (page.getPage() - 1) * page.getRows();
	    if ( offset < 0 ){
		   offset = 0;
	    }
		sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum <= ").append(offset + page.getRows()); 
		sqlBuffer.insert(0, "select * from (").append(") where r > ").append(offset);
		return sqlBuffer.toString();
	}  

}
