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
		
</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=basePath %>/manage/manageAdmin/update.do">
            <table>
						<input type="hidden" id="adminId" name="adminId" value="${manageAdmin.adminId}" />
					<tr>
			          <td>管理员账号：</td>
			          <td>
			          	<input name="adminName" id="adminName" type="text" style="width: 150px;" value="${manageAdmin.adminName}" class="easyui-validatebox" required="true" missingMessage="请输入管理员账号" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>管理员密码：</td>
			          <td>
			          	<input name="adminPassword" id="adminPassword" type="text" style="width: 150px;" value="${manageAdmin.adminPassword}" class="easyui-validatebox" required="true" missingMessage="请输入管理员密码" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>角色类型：</td>
			          <td>
			          	<input name="adminType" id="adminType" type="text" style="width: 150px;" value="${manageAdmin.adminType}" class="easyui-validatebox" required="true" missingMessage="请输入角色类型" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="adminType" id="adminType" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择角色类型">
			          		<option value="">请选择</option>
			          		<option value="0" <c:if test="${manageAdmin.adminType} == 0 "> selected </c:if> >是</option>
			          		<option value="1" <c:if test="${manageAdmin.adminType} == 1 "> selected </c:if> >否</option>
			          	</select>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>