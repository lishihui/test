package com.module.dao.param;

import org.apache.ibatis.annotations.Param;

public interface DxxzspTokenConfMapper {
	
	/**
	 * 获取token
	 * @param userName 用户名称
	 * @return
	 */
	String getToken(@Param("userName") String userName);
	
	/**
	 * 更新token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	int updToken(@Param("userName") String userName,@Param("token") String token);
	
	/**
	 * 添加token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	int addToken(@Param("userName") String userName,@Param("token") String token);
	
}