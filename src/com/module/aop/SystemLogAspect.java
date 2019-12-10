package com.module.aop;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import com.module.annotation.SystemControllerLog;
import com.module.domain.base.SessionInfo;
import com.module.domain.system.SysLog;
import com.module.service.system.ILogService;
import com.util.AppException;
import com.util.DateUtils;
import com.util.JsonUtil;
import com.util.StringUtils;
import com.util.filter.SysContent;

/**
 * 系统日志切点类
 * @author lhy
 *
 */
@Aspect
@Component
public class SystemLogAspect {
	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);
	
	private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");
	private static final ThreadLocal<SysLog> logThreadLocal = new NamedThreadLocal<SysLog>("ThreadLocal log");
	
	/*lhy
	private static final ThreadLocal<SessionInfo> currentUser=new NamedThreadLocal<SessionInfo>("ThreadLocal user");
	
	@Autowired(required=false)
	private HttpServletRequest request;
	*/
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	private ILogService logService;

	/**
	 * Service层切点 
	 */
    /*lhy	
    @Pointcut("@annotation(com.module.annotation.SystemServiceLog)")
	public void serviceAspect(){}
	*/
	
	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("@annotation(com.module.annotation.SystemControllerLog)")
	public void controllerAspect(){}
	
	/**
	 * 方法规则拦截
	 */
	@Pointcut("execution(* com.moduleAAA.controllerAAA.*.*(..))")
	public void controllerPointerCut(){}
	
	/**
	 * 前置通知 用于拦截Controller层记录用户的操作的开始时间
	 * @param joinPoint 切点
	 * @throws InterruptedException 
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) throws InterruptedException{
		
	/*	HttpServletRequest request = SysContent.getRequest();
		Date beginTime=new Date();
		beginTimeThreadLocal.set(beginTime);
		//debug模式下 显式打印开始时间用于调试
		if (logger.isDebugEnabled()){
	        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime), request.getRequestURI());
		}		
		lhy
		//读取session中的用户 
		HttpSession session = request.getSession();       
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");    
		currentUser.set(sessionInfo);
		*/
	}
	
	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint 切点
	 */
	@SuppressWarnings("unchecked")
	@After("controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {		
		/*lhy
		SessionInfo sessionInfo = currentUser.get();
        //登入login操作 前置通知时用户未校验 所以session中不存在用户信息
        if(sessionInfo == null){
    		HttpSession session = request.getSession();       
    		sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");    
    	    if(sessionInfo==null){
    	    	return;
    	    }
        }
        
		HttpServletRequest request = SysContent.getRequest();
		HttpSession session = request.getSession();       
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");    
	    if(sessionInfo==null){
	    	sessionInfo = new SessionInfo();
	    }
		
    	String title="";
    	String type="info";						  //日志类型(info:入库,error:错误)
    	String remoteAddr=request.getRemoteAddr();//请求的IP
    	String requestUri=request.getRequestURI();//请求的Uri
    	String method=request.getMethod();		  //请求的方法类型(post/get)
    	Map<String,String[]> params=request.getParameterMap(); //请求提交的参数
    	try {
    		title=getControllerMethodDescription2(joinPoint);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}    
    	// debu模式下打印JVM信息。
    	long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）  
    	long endTime = System.currentTimeMillis(); 	//2、结束时间  
    	
		if (logger.isDebugEnabled()){
	        logger.debug("计时结束：{}  URI: {}  耗时： {}   最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
	        		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime), 
	        		request.getRequestURI(), 
	        		DateUtils.formatDateTime(endTime - beginTime),
					Runtime.getRuntime().maxMemory()/1024/1024, 
					Runtime.getRuntime().totalMemory()/1024/1024, 
					Runtime.getRuntime().freeMemory()/1024/1024, 
					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
		}
    	
		SysLog log=new SysLog();
    	log.setLogid(StringUtils.getUUID());
    	log.setTitle(title);
    	log.setType(type);
    	log.setRemoteaddr(remoteAddr);
    	log.setRequesturi(requestUri);
    	log.setMethod(method);
    	//log.setMapToParams(params);
    	log.setParams(JsonUtil.ToJson(params));
    	log.setUserid(sessionInfo.getStaffid());
    	Date operateDate=beginTimeThreadLocal.get();
    	log.setOperatedate(operateDate);
    	log.setTimeout(DateUtils.formatDateTime(endTime - beginTime));

    	//1.直接执行保存操作
        //this.logService.createSystemLog(log);
        //2.优化:异步保存日志
        //new SaveLogThread(log, logService).start();
        //3.再优化:通过线程池来执行日志保存
        threadPoolTaskExecutor.execute(new SaveLogThread(log, logService));
        logThreadLocal.set(log);*/
	}
	
	/**
	 *  异常通知 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")  
	public  void doAfterThrowing(JoinPoint joinPoint, Exception e) {
		SysLog log = logThreadLocal.get();
		if(log != null){
			/*返回给前台AJAX请求错误信息*/
			HttpServletResponse response = SysContent.getResponse();
			if ( response!= null){
				try{
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.write(e.toString());
					out.flush();
					out.close();
				}catch(Exception ee){
					System.out.println(ee.toString());
				}
			}
			//2019-07-24修改 log.setException(e.toString());
			/*lhy 判断业务是否有拦截和抛出AppException*/
			log.setType("err");
			if ( e.getClass().getName().equals("com.util.AppException") ){
				log.setException( ((AppException)e).getErrtext());
			}else{
				log.setException( e.toString() );
			}
			new UpdateLogThread(log, logService).start();			
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint 切点
	 * @return 方法描述
	 */
	public static String getControllerMethodDescription2(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);
		String discription = controllerLog.description();
		//增加拦截的类名和方法名
		String str = method.toString();
		//第一次截取
		str = str.substring(0, str.indexOf("("));
		//第二次截取
		str = str.substring(str.lastIndexOf(".",str.lastIndexOf(".")-1)+1);
		discription =  str + ":" + discription;
		return discription;
	}

	/**
	 * 保存日志线程
	 * 
	 * @author lhy
	 *
	 */
	private static class SaveLogThread implements Runnable {
		private SysLog log;
		private ILogService logService;

		public SaveLogThread(SysLog log, ILogService logService) {
			this.log = log;
			this.logService = logService;
		}

		@Override
		public void run() {
			logService.createLog(log);
		}
	}

	/**
	 * 日志更新线程
	 * 
	 * @author lhy
	 *
	 */
	private static class UpdateLogThread extends Thread {
		private SysLog log;
		private ILogService logService;

		public UpdateLogThread(SysLog log, ILogService logService) {
			super(UpdateLogThread.class.getSimpleName());
			this.log = log;
			this.logService = logService;
		}

		@Override
		public void run() {
			this.logService.updateLog(log);
		}
	}
}
