package com.util;

/**
 * 常量工具类
 * @author zkl
 *
 */
public class FinalClassUtil {

	// 部门业务动态url
	public static final String GET_INSTANCE_LIST_URL = "http://192.168.6.13:9086/runtime/instance/v1/myCompleted";
	
	// 生成（调用安人系统接口）tocken过期时间，单位秒，默认为1天
    public static final Long EXPIRATION = 24 * 60 * 60L;
    
    // 用于验证签名的SecretKey，单点系统和应用系统需保持一致（目前不需要修改）
    public static final String SECURITE_KEY = "mySecret";
    
    // 生成token字符串后前面拼接的标识（来自安人接口的规则）
    public static final String JWT_HEADER = "Bearer ";
    
    // 将token保存到session中所使用的key
    public static final String TOKEN_NAME = "dxxzsp_token";
    
    //获取代办任务列表
    public static final String GET_TASK_INFO_URL = "http://192.168.6.13:9086/runtime/task/v1/getTasksByInstId";
    
    
}
