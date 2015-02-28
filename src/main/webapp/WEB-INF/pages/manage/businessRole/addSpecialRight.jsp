
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
function resetCom() {
	alert('asdfasdf');
}
	
	</script>
</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=ctx %>/manage/businessRole/specialSave.do">
            <div id="tabs">
							<table id="addSpecialRightTable" cellpadding="0" cellspacing="0" style="width: 800px; margin: 0px;padding: 0px;">
								
								<tr style="border: 1px solid;">
									<td style="padding:5px; border: 1px solid #C0C0C0; width: 200px" >功能菜单</td>
									<td style="border: 1px solid #C0C0C0;">功能权限</td>
								</tr>
								
								<c:forEach items="${menuList}" var="menu" varStatus="menuIndex">								
								<tr style="border: 1px solid;">
									<td style="padding:5px; border: 1px solid #C0C0C0; width: 100px">
									<input type="checkbox" id="menuId_${menu.menuId}_${menu.menuName}" name="menuId" value="${menu.menuId }" onclick="selectMenu(${menu.menuId }, '${menu.menuName}')"/>
									${menu.menuName}</td>
									<td style="border: 1px solid #C0C0C0;">
										<c:forEach items="${menu.functionList}" var="function">
											<input type="checkbox" class="functionType" id="functionId_${function.functionId}_${function.functionName}" name="functionId_${menu.menuId}" value="${function.functionId }" onclick="selectFunction(${menu.menuId}, '${menu.menuName}', ${function.functionId}, '${function.functionName}')"/>
											${function.functionName }
										</c:forEach>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="resetRight()" id="btn-reset" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>重置</a>
            <a href="javascript:void(0)" onclick="saveResourceRight()" id="btn-save-right" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="updateRight()" id="btn-update-right" style="display:none;" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
        </div>
</body>
</html>