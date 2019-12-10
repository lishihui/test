<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>
<%@taglib uri="http://www.horizon.cn/taglib/path" prefix="path"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="com.horizon.context.Context"%>
<%@page import="com.horizon.context.ContextFactory"%>
<%
	String workidval = request.getParameter("workId");
	String trackidls = request.getParameter("trackId");
	Context context = ContextFactory.getContext();
	String userid = context.getUserId();
%>

<!DOCTYPE html>
<html lang='<path:i18n key="lang"/>'>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title><c:out value="${workFlow.flowName}" /></title>
<%@include file="../../common/bootstrap.css.include.jsp"%>
<script type="text/javascript"
	src="../../../plugins/jquery/jquery-1.10.0.min.js"></script>
<link rel="stylesheet"
	href="<path:frontPath/>/jquery/jquery-ui/css/jquery-ui.css" />
<link rel="stylesheet"
	href="<path:frontPath/>/gritter/css/jquery.gritter.css" />
<link rel="stylesheet"
	href="<path:frontPath/>/ztree/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="../../../xuke/mystyle2.css" />
<link rel="stylesheet" href="../../../xuke/mystyle3.css" />

   <link rel="stylesheet"  type="text/css" media="print" href="../../../plugins/jquery/PrintArea.css"> 
<link rel="stylesheet" href="../../../workflow/module/workflow/printindex.css" media="print"/>
<script src="../../../dxxzsp/common/js/common.js"></script>
<script src="../../../dxxzsp/common/js/Loadwebsign.js"></script>
<script src="../../../dxxzsp/common/js/main.js"></script>
<style>
.hidebox{
	display:none !important;
}

.history {
	outline: none;
	background-color: #6bbbe8;
	border: none;
	height: 25px;
	border-radius: 5px;
	font-size: 14px;
	color: #ffffff;
	width: 120px
}

.zhengchang a[data-operate='rejectSubmit'] {
	display: none;
}

.zhengchang4 a[data-operate='stop'] {
	display: none;
}

.zhengchang2 a[data-operate='submit'] {
	display: none;
}

.zhengchang3 a[data-operate='jumpreject'] {
	display: none;
}

#tianyijian {
	readonly: false !important;
}

.hide {
	display: none !important;
}

