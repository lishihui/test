<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>中华人民共和国工业和信息化部</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/comm.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="layui-layout-body layui-layout-admin name-register">
		<%--列表内容--%>
		<div class="layui-side">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed">
						<a class="" href="javascript:;">域名注册管理机构申请<span class="layui-nav-more"></span></a>
						<dl class="layui-nav-child">
							<dd class="layui-this">
								<a href="javascript:openForm('申请表单','<%=request.getContextPath()%>/DxxzspDomainApplytask/toDxxzspDomainApplytask?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>申请表单
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('顶级域基本情况 ','<%=request.getContextPath()%>/DxxzspDomainBase/toDxxzspDomainBase?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>顶级域基本情况 
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('域名注册管理机构申请表 ','<%=request.getContextPath()%>/DxxzspDomainRegister/toDxxzspDomainRegister?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>域名注册管理机构申请表
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('公司概况','<%=request.getContextPath()%>/DxxzspDomainCompany/toDxxzspDomainCompany?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>公司概况
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('技术实施方案','<%=request.getContextPath()%>/DxxzspDomainTechplan/toDxxzspDomainTechplan?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>技术实施方案
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('信息安全保障措施','<%=request.getContextPath()%>/DxxzspDomainInfosafety/toDxxzspDomainInfosafety?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>信息安全保障措施
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('网络安全保障措施','<%=request.getContextPath()%>/DxxzspDomainNetworksafety/toDxxzspDomainNetworksafety?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>网络安全保障措施
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('域名注册管理相关制度','<%=request.getContextPath()%>/DxxzspDomainManagement/toDxxzspDomainManagement?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>域名注册管理相关制度
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('顶级域注册管理系统相关协议','<%=request.getContextPath()%>/DxxzspDomainAgreement/toDxxzspDomainAgreement?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>顶级域注册管理系统相关协议
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('顶级域注册管理系统场所情况','<%=request.getContextPath()%>/DxxzspDomainPlace/toDxxzspDomainPlace?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>顶级域注册管理系统场所情况
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('依法经营和诚信经营承诺书','<%=request.getContextPath()%>/DxxzspDomainPromise/toDxxzspDomainPromise?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>依法经营和诚信经营承诺书
								</a>
							</dd>
							<dd>
								<a href="javascript:openForm('电信管理机构要求提供的其他材料','<%=request.getContextPath()%>/DxxzspDomainOthers/toDxxzspDomainOthers?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001','11');">
									<span></span>电信管理机构要求提供的其他材料
								</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<%--表单内容--%>
		<div class="layui-body">
			<div class="layui-card">
				<div class="layui-card-header" style="height:50px;line-height:50px;padding-left:50px;">
					<div class="tt-btn close" style="display: block;">
						<i></i>
					</div>
					<div class="tt-btn open">
						<i></i>
					</div>
					<span id="title"></span>
				</div>
			</div>
			<div class="layui-fluid scroll" style="position: absolute;top: 68px;bottom: 10px;left: 0;right: 0">
				<iframe id="winiframe" frameborder="0" width="100%" height="100%" src=""></iframe>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		//点击表单列表
		function openForm(title,url){
			$("#title").html(title);//修改标题
			$("#winiframe").attr("src", url);//跳转页面
		}
		
		$(function() {
		    //默认打开一个表单
		    openForm("申请表单","<%=request.getContextPath()%>/DxxzspDomainApplytask/toDxxzspDomainApplytask?id=381ed9690fd342818d938b2584064dca&flowrunid=F1001");
		    
			//左操作栏展开收起
			$(".tt-btn.open").click(function() {
				$(".layui-side,.tt-btn.close").show();
				$(".tt-btn.open").hide();
				$(this).parents(".layui-body").css("left", "280px")
			})
			$(".tt-btn.close").click(function() {
				$(".tt-btn.open").show();
				$(".layui-side,.tt-btn.close").hide();
				$(this).parents(".layui-body").css("left", "0")
			})
		});
	</script>
</body>
</html>