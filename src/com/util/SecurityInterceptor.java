package com.util;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		/*
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();		
		String url = requestUri.substring(contextPath.length());

		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute("sessionInfo");
		//判断是否包含在菜单权限里
        
		if ( (url.indexOf("/VerifyCode/") > -1) || (url.indexOf("/Login/") > -1) || (url.indexOf("/Touch/") > -1)  ) {// 如果要访问的资源是不需要验证的
			return true;
		}
		
		if ((sessionInfo == null)) {// 如果没有登录或登录超时
			if(request.getHeader("x-requested-with")!=null   && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){   
				 //是ajax请求，则返回个消息给前台
	             response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
	             return false;
	        }else{  
	            //不是ajax请求，则直接跳转页面
				request.getRequestDispatcher("/Login/toLogOut?msg=您还没有登录或登录已超时！").forward(request, response);
				return false;
	        }
		}
		
		if(!sessionInfo.getResourceAllList().contains(url)){
			return true;
		}

		if (!sessionInfo.getResourceList().contains(url)) {// 如果当前用户没有访问此资源的权限
			request.getRequestDispatcher("/Login/toLogOut?msg=您无权使用本功能！").forward(request, response);
			return false;
		}
		*/
		
		return true;
	}
}
