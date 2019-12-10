package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.module.service.param.DxxzspTokenConfService;
import com.schedul.JWTokenTool;

/**
 * 全局公共工具方法
 * @author zkl
 *
 */
public class ToolUtil {

	/**
	 * 生成调用安人系统接口tocken
	 * @param username 用户登录名，必须是系统内存在的用户名
	 * @param expiration tocken有效时间
	 * @return
	 */
	public static String getARToken(String username,long expiration) {
		
			JWTokenTool tokenTool = new JWTokenTool();
	        //过期时间（秒），可与用户session过期时间一致，
	        tokenTool.setExpiration(expiration); // 设置tocken失效时间
	        //用于验证签名的SecretKey，单点系统和应用系统需保持一致
	        tokenTool.setSecret(FinalClassUtil.SECURITE_KEY);
	        //生成token
	        String token = tokenTool.generateToken(username);
			//返回token
			return FinalClassUtil.JWT_HEADER + token;
	}
	
}
