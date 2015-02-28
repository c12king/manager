
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	
	function selectMenu(menuId) {
		alert('menuId   '+menuId);
	}
	
	</script>
</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=ctx %>/manage/businessRole/standardSave.do">
            <table>
					<tr>
			          <td>角色名称：</td>
			          <td>
			          	<input name="roleName" id="roleName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入角色名称" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>角色描述：</td>
			          <td>
			          	<input name="roleDesc" id="roleDesc" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入角色描述" validType="reName"/>
			          </td>
			        </tr>
					
					<tr>
			          <td>选择角色所属部门：</td>
			          <td>
			          	<select name="groupId" id="groupId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择所属部门">
			          		<option value="">请选择</option>
			          		<c:forEach items="${groupList }" var="group">
			          		<option value="${group.groupId }">${group.groupName }</option>
			          		</c:forEach>
			          	</select>
			          </td>
			        </tr>
					
					<!-- <tr>
			          <td>是否特殊角色：</td>
			          <td>
			          	<select name="isSpecial" id="isSpecial" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择是否特殊角色">
			          		<option value="">请选择</option>
			          		<option value="0">否</option>
			          		<option value="1">是</option>
			          	</select>
			          </td>
			        </tr> -->
			        
			        <tr>
			          <td colspan="2">&nbsp;</td>
			        </tr>
			        
			        <tr>
			          <td>角色权限设置：</td>
			          <td>
			          	&nbsp;
			          </td>
			        </tr>
			        
			        <tr>
			          <td colspan="2">
			          
			          <div id="tabs">
							<table cellpadding="0" cellspacing="0" style="width: 950px; margin: 0px;padding: 0px;">
								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid; width: 100px" >功能菜单</td>
									<td style="border: 1px solid;">功能权限</td>
								</tr>
								
								<c:forEach items="${menuList}" var="menu" varStatus="menuIndex">								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid; width: 100px">
									<input type="checkbox" id="menuId_${menu.menuId}" name="menuId" value="${menu.menuId }" onclick="selectMenu(${menu.menuId })"/>
									${menu.menuMame}</td>
									<td style="border: 1px solid;">
										<c:forEach items="${menu.functionList}" var="function">
											<input type="checkbox" id="functionId_${function.functionId}" name="functionId_${menu.menuId}" value="${function.functionId }" onclick="selectFunction(${menu.menuId}, ${function.functionId})"/>
											${function.functionName }
										</c:forEach>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						
					</div>
			          
			          </td>
			        </tr>
			        
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>