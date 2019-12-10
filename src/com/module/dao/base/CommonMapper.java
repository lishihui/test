package com.module.dao.base;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
	/**
	 * 执行增加sql语句
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public long insertSQL(String sql);
	
	/**
	 * 执行修改sql语句
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public long updateSQL(String sql);
	
	/**
	 * 执行删除sql语句
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public long deleteSQL(String sql);
	
	/**
	 * 根据sql语句查询单调数据
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public Map<String, Object> findOneData(String sql);
	
	/**
	 * 根据sql语句查询多调数据
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public List<Map<String, Object>> findManyData(String sql);

	/**
	 * 根据sql语句查询条数
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public long findCount(String sql);

	/**
	 * 根据sql语句查询String 返回
	 * 
	 * @author lhy
	 * @param sql sql语句
	 * @return
	 */
	public List<String> findStringData(String sql);
}
