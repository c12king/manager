<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jian.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
		
<script type="text/javascript">
function login() {

	$('#loginForm').form('submit', {
        url: $('#loginForm').attr('action'),
        onSubmit:function(){
    		return $('#loginForm').form('validate');   
		},
        success: function (data) {
            eval('data=' + data);
            if (data.success == 'true') {
                window.location.href = '<%=basePath %>/index/main.do';
            } else {
                $.messager.alert('错误', '您输入的用户名或者密码不正确，请重新输入!', 'error');
                $('#loginForm').form('clear');
            }
        }
    });
}

	function clear() {
		$('#loginForm').form('clear');
	}
</script>

</head>
<body class="easyui-layout">
	
	<noscript>
        <div style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px;
            width: 100%; background: white; text-align: center;">
            <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
        </div>
    </noscript>
    <div region="north" title="020后台管理系统" split="false" >
	</div>
	<div region="south" title="系统信息" split="true" style="height:60px;padding:5px;background:#efefef;">
			<div>系统信息</div>
	</div>
	<div region="center" title="系统管理" style="overflow:hidden;">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
			 <form id="loginForm" method="post" action="<%=basePath %>/index/login.do" >
			 <fieldset>
				<div title="登录" style="padding:10px 0 20px 20px;overflow:hidden;"> 
					<div style="margin-top:20px;">
						<h3>020后台管理系统</h3>
					</div>
					<div >
						<label>用户名:</label>
						<input name="adminName" id="adminName" class="easyui-validatebox" required="true" missingMessage="请输入用户名" type="text" value="" >
					</div>
					<div style="padding-top:10px;">
						<label>密&nbsp;&nbsp;码:</label>
						<input name="adminPassword" id="adminPassword" class="easyui-validatebox" required="true" missingMessage="请输入密码" type="password" value="" >
					</div>
					<div style="padding-top:10px;">
						<label>${message }</label>
					</div>
					<div style="padding-top:10px;">
						<input type="button" value="确定" onclick="login()" />
						<input type="button" value="取消" onclick="clear()" />
					</div>
				</div>
				</fieldset>
			</form>	
			</div>
		</div>
</body>
</html>