.show {
	display: block !important;
}
</style>
<script>

 var workidls="<%=workidval%>";
 var trackidls="<%=trackidls%>";
 var userid="<%=userid%>";
 var isok="";
    var flowtye = "";
    /**字段背景颜色**/
    var color0 = "";
    var color1 = "orange";
    var color2 = "red";
    var isZhuban = false;//当前登录人是否是主办
    var istuihui = false;//当前是否退回到企业申请，修改字段
    var haslimit = false;//是否有表单审核权限
    var quanxian =true;//是否又表单权限
    var firstnode="";
    var firstnodeval="";
    function GetUrlparamString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	

	
	//初始化方法
	 $(document).ready(function(){
	            $("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
	 			var user = $("#right-menu div[class='row no-margin'] label:last-child span").html()+"";
				
				
				if (user.indexOf("创建者") > 0) {
		$("div.modal-dialog").hide();
		$("#FlowTrack1").hide();
		/* $("#myTab").prev().hide(); */
	}	
				if (user.indexOf("已办") > 0&&user.indexOf("主办")<0) {
				
					$("#yijjianCom").attr("readonly","readonly");
				}	
	 
		//ie8不支持indexOf方法，手动加上这个方法
		if (!Array.prototype.indexOf) {
			Array.prototype.indexOf = function(searchElement, fromIndex) {
			var k;
			if (this == null) {
			throw new TypeError('"this" is null or not defined');
			}
			var O = Object(this);
			var len = O.length >>> 0;
			if (len === 0) {
				return -1;
			}
			var n = +fromIndex || 0;
			if (Math.abs(n) === Infinity) {
				n = 0;
			}
			if (n >= len) {
				return -1;
			}
			k = Math.max(n >= 0 ? n : len - Math.abs(n), 0);
			while (k < len) {
				if (k in O && O[k] === searchElement) {
					return k;
				}
				k++;
			}
			return -1;
			};
		}
		$("#le div a").attr("iszan","true");
		//获取流程节点
		nodeName = $("input[name='nodeName']").val();
		//获取nodeid
		 nodeId = $("input[name='nodeId']").val();
		//获取流程id
		 flowId = $("input[name='flowId']").val();
		//获取当前流程的状态
		 workStatus = $("#right-menu div[class='row no-margin'] label").eq(5);
	     workStatus1 = $(workStatus).find("span").html();
		//获取流程id
		 workid = $("input[name='workId']").val();
		$("#thisWorkid").val(workid);
		
		
		/* 为企业申请撤消而锁定
		 * liuhy 2018-09-19 将业务记录表  DXXZSP_YEWUJILU_USER 的 title 字段值改为  "已锁定" 企业撤消时判断该值 为  "已锁定" 时走申请撤消
		 * 注：这个字段没有值时按原有流程
		 */
		if( user.indexOf("主办")<0 ){
		}else{
			$.ajax({
				url:'/dxxzsp/xuke/changeTitle.jsp',
				type:"post",
				dataType:'json',
				data:{
					workid:workid,
				},
				async : false,
				error : function(data) {
					//无后续处理
				},
				success : function(data){
					//加锁成功 无后续处理
				}
			});
		}
		//为企业申请撤消而锁定
		
		if(flowId=="anhuishenqing"&&(nodeId=="Node9"||nodeId=="Node3"))
		{
		    quanxian=false;
		}		
		else if(flowId=="qinghaishenqing"&&(nodeId=="Node10"||nodeId=="Node12"))
		{
		    quanxian=false;
		}
		else if(flowId=="ksxksq"&&nodeId=="Node7")
		{
		    quanxian=false;
		}
		if(flowId=="fujianshenqing"&&(nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node7"))
		{
		    quanxian=false;
		}
		if(flowId=="guangdongxk"&&(nodeId=="Node3"||nodeId=="Node5"))
		{
		    quanxian=false;
		}
		if(flowId=="guizhoushenqing"&&(nodeId=="Node14"||nodeId=="Node16"))
		{
		    quanxian=false;
		}
		if(flowId=="hainansq"&&(nodeId=="Node3"||nodeId=="Node4"))
		{
		    quanxian=false;
		}
		if(flowId=="hubeisq"&&(nodeId=="Node6"||nodeId=="Node10"))
		{
		    quanxian=false;
		}
		if(flowId=="hunansq"&&(nodeId=="Node5"||nodeId=="Node4"))
		{
		    quanxian=false;
		}
		if(flowId=="dalianshenqing"&&(nodeId=="Node14"||nodeId=="Node15"||nodeId=="Node16"))
		{
		    quanxian=false;
		}
		if(flowId=="shanxissqlc"&&(nodeId=="Node3"||nodeId=="Node4"))
		{
		    quanxian=false;
		}
		if(flowId=="tianjingssqlc"&&(nodeId=="Node20"||nodeId=="Node4"||nodeId=="Node3"))
		{
		    quanxian=false;
		}
		if(flowId=="zhejiangshenqing"&&(nodeId=="Node3"||nodeId=="Node8"))
		{
		    quanxian=false;
		}
		if(flowId=="chongqingsq"&&(nodeId=="Node6"||nodeId=="Node4"))
		{
		    quanxian=false;
		}
		if(flowId=="xinzangshenqing"&&(nodeId=="Node3"||nodeId=="Node2"))
		{
		    quanxian=false;
		}
		
				if(flowId=="shandongshenqing"&&(nodeId=="Node8"||nodeId=="Node6"&&nodeId=="Node16"||nodeId=="Node17"))
		{
		    quanxian=false;
		}
		
		
		
		//辽宁省变更
		/*if(flowId=="dalianbiangeng"&&nodeId=="Node3")
		{
		    quanxian=false;
		}*/
		
		
		
		
		// 自贸区申请 审核权限设置
		
		
		if((flowId=="zmqhn")&&(nodeId=="Node4"||nodeId=="Node5")){ quanxian = false;}
		if (flowId == "zmqguangdong" && (nodeId == "Node10" || nodeId == "Node3")){ quanxian = false;}
		if (flowId == "zmqhubei" && (nodeId == "Node4" || nodeId == "Node5")){ quanxian = false;}
		if (flowId == "zmqchongqing" && (nodeId == "Node3" || nodeId == "Node5")){ quanxian = false;}
		if (flowId == "zmqzj" && (nodeId == "Node2" || nodeId == "Node6")){ quanxian = false;}
		if (flowId == "zmqln" && (nodeId == "Node5" || nodeId == "Node6"|| nodeId == "Node7")){ quanxian = false;}
		if (flowId == "zmqtj" && (nodeId == "Node3" || nodeId == "Node4"|| nodeId == "Node5")){ quanxian = false;}
		
		//评测隐藏查看历史审核意见
		if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
			$("#bdshls").hide();
		}
		//域名管理机构
		if((flowId=="yumingfuwuzhuce")&&(nodeId=="Node4"||nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node7"||nodeId=="Node8"||nodeId=="Node13"||nodeId=="Node14"||nodeId=="Node15"||nodeId=="Node16")){ quanxian = false;}
		//域名服务商
		if((flowId=="beijingyumingfws")&&(nodeId=="Node4"||nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node3")){ quanxian = false;}
		if((flowId=="henanfws")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7"||nodeId=="Node18"||nodeId=="Node19")){ quanxian = false;}
		if((flowId=="jiangsufws")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7"||nodeId=="Node18"||nodeId=="Node19")){ quanxian = false;}
		if((flowId=="shandongfws")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7"||nodeId=="Node18")){ quanxian = false;}
		if((flowId=="hainfws")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7")){ quanxian = false;}
		if((flowId=="shanxiyumingfws")&&(nodeId=="Node3"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node4")){ quanxian = false;}
		if((flowId=="hebeiyumingfws")&&(nodeId=="Node3"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node4")){ quanxian = false;}
		if((flowId=="lnymzcfwslc")&&(nodeId=="Node2"||nodeId=="Node3"||nodeId=="Node5"||nodeId=="Node4")){ quanxian = false;}
		if((flowId=="zjsymzcfwssqlc")&&(nodeId=="Node3"||nodeId=="Node4")){ quanxian = false;}
		if((flowId=="xzymzcfwslc")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7"||nodeId=="Node18"||nodeId=="Node19")){ quanxian = false;}
		if((flowId=="anhuifws")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node5"||nodeId=="Node7")){ quanxian = false;}
		if((flowId=="jlymzcfwslc")&&(nodeId=="Node3"||nodeId=="Node4"||nodeId=="Node5"||nodeId=="Node6")){ quanxian = false;}
		if((flowId=="hbymzcfuslc")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node20"||nodeId=="Node22")){ quanxian = false;}
		if((flowId=="jxymzcfuslc")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node20"||nodeId=="Node22")){ quanxian = false;}
		if((flowId=="cqymzcfwslc")&&(nodeId=="Node16"||nodeId=="Node6")){ quanxian = false;}
		if((flowId=="gxymzcfuslc")&&(nodeId=="Node16"||nodeId=="Node6"||nodeId=="Node20")){ quanxian = false;}
		if((flowId=="hljfws")&&(nodeId=="Node4"||nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node7")){ quanxian = false;}
		if((flowId=="tianjinfws")&&(nodeId=="Node16"||nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node7")){ quanxian = false;}
		if((flowId=="fujianyumingfws")&&(nodeId=="Node2"||nodeId=="Node3")){ quanxian = false;}
		if((flowId=="xinjiangfws")&&(nodeId=="Node16"||nodeId=="Node5"||nodeId=="Node6"||nodeId=="Node7")){ quanxian = false;}

		/**
		判断是否时退回到开始节点，
		若是；则将有审核意见的字段的颜色置为红色，点击字段在右上角显示该字段的最新的审核意见和审核历史意见，并且该字段设置为可以填写；
			点击左侧标签时，右边的表单审核意见也不加载	
		**/
		workStatus1 = workStatus1.replace(/\ +/g,"");
		workStatus1 = workStatus1.replace(/[\r\n]/g,"");
		nodeName = nodeName.replace(/\ +/g,"");
		nodeName = nodeName.replace(/[\r\n]/g,"");
			//查询是否是退回到开始节点
			$.ajax({
				url :encodeURI(horizon.paths.apppath+"/xuke/getworkstatus.jsp?workId="+workid+"&nodeId="+nodeId),
				type : "post",
				dataType : 'json',
				async : false,
				error : function() {
					alert("Error");
				},
				success : function(data) {
				firstnode=data.firstnode;
					if(data.isFirst=="true"||(user.indexOf("已办") > 0&&user.indexOf("主办")<0)){
						istuihui = true;
						$("#bdsh").hide();
						if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
							$("#bdshls").hide();
						}else{
							$("#bdshls").show();
						}
						
						$("#tuihui").val(istuihui);
						
					}else{
						/* $("#bdsh").hide();
						$("#bdshls").show(); */
					}
					if(data.isFirst=="false"){
					istuihui = false;
					$("#tuihui").val(istuihui);
					}
					if(data.isFirst=="true"&&(user.indexOf("主办")>0)){
					$("#bdshls").hide();
					}
					
					if(data.isInPro=="true"){
						$("div[class='subformflags']").each(function(){
							var divClass = $(this).attr("class");
							var classsub = divClass.substring(1,divClass.length-1);
							$(this).attr("class","A"+classsub);
						});
					}
					$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					onloadmenu();
					
				}
			});
			$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");


	 	$.ajax( {
	        		url :encodeURI(horizon.paths.apppath+"/waizi/wai/chaxunshijianid.jsp?workid="+workid),
	        		type : "post",
	        		dataType : 'json',
	        		async : false,
	        		error : function() {
	        			alert("error");
	        		},
	        		success : function(data) {
                       if(data.result=="1")
                       {
                       
			          /*  fujianchaxun(data.shijianid); */
                       }
	        		}
	        	}); 
	        	

			
	
			
			
			if(flowId=="wzsqsplc")
			{
			
			   var i=1;
 			  
       	$("a[yewucode='W0105YD']").parent().hide(); 
 	$("a[yewucode='W0106YD']").parent().hide();
 	$("a[yewucode='W0107YD']").parent().hide(); 
 	$("a[yewucode='W0108YD']").parent().hide();
 	$("a[yewucode='W0109YD']").parent().hide();
 	/* $("#bdsh").attr("style","width: 130px; dislay: none;height:20px;top:48px;"); */   
 	 
			}
			
 			
						if(flowId=="ksxksq")
			{
			
			
		$("a[yewucode='K30K01YD']").parent().parent().parent().hide(); 
		$("a[yewucode='K31K01YD']").parent().parent().parent().hide();
 	 
			} 
			
         
			var  jqidq=flowId.lastIndexOf('c');

			var  jqidh=flowId.lastIndexOf('s')

			var bb=flowId.substring(jqidh,jqidq);
		if(bb=="shl"||bb=="spl"||bb=="hainangjl"){
			
			$("a[yewucode='J01J15YD']").parent().hide(); 
		 	$("a[yewucode='J01J16YD']").parent().hide();
		 	$("a[yewucode='J01J17YD']").parent().hide(); 
		 	$("a[yewucode='J01J18YD']").parent().hide();
		 	$("a[yewucode='J01J19YD']").parent().hide();
		 	$("a[yewucode='J01J20YD']").parent().hide();
		}
		
		$("a[yewucode='A30A01YD']").parent().parent().parent().hide(); 
		$("a[yewucode='A31A01YD']").parent().parent().parent().hide();
		$("a[yewucode='A32A01YD']").parent().parent().parent().hide();
		$("a[yewucode='A33A01YD']").parent().parent().parent().hide();
		$("a[yewucode='A34A01YD']").parent().parent().parent().hide(); 
	
		$("a[yewucode='S54S33YD']").parent().parent().parent().hide(); 
		$("a[yewucode='S55S44YD']").parent().parent().parent().hide();
		$("a[yewucode='S56S55YD']").parent().parent().parent().hide();
		$("a[yewucode='S57S66YD']").parent().parent().parent().hide();
		$("a[yewucode='S58S77YD']").parent().parent().parent().hide();	
		/* 域名管理 */
		$("a[yewucode='Y03Y13YD']").parent().hide();
		$("a[yewucode='Y03Y14YD']").parent().hide();
		$("a[yewucode='Y03Y15YD']").parent().hide();
		$("a[yewucode='Y03Y16YD']").parent().hide();
		/* 域名跟服务 */
		$("a[yewucode='Y0108YD']").parent().hide();
		$("a[yewucode='Y0109YD']").parent().hide();
		$("a[yewucode='Y0110YD']").parent().hide();
		$("a[yewucode='Y0111YD']").parent().hide();
		/* 域名服务商 */
		$("a[yewucode='Y0213YD']").parent().hide();
		$("a[yewucode='Y0214YD']").parent().hide();
		$("a[yewucode='Y0215YD']").parent().hide();
		$("a[yewucode='Y0216YD']").parent().hide();
		$("a[yewucode='Y0217YD']").parent().hide();
		$("a[yewucode='Y0218YD']").parent().hide();
		
		if($!=undefined && $("input[name='deptName']")!=undefined && $("input[name='deptName']").length>0 && $("input[name='deptName']").val()!="企业"){ $("tr[name='shydNotShowQy']").show();}
	 });
	
	  function  onloadmenu(){
		   nodeId = $("input[name='nodeId']").val();
	       $("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
		  //查询是否是当前主办人；若是，则显示表单审核，若不是，隐藏表单审核
		  	 var user = $("#right-menu div[class='row no-margin'] label:last-child span").html();
			 if(user.indexOf("主办")>0){
			 	isZhuban = true;
			 	$("#lishikuang").val("zhuban");
			 }else if(user.indexOf("已办")>0 && user.indexOf("主办")<0){
			 	$("#bdsh").hide();
			 	if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
	    			$("#bdshls").hide();
	    		}else{
	    			$("#bdshls").show();
	    		} 
				$("#lishikuang").val("yiban");    		
			 }
			 flowtye = GetUrlparamString("flowtye");
			 var sjid = GetUrlparamString("sjid");
			
			 //判断该申请是否是跨区域的业务申请；
			 //若flowtye不为空，则直接根据flowtye的值判断是否为跨区域申请，1：表示跨区域申请；
			 //若flowtye为空，则需根据流程id(workid)到数据库中查询该流程的flowid是否为ksxksq.
			     	
			 if(flowtye!=null && flowtye!=""){
				 $("#thisSjid").val(sjid);
			     if(flowtye==1){//值为1：表示是跨地区许可申请
			     	$("#myTab").children("li").each(function(){
			     		$(this).hide();
			     	});
			     	//查询出该业务申请下的所有的业务表单，显示在左侧
				    	
			     	if(!istuihui){
				    	$.ajax({
							url :encodeURI(horizon.paths.apppath+"/xuke/getTabs.jsp?sjid="+sjid+"&flowId="+flowId+"&nodeId="+nodeId),
							type : "post",
							dataType : 'json',
							async : false,
							error : function() {
								alert("Error");
							},
							success : function(data) {
								var appendStr = "";
						    	var appendStr1 = "";
								$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
						    	var beiyonghtml = $("#biaodanyjdiv").html();
								
						    	var beiyong1html = $("#beiyong1").html();
						    	if(data.haslimit=="true" && isZhuban){//是主办人并且有审核权限时，显示表单审核按钮
						    		haslimit = true;
						    		$("#bdsh").show();
						    		$("#bdshls").hide();
						    	}else if((data.haslimit=="true" && !isZhuban) || data.haslimit=="false"){//其他情况显示查看表单审核历史按钮
						    		$("#bdsh").hide();
						    		if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
						    			$("#bdshls").hide();
						    		}
						    		else if(user.indexOf("创建者") < 0){
						    		$("#bdshls").show();
						    		}
						    		else{
						    			$("#bdshls").hide();
						    		} 
						    		$("#lishikuang").val("yiban");
						    	}else {
						    		$("#bdsh").hide();
						    		$("#bdshls").hide();
						    	}
						    	var i=0;
						    	var tabs = data.tab;
							    for(var type in tabs){
							    	if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in tabs[type].sublist){
                                        var yijiancolor = "";
                                        if (user.indexOf("创建者") < 0){
                                            if(tabs[type].sublist[sublist].yijianvalue=="pass"){
                                                yijiancolor = "green";
                                            }else if(tabs[type].sublist[sublist].yijianvalue=="modify"){
                                                yijiancolor = "red";
                                            }
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab' class='zhua' style='text-align:left;color:"+yijiancolor+";' yewucode='"+tabs[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+tabs[type].id+"\",\""+tabs[type].sublist[sublist].formid+"\",\""+tabs[type].sublist[sublist].yewucode+"\")' >"+tabs[type].sublist[sublist].yewuname+"</a></li>";
							    		if(data.haslimit=="true" && isZhuban){
								    		var shenhehtml = "<div id='shenhe"+data[type].sublist[sublist].yewucode+"' style='display:none;'><span class='biaomingclass'>"+tabs[type].sublist[sublist].yewuname+"</span><div id='divshenhe"+tabs[type].sublist[sublist].yewucode+"'><div valid='valid'>"+beiyonghtml+"</div></div>"+beiyong1html+"</div>";
								    		$("#you #kuang_shenhe").append(shenhehtml);
							    		}
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    
							    if (user.indexOf("创建者") < 0)
							    {
							    
						    	appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
							    $("#myTab").append(appendStr);
							}
						});
			     	}else if(istuihui){//当退回到开始节点时，需要使用颜色标记表单是否有修改意见
			     		$.ajax({
						url :encodeURI(horizon.paths.apppath+"/xuke/getTabsAndShyj.jsp?sjid="+sjid+"&flowId="+flowId+"&nodeId="+nodeId),
						type : "post",
						dataType : 'json',
						async : false,
						error : function() {
							alert("Error");
						},
						success : function(data) {
							var appendStr = "";
					    	var appendStr1 = "";
							$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					    	var beiyonghtml = $("#biaodanyjdiv").html();
					    	var beiyong1html = $("#beiyong1").html();
					    	//判断返回的data是否为空，若为空，则表明该项目不是跨区域的申请，若不为空，则表明该项目是跨区域申请，需重新加载左侧的Tab标签 
					    	if(!$.isEmptyObject(data)){
				    		 	$("#myTab").children("li").each(function(){
						     		$(this).hide();
						     	});
						     	var i=0;
							    for(var type in data){
				    				//加载左侧Tab标签
				    				if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in data[type].sublist){
							    		var yijiancolor = "";
							    		if(data[type].sublist[sublist].yijianvalue=="pass"){
							    			yijiancolor = "green";
							    		}else if(data[type].sublist[sublist].yijianvalue=="modify"){
							    			yijiancolor = "red";
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab'style='cursor:pointer;text-align:left;color:"+yijiancolor+";' class='zhua'  yewucode='"+data[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+data[type].id+"\",\""+data[type].sublist[sublist].formid+"\",\""+data[type].sublist[sublist].yewucode+"\")' >"+data[type].sublist[sublist].yewuname+"</a></li>";
							    		
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    if (user.indexOf("创建者") < 0)
							    {
							    
						    	appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
							    $("#myTab").append(appendStr);
					    	}
						}
					});
			     	}
				}else if(flowtye==2){//省内许可
			    	
			    }else{
			    	//对tap名称进行改写
			    	//值为1：表示是跨地区许可申请
			     	$("#myTab").children("li").each(function(){
			     		$(this).hide();
			     	});
			    
			     	//查询出该业务申请下的所有的业务表单，显示在左侧
			     	if(!istuihui){
				    	$.ajax({
							url :encodeURI(horizon.paths.apppath+"/xuke/getTabs.jsp?sjid="+sjid+"&flowId="+flowId+"&nodeId="+nodeId),
							type : "post",
							dataType : 'json',
							async : false,
							error : function() {
								alert("Error");
							},
							success : function(data) {
								var appendStr = "";
						    	var appendStr1 = "";
								$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
						    	var beiyonghtml = $("#biaodanyjdiv").html();
						    	var beiyong1html = $("#beiyong1").html();
						    	if(data.haslimit=="true" && isZhuban){//是主办人并且有审核权限时，显示表单审核按钮
						    		haslimit = true;
						    		$("#bdsh").show();
						    		$("#bdshls").hide();
						    	}else if((data.haslimit=="true" && !isZhuban) || data.haslimit=="false"){//其他情况显示查看表单审核历史按钮
						    		$("#bdsh").hide();
						    		if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
						    			$("#bdshls").hide();
						    		}else if(user.indexOf("创建者") < 0){
						    		    $("#bdshls").show();
						    		}else{
						    			$("#bdshls").hide();
						    		} 
						    		$("#lishikuang").val("yiban");
						    	}else {
						    		$("#bdsh").hide();
						    		$("#bdshls").hide();
						    	}
						    	var i=0;
						    	var tabs = data.tab;
							    for(var type in tabs){
							    	if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in tabs[type].sublist){
							    		var yijiancolor = "";
							    		if (user.indexOf("创建者") < 0){
    							    		if(tabs[type].sublist[sublist].yijianvalue=="pass"){
    							    			yijiancolor = "green";
    							    		}else if(tabs[type].sublist[sublist].yijianvalue=="modify"){
    							    			yijiancolor = "red";
    							    		}
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab' class='zhua' style='text-align:left;color:"+yijiancolor+";' yewucode='"+tabs[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+tabs[type].id+"\",\""+tabs[type].sublist[sublist].formid+"\",\""+tabs[type].sublist[sublist].yewucode+"\")' >"+tabs[type].sublist[sublist].yewuname+"</a></li>";
							    		if(data.haslimit=="true" && isZhuban){
								    		var shenhehtml = "<div id='shenhe"+data[type].sublist[sublist].yewucode+"' style='display:none;'><span class='biaomingclass'>"+tabs[type].sublist[sublist].yewuname+"</span><div id='divshenhe"+tabs[type].sublist[sublist].yewucode+"'><div valid='valid'>"+beiyonghtml+"</div></div>"+beiyong1html+"</div>";
								    		$("#you #kuang_shenhe").append(shenhehtml);
							    		}
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    if (user.indexOf("创建者") < 0){
							        appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
							    $("#myTab").append(appendStr);
							}
						});
			     	}else if(istuihui){//当退回到开始节点时，需要使用颜色标记表单是否有修改意见
			     		$.ajax({
						url :encodeURI(horizon.paths.apppath+"/xuke/getTabsAndShyj.jsp?sjid="+sjid+"&flowId="+flowId+"&nodeId="+nodeId),
						type : "post",
						dataType : 'json',
						async : false,
						error : function() {
							alert("Error");
						},
						success : function(data) {
							var appendStr = "";
					    	var appendStr1 = "";
							$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					    	var beiyonghtml = $("#biaodanyjdiv").html();
					    	var beiyong1html = $("#beiyong1").html();
					    	//判断返回的data是否为空，若为空，则表明该项目不是跨区域的申请，若不为空，则表明该项目是跨区域申请，需重新加载左侧的Tab标签 
					    	if(!$.isEmptyObject(data)){
				    		 	$("#myTab").children("li").each(function(){
						     		$(this).hide();
						     	});
						     	var i=0;
							    for(var type in data){
				    				//加载左侧Tab标签
				    				if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in data[type].sublist){
							    		var yijiancolor = "";
							    		if(data[type].sublist[sublist].yijianvalue=="pass"){
							    			yijiancolor = "green";
							    		}else if(data[type].sublist[sublist].yijianvalue=="modify"){
							    			yijiancolor = "red";
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab'style='cursor:pointer;text-align:left;color:"+yijiancolor+";' class='zhua'  yewucode='"+data[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+data[type].id+"\",\""+data[type].sublist[sublist].formid+"\",\""+data[type].sublist[sublist].yewucode+"\")' >"+data[type].sublist[sublist].yewuname+"</a></li>";
							    		
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    if (user.indexOf("创建者") < 0)
							    {
							    
						    	appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
						    	
							    $("#myTab").append(appendStr);
					    	}
						}
					});
			     	
			    }
			 }
			 }else {
			
					$("#myTab").children("li").each(function(){
			     	$(this).hide();
			     	});
			 	//从dxxzsp_yewujilu_user和tw_hz_instance表中获取sjid,查询该项目是否为跨区域的申请以及该申请下的所有的业务表单
			 	if(!istuihui){
			 		var islimit = true;//是否有表单审核权限
				 	$.ajax({
						url :encodeURI(horizon.paths.apppath+"/xuke/getTabsByworkid.jsp?workid="+workid+"&flowId="+flowId+"&nodeId="+nodeId),
						type : "post",
						dataType : 'json',
						async : false,
						error : function() {
							alert("Error");
						},
						success : function(data) {
							var appendStr = "";
					    	var appendStr1 = "";
							$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					    	var beiyonghtml = $("#biaodanyjdiv").html();
					    	var beiyong1html = $("#beiyong1").html();
					    	if(data.haslimit=="true" && isZhuban){//是主办人并且有审核权限时，显示表单审核按钮
					    		haslimit = true;
					    		$("#bdsh").show();
					    		$("#bdshls").hide();
					    	}else if((data.haslimit=="true" && !isZhuban) || data.haslimit=="false"){//其他情况显示查看表单审核历史按钮
					    		$("#bdsh").hide();
					    		if(flowId=="JIFANG"||flowId=="CDNXA"||flowId=="IDCXA"||flowId=="BAJK"||flowId=="idcnet"||flowId=="ISPXA"){
					    			$("#bdshls").hide();
					    		}		else if(user.indexOf("创建者") < 0){
						    		$("#bdshls").show();
						    		}
						    		else{
						    			$("#bdshls").hide();
						    		} 
					    		$("#lishikuang").val("yiban");
					    	}else{
					    		$("#bdsh").hide();
					    		$("#bdshls").hide();
					    	}
					    	//判断返回的data是否为空，若为空，则表明该项目不是跨区域的申请，若不为空，则表明该项目是跨区域申请，需重新加载左侧的Tab标签 
					    	if(!$.isEmptyObject(data.tab)){
				    		 	$("#myTab").children("li").each(function(){
						     		$(this).hide();
						     	});
						     	var i=0;
						     	var tabs = data.tab;
							    for(var type in tabs){
							    	//给thidSjid字段赋值
				    				$("#thisSjid").val(tabs[type].shijianid);
				    				//加载左侧Tab标签
				    				if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+tabs[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in tabs[type].sublist){
							    		var yijiancolor = "";
							    			    							    		if (user.indexOf("创建者") < 0)
							    {
							    		if(tabs[type].sublist[sublist].yijianvalue=="pass"){
							    			yijiancolor = "green";
							    		}else if(tabs[type].sublist[sublist].yijianvalue=="modify"){
							    			yijiancolor = "red";
							    		}
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab'class='zhua' style='text-align:left;color:"+yijiancolor+";' yewucode='"+tabs[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+tabs[type].id+"\",\""+tabs[type].sublist[sublist].formid+"\",\""+tabs[type].sublist[sublist].yewucode+"\")' title='"+tabs[type].sublist[sublist].yewuname+"' >"+tabs[type].sublist[sublist].yewuname+"</a></li>";
							    		if(data.haslimit=="true" && isZhuban){
								    		var shenhehtml = "<div id='shenhe"+tabs[type].sublist[sublist].yewucode+"' style='display:none;'><span class='biaomingclass' >"+tabs[type].sublist[sublist].yewuname+"</span><div id='divshenhe"+tabs[type].sublist[sublist].yewucode+"'><div valid='valid'>"+beiyonghtml+"</div></div>"+beiyong1html+"</div>";
								    		$("#you #kuang_shenhe").append(shenhehtml);
							    		}
							    		
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    if (user.indexOf("创建者") < 0)
							    {
							    
						    	appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
						    	
							    $("#myTab").append(appendStr);
							    }
						}
					});
				}else if(istuihui){//当退回到开始节点时，需要使用颜色标记表单是否有修改意见
			     		$.ajax({
						url :encodeURI(horizon.paths.apppath+"/xuke/getTabsByworkidAndShyj.jsp?workid="+workid+"&flowId="+flowId+"&nodeId="+nodeId),
						type : "post",
						dataType : 'json',
						async : false,
						error : function() {
							alert("Error");
						},
						success : function(data) {
							var appendStr = "";
					    	var appendStr1 = "";
							$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					    	var beiyonghtml = $("#biaodanyjdiv").html();
					    	var beiyong1html = $("#beiyong1").html();
					    	//判断返回的data是否为空，若为空，则表明该项目不是跨区域的申请，若不为空，则表明该项目是跨区域申请，需重新加载左侧的Tab标签 
					    	if(!$.isEmptyObject(data)){
				    		 	$("#myTab").children("li").each(function(){
						     		$(this).hide();
						     	});
						     	var i = 0;
							    for(var type in data){
							    	//给thidSjid字段赋值
				    				$("#thisSjid").val(data[type].shijianid);
				    				//加载左侧Tab标签
				    				if(i==0){
								    	appendStr1 += "<li class='zhu widthclass one zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}else{
								    	appendStr1 += "<li class='zhu widthclass zhuli'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='table(this)' href='#'>"+data[type].yewuname+"</a>"
								    				+"<ul class='nav nav-tabs '>";
							    	}
							    	for(var sublist in data[type].sublist){
							    		var yijiancolor = "";
							    		if(data[type].sublist[sublist].yijianvalue=="pass"){
							    			yijiancolor = "green";
							    		}/* else if(data[type].sublist[sublist].yijianvalue=="nopass"){
							    			yijiancolor = "red";
							    		} */else if(data[type].sublist[sublist].yijianvalue=="modify"){
							    			yijiancolor = "red";
							    		}
							    		appendStr1 +="<li class='widthclass'><a data-toggle='tab'style='cursor:pointer;text-align:left;color:"+yijiancolor+";' class='zhua' yewucode='"+data[type].sublist[sublist].yewucode+"' href='#' onclick='showdiv1(this,\""+data[type].id+"\",\""+data[type].sublist[sublist].formid+"\",\""+data[type].sublist[sublist].yewucode+"\")' >"+data[type].sublist[sublist].yewuname+"</a></li>";
							    		var shenhehtml = "<div id='shenhe"+data[type].sublist[sublist].yewucode+"' style='display:none;'><span class='biaomingclass' >"+data[type].sublist[sublist].yewuname+"</span><div id='divshenhe"+data[type].sublist[sublist].yewucode+"'><div valid='valid'>"+beiyonghtml+"</div></div>"+beiyong1html+"</div>";
							    		$("#you #kuang_shenhe").append(shenhehtml);
							    		
							    	}
							    	appendStr1 +="</ul></li>";
							    	i++;
							    }
							    if (user.indexOf("创建者") < 0)
							    {
							    
						    	appendStr1 +="<li class='zhu widthclass' id='FlowTrack1'><a class='zhu'style='cursor:pointer;text-align:left;' data-toggle='tab' onclick='showflow();' href='#FlowTrack'>流程跟踪</a></li>";
							    }
						    	appendStr+=appendStr1;
						    	
							    $("#myTab").append(appendStr);
					    	}
				
						}
					});
		     	}
			 }
			//当不是退回节点把页面checkbox设为只读
 			if(!istuihui){
 			if(flowId!="wzsqsplc"){
			 $("input[type='checkbox']").click(function(){
			 

			      //this.checked = !this.checked;


			   });
			} }
			 
		}
	  
	
//保存
	
	
		function form(b){
			if($(b).attr("iszan")=="false"){//只有一列，左右都不展开
				//显示
				$("#yingshow").show();
				document.getElementById("myTab").style.display="";
				$("#myTab").prev().show();
				$("#tx").attr("src",horizon.paths.apppath+"/xuke/images/web/zuo.png");
				$(b).attr("iszan","true");
				$("#zhong").removeClass("zhankai1");
				$("#zhong").removeClass("zhankai");
				$("#le").attr("class","floatclass5");
				$("#bdsh").attr("class","floatclass6"); 
				$("#bdshls").attr("class","floatclass6"); 
			}else if($(b).attr("iszan")=="false1"){//两列，右展开
				$("#yingshow").show();
				document.getElementById("myTab").style.display="";
				$("#myTab").prev().show();
				$("#tx").attr("src",horizon.paths.apppath+"/xuke/images/web/zuo.png");
				$(b).attr("iszan","true1");
				$("#zhong").removeClass("zhankai1");
				$("#zhong").removeClass("zhankai");
				$("#le").attr("class","floatclass8");
			//	$("#bdsh").attr("class","floatclass9"); 
				
			}else if($(b).attr("iszan")=="true1"){//三列，左右都展开
				$("#yingshow").hide();
				document.getElementById("myTab").style.display="none";
				$("#myTab").prev().hide();
				$("#tx").attr("src",horizon.paths.apppath+"/xuke/images/web/you.png");
				$(b).attr("iszan","false1");
				$("#zhong").removeClass("zhankai");
				$("#zhong").addClass("zhankai1");
				$("#le").attr("class","");
				//$("#bdsh").attr("class","floatclass9"); 
			}else{//两列，左展开
				//关闭
				$("#yingshow").hide();
				document.getElementById("myTab").style.display="none";
				$("#myTab").prev().hide();
				$("#tx").attr("src",horizon.paths.apppath+"/xuke/images/web/you.png");
				$(b).attr("iszan","false");
				$("#zhong").removeClass("zhankai1");
				$("#zhong").addClass("zhankai");
				$("#le").attr("class","");
				$("#bdsh").attr("class","floatclass7"); 
				$("#bdshls").attr("class","floatclass7"); 
			}
		}    
		
		function table(b){
			//当前业务为跨区域申请时，点击总标签，要去除所有子标签的active样式
			if(flowtye=="1"){
				$("#myTab li ul li").each(function(){
					$(this).removeClass("active");
				});
			}
			if($(b).attr("iszan")=="false"){
				//显示
				$(b).next().show();
				$(b).attr("iszan","true");
			}else{
				//关闭
				$(b).next().hide();
				$(b).attr("iszan","false");
			}
		}
		//绑定事件，填写表单字段审核意见和表单意见
		function bindOnclick1(){
	     $("#iframewz05").contents().find("div[class='subformflag']").attr("class","subformflag shenpi"); 
		
		
			$(".subformflag").removeClass("chakan");
			$(".subformflag").addClass("shenpi");
            $(".shenpi .tdclass ,.shenpi .fujianclass").click(function(){
			  //当前字段的状态，0 表示未选中，1 表示已选中，2 表示已保存，不能更改意见
			  var status = $(this).attr("newcolor");
			  var name = $(this).html();
			  /**去除&nbsp;、空格以及换行符**/
			  name = name.replace(/&nbsp;/gi,"");
			  name =name.replace(/\ +/g,"");
			  name =name.replace(/[\r\n]/g,"");
			  //获取当前表单id
			  var formid = $("#thisForm").val();
			  //获取字段的英文名
			  var eleName = "";
			  eleName = $(this).attr("name");
			  if(eleName==null || eleName=="null" || eleName=="undefined" || eleName==""){
				  var tdNext = $(this).next();
				  eleName = $(tdNext).find("[name^='"+formid+"']").attr("name");
			  }
			  //获取当前字段的坐标
			  var zuobiao = "";
			  var row = $(this).parent().index(); // 行位置
		      var col = $(this).index();//列位置
		      zuobiao = row+";"+col;
			  //获取当前div的有效的意见审核框
			  var thisdiv = $("#thisDiv").val();
			
			  var validziduan = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='ziduanname']");
			  var validziduanEng = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='ziduanEng']");
			  var validzuobiao = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='zuobiao']");
			  var text1 = $(validziduan).val();
			  var textEng = $(validziduanEng).val();
			  var textzuobiao = $(validzuobiao).val();
			  if(status==null || status=="" || status=="0"){
				  if(text1==""){
					text1 += name;
				  }else{
					text1 += ";"+name;
				  }
				  if(textEng==""){
					textEng += eleName;
				  }else{
					textEng += ";"+eleName;
				  }
				  if(textzuobiao==""){
					textzuobiao += zuobiao;
				  }else{
					textzuobiao += ","+zuobiao;
				  }
				  $(validziduan).val(text1);
				  $(validziduanEng).val(textEng);
				  $(validzuobiao).val(textzuobiao);
				  $(validziduan).attr("title",text1);
				  $(this).css("color",color1);
				  $(this).attr("newcolor","1");
			  }else if(status=="1"){
				  var text2 = text1.split(";"); 
				  for (var i = 0; i < text2.length; i++) {
					  if(name == text2[i]){
						text2.splice(i,1);
					  }
				  }
				  var text3=text2.join(";");
				  $(validziduan).val(text3);
				  $(validziduan).attr("title",text3);
				  
				  var engname = textEng.split(";");
				  for (var i = 0; i < engname.length; i++) {
					  if(eleName == engname[i]){
						engname.splice(i,1);
					  }
				  }
				  $(validziduanEng).val(engname.join(";"));
				  
				  var zuobiaoname = textzuobiao.split(",");
				  for (var i = 0; i < zuobiaoname.length; i++) {
					  if(zuobiao == zuobiaoname[i]){
						zuobiaoname.splice(i,1);
					  }
				  }
				  $(validzuobiao).val(zuobiaoname.join(","));
				  
				  $(this).css("color",color0);
				  $(this).attr("newcolor","0");
			  }else if(status=="2"){
			  		
			  }
		  });
		  
		  
		  
		 $("#iframewz05").contents().find(".shenpi .tdclass").click(function(){
			  
			  //当前字段的状态，0 表示未选中，1 表示已选中，2 表示已保存，不能更改意见
			  var status = $(this).attr("newcolor");
			  
			  var name = $(this).html();
			  
			  /**去除&nbsp;、空格以及换行符**/
			  name = name.replace(/&nbsp;/gi,"");
			  name =name.replace(/\ +/g,"");
			  name =name.replace(/[\r\n]/g,"");
			  //获取当前表单id
			  var formid = $("#thisForm").val();
			  
			  //获取字段的英文名
			  var eleName = "";
			  eleName = $(this).attr("name");
			  if(eleName==null || eleName=="null" || eleName=="undefined" || eleName==""){
				  var tdNext = $(this).next();
				  eleName = $(tdNext).find("[name^='"+formid+"']").attr("name");
			  }
			  
			  //获取当前字段的坐标
			  var zuobiao = "";
			  var row = $(this).parent().index(); // 行位置
		      var col = $(this).index();//列位置
		      zuobiao = row+";"+col;
			  //获取当前div的有效的意见审核框
			  var thisdiv = $("#thisDiv").val();
			
			  var validziduan = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='ziduanname']");
			  
			  
			  var validziduanEng = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='ziduanEng']");
			  
			  var validzuobiao = $("#shenhe"+thisdiv+" div[valid='valid'] input[name='zuobiao']");
			  
			  var text1 = $(validziduan).val();
			  
			  var textEng = $(validziduanEng).val();
			  
			  var textzuobiao = $(validzuobiao).val();
			  
			  if(status==null || status=="" || status=="0"){
				  if(text1==""){
					text1 += name;
				  }else{
					text1 += ";"+name;
				  }
				  if(textEng==""){
					textEng += eleName;
				  }else{
					textEng += ";"+eleName;
				  }
				  if(textzuobiao==""){
					textzuobiao += zuobiao;
				  }else{
					textzuobiao += ","+zuobiao;
				  }
				  $(validziduan).val(text1);
				  $(validziduanEng).val(textEng);
				  $(validzuobiao).val(textzuobiao);
				  $(validziduan).attr("title",text1);
				  $(this).css("color",color1);
				  $(this).attr("newcolor","1");
			  }else if(status=="1"){
				  var text2 = text1.split(";"); 
				  for (var i = 0; i < text2.length; i++) {
					  if(name == text2[i]){
						text2.splice(i,1);
					  }
				  }
				  var text3=text2.join(";");
				  $(validziduan).val(text3);
				  $(validziduan).attr("title",text3);
				  
				  var engname = textEng.split(";");
				  for (var i = 0; i < engname.length; i++) {
					  if(eleName == engname[i]){
						engname.splice(i,1);
					  }
				  }
				  $(validziduanEng).val(engname.join(";"));
				  
				  var zuobiaoname = textzuobiao.split(",");
				  for (var i = 0; i < zuobiaoname.length; i++) {
					  if(zuobiao == zuobiaoname[i]){
						zuobiaoname.splice(i,1);
					  }
				  }
				  $(validzuobiao).val(zuobiaoname.join(","));
				  
				  $(this).css("color",color0);
				  $(this).attr("newcolor","0");
			  }else if(status=="2"){
			  		
			  }
		  });
		  
		  
		}
		//绑定事件，查看该字段的所有审核历史意见
		function bindOnclick2(){
						  //获取当前div的有效的意见审核框
			 	  var thisdiv = $("#thisDiv").val();
			 	  //获取当前的formid
			 	  var thisformid = $("#thisForm").val();
			 	  //获取当前的workid
			 	  var thisWorkid = $("#thisWorkid").val();
			 	  //获取当前的sjid
			 	  var thisSjid = $("#thisSjid").val();
			 	  var shenhekuang = $("#lishikuang").val();
			 	  			  $.ajax({
					url :encodeURI(horizon.paths.apppath+"/xuke/getbdshenheyijianlishi.jsp?sjid="+thisSjid+"&formid="+thisformid+"&divid="+thisdiv+"&workid="+thisWorkid),
					type : "post",
					dataType : 'json',
					async : false,
					error : function() {
						alert("Error");
					},
					success : function(data) {
						$("#lishishenheyijian .index1").empty();
						$("#lishishenheyijian1 .index1").empty();
						$("#lishishenheyijian .index").empty();
						$("#lishishenheyijian1 .index").empty();
									var formname = "<span style='display:block;text-align:center;font-weight: bolder;'>历史表单意见</span>";
															if(shenhekuang=="zhuban"){
								$("#lishishenheyijian .index1").append(formname);
							}else if(shenhekuang=="yiban"){
								$("#lishishenheyijian1 .index1").append(formname);
							}
							
							if(data.flag!='fail'){
                                for(var j =0;j< data.lishi.length;j++){
								var addformHtml = "";
								var user = $("#right-menu div[class='row no-margin'] label:last-child span").html()+"";
				                if (user.indexOf("创建者") > 0) {
				                								addformHtml += "<div><div class='content_07'>";
										addformHtml += "<div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4;font-weight: bolder;'></span>"
												 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:middle'/><span>意见：</span></div>"
						     					 +"<div class='zuo_02'><span name='' cols='' rows=''>"+data.lishi[j].yj+"</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important;font-weight: bolder;' name='' cols='' rows=''>审核时间：</span>"
						     					+"<span style='height:auto!important' name='' cols='' rows=''>"+data.lishi[j].created+"</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important;font-weight: bolder;' name='' cols='' rows=''>意见字段(点击具体字段查看)：</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important' name='' cols='' rows=''>"+data.lishi[j].ziduan+"</span></div>";
										addformHtml += "</div></div></div>";
				                }
								else{
								addformHtml += "<div><div class='content_07'>";
										addformHtml += "<div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4;font-weight: bolder;'>"+data.lishi[j].nodename+"</span>"
												 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:middle'/><span>意见：</span></div>"
						     					 +"<div class='zuo_02'><span name='' cols='' rows=''>"+data.lishi[j].yj+"</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important;font-weight: bolder;' name='' cols='' rows=''>审核时间：</span>"
						     					+"<span style='height:auto!important' name='' cols='' rows=''>"+data.lishi[j].created+"</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important;font-weight: bolder;' name='' cols='' rows=''>意见字段(点击具体字段查看)：</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important' name='' cols='' rows=''>"+data.lishi[j].ziduan+"</span></div>";
										addformHtml += "</div></div></div>";
										}
	                            if(shenhekuang=="zhuban"){
								$("#lishishenheyijian .index1").append(addformHtml);
							}else if(shenhekuang=="yiban"){
								$("#lishishenheyijian1 .index1").append(addformHtml);
							}
	}
	
	}
	
	}
		});
		
		
			  $("div[class='subformflag']").addClass("chakan");
			  $(".subformflag").removeClass("shenpi");
			  $(".subformflag").addClass("chakan");
		      $(".chakan .tdclass,.chakan .fujianclass").click(function(){
				  //获取字段的英文名
				  var eleName = "";
				  eleName = $(this).attr("name");
				  if(eleName==null || eleName=="null" || eleName=="undefined" || eleName==""){
					  var tdNext = $(this).next();
					  eleName = $(tdNext).find("[name^='"+thisformid+"']").attr("name");
				  }
				  //获取坐标
				  var zuobiao = "";
				  var row = $(this).parent().index(); // 行位置
			      var col = $(this).index();//列位置
			      zuobiao = row+";"+col;
				  //获取字段的中文名
				  var ziduanname = $(this).html();
				  /**去除&nbsp;、空格以及换行符**/
				  ziduanname = ziduanname.replace(/&nbsp;/gi,"");
				  ziduanname = ziduanname.replace(/\ +/g,"");
				  ziduanname = ziduanname.replace(/[\r\n]/g,"");
				  $.ajax({
					url :encodeURI(horizon.paths.apppath+"/xuke/getshenheyijianlishi.jsp?sjid="+thisSjid+"&formid="+thisformid+"&divid="+thisdiv+"&workid="+thisWorkid+"&elename="+eleName+"&ziduan="+ziduanname+"&zuobiao="+zuobiao),
					type : "post",
					dataType : 'json',
					async : false,
					error : function() {
						alert("Error");
					},
					success : function(data) {
						$("#lishishenheyijian .index").empty();
						$("#lishishenheyijian1 .index").empty();
						var flag = data.flag;
						if(flag=="success"){
							var zdname = "<span style='display:block;text-align:center;font-weight: bolder;'>栏目名称:"+ziduanname+"</span>";
							if(shenhekuang=="zhuban"){
								$("#lishishenheyijian .index").append(zdname);
							}else if(shenhekuang=="yiban"){
								$("#lishishenheyijian1 .index").append(zdname);
							}
							for(var type in data.lishi){
								var addHtml = "";
								addHtml += "<div><div class='content_07'>";
								for(var j =0;j< data.lishi[type].picilist.length;j++){
									 if(j==data.lishi[type].picilist.length-1){
										addHtml += "<div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4;font-weight: bolder;'>"+data.lishi[type].picilist[j].nodename+"</span>"
												 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:middle'/><span>意见：</span></div>"
						     					 +"<div class='zuo_02'><span name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</span></div>"
						     					+"<div class='zuo_01' style='height:auto!important;padding-left:0px!important'><span style='height:auto!important;font-weight: bolder;' name='' cols='' rows=''>审核时间：</span>"
						     					+"<span style='height:auto!important' name='' cols='' rows=''>"+data.lishi[type].picilist[j].created+"</span></div>";
										if(data.lishi[type].hislist.length>0){
											addHtml += "<span>修改时间："+data.lishi[type].hislist[0].created+"</span><br>";
											for(var m =0;m<data.lishi[type].hislist.length;m++){
												if(data.lishi[type].hislist[m].dtcomment==""){
													var oldval = data.lishi[type].hislist[m].oldval;
													var newval = data.lishi[type].hislist[m].newval;
													if(oldval=="" && newval!=""){
														addHtml += "<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
													}else if(oldval!="" && newval==""){
														addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>";
													}else{
														addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>"
																+"<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
													}
												}else if(data.lishi[type].hislist[m].dtcomment=="动态表格增加数据" || data.lishi[type].hislist[m].dtcomment=="动态表格删除数据"){
													addHtml += "<span style='color:orange;font-weight:bold;'>修改内容：</span><span>"+data.lishi[type].hislist[m].dtcomment+"</span><br>";
												}else{
													var oldval = data.lishi[type].hislist[m].oldval;
													var newval = data.lishi[type].hislist[m].newval;
													addHtml += "<span style='color:orange;font-weight:bold;'>修改内容：</span><span>"+data.lishi[type].hislist[m].dtcomment+"</span><br>";
													if(oldval=="" && newval!=""){
														addHtml += "<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
													}else if(oldval!="" && newval==""){
														addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>";
													}else{
														addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>"
																+"<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
													}
												}
											}
										}
										addHtml += "</div></div></div>";
									}
									else if(j==0){
										 addHtml += "<div class='zuo head' style='border-top:1px #CCCCCC dotted;'><div class='zuo_01'><span style='color:#a36bc4'>"+data.lishi[type].picilist[j].nodename+"</span>"
												 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:bottom'/><span>意见：</span></div>"
						     					 +"<div class='zuo_02'><textarea name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</textarea></div>"
						     					+"<div class='zuo_01'><textarea name='' cols='' rows=''>审核时间："+data.lishi[type].picilist[j].created+"</textarea></div>";
									}else{
										 addHtml += "<div class='content_07'><div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4'>"+data.lishi[type].picilist[j].nodename+"</span>"
												 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:bottom'/><span>意见：</span></div>"
						     					 +"<div class='zuo_02'><textarea name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</textarea></div>"
						     					+"<div class='zuo_01'><textarea name='' cols='' rows=''>审核时间："+data.lishi[type].picilist[j].created+"</textarea></div>";
									}
								}
								if(shenhekuang=="zhuban"){
									$("#lishishenheyijian .index").append(addHtml);
								}else if(shenhekuang=="yiban"){
									$("#lishishenheyijian1 .index").append(addHtml);
								}
							}
						}else if(flag=="fail"){
							var addHtml = "<span style='display:block;text-align:center'>栏目名称:"+ziduanname+"</span><br><span style='display:block;text-align:center'>无历史审核意见!<span>";
							if(shenhekuang=="zhuban"){
								$("#lishishenheyijian .index").append(addHtml);
							}else if(shenhekuang=="yiban"){
								$("#lishishenheyijian1 .index").append(addHtml);
							}
						}						
					}
				 });	
		  });
		}
		function showdiv(){
		  $("#you").show();
		  //缩小表单的宽度
		  $("#zhong").removeClass("floatclass3");
		  $("#zhong").addClass("shousuosh");
		  //组合选定法   .class1 .class2
		  bindOnclick1();
		}
		function showdivls(){
		  $("#youls").show();
		  //缩小表单的宽度
		  $("#zhong").removeClass("floatclass3");
		  $("#zhong").addClass("shousuosh");
		  //组合选定法   .class1 .class2
		  bindOnclick2();
		}

		function hidediv(){
			$("#you").hide();
			//增加表单宽度
		    $("#zhong").removeClass("shousuosh");
		    $("#zhong").addClass("floatclass3");
			//解绑click事件
			$("div[class='subformflag']").removeClass("shenpi");
			$("div[class='subformflag']").removeClass("chakan");
			$(".tdclass,.fujianclass").unbind("click");
		}
		function hidedivls(){
			$("#youls").hide();
			//增加表单宽度
		    $("#zhong").removeClass("shousuosh");
		    $("#zhong").addClass("floatclass3");
			//解绑click事件
			$("div[class='subformflag']").removeClass("chakan");
			$(".tdclass,.fujianclass").unbind("click");
		}
	
	//点击流程跟踪菜单，显示流程跟踪页面
	function showflow(){
		$("#zhong>div").each(function(){
			$(this).removeClass("active");
			$(this).removeClass("in");
		});
		$("#FlowTrack").addClass("active");
		$("#FlowTrack").addClass("in");
	}
	
	
		//点击流程跟踪菜单，显示流程跟踪页面
	function showswxx(){
		$("#zhong>div").each(function(){
			$(this).removeClass("active");
			$(this).removeClass("in");
		});
		$("#HZ2882fd65c14adb0165c1582c1f0008").addClass("active");
		$("#HZ2882fd65c14adb0165c1582c1f0008").addClass("in");
	}
	
	
			//点击流程跟踪菜单，显示流程跟踪页面
	function showymxx(){
		$("#zhong>div").each(function(){
			$(this).removeClass("active");
			$(this).removeClass("in");
		});
		$("#HZ808081661398ed016613c3989608ec").addClass("active");
		$("#HZ808081661398ed016613c3989608ec").addClass("in");
	}
	
	function serchshenhequanxian(yewucode)
	{
       var flag=false;
	  
	  		$.ajax( {
			url : horizon.paths.apppath+'/xuke/checkshenhequanxian.jsp?yewucode='
					+ encodeURI(yewucode) +'&nodeid='+nodeId+'&userid='+userid+'&flowid='
					+ flowId+'&workidls='+workidls,
			type : "post",
			dataType : 'json',
			async : false,
			error : function() {
			},
			success : function(data) {
				if(data.flag=='0'){
					
					flag = true;
				}
			}
		});  
		
		return flag;
	  
	}
	
	
	
	//点击左侧菜单，右边的表单相应的变化
	function showdiv1(a,formcode,formid,yewucode){
		//点击左侧的子标签显示相应form表单
		$("#zhong>div").each(function(){
			$(this).removeClass("active");
			$(this).removeClass("in");
		});
		$("#"+formid).addClass("active");
		$("#"+formid).addClass("in");
		
		$("#myTab li ul li").each(function(){
			$(this).removeClass("active");
		});
		$(a).parent().addClass("active");
		//结合神内和跨地区
		
		var formcodez=formcode.replace(/A/g, "K");
	    formcodez=formcodez.replace(/S/g, "B");
		
		//隐藏和显示对应的表单
		$("div[id^='"+formcodez+"']").each(function(){
			$(this).hide();
		});
		var yewucodez=yewucode.replace(/A/g, "K");
	    yewucodez=yewucodez.replace(/S/g, "B");
		$("#liandivid").val(yewucodez);
		$("#youding").val(yewucode);
		 $("div[id='"+yewucodez+"']").show(); 
		/* $("div[id='yijian']").show(); */ 
		var sjid = $("#thisSjid").val();
		var nodename = $("input[name='nodeName']").val();
		var workid = $("#thisWorkid").val();
		var nodeid = $("input[name='nodeId']").val();
		//动态调用接口验证方法
		try{
			 eval(yewucodez+"InterfaceCheck"+"();");
        }catch(err){
        	
        }
		var text="";
/* 		if(yewucode.substring(0,1)=='K'||yewucode.substring(0,1)=='B'){
			text="跨地区";
		}else if(yewucode.substring(0,1)=='A'||yewucode.substring(0,1)=='S'){
			text="省内";
		} */
		
		$("h4").find("span").each(function(){
			var value=$(this).html();
			var newValue=value.replace(text,"");
			var el=text+newValue;
			$(this).html(el);
			
		});
		if(!istuihui && isZhuban && haslimit &&yewucode.substr(yewucode.length-2)!='YD'){
		
	
		
		if(quanxian)
		{
				
			
			//先关闭右侧的审核框
			hidediv();
			showdiv();
			//默认显示审核框的第一个页签
			changeYeqian1("0");
			
			
			
			
		
		}
		else{
		
				var flag=serchshenhequanxian(yewucode);
			
			//先关闭右侧的审核框
			hidediv();
			if(flag==true)
			{
			//再打开右边的审核框
			showdiv();
			$("#bdsh").show();
			}
			else
			{
			//隐藏审核表单的button
			$("#bdsh").hide();
			}
			//默认显示审核框的第一个页签
			changeYeqian1("0");
		}

		}
		if(!istuihui && yewucode=="K00K02"){
			$("a[name='yanzheng']").each(function(){
				$(this).show();
			});
		}
		/***当前用户身份是主办人，并且不是退回到企业申请阶段时，加载右侧的表单审核意见框***/
		//alert(isZhuban);
		if(isZhuban && !istuihui&&yewucode.substr(yewucode.length-2)!='YD'){
			//查询是否有该表单的相关的字段审核意见
			$.ajax({
				url :encodeURI(horizon.paths.apppath+"/xuke/getshenheyijian.jsp?sjid="+sjid+"&formid="+formid+"&divid="+yewucode+"&nodename="+nodename+"&workid="+workid+"&nodeid="+nodeid),
				type : "post",
				dataType : 'json',
				async : false,
				error : function() {
					alert("Error");
				},
				success : function(data) {
					var flag= data.flag;
					var flag1= data.flag1;
					var biaodanyijian = data.biaodanyijian;
					var biaodanremark = data.biaodanremark;
					//上一批次的意见
					var lastpici = data.lastpici;
					//上一批次的意见坐标
					var lastpicizuobiao = data.lastpicizuobiao;

					var contentdivid=data.contentdivid;
					//flag为success 表明数据库中已有该表单的字段意见，需显示这些审核意见
					if(flag=="success"){
						var list = data.list;//本批次的意见
						var list1 = data.list1;
						//先清空右边的审核意见单
						$("#shenhe"+yewucode+" #divshenhe"+yewucode).empty();
						for(var type=0;type<list.length;type++){
							//显示已有的审核意见
							if(contentdivid!=null&&contentdivid!=""){
								var number=(parseInt(list[type].contentdivid)+1).toString();
								var shenhehtml = "<div valid='invalid'><div class='guding_01'><ul class='ui2clss'><li style='border-bottom:1px #FFFFFF solid'><a>填写信息项意见(第"+number+"张表)</a></li>"
									+"<li style='border-bottom:1px #FFFFFF solid;height:50px;padding:0px'>"
									+"<input type='text' name='ziduanid' style='display:none;' value='"+list[type].id+"'/> "
									+"<input type='text' name='ziduanEng' style='display:none;'/><input type='text' name='zuobiao' style='display:none;'/>"
									+"<span class='shyj'>栏目名称：</span><input type='text' name='ziduanname' readonly='readonly' style='margin-top:8px;width:58%' value='"+list[type].ziduanname+"' title='"+list[type].ziduanname+"'/>"
									+"</li><li style=''><span class='shyj'>修改意见：</span><textarea type='text' readonly='readonly' name='yijian' style='margin-top:8px;width:58%;height:auto;' value='"+list[type].yijian+"'>"+list[type].yijian+"</textarea>"
									+"</li></ul></div><div class='guding_02'>"
									+"<input type='button' value='确定' class='anniu_02' onclick='saveYijian(this);' disabled='disabled'>"
									+"<input type='button' onclick='deleteYijian(this);' value='删除' class='anniu_02' style='background-color:#68a942'>"
									+"</div></div>";
							}else{
								var shenhehtml = "<div valid='invalid'><div class='guding_01'><ul class='ui2clss'><li style='border-bottom:1px #FFFFFF solid'><a>填写信息项意见</a></li>"
												+"<li style='border-bottom:1px #FFFFFF solid;height:50px;padding:0px'>"
												+"<input type='text' name='ziduanid' style='display:none;' value='"+list[type].id+"'/> "
												+"<input type='text' name='ziduanEng' style='display:none;'/><input type='text' name='zuobiao' style='display:none;'/>"
												+"<span class='shyj'>栏目名称：</span><input type='text' name='ziduanname' readonly='readonly' style='margin-top:8px;width:58%' value='"+list[type].ziduanname+"' title='"+list[type].ziduanname+"'/>"
												+"</li><li style=''><span class='shyj'>修改意见：</span><textarea type='text' readonly='readonly' name='yijian' style='margin-top:8px;width:58%;height:auto;' value='"+list[type].yijian+"'>"+list[type].yijian+"</textarea>"
												+"</li></ul></div><div class='guding_02'>"
												+"<input type='button' value='确定' class='anniu_02' onclick='saveYijian(this);' disabled='disabled'>"
												+"<input type='button' onclick='deleteYijian(this);' value='删除' class='anniu_02' style='background-color:#68a942'>"
												+"</div></div>";
							}
							$("#shenhe"+yewucode+" #divshenhe"+yewucode).append(shenhehtml);
							//将已保存的意见的相关表单字段颜色置为红色
							var ziduanzuobiao = list[type].zuobiao;
							var zuobiaoarr = ziduanzuobiao.split(",");
							for(var i=0;i<zuobiaoarr.length;i++){
								var arr1 = zuobiaoarr[i].split(";");
								//下文主要是业务表单中的有意见的字段变色的方式，神内的改为跨地区的表单编码
								var wrongele = $("#"+formid+" #"+yewucodez).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")");
								$(wrongele).css("color",color2);
								$(wrongele).attr("newcolor","2");
							}
						}
						//最后增加一个空白的意见填写框
						//alert("元素："+$("#biaodanyjdiv input[name='yijian']").length);
						$("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
						var beiyonghtml = $("#biaodanyjdiv").html();
						var kongbaihtml = "<div valid='valid'>"+beiyonghtml+"</div>";
						$("#shenhe"+yewucode+" #divshenhe"+yewucode).append(kongbaihtml);
					}
					if(flag=="fail"){
					   $("#shenhe"+yewucode+" #divshenhe"+yewucode+" input[name='yijian']").removeAttr("readonly");
					}
					if(flag1=="success"){
						
						//将已保存的意见的相关表单字段背景颜色置为蓝色
						var zuobiaoarr = lastpicizuobiao.split(",");
						for(var i=0;i<zuobiaoarr.length;i++){
							var arr1 = zuobiaoarr[i].split(";");
							var wrongele = $("#"+formid+" #"+yewucodez).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")");
							$(wrongele).css("background-color","#b3d3f3");
						}
					}
					/**给右侧的表单意见赋值**/
					if(biaodanyijian!=""){
						$("#shenhe"+yewucode+" select").val(biaodanyijian);
						$("#shenhe"+yewucode+" input[name='bdbeizhu']").val(biaodanremark);
						$("#shenhe"+yewucode+" #hehehe").text(biaodanremark);
					} 
				}
			});	
			//隐藏和显示对应的审核意见填写框
			$("div[id^='shenhe']").each(function(){
				$(this).hide();
			});
			$("#shenheyijian").hide();
			$("#shenhe"+yewucode).show();
		}
		
		//给相关字段赋值，以便于保存审核意见时取值
		$("#thisForm").val(formid);
		$("#thisDiv").val(yewucode);
		//当退回到开始节点时，查询该模块的审核意见，用红色标明哪些字段是有审核意见的
		if(istuihui){
			$.ajax({
				url :encodeURI(horizon.paths.apppath+"/xuke/getshyjForTuihui.jsp?sjid="+sjid+"&formid="+formid+"&divid="+yewucode+"&workid="+workid),
				type : "post",
				dataType : 'json',
				async : false,
				error : function() {
					alert("Error");
				},
				success : function(data) {
					var ziduanname = data.ziduan;
					var ziduanengall = data.ziduaneng;
					var zuobiaoall = data.zuobiao;
					if(ziduanname==null || ziduanname=="null"){
						ziduanname = "";
					}
					if(ziduanengall==null || ziduanengall=="null"){
						ziduanengall = "";
					}
					if(zuobiaoall==null || zuobiaoall=="null"){
						zuobiaoall = "";
					}
					var zuobiaoArr = zuobiaoall.split(",");
					for(var i=0;i<zuobiaoArr.length;i++){
						var arr1 = zuobiaoArr[i].split(";");
						//根据行和列找到相应的位置，设置颜色，使用yewucodez，做省内的兼容方式；
						var wrongele = $("#"+formid+" #"+yewucodez).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")");
						$(wrongele).css("color",color2);
						$(wrongele).attr("newcolor","2");
						
						//添加评测机房视图链接按钮
// 						if(yewucode.substring(0,3)=='P04'){
// 							if($("#pingcejf1").attr("newcolor")=="2"){
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_JIFANGNAME']").parent().find("label").attr("style","border-color: rgb(242, 166, 150");
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_JIFANGNAME']").parent().attr("class","input-group ");
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_JIFANGNAME']").prev().after("<span class='input-group-btn'><button class='link_button'onclick='goBendijifang()'type='button'><i class='ace-icon fa fa-location-arrow bigger-110'></i></button></span>");
// 							}
// 							if($("#pingcejf2").attr("newcolor")=="2"){
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_YIDIJIFANGMINGCHENG']").parent().find("label").attr("style","border-color: rgb(242, 166, 150");
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_YIDIJIFANGMINGCHENG']").parent().attr("class","input-group ");
// 								$("input[name='HZ8ba0fe62bdb8000162bdd7fb25002c_YIDIJIFANGMINGCHENG']").prev().after("<span class='input-group-btn'><button class='link_button'onclick='goYidijifang()'type='button'><i class='ace-icon fa fa-location-arrow bigger-110'></i></button></span>");
// 							}
// 						}else if(yewucode.substring(0,3)=='P06'){
// 							if($("#pingcejf1").attr("newcolor")=="2"){
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_JIFANGNAME']").parent().find("label").attr("style","border-color: rgb(242, 166, 150");
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_JIFANGNAME']").parent().attr("class","input-group ");
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_JIFANGNAME']").prev().after("<span class='input-group-btn'><button class='link_button'onclick='goBendijifang()'type='button'><i class='ace-icon fa fa-location-arrow bigger-110'></i></button></span>");
// 							}
// 							if($("#pingcejf2").attr("newcolor")=="2"){
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_YIDIJIFANGMINGCHENG']").parent().find("label").attr("style","border-color: rgb(242, 166, 150");
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_YIDIJIFANGMINGCHENG']").parent().attr("class","input-group ");
// 								$("input[name='HZ8ba0a262f5304a0162f536d4a60049_YIDIJIFANGMINGCHENG']").prev().after("<span class='input-group-btn'><button class='link_button'onclick='goYidijifang()'type='button'><i class='ace-icon fa fa-location-arrow bigger-110'></i></button></span>");
// 							}
// 						}
						
						//该元素绑定点击事件
						$(wrongele).click(function(){
							//获取该表单字段对应的英文名称
						   var eleName = "";
						   eleName = $(this).attr("name");
						   if(eleName==null || eleName=="null" || eleName=="undefined" || eleName==""){
							  var tdNext = $(this).next();
							  eleName = $(tdNext).find("[name^='"+formid+"']").attr("name");
						   }
							//获取该表单字段的中文名称
							var ziduan = $(this).html();
							//去除&nbsp;、空格以及换行符
							ziduan = ziduan.replace(/&nbsp;/gi,"");
							ziduan = ziduan.replace(/\ +/g,"");
							ziduan = ziduan.replace(/[\r\n]/g,"");
							//获取该td的坐标
							var zuobiao = "";
							var row = $(this).parent().index(); // 行位置
						    var col = $(this).index();//列位置
						    zuobiao = row+";"+col;
							$(".department").show();
							$("#le").attr("class","floatclass8");
							$("#bdsh").attr("class","floatclass9");
						 	var iszanValue = $("#le div a").attr("iszan");
							if(iszanValue=="true"){//左边有两列
								$("#le div a").attr("iszan","true1");
							}else if(iszanValue=="false"){//左边有一列
								$("#le div a").attr("iszan","false1");
							} 
							//根据字段名，从后台加载最近一次的审核意见和历史的审核意见
							$.ajax({
								url :encodeURI(horizon.paths.apppath+"/xuke/getshyjXin.jsp?sjid="+sjid+"&formid="+formid+"&divid="+yewucode+"&workid="+workid+"&ziduan="+ziduan+"&elename="+eleName+"&zuobiao="+zuobiao),
								type : "post",
								dataType : 'json',
								async : false,
								error : function() {
									alert("Error");
								},
								success : function(data) {
									var flag1 = data.flag1;
									if(flag1=="success"){
										$("#xinshyj ul").empty();
										$("#xinshyj ul").append("<li><span class='kuang_01'>栏目名称</span><input readonly='readonly' type='text' value='"+ziduan+"' /></li>");
										for(var node=0; node<data.list.length;node++){
											$("#xinshyj ul").append("<li style='display:none'><span class='kuang_01'>岗位</span><input type='text' readonly='readonly' value='"+data.list[node].nodename+"'/>"
															+"</li><li><span class='kuang_01'>修改意见</span><textarea value='"+data.list[node].yijian+"' type='text' rows='5' readonly='readonly' style='height:auto!important;'>"+data.list[node].yijian+"</textarea></li>");
										} 
									}
									var flag2 = data.flag2;
									if(flag2=="success"){
										$("#lishishyj .index").empty();
										var zdname = "<span style='display:block;text-align:center'>栏目名称:"+ziduan+"</span>";
										$("#lishishyj .index").append(zdname);
											for(var type in data.lishi){
												var addHtml = "";
												// style='border-top:1px #CCCCCC dotted;'
												addHtml += "<div ><div class='content_07'>";
												for(var j =0;j< data.lishi[type].picilist.length;j++){
													if(j==data.lishi[type].picilist.length-1){
														addHtml += "<div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4'>"+"</span>"
																 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:bottom'/><span>意见：</span></div>"
										     					 +"<div class='zuo_02'><textarea name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</textarea></div>"
										     					 +"<div class='zuo_01'><textarea name='' cols='' rows=''>审核时间："+data.lishi[type].picilist[j].created+"</textarea></div>";
										     			/* if(data.lishi[type].bh!=""){
															addHtml += "<span>修改时间："+data.lishi[type].created+"</span><br><span>修改内容："+data.lishi[type].bh+"</span></div></div></div>";
														}else{
															addHtml += "</div></div></div>";
														} */	
														if(data.lishi[type].hislist.length>0){
															addHtml += "<span>修改时间："+data.lishi[type].hislist[0].created+"</span><br>";
															for(var m =0;m<data.lishi[type].hislist.length;m++){
																if(data.lishi[type].hislist[m].dtcomment==""){
																	var oldval = data.lishi[type].hislist[m].oldval;
																	var newval = data.lishi[type].hislist[m].newval;
																	if(oldval=="" && newval!=""){
																		addHtml += "<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
																	}else if(oldval!="" && newval==""){
																		addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>";
																	}else{
																		addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>"
																				+"<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
																	}
																}else if(data.lishi[type].hislist[m].dtcomment=="动态表格增加数据" || data.lishi[type].hislist[m].dtcomment=="动态表格删除数据"){
																	addHtml += "<span style='color:orange;font-weight:bold;'>修改内容：</span><span>"+data.lishi[type].hislist[m].dtcomment+"</span><br>";
																}else{
																	var oldval = data.lishi[type].hislist[m].oldval;
																	var newval = data.lishi[type].hislist[m].newval;
																	addHtml += "<span style='color:orange;font-weight:bold;'>修改内容：</span><span>"+data.lishi[type].hislist[m].dtcomment+"</span><br>";
																	if(oldval=="" && newval!=""){
																		addHtml += "<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
																	}else if(oldval!="" && newval==""){
																		addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>";
																	}else{
																		addHtml +="<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>"
																				+"<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>";
																	}
																	/* addHtml += "<span style='color:orange;font-weight:bold;'>修改内容：</span><span>"+data.lishi[type].hislist[m].dtcomment+"</span><br>"
																			+"<span style='color:orange;font-weight:bold;'>修改前：</span><span>"+oldval+"</span><br>"
																			+"<span style='color:orange;font-weight:bold;'>修改后：</span><span>"+newval+"</span><br>"; */
																}
																
															}
														}
														addHtml += "</div></div></div>";
													}
													else if(j==0){
														 addHtml += "<div class='zuo head' style='border-top:1px #CCCCCC dotted;'><div class='zuo_01'><span style='color:#a36bc4'>"+"</span>"
																 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:bottom'/><span>意见：</span></div>"
										     					 +"<div class='zuo_02'><textarea name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</textarea></div></div>"
										     					 +"<div class='zuo_01 zuo'><textarea name='' cols='' rows=''>审核时间："+data.lishi[type].picilist[j].created+"</textarea></div>";
													}else{
														 addHtml += "<div class='content_07'><div class='zuo head'><div class='zuo_01'><span style='color:#a36bc4'>"+"</span>"
																 +"<img src='../../../workflow/module/workflow/yijian.png' height='15' style='margin-right:1%;margin-left:3%; vertical-align:bottom'/><span>意见：</span></div>"
										     					 +"<div class='zuo_02'><textarea name='' cols='' rows=''>"+data.lishi[type].picilist[j].yijian+"</textarea></div></div>"
										     					 +"<div class='zuo_01'><textarea name='' cols='' rows=''>审核时间："+data.lishi[type].picilist[j].created+"</textarea></div>";
													}
												}
												$("#lishishyj .index").append(addHtml);
											}
									}
									//flag为success 表明数据库中已有该表单的字段意见，需显示这些审核意见
								}
							});	
						});
						
					}
					
					//使用yewucodez，做省内的兼容方式；
					var firstyewucode=yewucodez.substring(0,1);
					if(firstyewucode!="P"){
						$("#"+formid+" #"+yewucodez).find("table").children("tbody").children("tr").children("td").each(function(){
							//数字框替换
							if($(this).find("input[data-type='number']").length>0 && $(this).find("table").length<=0){
								$(this).find("i[class='ace-icon glyphicon glyphicon-pencil']").remove();
								$(this).find("input[data-type='number']").each(function(){
									var inputName = $(this).attr("name");
									if(typeof(inputName)!='undefined'){
									var dtformid=inputName.split('_')[0];
									if(dtformid==formid){
									if(ziduanengall.indexOf(inputName)<0){
										var inputValue = $(this).val();
											if(typeof(inputValue)!='undefined'){
										$(this).parent().after("<div class='form-group no-margin '><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div");
										$(this).parent().remove();
										}
									}
									}
									}
								});
							}
							//input框替换
							if($(this).find("input[type='text']").length>0 && $(this).find("table").length<=0){
								var fromid=$("input[name='FORMID']").val();
								$(this).find("input[type='text']").each(function(){
									var inputName = $(this).attr("name");
									if(typeof(inputName)!='undefined'){
									var dtformid=inputName.split('_')[0];
									if(dtformid==formid){
									if(ziduanengall.indexOf(inputName)<0){
										var inputValue = $(this).val();
											if(typeof(inputValue)!='undefined'){
										$(this).parent().after("<div class='form-group no-margin '><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div");
										$(this).parent().remove();
										}
									}
									}
									}
								});
							}
							
							//文本替换
							if($(this).find("textarea").length>0 && $(this).find("table").length<=0){	
								$(this).find("textarea").each(function(){
									var inputName = $(this).attr("name");
									if(typeof(inputName)!='undefined'){
										var dtformid=inputName.split('_')[0];
										if(dtformid==formid){
									if(ziduanengall.indexOf(inputName)<0){
										var inputValue = $(this).val();
										if(typeof(inputValue)!='undefined'){
										$(this).parent().after("<div class='form-group no-margin '><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div>");
										$(this).parent().remove();
										}
									}
										}
									}
								}); 
							}
							
							//百度edit替换 wb 0402 测试前端退回不能编辑
// 					 		if($(this).find("[id^='ueditor']").contents().find("body[contenteditable='true']").length>0){
// 								$(this).find("[id^='ueditor']").contents().find("body[contenteditable='true']").attr("contenteditable",false);
// 								$(this).find("[id^='ueditor']").contents().find("body[contenteditable='false']").attr("style","overflow-y: hidden; height: 90px; cursor: not-allowed;");
// 								$(this).find("[id$='toolbarbox']").addClass("hidebox");
// 								$(this).find("[id$='bottombar']").hide();
// 							}  
							
							
							
							//下拉框替换
							if($(this).find("select").length>0 && $(this).find("table").length<=0){
								$(this).find("select").each(function(){
									var inputName = $(this).attr("name");
									if(typeof(inputName)!='undefined'){
										var dtformid=inputName.split('_')[0];
										if(dtformid==formid){
									if(ziduanengall.indexOf(inputName)<0){
										var inputValue = $(this).next().find("span").html();
										if(inputValue=="请选择"){
											inputValue = "";
										}
										if(typeof(inputValue)!='undefined'){
										$(this).parent().parent().after("<div class='form-group no-margin'><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div>");
										$(this).parent().parent().remove();
										}
									}
										}
									}
								});
							}
							//单选框替换
							if($(this).find("input[type='radio']").length>0 && $(this).find("table").length<=0){
								var inputName = $(this).find("input[type='radio']:first").attr("name");
								if(typeof(inputName)!='undefined'){
									var dtformid=inputName.split('_')[0];
									if(dtformid==formid){
								if(ziduanengall.indexOf(inputName)<0){
								var inputValue = "";
									if($(this).find("input[type='radio']:checked").length>0){
										
										inputValue = $(this).find("input[type='radio']:checked").val();
									}
									if(inputValue!=''&&typeof(inputValue)!='undefined'){
									var divEle = $(this).children("div");
									divEle.empty();
									divEle.append("<label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'>");
								}
								}
									}
								}
							}
							//复选框替换
							if($(this).find("input[type='checkbox']").length>0 && $(this).find("table").length<=0){
								//获取该字段的name属性
								var inputName = $(this).find("input[type='checkbox']:first").attr("name");
								if(typeof(inputName)!='undefined'){
									var dtformid=inputName.split('_')[0];
									if(dtformid==formid){
								if(ziduanengall.indexOf(inputName)<0){
									//获取选中的值
									 var chk_value = [];
									 var inputValue = "";
									 if($(this).find("input[type='checkbox']").length>0){
										 $(this).find("input[type='checkbox']:checked").each(function(){
										 	   chk_value.push($(this).val());    
										 });
										if(chk_value.length!=0){
										 	inputValue = chk_value.join(";");
										 }
									 }
									 if(inputValue!=''&&typeof(inputValue)!='undefined'){
									 $("input[name='"+inputName+"']").attr("disabled",true);
									 var inputEle = $(this).find("input[type='checkbox']").eq(0);
									var divEle = $(inputEle).parent().parent().parent();
									divEle.append("<input name='"+inputName+"' type='hidden' value='"+inputValue+"'>"); 
									 }
								
								}else{
									$("input[name='"+inputName+"']").attr("disabled",false);
								}
									}
								}
							} 
							//附件替换
							if($(this).find("input[data-type='file']").length>0 && $(this).find("table").length<=0){
								 var inputEle = $(this).find("div[class='form-group no-margin '] label[class='ace-file-input form-control'] input");
								var inputName = $(inputEle).attr("name");
								if(typeof(inputName)!='undefined'){
									var dtformid=inputName.split('_')[0];
									if(dtformid==formid){
								if(ziduanengall.indexOf(inputName)<0){
									if($(this).find("a[data-action='delete']").length>0){
										$(this).find("a[data-action='delete']").remove();
									}
									var maxLength = $(inputEle).attr("maxlength");
									var dataType = $(inputEle).attr("data-type");
									var dataExtension = $(inputEle).attr("data-extension");
									var labelEle = $(this).find("div[class='form-group no-margin '] label[class='ace-file-input form-control']");
									$(labelEle).replaceWith("<input name='"+inputName+"' type='hidden' maxlength='"+maxLength+"' data-type='"+dataType+"' data-extension='"+dataExtension+"'>");
								}
									}
								}
							}
						});
						
						//动态表格替换
						$("#"+formid+" #"+yewucodez+" table tr td").each(function(){
							
							if($(this).find("table").length>0 && ziduanengall.indexOf($(this).attr("name"))<0){
								var tableEle = $(this).find("table");
								var tableEleid =$(tableEle).attr("id");
								tableEle="[id='"+tableEleid+"']";
								$(tableEle).find("thead tr th:last-child").hide();
								$(tableEle).find("tbody tr").each(function(){
									$(this).find("td:last-child").hide();
								});
								$(tableEle).find("tbody tr").not(".hidden,.center").each(function(){
									$(this).find("td").each(function(){
										 var spanEle = $(this).find("div[class^='form-group no-margin'] span");
										 var ss = $(this).find("div[class^='form-group no-margin']");
									     if($(spanEle).children("input").length>0){
											var inputValue = $(this).find("input").val();
											var inputName = $(this).find("input").attr("name");
											if(typeof(inputValue)!='undefined'){
											$(this).children("div").remove();
											$(this).append("<div class='form-group no-margin '><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div>");
									     }
									     }	
										if($(spanEle).children("textarea").length>0){
											var inputValue = $(this).find("textarea").val();
											var inputName = $(this).find("textarea").attr("name");
												if(typeof(inputValue)!='undefined'){
											$(this).children("div").remove();
											$(this).append("<div class='form-group no-margin '><label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'></div>");
										}
										} 
										  if($(spanEle).children("select[multiple='multiple']").length>0){
											var inputName = $(this).find("select").attr("name");
											var chk_value = [];
											var inputValue = "";
											if($(this).find("ul[class^='chosen-choices'] li[class^='search-choice']").length>0){
												$(this).find("ul[class^='chosen-choices'] li[class^='search-choice']").each(function(){
													 chk_value.push($(this).children("span").html().trim());    
												});
												inputValue = chk_value.join(";");
											}
												if(inputValue!=''&&typeof(inputValue)!='undefined'){
											$(this).find("div[class^='form-group no-margin']").empty();
											$(this).find("div[class^='form-group no-margin']").append("<label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'>");
											}
										  }else if($(spanEle).children("select").length>0){
										    var inputName = $(this).find("select").attr("name");
										    var inputValue = $(this).find("select +div a span").html();
										    if(inputValue!=''&&typeof(inputValue)!='undefined'){
										    if(inputValue=="请选择"){
										    	inputValue = "";
										    }
										    $(this).find("div[class^='form-group no-margin']").empty();
										    $(this).find("div[class^='form-group no-margin']").append("<label class='form-control form-read-lable'>"+inputValue+"</label><input name='"+inputName+"' type='hidden' value='"+inputValue+"'>");
										 }
										  }
										  
										//域名-退回无意见动态表格中的复选框的禁选
											 if($(this).find("input[type='checkbox']").length>0){
												$(this).find("input[type='checkbox']").attr("onclick","return false");
											}
											//域名-退回无意见动态表格中的单选框的禁选
											 if($(this).find("input[type='radio']").length>0){
												$(this).find("input[type='radio']").attr("onclick","return false");
											}


										//附件替换
										if($(this).find("input[type='file']").length>0){
											var inputEle = $(this).find("div[class='form-group no-margin '] label[class='ace-file-input form-control'] input");
											var name = $(inputEle).attr("name");
											if(ziduanengall.indexOf(name)<0){
												var maxLength = $(inputEle).attr("maxlength");
												var dataType = $(inputEle).attr("data-type");
												var dataExtension = $(inputEle).attr("data-extension");
												var labelEle = $(this).find("div[class='form-group no-margin '] label[class='ace-file-input form-control']");
												$(labelEle).replaceWith("<input name='"+name+"' type='hidden' maxlength='"+maxLength+"' data-type='"+dataType+"' data-extension='"+dataExtension+"'>");
											}
										}
									});
								});
							}
						});
					}
				    
					
				}
			});	
		}
		bindOnclick2();
	}

	//保存字段修改意见
	function saveYijian(b){
		var workid = $("#thisWorkid").val();
		var nodename = $("input[name='nodeName']").val();
		var sjid = $("#thisSjid").val();
		var formid = $("#thisForm").val();
		var divid = $("#thisDiv").val();
		var nodeid = $("input[name='nodeId']").val();
		var ziduan = "";//字段中文名称
		var yijian = "";//意见
		var ziduanEng = "";
		var zuobiao = "";
		var inputdiv = $(b).parent().prev();
		$(inputdiv).find("input").each(function(){
			var name = $(this).attr("name");
			if(name =="ziduanname"){
				ziduan =  $(this).val();
			}else if(name =="yijian"){
				yijian =  $(this).val();
				
			}else if(name=="ziduanEng"){
				ziduanEng =  $(this).val();
			}else if(name=="zuobiao"){
				zuobiao = $(this).val();
			}
		});
		$(inputdiv).find("textarea").each(function(){
			var name = $(this).attr("name");
			if(name =="ziduanname"){
				ziduan =  $(this).val();
			}else if(name =="yijian"){
				yijian =  $(this).val();
				
			}else if(name=="ziduanEng"){
				ziduanEng =  $(this).val();
			}else if(name=="zuobiao"){
				zuobiao = $(this).val();
			}
		});
		if(ziduan==null || ziduan=="" || yijian==null || yijian==""){
			alert("栏目名称和修改意见不能为空!");
			return false;
		}
		

		//意见转换处理特殊字符 lhy 2018-11-26
		yijian = escape(yijian);

		//调用后台保存数据
		$.ajax({
			url :encodeURI(horizon.paths.apppath+"/xuke/saveYijian.jsp?workid="+workid+"&sjid="+sjid+"&formid="+formid+
				"&divid="+divid+"&ziduan="+ziduan+"&yijian="+yijian+"&nodename="+nodename+"&ziduanEng="+ziduanEng+"&zuobiao="+zuobiao+"&nodeid="+nodeid),
			type : "post",
			dataType : 'json',
			async : false,
			error : function() {
				alert("Error");
			},
			success : function(data) {
				if(data.flag=="success"){
					 divid=divid.replace(/A/g, "K");
				      divid=divid.replace(/S/g, "B");
					alert("保存成功!");
				 	$(inputdiv).find("input[name='ziduanid']").val(data.yijianid);
				 	$(b).attr("disabled", true);
				 	$(b).next().attr("disabled", false);
				 	$(inputdiv).find("textarea").each(function(){
						$(this).attr("readonly", true);
					});
				 	
				 	
				 	
					var zuobiaoArr = zuobiao.split(",");
					for(var i=0;i<zuobiaoArr.length;i++){
						var arr1 = zuobiaoArr[i].split(";");
						//根据行和列找到相应的位置，设置颜色；
						$("#"+formid+" #"+divid).find("table").find("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")").css("color",color2);
						$("#"+formid+" #"+divid).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")").attr("newcolor","2");
					}
					//将该意见框的div的valid属性置为"invalid"
					$(inputdiv).parent().attr("valid","invalid");
					//增加一个填写意见框
					var yijianhtml = "<div valid='valid'>";
					 $("#biaodanyjdiv input[name='yijian']").removeAttr("readonly");
					var beiyonghtml = $("#beiyong div").html();
					yijianhtml = yijianhtml + beiyonghtml +"</div>";
					$(b).parent().parent().after(yijianhtml);
					
				}
				if(data.bdyj=="modify"){
					 divid=divid.replace(/A/g, "K");
				      divid=divid.replace(/S/g, "B");
					$("#shenhe"+divid+" select").val("modify");
					$("#myTab a[yewucode='"+divid+"']").css("color","red");
				} 
			}
		});
	}
	//删除修改意见
	function deleteYijian(b){
		var ziduanid = "";
		//var ziduan = "";
		$(b).parent().prev().find("input").each(function(){
			var name = $(this).attr("name");
			if(name =="ziduanid"){
				ziduanid =  $(this).val();
			}
		});
		
		//调用后台删除数据
		$.ajax({
			url :encodeURI(horizon.paths.apppath+"/xuke/deleteYijian.jsp?ziduanid="+ziduanid),
			type : "post",
			dataType : 'json',
			async : false,
			error : function() {
				alert("Error");
			},
			success : function(data) {
				var divid = $("#thisDiv").val();
				if(data.flag=="success"){
					alert("删除成功!");
					 divid=divid.replace(/A/g, "K");
				      divid=divid.replace(/S/g, "B");
				     
					//删除元素
					$(b).parent().parent().remove();
					//将字段的颜色变为白色
					var ziduanname = data.ziduanname;
					var zuobiao = data.zuobiao;
					//var divid = data.divid;
					var formid = data.formid;
					var zuobiaoArr = zuobiao.split(",");
					for(var i=0;i<zuobiaoArr.length;i++){
						var arr1 = zuobiaoArr[i].split(";");
						//根据行和列找到相应的位置，设置颜色；
						$("#"+formid+" #"+divid).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")").css("color",color0);
						$("#"+formid+" #"+divid).find("table").children("tbody").children("tr:eq("+arr1[0]+")").children("td:eq("+arr1[1]+")").attr("newcolor","0");
					}
				}
			}
		});
	}
	//保存表单意见，点击保存后 ，关闭表单审核框
	function saveBiaodanyijian(b){
		var sjid = $("#thisSjid").val();
		var formid = $("#thisForm").val();
		var divid = $("#thisDiv").val();
		var workid = $("#thisWorkid").val();
		var nodeid = $("input[name='nodeId']").val();
		var nodename = $("input[name='nodeName']").val();
		var yijian = $(b).parent().prev().find("select option:selected").text();
		var yijianele = $(b).parent().prev().find("select");
		var yijianValue = $(yijianele).val();
		var beizhuele = $(b).parent().prev().find("input[name='bdbeizhu']");
		var beizhu = $(beizhuele).val();
		if(yijian=="--请选择--"){
			alert("请选择表单意见");
			return false;
		}
		if(yijian=="退回补正"){
			var flag1 =true;
			$.ajax( {
				url : horizon.paths.apppath+'/xuke/checkThbdyj.jsp?workid='
						+ encodeURI(workid) +'&nodeid='+nodeid+'&divid='+divid+'&formid='+formid+'&temp='
						+ Math.random(),
				type : "post",
				dataType : 'json',
				async : false,
				error : function() {
				},
				success : function(data) {
					if(data.flag=='fail'){
						alert("请检查是否存在表单意见是“退回补正”但没有填写栏目修改意见的情况");
						flag1 = false;
					}
				}
			});
			if(!flag1){
				return false;
			}
		}
		//调用后台保存数据
		$.ajax({
			url :encodeURI(horizon.paths.apppath+"/xuke/saveBiaodanyijian.jsp?sjid="+sjid+"&formid="+formid+"&divid="+divid+"&workid="+workid
					+"&yijian="+yijian+"&nodename="+nodename+"&yijianValue="+yijianValue+"&nodeid="+nodeid+"&remark="+beizhu),
			type : "post",
			dataType : 'json',
			async : false,
			error : function() {
				alert("Error");
			},
			success : function(data) {
				if(data.flag=="success"){
					alert("保存成功!");
					//改变左侧对应的表单页签颜色
					var color = "";
					if(yijianValue=="pass"){
						color = "green";
					}else if(yijianValue=="modify"){
						color = "red";
					}
					$("#myTab a[yewucode='"+divid+"']").css("color",color);
					//关闭审核框
					hidediv();
					horizonOpen(this);
					
				}else if(data.flag=="wrong"){
					alert("该表单有需要退回修改的字段，表单意见不能为“建议审核通过”!");
					$(yijianele).val(data.oldval);
					$(beizhuele).val(data.oldremark);
				}
			}
		});
	}
	//企业人员页面，审核意见Tab页签切换
	 function changeYeqian(order){
		if(order==0){
			$("#tag0").removeClass("yeqian_02");
			$("#tag0").addClass("yeqian_01");
			
			
			$("#tag1").removeClass("yeqian_01");
			$("#tag1").addClass("yeqian_02");
			$("#xinshyj").show();
			$("#lishishyj").hide();
			
		}else if(order==1){
			$("#tag1").removeClass("yeqian_02");
			$("#tag1").addClass("yeqian_01");
			
			$("#tag0").removeClass("yeqian_01");
			$("#tag0").addClass("yeqian_02");
			$("#xinshyj").hide();
			$("#lishishyj").show();
			
		}
		
	} 
	//点击图片，关闭右侧的审核意见页签
	function closeyijian(){
		//隐藏
		$(".department").hide();
		//调整页面样式
		$("#zhong").removeClass("zhankai1");
		$("#zhong").removeClass("zhankai");
		$("#le div a").attr("iszan","true");
		$("#le").attr("class","floatclass5");
	}
	//流程审核人员页面，审核意见Tab页签切换
	 function changeYeqian1(order){
		if(order==0){
			$("#tag00").removeClass("yeqian_04");
			$("#tag00").addClass("yeqian_03");
			
			
			$("#tag01").removeClass("yeqian_03");
			$("#tag01").addClass("yeqian_04");
			$("#kuang_shenhe").show();
			$("#lishishenheyijian").hide();
			//解绑click事件
			$("div[id^='K'],div[id^='T'],div[id^='B'],div[id^='P']").removeClass("chakan");
			$(".tdclass,.fujianclass").unbind("click");
			//绑定click事件,填写字段意见和表单意见
			 bindOnclick1(); 
			
		}else if(order==1){
			$("#tag01").removeClass("yeqian_04");
			$("#tag01").addClass("yeqian_03");
			
			$("#tag00").removeClass("yeqian_03");
			$("#tag00").addClass("yeqian_04");
			$("#kuang_shenhe").hide();
			$("#lishishenheyijian").show();
			//解绑click事件
			$("div[id^='K'],div[id^='T'],div[id^='B'],div[id^='P']").removeClass("shenpi");
			$(".tdclass,.fujianclass").unbind("click");
			//绑定onclick事件，查看历史审核意见
			bindOnclick2();
		}
		
	}
	function horizonOpen(b){
	
	
var user = $("#right-menu div[class='row no-margin'] label:last-child span").html()+"";
      
    
     
      if (user.indexOf("创建者") ==-1) {

	  
        var cc = $("input[name='workId']").val();
	    var istuihui=$("#tuihui").val();
	     //加封面设计
	     var sjid="";
	     var yewucode="";
	     var url="";
	     $.ajax({
			url :horizon.paths.apppath+"/xuke/getfengmianInfo.jsp?workid="+cc,
			type : "post",
			dataType : 'json',
			async : false,
			error : function() {
				alert("Error");
			},
			success : function(data) {
			
				sjid=data.shijianid;
				yewucode=data.yewucode;
				
				$("#zhong>div").each(function(){
					$(this).removeClass("active");
					$(this).removeClass("in");
				});
				 $("#fengmian").addClass("active");
				 $("#fengmian").addClass("in");

				 var user = $("#right-menu div[class='row no-margin'] label:last-child span").html();
				 if(user.indexOf("主办")>0&&istuihui=='false'&&haslimit){
				 	//获取节点nodename
				 	var nodename = $("input[name='nodeName']").val();
				 	var nodeid = $("input[name='nodeId']").val();
				 	var url11 = horizon.paths.apppath+"/xuke/page2.jsp?trackid="+trackidls+"&viewid=HZ2885005f57d70b015f58675f8d0140&sjid="+sjid+"&flowtye=1&yewucodes="+yewucode+"&nodeid="+nodeid+"&workid="+workidls;
				 	$.ajax({
					    url: url11,
					    type: "POST",
					    dataType: "html",
					    error: function(){
					       alert('Error');
					    },
					    success: function(data){
					       $("#fengmian").empty();
						   $("#fengmian").html(data);
				    	}
					});
				 }else{
					 $.ajax({
					    url: horizon.paths.apppath+"/xuke/page3.jsp?trackid="+trackidls+"&viewid=HZ2885005f57d70b015f58675f8d0140&sjid="+sjid+"&flowtye=1&yewucodes="+yewucode+"&workid="+workidls,
					    type: "POST",
					    dataType: "html",
					    error: function(){
					       alert('Error');
					    },
					    success: function(data){
					       $("#fengmian").empty();
						   $("#fengmian").html(data);
				    	}
					});
				 }	
		  }
			
		});}
	}
	
	
	//根据导航菜单获取yewucode打印相应表单
	function printTable(){
		
		var divId=$("#thisDiv").val();
		//LODOP=getLodop();
		//alert(divId);
		
		//liuhy 2018-12-05 评测表单打印采用WORD导出
		if(divId==undefined || divId=="" || divId==null){  
		     alert("请点击左侧需要打印的表单！");  
		     return;
		}
		if(divId=="P01P01" || divId=="P03P01" || divId=="P04P01" || divId=="P05P01" || divId=="P06P01" || divId=="P07P01"){  
		     exportWord(divId);
		     return;
		}
		//liuhy 2018-12-05 评测表单打印采用WORD导出
		$("#imgscss").html("");
		 $("#dayingcontent").html("");
		 divId=divId.replace(/A/g, "K");
	     divId=divId.replace(/S/g, "B");
		//alert(divId);
		//alert($("#"+divId).html())
		//alert(horizon.paths.apppath+'/workflow/module/workflow/shuiyin.png')
		//var strFormHtml=strBodyStyle+$("#"+divId).html();
	//	var hdhd= { globalStyles: true,
     //   mediaPrint: true,
    //   stylesheet: null,
     //  noPrintSelector: ".no-print",
     //  iframe: true,
      // append: null,
     //  prepend: null,
      //  manuallyCopyFormValues: true
	
	
	 // }
	 
      var conHeight = $("#"+divId).height();
	 var conWidth = $("#"+divId).width();
	 //alert(conHeight+","+conWidth);
	 /*var stylecss="<style id='cccss'>@media print {"+
     "table,td { border: 1px solid #a0a0a1;border-collapse:collapse;"+
	 "border-width: 1px; border-style: solid;}"+
     ".hidden{ display:none !important;}"+
     ".tdclass{color: #000000 !important;}"+
	 "#imgscss{position:relative;top:0px;z-index:-120px;width:1017px;height:1017px;display: inline;}"+
     "#dayingcontent{position:absolute;z-index:100px; top:1px;}"+
	 "}"+
	  "</style>";
	  */
	  
	  
	  //wangpeng   2019.01.10
	  var stylecss="<style id='cccss'>@media print {"+
     "table,td { border: 1px solid #a0a0a1;border-collapse:collapse;"+
	 "border-width: 1px; border-style: solid;}"+
     ".hidden{ display:none !important;}"+
     ".tdclass{color: #000000 !important;}"+
     ".sinput{vertical-align: middle;display:inline-block;text-indent: 0em!important;}"+
	 ".sinput label{border: none;}"+
	 ".no-margin label{border: none;}"+
	 ".shengfen"+divId+" label{font-size: 18px;padding: 0;margin: 0;vertical-align: middle;font-weight: bolder;color: #000000;}"+
     ".title{font-weight: bolder;font-size: 18px;text-align: center;}"+
     ".right{text-align: right;}"+
	 "#imgscss{position:relative;top:0px;z-index:-120px;width:1017px;height:1017px;display: inline;}"+
     "#dayingcontent{position:absolute;z-index:100px; top:1px;}"+
     "#yqzqk table{width:99% !important;}"+
     "#viewDivzhu table{width:99% !important;}"+
	 "}"+
	  "</style>";

	  $("#imgscss").append(stylecss);
	// alert(".imgs{top:0px;z-index:120;width:508.5px;height:508.5px;display: inline;}");
    var num = Math.ceil(conHeight*conWidth/1017/1017);
	//$("#"+divId).before("<div id='inggs'></div>");
	
    for(var i=0;i<num;i++){
        $("#imgscss").append('<img class="imgs" src="../../../workflow/module/workflow/shuiyin.png" style="z-index:150" />');
    };
        
	    $("#dayingcontent").html($("#"+divId).html());
		$("#dayinghtml").show();
		
		var iframes =$("#dayingcontent iframe");
         var iframes2 =$("#"+divId+" iframe");
	    $(iframes).each(function(i){ 
         
         $(this).attr("id","dayingww"+i);
          $(this).attr("name","dayingww"+i);
         console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
         console.log($(iframes2[i]).contents().find("body").html());
         
         console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); 
     
         
            var idd="dayingww"+i;
         
        //关于视图的特殊处理
        var urlstr =$(iframes2[i]).attr("src");
        if(urlstr != null && urlstr != ""){
        	var urlstrss=urlstr.split("viewid");
        }
        var htmlstr = "";
        if(urlstrss.length>=2){
             htmlstr=$(iframes2[i]).contents().find('[class="widget-box no-margin no-border hidden-print"]').html();
        }else{
            htmlstr=$(iframes2[i]).contents().find("body").html();
        }

         $("#dayingww"+i).after(htmlstr);
         //$("#dayinghtml").append(htmlstr);
       // console.log(htmlstr);
          //setTimeout("",3000);
	     $("#dayingww"+i).remove();
		});
        console.log($("#dayinghtml").html());
          var htmlsss=$("#dayinghtml").html();
          $("#dayinghtml").html(htmlsss);
          $("#dayinghtml script").remove();
    var head = document.head || document.getElementsByTagName("head")[0] || document.documentElement;
	   var oscript = document.createElement("script");
	   oscript.src ="../../../plugins/jquery/jquery.PrintArea.js";
		//var jiaob='<script  id="javajiaob" type="text/javascript" src="../../../plugins/jquery/jquery.PrintArea.js"><\/script>';
		$("[src='../../../plugins/jquery/jquery.PrintArea.js']").remove();
		//$(head).append(jiaob);
		 head.insertBefore( oscript,head.firstChild );
	 if (document.all) {
        oscript.onreadystatechange = function() {
            if (oscript.readyState == 'loaded' || oscript.readyState == 'complete') {
              
       
		$("#dayinghtml").show();
		
		newIframeHeight();
		
	    $("#dayinghtml").printArea();
		
       
       
		$("#dayinghtml").hide();
		oldIframeHeight();
       // $("#cccss").remove();
		$("#imgscss").html("");
	   $("#dayingcontent").html("");
            }
        }
    } else {
        oscript.onload = function() {
        	
		$("#dayinghtml").show();
		
		newIframeHeight(); 
	  
	    $("#dayinghtml").printArea();
		
       
       
		$("#dayinghtml").hide();
		
		oldIframeHeight(); 
       // $("#cccss").remove();
		$("#imgscss").html("");
	   //$("#dayingcontent").html("");
            
    }
	
		
		//alert(urlqian+"/dxxzsp/workflow/module/workflow/shuiyin.png");
		//LODOP.PRINT_INIT("");
        //LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' src='"+urlqian+"/dxxzsp/workflow/module/workflow/shuiyin.png' style='z-index: -1'/>");
        
		//LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);	
        //LODOP.SET_SHOW_MODE("BKIMG_PRINT",1);	
        //LODOP.SET_SHOW_MODE("BKIMG_LEFT",-31);	
        //LODOP.SET_SHOW_MODE("BKIMG_TOP",-30);
	
		//LODOP.SET_PRINT_STYLEA(2,"Bold",1);
		//LODOP.ADD_PRINT_HTM(50,50,"80%","100%",strFormHtml);
		//alert(strFormHtml);
		//LODOP.PREVIEW();
	}
	
	}
	
	
	function newIframeHeight(){
		try{
			var iframe = document.getElementById("mainIframe");
			if(iframe != null && iframe != undefined){
				var gao1 = $("#mainIframe").contents().find("form").height();
				$("#divContent_0 iframe").height(gao1);
				$("#divContent_0").height(gao1);
				$("#divContent_0 .page-content").css({"height":gao1,"overflow-y":"hidden"});
				var divContent1 = document.getElementById("divContent_1");
				if(divContent1 != null && divContent1 != undefined && divContent1 != ""){
					var gao2 = $("#divContent_1 iframe").contents().find("form").height();
					$("#divContent_1 iframe").height(gao2);
					$("#divContent_1").height(gao2);
					$("#divContent_1 .page-content").css({"height":gao2,"overflow-y":"hidden"});
				}
			}
	    }catch(e){
	        throw new Error('Error');
	    }
	}
	
	function oldIframeHeight(){
		$("#mainIframe").css("height","100%");
		$("#divContent_0").height(850);
		var divContent = document.getElementById("divContent_1");
		if(divContent != null && divContent != undefined && divContent != ""){
			$("#divContent_1").height(850);
			$("#divContent_1 iframe").css("height","100%");
		}
		$(".page-content").css({"height":"900px","overflow-y":"scroll"});
	}
	
	//liuhy 2018-12-05 评测表单打印采用WORD导出
	function exportWord(divId){
		var sjid = GetUrlparamString("sjid");
		var url=horizon.paths.apppath + '/xkcrs.do?jia='+sjid+'&divId='+divId;
		$.ajax({
			type: "POST",
			url: url,
			async:false,
			success:function(data, textStatus){
				document.location=  horizon.paths.apppath+"/xuke/downloadDoc.jsp?filename=" + data + "&divId=" + divId;
			},
			error:function(data, textStatus){}
		});
	}
	//liuhy 2018-12-05 评测表单打印采用WORD导出
    </script>
<%@include file="../../common/ace.css.include.jsp"%>
<%@include file="../../common/base.css.include.jsp"%>
<%@include file="../../common/base.script.include.jsp"%>
<script type="text/javascript">
        horizon.lang.workflow = <path:i18n group="workflow"/>;
    </script>
<c:if test="${not empty workFlowImport}">
	<c:import url="${workFlowImport}" />
</c:if>
<%@include file="../../common/oldbrowser.script.include.jsp"%>
</head>
<body class="workflow-body"
	data-aa="<path:prop name="workflow.import"/>">
	<object
		style="left: 0px; top: 0px; width: 0px; height: 0px; position: absolute;"
		id="DWebSignSeal" codebase="WebSign.cab#version=4,1,0,0"
		classid="CLSID:77709A87-71F9-41AE-904F-886976F99E3E"
		data="data:application/x-oleobject;base64,h5pwd/lxrkGQT4hpdvmePgAJAAA="></object>
	<input id="tuihui" type="hidden" value="" />
	<c:choose>
		<c:when test="${empty workFlow.openType}">
			<div class="alert alert-danger alert-inflow bigger-110 center">
				<c:out value="${workFlow.flowMsg}" />
			</div>
		</c:when>
		<c:when
			test="${workFlow.selectNodes ne null and workFlow.openType eq 'false'}">
			<form class="form-horizontal" role="form">
				<div class="alert alert-info alert-inflow bigger-110 center">
					<div class="control-group">
						<label class="control-label bolder blue"><path:i18n
								group="workflow" key="selectActiveNode" /></label> <br /> <label
							class="control-label"> <c:forEach var="node"
								items="${workFlow.selectNodes}" varStatus="i">
								<div class="radio align-left">
									<label> <input name="trackId" type="radio" class="ace"
										value="<c:out value="${node.nodeId}"/>" /> <span class="lbl">
											<c:out value="${node.nodeName}" />
									</span>
									</label>
								</div>
							</c:forEach>
						</label> <input type="hidden" name="workId"
							value="<c:out value="${workFlow.workId}"/>" />
						<div class="hr hr-dotted hr18"></div>
						<p>
							<button type="submit" class="btn btn-sm btn-success">
								<path:i18n group="workflow" key="ok" />
							</button>
						</p>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div class="main-container">
				<!-- 操作开始 -->
				<div class="flow-buttons ">
					<ul class="nav nav-pills no-margin">



						<!-- 省内受理按钮 -->
						<!--
						<li class="snsl hide"><a id="snsl"
							href="javascript:void(0);" onclick="snsl()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="snslyou hide"><a id="snslyou"
							href="javascript:void(0);" onclick="snslyou()"
                            data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"
							> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="snbsl hide"><a id="snbsl"
							href="javascript:void(0);" onclick="snbsl()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
						<li class="snbslyou hide"><a id="snbslyou"
							href="javascript:void(0);" onclick="snbslyou()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
						<li class="snpizhun hide"><a id="snpizhun"
							href="javascript:void(0);" onclick="snpizhun()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="批准"/>"> <i
								class="ace-icon <c:out value="批准"/>"></i> <c:out value="批准" />
						</a></li>
						<li class="snbpizhun hide"><a id="snbpizhun"
							href="javascript:void(0);" onclick="snbpizhun()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不批准"/>"> <i
								class="ace-icon <c:out value="不批准"/>"></i> <c:out value="不批准" />
						</a></li>
						<li class="snbuzhen hide"><a id="snbuzhen"
							href="javascript:void(0);" onclick="snbuzhen()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="补正"/>"> <i
								class="ace-icon <c:out value="补正"/>"></i> <c:out value="补正" />
						</a></li>
						<li class="renyituihui hide"><a id="renyituihui"
						
							href="javascript:void(0);" onclick="renyituihuibuzhen()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="退回补正"/>"> <i
								class="ace-icon <c:out value="退回补正"/>"></i> <c:out value="退回补正" />
						</a></li>
						<li class="bupizhun hide"><a id="bupizhun"
							href="javascript:void(0);" onclick="bupizhun()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不批准"/>"> <i
								class="ace-icon <c:out value="不批准"/>"></i> <c:out value="不批准" />
						</a></li>
-->
						<!-- 省内变更受理按钮 

						<li class="snbgsl hide"><a id="snbgsl"
							href="javascript:void(0);" onclick="snbgsl()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="snbgslyou hide"><a id="snbgslyou"
							href="javascript:void(0);" onclick="snbgslyou()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="snbgbsl hide"><a id="snbgbsl"
							href="javascript:void(0);" onclick="snbgbsl()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
						<li class="snbgpizhun hide"><a id="snbgpizhun"
							href="javascript:void(0);" onclick="snbgpizhun()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="批准"/>"> <i
								class="ace-icon <c:out value="批准"/>"></i> <c:out value="批准" />
						</a></li>
						<li class="snbgbpizhun hide"><a id="snbgbpizhun"
							href="javascript:void(0);" onclick="snbgbpizhun()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不批准"/>"> <i
								class="ace-icon <c:out value="不批准"/>"></i> <c:out value="不批准" />
						</a></li>
						<li class="snbgbuzhen hide"><a id="snbgbuzhen"
							href="javascript:void(0);" onclick="snbgbuzhen()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="补正"/>"> <i
								class="ace-icon <c:out value="补正"/>"></i> <c:out value="补正" />
						</a></li>
-->
						<!-- 外商受理按钮 -->
						<!--
						<li class="shouli hide"><a id="shouli1"
							href="javascript:void(0);" onclick="shouli()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="shouli hide"><a id="shouli2"
							href="javascript:void(0);" onclick="bushouli()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
						


						<li class="waishang hide"><a id="waishang1"
							href="javascript:void(0);" onclick="shenpitongguo()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="审批通过"/>"> <i
								class="ace-icon <c:out value="审批通过"/>"></i> <c:out value="审批通过" />
						</a></li>
						<li class="waishang hide"><a id="waishang2"
							href="javascript:void(0);" onclick="shenpibutongguo()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="审批不通过"/>"> <i
								class="ace-icon <c:out value="审批不通过"/>"></i> <c:out
									value="审批不通过" />
						</a></li>
						
					-->


						<!-- 跨地区申请受理按钮 -->
						<!--
						<li class="kdqsqshouli hide"><a id="kdqsqsl1"
							href="javascript:void(0);" onclick="kdqsqshouli()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> 
							<i class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="kdqsqshouli hide"><a id="kdqsqsl2"
							href="javascript:void(0);" onclick="kdqsqbushouli()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
							<li class="kdqsqshouli hide"><a id="kdqsqbz"
							href="javascript:void(0);" onclick="kdqsqbuzheng()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="退回补正"/>"> <i
								class="ace-icon <c:out value="退回补正"/>"></i> <c:out value="退回补正" />
						</a></li>
						-->
						<!-- 跨地区变更受理按钮 -->

						<li class="kdqbgshouli hide"><a id="kdqbgsl1"
							href="javascript:void(0);" onclick="regionalAcceptBtn()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="kdqbgshouli hide"><a id="kdqbgsl2"
							href="javascript:void(0);" onclick="regionalNotAcceptBtn(this)"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
						<!-- 宽带登记分办补正按钮 -->
						<!--
						<li class="kuaidaibuzheng hide"><a id="kdjrbz"
							href="javascript:void(0);" onclick="kdjrdengjifengban()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="登记分办"/>"> <i
								class="ace-icon <c:out value="登记分办"/>"></i> <c:out value="登记分办" />
						</a></li>
							<li class="kuaidaibuzheng hide"><a id="kdjrbztz"
							href="javascript:void(0);" onclick="kdjrtongzhibugao(this)"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="补正通知"/>"> <i
								class="ace-icon <c:out value="补正通知"/>"></i> <c:out value="补正通知" />
						</a></li>
						
						
							<li class="kuaidaisl hide"><a id="kdjrsl"
							href="javascript:void(0);" onclick="kdjrshouli()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="受理"/>"> <i
								class="ace-icon <c:out value="受理"/>"></i> <c:out value="受理" />
						</a></li>
						<li class="kuaidaisl hide"><a id="kdjrbsl"
							href="javascript:void(0);" onclick=" kdjrbushouli(this)"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予受理"/>"> <i
								class="ace-icon <c:out value="不予受理"/>"></i> <c:out value="不予受理" />
						</a></li>
				
						<li class="kuaidaipizhun hide"><a id="kdjrpz"
							href="javascript:void(0);" onclick="kdjrshenpitongguo()"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="批准"/>"> <i
								class="ace-icon <c:out value="批准"/>"></i> <c:out value="批准" />
						</a></li>
						<li class="kuaidaipizhun hide"><a id="kdjrbpz"
							href="javascript:void(0);" onclick="kdjrshenpibutongguo(this)"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="不予批准"/>"> <i
								class="ace-icon <c:out value="不予批准"/>"></i> <c:out value="不予批准" />
						</a></li>
					-->
						<!-- 评测按钮 onclick方法在page2.jsp-->



						<!-- 评测按钮结束 -->
						<!-- 增加确认撤消按钮 liuhy 2018-09-11 -->
						<li id="revocationBut" style="float: right;display:none;"><a href="javascript:void(0);"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="确认撤消"/>" onclick="openRevocation()"> <i
								class="ace-icon <c:out value="确认撤消"/>"></i> <c:out value="确认撤消" />
						</a></li> 
						<!-- 增加确认撤消按钮 liuhy 2018-09-11 -->

						<li><a href="javascript:void(0);"
							data-operate="<c:out value="${button.buttonId}"/>"
							data-clazz="<c:out value="${button.buttonClass}"/>"
							data-text="<c:out value="打印"/>" onclick="printTable()"> <i
								class="ace-icon <c:out value="打印"/>"></i> <c:out value="打印" />
						</a></li>

						<c:forEach var="button" items="${workFlow.flowButtons}" 
							varStatus="i">

							<li ><a href="javascript:void(0);"
								data-operate="<c:out value="${button.buttonId}"/>"
								data-clazz="<c:out value="${button.buttonClass}"/>"
								data-text="<c:out value="${button.buttonName}"/>"> <i
									class="ace-icon <c:out value="${button.icon}"/>"></i> <c:out
										value="${button.buttonName}" />
							</a></li>
						</c:forEach>
						<%-- 						<li><a href="javascript:void(0);" data-operate="close">
								<i class="ace-icon fa fa-times"></i> <path:i18n group="workflow"
									key="close" />
						</a></li> --%>
						<li class="more hidden"><a href="javascript:void(0);"
							data-toggle="dropdown" class="dropdown-toggle"> <i
								class="ace-icon fa fa-list"></i> <path:i18n group="workflow"
									key="more" />
						</a>
							<ul
								class="dropdown-menu dropdown-light-blue dropdown-caret dropdown-menu-right">
								<c:forEach var="button" items="${workFlow.flowButtons}"
									varStatus="i">
									<li class="hidden" ><a href="javascript:void(0);"
										data-operate="<c:out value="${button.buttonId}"/>"
										data-clazz="<c:out value="${button.buttonClass}"/>"> <i
											class="ace-icon <c:out value="${curButton.icon}"/>"></i> <c:out
												value="${button.buttonName}" />
									</a></li>
								</c:forEach>
								<li class="hidden" id="qunimade3"><a href="javascript:void(0);"
									data-operate="close"> <i class="ace-icon fa fa-times"></i>
										<path:i18n group="workflow" key="close" />
								</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- 操作结束 -->
				<div class="flow-body">
					<c:if test="${workFlow.openType eq 'false'}">
						<div class="alert alert-danger alert-inflow bigger-110 center">
							<c:out value="${workFlow.flowMsg}" />
						</div>
					</c:if>
					<div class="tabbable">
						<!-- 需要隐藏的部分 默认style="display:none" -->

						<div id="yingshow"
							style="position: fixed; top: 48px; left: 20px; width: 300px; height: 470px;"
							class="floatclass">
							<div
								style="width: 100%; height: 550px; overflow-y: auto; overflow-x: hidden;">
								<div
									style="height: 35px; width: 100%; text-align: center; font-size: 18px; background-color: #efefef; line-height: 35px; color: #0658b1">
									<a onclick="horizonOpen(this);" href="##">申请概况</a>
								</div>
								<ul class="nav nav-tabs" id="myTab">
									<li class="zhu"><a class="zhu" style="text-align: left;"
										onclick="table(this)"><c:out value="${workFlow.flowName}" /></a>
										<ul class="nav nav-tabs floatclass2" id="Tabname">
											<c:forEach var="form" items="${workFlow.flowForms}"
												varStatus="i">
												<li
													<c:if test="${form.isDef eq 'true'}"> class="active widthclass"</c:if>
													class="widthclass"><a data-toggle="tab"
													style="text-align: left;"
													href="#<c:out value="${form.formId}"/>"> <c:out
															value="${form.formName}" />
												</a></li>
											</c:forEach>
										</ul></li>
								</ul>
							</div>
						</div>

						<!-- /需要隐藏的部分 -->

						<div class="floatclass5" id="le">
							<div class="" style="width: 10px;">
								<a
									style="background-color: #72b2e3; border-radius: 5%; width: 30px; height: 24px; display: block;"
									onclick="form(this)"><img id="tx"
									src="../../../xuke/images/web/zuo.png" width="30px"
									height="24px"></a>
							</div>

							<form class="base-form form-horizontal" role="form" id="fm"
								method="post">
								<c:choose>
									<c:when test="${workFlow.flowForms ne null}">
										<div
											class="tab-content no-padding-left no-padding-right no-padding-top floatclass3"
											id="zhong">
											<div id="fengmian" class="tab-pane fade"></div>
											<c:forEach var="form" items="${workFlow.flowForms}"
												varStatus="i">
												<c:choose>
													<c:when test="${form.formId eq 'FlowTrack'}">
														<!-- 流程跟踪 -->
														<div id="<c:out value="${form.formId}"/>"
															class="empty tab-pane fade floatclass4 <c:if test="${form.isDef eq 'true'}">active in</c:if>">
															<div class="row no-margin">
																<div class="col-xs-12">
																	<div class="widget-box transparent">
																		<div class="widget-header">
																			<h4 class="widget-title lighter">
																				<i class="ace-icon fa fa-sitemap"></i>
																				<path:i18n group="workflow" key="flowChart" />
																			</h4>
																			<div class="widget-toolbar">
																				<a href="javascript:void(0);" data-action="collapse">
																					<i class="ace-icon fa fa-chevron-up"></i>
																				</a>
																			</div>
																		</div>
																		<div class="widget-body">
																			<div
																				class="widget-main no-padding-left no-padding-right">
																				<div class="flowchart-container"></div>
																			</div>
																		</div>
																	</div>
																	<div class="widget-box transparent">
																		<div class="widget-header">
																			<h4 class="widget-title lighter">
																				<i class="ace-icon fa fa-clock-o"></i>
																				<path:i18n group="workflow" key="history" />
																			</h4>
																			<div class="widget-toolbar">
																				<div class="widget-menu">
																					<a href="javascript:void(0);"
																						data-action="settings" data-toggle="dropdown">
																						<i class="ace-icon fa fa-bars"></i>
																					</a>
																					<ul
																						class="dropdown-menu dropdown-menu-right dropdown-light-blue dropdown-caret dropdown-closer">
																						<li class="active"><a
																							href="javascript:void(0)" data-action="timeline">
																								<i class="ace-icon fa fa-clock-o"></i> <path:i18n
																									group="workflow" key="timeLine" />
																						</a></li>
																						<li><a href="javascript:void(0)"
																							data-action="table"> <i
																								class="ace-icon fa fa-list-alt"></i> <path:i18n
																									group="workflow" key="table" />
																						</a></li>
																					</ul>
																				</div>
																				<a href="javascript:void(0);" data-action="collapse">
																					<i class="ace-icon fa fa-chevron-up"></i>
																				</a>
																			</div>
																		</div>
																		<div class="widget-body">
																			<div
																				class="widget-main no-padding-left no-padding-right note-container"></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</c:when>
													<c:when test="${form.formType eq 'JSP'}">
														<!-- 外部表单 -->
														<div id="<c:out value="${form.formId}"/>"
															class="tab-pane fade <c:if test="${form.isDef eq 'true'}">active in</c:if>">
															<div class="row no-margin form-body">
																<div class="col-xs-12">
																	<c:import url="${form.formBody}">
																		<c:param name="formId" value="${form.formId}" />
																		<c:param name="dataId" value="${form.formDataId}" />
																		<c:param name="isNew" value="${form.isNewData}" />
																	</c:import>
																</div>
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<!-- 定制表单 -->
														<div id="<c:out value="${form.formId}"/>"
															class="tab-pane fade <c:if test="${form.isDef eq 'true'}">active in</c:if>">
															<c:if test="${forms[form.formId].formButtons ne null}">
																<div class="row no-margin">
																	<div class="col-xs-12 form-buttons">
																		<ul class="nav nav-pills no-margin">
																			<c:forEach var="formButton"
																				items="${forms[form.formId].formButtons}"
																				varStatus="k">
																				<li><a href="javascript:void(0)"
																					onclick="<c:out value="${formButton.func}"/>">
																						<c:if test="${formButton.buttonIcon ne null }">
																							<i
																								class="ace-icon <c:out value="${formButton.buttonIcon}"/> hidden-xs"></i>
																						</c:if> <c:if
																							test="${formButton.buttonIcon eq null || formButton.buttonIcon == ''}">
																							<i class="ace-icon fa fa-coffee hidden-xs"></i>
																						</c:if> <c:out value="${formButton.buttonName}" />
																				</a></li>
																			</c:forEach>
																		</ul>
																	</div>
																</div>
															</c:if>
															<div class="row no-margin form-body">
																<div class="col-xs-12">
																	<c:out value="${bodys[form.formId]}" escapeXml="false" />
																</div>
																<input type="hidden"
																	name="<c:out value="${form.formId}"/>_WORKFLOW_DATA"
																	value='<c:out value="${form.formDataId}"/>' />
															</div>
														</div>
														<!--表单结束-->
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</div>
						</div>

						</c:when>
						<c:otherwise>
							<div class="alert alert-danger alert-inflow bigger-110 center">
								<path:i18n group="workflow" key="noPermission" />
							</div>
						</c:otherwise>
	</c:choose>
	<div class="department" style="display: none;">

		<div class="department_01">
			<h3>
				<span class="yeqian_01" onclick="changeYeqian(0)" id="tag0">审核意见</span>
				<span class="yeqian_02" onclick="changeYeqian(1)" id="tag1">历史审核意见</span>
			</h3>
			<div id="xinshyj" class="kuang">
				<ul>
					<li><span class="kuang_01">岗位</span><input name="" type="text" />
					</li>
					<li><span class="kuang_01">修改意见</span><input name=""
						type="text" /></li>
				</ul>
			</div>
			<div class="department_02">
				<img src="../../../workflow/module/workflow/suofang1.png"
					onclick="closeyijian();" height="30px">
			</div>
		</div>
		<div id="lishishyj" style="display: none;">
			<!-- 显示历史审核意见 -->
			<div class="index"></div>
		</div>
	</div>

	<div class="floatclass6" id="bdsh"
		style="width: 130px; display: none;height:20px;">
		<input class="history" onclick="showdiv()" type="button" value="表单审核">
		</input>
	</div>
	<div class="floatclass6" id="bdshls"
		style="width: 130px; display: none;height:20px">
		<input class="history" onclick="showdivls()" type="button"
			value="查看历史审核意见"> </input>
	</div>
	<!-- 该input框存储当前formid和div的id,以便于保存审核意见时清楚是哪张表哪个div -->
	<input type="text" id="thisForm" value="" style="display: none;" />
	<input type="text" id="thisDiv" value="" style="display: none;" />
	<input type="text" id="thisSjid" value="" style="display: none;" />
	<input type="text" id="thisWorkid" value="" style="display: none;" />
	<input type="text" id="lishikuang" value="" style="display: none;" />

	<div class="guding department_03" id="you" style="display: none">

		<h3>
			<span class="yeqian_03" onclick="changeYeqian1(0);" id="tag00">审核意见</span>
			<span class="yeqian_04" onclick="changeYeqian1(1);" id="tag01">历史审核意见</span>
		</h3>
		<div class="department_02">
			<img src="../../../workflow/module/workflow/suofang1.png"
				onclick="hidediv();" height="30px">
		</div>
		<div id="kuang_shenhe">
			<div id="shenheyijian" style="overflow: auto;">
				<div>
					<div valid="valid">
						<div class="guding_01">
							<ul class="ui2clss">
								<li style="border-bottom: 1px #FFFFFF solid"><a>填写信息项意见</a></li>
								<li
									style="border-bottom: 1px #FFFFFF solid; height: 50px; padding: 0px">
									<input type="text" name="ziduanEng" style="display: none;" />
									<input type="text" name="zuobiao" style="display: none;" /> <input
									type="text" name="ziduanid" style="display: none;" /> <span
									class="shyj">栏目名称：</span><input type="text" name="ziduanname"
									readonly="readonly" style="margin-top: 8px; width: 58%" />
								</li>
								<li style=""><span class="shyj">修改意见：</span><textarea
									type="text" name="yijian" id="tianyijian"
									style="margin-top: 8px;  width: 58%;height:auto;" ></textarea>/></li>
							</ul>
						</div>
						<div class="guding_02">
							<input type="button" value="确定" class="anniu_02"
								onclick="saveYijian(this);" /><input type="button"
								onclick="deleteYijian(this);" disabled="true" value="删除"
								class="anniu_02" style="background-color: #68a942" />
						</div>
					</div>
				</div>
				<!-- 表单总的审核意见 -->
				<div>
					<div class="guding_01">
						<ul class="ui2clss">
							<li style="border-bottom: 1px #FFFFFF solid"><a>填写表单意见</a></li>
							<li
								style="border-bottom: 1px #FFFFFF solid; height: 50px; padding: 0px">
								<input type="text" name="biaodanyijianid" style="display: none;" />
								<span class="shyj">意见：</span> <select name="biaodanyijian"
								style="margin-top: 8px; width: 58%; float: left">
									<option>--请选择--</option>
									<option value="pass" selected>建议审核通过</option>
									<!-- 	<option value="nopass">建议不通过</option> -->
									<option value="modify">退回补正</option>
							</select>
							</li>
							<li
								style="border-bottom: 1px #FFFFFF solid; height: 100px; padding: 0px">
								<span class="shyj">备注：</span> <textarea rows="3" cols="30"
									name="bdbei"
									style="margin-top: 8px; width: 58%; float: left; height: 84px"></textarea>
								<input name="bdbeizhu" id="bdbeizhuhedden" type="hidden" />
							</li>
						</ul>
					</div>
					<div class="guding_02">
						<input type="button" value="确认" class="anniu_03"
							onclick="saveBiaodanyijian(this);" />
					</div>
				</div>
			</div>
		</div>
		<div id="lishishenheyijian" style="display: none;">
		<div class="index1"></div>
			<div class="index"></div>
		</div>
		<div>
			<div id="beiyong" style="display: none;">
				<div id='biaodanyjdiv'>
					<div class="guding_01">
						<ul class="ui2clss">
							<li style="border-bottom: 1px #FFFFFF solid"><a>填写信息项意见</a></li>
							<li
								style="border-bottom: 1px #FFFFFF solid; height: 50px; padding: 0px">
								<input type="text" name="ziduanid" style="display: none;" /> <input
								type="text" name="ziduanEng" style="display: none;" /> <input
								type="text" name="zuobiao" style="display: none;" /> <span
								class="shyj">栏目名称：</span><input type="text" name="ziduanname"
								readonly="readonly" style="margin-top: 8px; width: 58%" />
							</li>
							<li style=""><span class="shyj">修改意见：</span><textarea
								type="text" name="yijian" style="margin-top: 8px; width: 58%;height:auto;"></textarea>
							</li>
						</ul>
					</div>
					<div class="guding_02">
						<input type="button" value="确定" class="anniu_02"
							onclick="saveYijian(this);" /><input type="button"
							onclick="deleteYijian(this);" disabled="true" value="删除"
							class="anniu_02" style="background-color: #68a942" />
					</div>
				</div>
			</div>
			<div id="beiyong1" style="display: none;">
				<div>
					<div class="guding_01">
						<ul class="ui2clss">
							<li style="border-bottom: 1px #FFFFFF solid"><a>填写表单意见</a></li>
							<li
								style="border-bottom: 1px #FFFFFF solid; height: 50px; padding: 0px">
								<input type="text" name="biaodanyijianid" style="display: none;" />
								<span class="shyj">意见：</span> <select name="biaodanyijian"
								style="margin-top: 8px; width: 58%; float: left">
									<option>--请选择--</option>
									<option value="pass" selected>建议审核通过</option>
									<!-- <option value="nopass">建议不通过</option> -->
									<option value="modify">退回补正</option>
							</select>
							</li>
							<li
								style="border-bottom: 1px #FFFFFF solid; height: 100px; padding: 0px">
								<span class="shyj">备注：</span>
								<div id="hehehe" rows="3" cols="30" name="bdbeiz"
									style="margin-top: 8px; width: 58%; float: left; height: 84px;text-align:left;background-color:#ffffff;"
									onclick="openyijiandiv()"></div> <input name="bdbeizhu"
								id="bdbeizhuhedden" type="hidden" />
							</li>
						</ul>
					</div>
					<div class="guding_02">
						<input type="button" value="确认" class="anniu_03"
							onclick="saveBiaodanyijian(this);" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="guding" id="youls" style="display: none">
		<h3>
			<span>历史审核意见</span>
		</h3>
		<div class="department_02">
			<img src="../../../workflow/module/workflow/suofang1.png"
				onclick="hidedivls();" height="30px">
		</div>
		<div id="lishishenheyijian1">
			<div class="index1"></div>
			<div class="index"></div>
		</div>
	</div>
	<div id="right-menu" class="modal aside" data-body-scroll="false"
		data-offset="true" data-placement="right"
		data-fixed="<path:prop name="workflow.fixedModal"/>"
		data-backdrop="invisible" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h4 class="header lighter blue no-margin">
						<i class="ace-icon fa fa-lightbulb-o"></i>
						<path:i18n group="workflow" key="handleStatus" />
						<label class="pull-right"> <a id="fixed-modal"
							class="pointer"><i class="ace-icon fa fa-unlock bigger-160"
								data-fixed-icon="fa-lock" data-unfixed-icon="fa-unlock"></i></a>
						</label>
					</h4>
					<div class="space-6"></div>
					<div class="well well-sm">
						<div class="row no-margin">
							<label class="col-xs-12 col-sm-6 no-padding control-label">
								<i class="ace-icon fa fa-circle-o green bigger-110"></i> <path:i18n
									group="workflow" key="currentNode" />:
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<span class="orange"> <c:out
										value="${workFlow.flowNode.nodeName}" />
							</span>
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<i class="ace-icon fa fa-edit green smaller-90"></i> <path:i18n
									group="workflow" key="transactor" />:
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<span class="orange"> <c:out
										value="${workFlow.flowUser.transactorName}" />
							</span>
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<i class="ace-icon fa fa-flag green smaller-90"></i> <path:i18n
									group="workflow" key="flowStatus" />:
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<span class="orange"> <c:out
										value="${workFlow.flowStatusName}" />
							</span>
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<i class="ace-icon fa fa-user green bigger-110"></i> <path:i18n
									group="workflow" key="currentUser" />:
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<span class="orange"> <c:out
										value="${workFlow.flowUser.userName}" />
							</span>
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<i class="ace-icon fa fa-gavel green smaller-90"></i> <path:i18n
									group="workflow" key="userIdentity" />:
							</label> <label class="col-xs-12 col-sm-6 no-padding control-label">
								<span class="orange"> <c:out
										value="${workFlow.flowUser.authorName}" />
							</span>
							</label>
						</div>
					</div>
					<h4 class="header lighter blue no-margin">
						<i class="ace-icon fa fa-pencil-square-o"></i>
						<path:i18n group="workflow" key="comment" />
					</h4>
					<div class="space-6"></div>
					<div>
						<textarea
							placeholder=<path:i18n group="workflow" key="commentPlaceholder" />
							name="comment" class="form-control" rows="8" id="yijjianCom"></textarea>
					</div>
				</div>
			</div>
			<button
				class="aside-trigger btn btn-info btn-app btn-xs ace-settings-btn"
				data-target="#right-menu" data-toggle="modal" type="button">
				<i data-icon1="fa-fire" data-icon2="fa-minus"
					class="ace-icon fa fa-fire bigger-110 icon-only"></i>
			</button>
		</div>
	</div>
	<div class="hide">
		<input type="hidden" name="flowId"
			value='<c:out value="${workFlow.flowId}"/>' /> <input type="hidden"
			name="workId" value='<c:out value="${workFlow.workId}"/>' /> <input
			type="hidden" name="subjection"
			value='<c:out value="${workFlow.subjectionId}"/>' /> <input
			type="hidden" name="authorKey"
			value='<c:out value="${workFlow.authorKey}"/>' /> <input
			type="hidden" name="nodeId"
			value='<c:out value="${workFlow.flowNode.nodeId}"/>' /> <input
			type="hidden" name="nodeName"
			value='<c:out value="${workFlow.flowNode.nodeName}"/>' /> <input
			type="hidden" name="trackId"
			value='<c:out value="${workFlow.flowNode.trackId}"/>' /> <input
			type="hidden" name="userId"
			value='<c:out value="${workFlow.flowUser.userId}"/>' /> <input
			type="hidden" name="userName"
			value='<c:out value="${workFlow.flowUser.userName}"/>' /> <input
			type="hidden" name="deptId"
			value='<c:out value="${workFlow.flowUser.deptId}"/>' /> <input
			type="hidden" name="deptName"
			value='<c:out value="${workFlow.flowUser.deptName}"/>' /> <input
			type="hidden" name="unValidate"
			value='<path:prop name="workflow.unValidate"/>' />
	</div>
	</form>
	</div>
	</div>
	<a href="javascript:void(0);" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div>
	<div class="hidden">
		<div class="widget-box author-widget-box transparent">
			<div class="widget-header widget-header-flat widget-header-small">
				<div class="widget-title bigger-110 nowrap inline"></div>
				<div class="widget-toolbar no-border">
					<ul class="nav nav-tabs">
						<li class="author"><a data-toggle="not-allowed"
							href="javascript:void(0);"><path:i18n group="workflow"
									key="author" /></a></li>
						<li class="secondAuthor" style="display: none;"><a
							data-toggle="not-allowed" href="javascript:void(0);"><path:i18n
									group="workflow" key="secondAuthor" /></a></li>
						<li class="reader"><a data-toggle="not-allowed"
							href="javascript:void(0);"><path:i18n group="workflow"
									key="reader" /></a></li>
					</ul>
				</div>
				<div
					class="widget-toolbar timeLimit-toolbar no-border padding-3 hidden hide">
					<div class="input-group">
						<input tabindex="-1" name="timeLimit" type="text"
							onkeyup="this.value=this.value.replace(/\D/g, '')"
							onblur="this.value=this.value.replace(/\D/g, '')" /> <span
							class="input-group-btn">
							<button data-toggle="dropdown"
								class="timeLimitBtn btn btn-white btn-sm" type="button">
								<span class="grey"><path:i18n group="workflow"
										key="workday" /></span> <i
									class="ace-icon fa fa-caret-down icon-only"></i>
							</button>
							<ul
								class="dropdown-menu dropdown-info dropdown-menu-right dropdown-caret">
								<li class="active" data-code="0"><a
									href="javascript:void(0);"><path:i18n group="workflow"
											key="workday" /></a></li>
								<li data-code="1"><a href="javascript:void(0);"><path:i18n
											group="workflow" key="day" /></a></li>
								<li data-code="2"><a href="javascript:void(0);"><path:i18n
											group="workflow" key="hour" /></a></li>
							</ul>
						</span>
					</div>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="tabbable">
						<div class="tab-content padding-8">
							<div class="tab-pane author">
								<div class="no-padding author-container tags no-border"></div>
								<div class="hidden">
									<input type="hidden" name="id" /> <input type="hidden"
										name="name" /> <a href="javascript:void(0);"
										class="width-100 btn btn-sm btn-info btn-white btn-selectAuthor">
										<i class="ace-icon fa fa-user bigger-120 "></i> <path:i18n
											group="workflow" key="selectAnthor" />
									</a>
								</div>
							</div>
							<div class="tab-pane secondAuthor">
								<div class="no-padding secondAuthor-container tags no-border"></div>
								<div class="hidden">
									<input type="hidden" name="id" /> <input type="hidden"
										name="name" /> <a href="javascript:void(0);"
										class="width-100 btn btn-sm btn-info btn-white btn-selectSecondAuthor">
										<i class="ace-icon fa fa-user bigger-120 "></i> <path:i18n
											group="workflow" key="selectSecondAuthor" />
									</a>
								</div>
							</div>
							<div class="tab-pane reader">
								<div class="no-padding reader-container tags no-border"></div>
								<div class="hidden">
									<input type="hidden" name="id" /> <input type="hidden"
										name="name" /> <a href="javascript:void(0);"
										class="width-100 btn btn-sm btn-info btn-white btn-selectReader">
										<i class="ace-icon fa fa-user bigger-120 "></i> <path:i18n
											group="workflow" key="selectReader" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="control-group msg-type-container row no-margin"
			data-msg-type="<path:prop name="workflow.messageType"/>">
			<label class="control-label col-xs-1"><i
				class="ace-icon fa fa-envelope-o blue bigger-110"></i></label>
			<div class="checkbox col-xs-11 no-margin-top no-padding-left">
				<label> <input name="messageType" type="checkbox"
					class="ace" value="Mail" /> <span class="lbl"> <path:i18n
							group="workflow" key="mail" />
				</span>
				</label> <label> <input name="messageType" type="checkbox"
					class="ace" value="SMS" /> <span class="lbl"> <path:i18n
							group="workflow" key="sms" />
				</span>
				</label> <label> <input name="messageType" type="checkbox"
					class="ace" value="Msg" /> <span class="lbl"> <path:i18n
							group="workflow" key="msg" />
				</span>
				</label> <label> <input name="messageType" type="checkbox"
					class="ace" value="IM" /> <span class="lbl"> <path:i18n
							group="workflow" key="im" />
				</span>
				</label>
			</div>
		</div>
	</div>
	<div id="shenfenz"></div>
	<button type="button" class="hidden" id="focus">focus</button>
	<script
		data-main="<path:assetsPath/>/module/workflow/js/horizon.workflow"
		src="<path:frontPath/>/require/require.js"></script>
	</c:otherwise>
	</c:choose>

	<div id="showguquan" status="false"></div>
	<div id="showInfo" style="display:none;">
		<span id="saveInfo" style="display:none;"></span>
	</div>
	<div id="changyongyj" style="display:none;">
		<link href="../../../common/Untitled.css" rel="stylesheet" type="text/css" />
		<div class="biaoge">
			<div class="sousuo"></div>
			<input id="liandivid" type="hidden" /> 
			<input id="youding"type="hidden" />
			<script type="text/javascript">
   var cdcdc="";
function ShowElement(element)
{
	$("[aria-describedby='changyongyj'] #yijiancont").val("");
	$("[aria-describedby='changyongyj'] #yijiancont").hide();
	$("[aria-describedby='changyongyj'] #kongkong").show();
var oldhtml = element.innerHTML;
var newobj = document.createElement('input');
//创建新的input元素
newobj.type = 'text';
newobj.value = oldhtml;
newobj.style="width:100%;font-size:16px;"

//为新增元素添加类型
newobj.onblur = function(){
element.innerHTML = this.value ? this.value : oldhtml;
 cdcdc= this.value ? this.value : oldhtml;
 $("[aria-describedby='changyongyj'] #contui").html("");
	 var yewucodestrr =$("#liandivid").val();
	 var contentstr =cdcdc;
	 var id=$(element).attr("id");
     $.ajax({
        url: '../../../common/updateyijiancontent.jsp',
        type: "post",
        dataType: 'json',
        async: false,
        data: {
          yewucode:yewucodestrr,
		  content:contentstr,
		  id:id
        },
        error: function() {
            alert("error");
        },
		 success: function(data) {
			    $("#contui").html("");
		   $("[aria-describedby='changyongyj'] #contui").html("");
		    for(var i=0;i<data.length;i++){
		        var lihtml="<li style='border-bottom:1px #dfdfdf solid' id='"+data[i].id+"div' class='pilibudaixi'> "+
                        "<div style='display:table-row;'>"+
                        "<div  id='"+data[i].id+"' class='contleft' onclick='setElement(this)' ondblclick='ShowElement(this)' title='双击修改意见内容'>"+
						data[i].content+
						"</div>"+
                        "<div class='aright'>"+
                        "<a href='#' id='"+data[i].id+"href' onclick='shanchuyijian(this)'>删除</a>"+
                        "</div>"+
                        "<div style='clear:both'></div>"+
                        " </li>"
		        $("[aria-describedby='changyongyj'] #contui").append(lihtml);
			
			}
			licontent=data;
			$("[aria-describedby='changyongyj'] #yijiancont").val(contentstr);
			$("[aria-describedby='changyongyj'] #kongkong").hide();
			$("[aria-describedby='changyongyj'] #yijiancont").show();
			if(contentstr.trim()==""){
				$("[aria-describedby='changyongyj'] .pilibudaixi").show();
				return ;
			}
			
			for (var i = 0; i < licontent.length; i++) {
		      var contli =licontent[i].content
		      var cc =contli.match(contentstr);
		      var divid =licontent[i].id+"div";
				if (cc+""==""||cc+""=="null") {
					$("[aria-describedby='changyongyj'] #"+divid).hide();
					//ii=ii-1;
					
				}else{
					$("[aria-describedby='changyongyj'] #"+divid).show();
				}
		    }
		 }
		 
    });
//当触发时判断新增元素值是否为空，为空则不修改，并返回原有值 
}

element.innerHTML = '';
element.appendChild(newobj);
newobj.focus;
   //调用ajax方法进行表单修改
  
}

function setElement(b){
  document.getElementById("yijiancont").value=b.innerHTML;

}
var licontent = "";
function getYijianContext(){
	$(".sousuo").html("");
    var htmlinput ='<input name="" type="text" class="anniu_031" id="yijiancont" />'+
	'<input name="" type="text" class="anniu_031" id="kongkong" style="display:none" />'+
    '<img src="../../../common/sousuo.png" width="5%" />'+
	
    '<input name="" type="button" value="确定" class="anniu_021" onclick="setzhi()" />'+
	'<input name="" type="button" value="添加"  class="anniu_021" onclick="saveyijian()" />';
	$(".sousuo").html(htmlinput);
	
    $("#yijiancont").val("");
	$(".contui").html("");
	$("#yijiancont").keyup(
		function() {
			
		  var yijinneirong= $(this).val();
		 
          if(yijinneirong.trim()==""){
			 $("[aria-describedby='changyongyj'] .pilibudaixi").show();
             return;
          }else{
            // var ii=licontent.length;  
             for (var i = 0; i < licontent.length; i++) {
		      var contli =licontent[i].content;
		      var cc =contli.match(yijinneirong);
		      var divid =licontent[i].id+"div";
			  //alert(licontent[i].id);
			  //alert($("[aria-describedby='changyongyj'] #"+divid).html());
			 // alert("|"+cc+"|");
				if (cc+""=="null"||cc+""=="") {
					$("[aria-describedby='changyongyj'] #"+divid).hide();
					//ii=ii-1;
					
				}else{
					$("[aria-describedby='changyongyj'] #"+divid).show();
				}
		    }
		  }
		  
	    }
	)
    var yewucodestrr =$("#liandivid").val();
    $.ajax({
        url: '../../../common/getyijiancontent.jsp',
        type: "post",
        dataType: 'json',
        async: false,
        data: {
          yewucode:yewucodestrr
        },
        error: function() {
            alert("error");
        },
		 success: function(data) {
		   $("#contui").html("");
		   $("[aria-describedby='changyongyj'] #contui").html("");
		    for(var i=0;i<data.length;i++){
		        var lihtml="<li style='border-bottom:1px #dfdfdf solid' id='"+data[i].id+"div' class='pilibudaixi'> "+
                        "<div style='display:table-row;'>"+
                        "<div  id='"+data[i].id+"' class='contleft' onclick='setElement(this)' ondblclick='ShowElement(this)' title='双击修改意见内容'>"+
						data[i].content+
						"</div>"+
                        "<div class='aright'>"+
                        "<a href='#' id='"+data[i].id+"href' onclick='shanchuyijian(this)'>删除</a>"+
                        "</div>"+
                        "<div style='clear:both'></div>"+
                        " </li>"
		        $("#contui").append(lihtml);
			
			}
			licontent=data;
			 $("#changyongyj").dialog({
            minWidth : 610,
            minHeight : 470,
            title : "表单意见填写"              				 
           });
            $(".ui-dialog-buttonset").hide();
		 }
		 
    })
}

function setzhi(){
    var yijiancontstr =$("#yijiancont").val();
	var yewucodestrr =$("#youding").val();
	
    $("#shenhe"+yewucodestrr+" #hehehe").text(yijiancontstr);
	$("#shenhe"+yewucodestrr+" #bdbeizhuhedden").val(yijiancontstr)
	 $("[title='Close']").click();
	$(".ui-dialog-titlebar-close").click();
	//$("[data-operate='"+c+"']").click();
	//$("button[class='aside-trigger btn btn-info btn-app btn-xs ace-settings-btn']").click();

}

function saveyijian(){
        $("#contui").html("");
		   $("[aria-describedby='changyongyj'] #contui").html("");
	 var yewucodestrr =$("#liandivid").val();
	 var contentstr =$("#yijiancont").val();
     $.ajax({
        url: '../../../common/insertyijiancontent.jsp',
        type: "post",
        dataType: 'json',
        async: false,
        data: {
          yewucode:yewucodestrr,
		  content:contentstr
        },
        error: function() {
            alert("error");
        },
		 success: function(data) {
			 
		    for(var i=0;i<data.length;i++){
		        var lihtml="<li style='border-bottom:1px #dfdfdf solid' id='"+data[i].id+"div' class='pilibudaixi'> "+
                        "<div style='display:table-row;'>"+
                        "<div  id='"+data[i].id+"' class='contleft' onclick='setElement(this)' ondblclick='ShowElement(this)' title='双击修改意见内容'>"+
						data[i].content+
						"</div>"+
                        "<div class='aright'>"+
                        "<a href='#' id='"+data[i].id+"href' onclick='shanchuyijian(this)'>删除</a>"+
                        "</div>"+
                        "<div style='clear:both'></div>"+
                        " </li>"
		        $("#contui").append(lihtml);
			
			}
			licontent=data;
			if(contentstr.trim()==""){
				$("[aria-describedby='changyongyj'] .pilibudaixi").show();
				return ;
			}
			for (var i = 0; i < licontent.length; i++) {
		      var contli =licontent[i].content
		      var cc =contli.match(contentstr);
		      var divid =licontent[i].id+"div";
				if (cc+""==""||cc+""=="null") {
					$("[aria-describedby='changyongyj'] #"+divid).hide();
					//ii=ii-1;
					
				}else{
					$("[aria-describedby='changyongyj'] #"+divid).show();
				}
		    }
		 }
		 
    })

}

function shanchuyijian(a){
	var id=$(a).attr("id");
	   $("#contui").html("");
		   $("[aria-describedby='changyongyj'] #contui").html("");
	 var yewucodestrr =$("#liandivid").val();
	 var contentstr =$("#yijiancont").val();
     $.ajax({
        url: '../../../common/deleteyijiancontent.jsp',
        type: "post",
        dataType: 'json',
        async: false,
        data: {
          yewucode:yewucodestrr,
		  content:contentstr,
		  id:id
        },
        error: function() {
            alert("error");
        },
		 success: function(data) {
		    for(var i=0;i<data.length;i++){
		        var lihtml="<li class='pilibudaixi' style='border-bottom:1px #dfdfdf solid' id='"+data[i].id+"div'> "+
                        "<div style='display:table-row;'>"+
                        "<div  id='"+data[i].id+"' class='contleft' onclick='setElement(this)' ondblclick='ShowElement(this)' title='双击修改意见内容'>"+
						data[i].content+
						"</div>"+
                        "<div class='aright'>"+
                        "<a href='#' id='"+data[i].id+"href' onclick='shanchuyijian(this)'>删除</a>"+
                        "</div>"+
                        "<div style='clear:both'></div>"+
                        " </li>"
		        $("#contui").append(lihtml);
			    $("[aria-describedby='changyongyj'] #contui").append(lihtml);
			}
			licontent=data;
			
			for (var i = 0; i < licontent.length; i++) {
		      var contli =licontent[i].content
		      var cc =contli.match(contentstr);
		      var divid =licontent[i].id+"div";
				if (cc+""==""||cc+""=="null") {
					$("#"+divid).hide();
					//ii=ii-1;
					
				}else{
					$("#"+divid).show();
				}
		    }
		 }
		 
    })
}
function openyijiandiv(){
    getYijianContext();
}
</script>

			<ul id="contui">

			</ul>
		</div>
	</div>
	<div id="dayinghtml" style="display:none">
	<div id="imgscss"></div>
	<div id="dayingcontent"></div>
	</div>
</body>
</html>
