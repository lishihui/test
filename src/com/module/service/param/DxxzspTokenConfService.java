package com.module.service.param;

/**
 * token操作类
 * @author zkl
 *
 */
public interface DxxzspTokenConfService {

	/**
	 * 获取token
	 * @param userName 用户名称
	 * @return
	 */
	String getToken(String userName);
	
	/**
	 * 更新token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	int updToken(String userName,String token);
	
	/**
	 * 添加token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	int addToken(String userName,String token);
	
}
