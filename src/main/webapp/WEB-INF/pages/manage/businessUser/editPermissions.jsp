<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>权限管理</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui-1.10.2.custom.min.css" >
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.10.2.custom.min.js"></script>

</head>
<body>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.10.2.custom.min.js"></script>
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	</script>
<div class="easyui-layout">
	<div data-options='region:"center",split:true,border:true'>
	    <form id="addFuntion" method="post" action="<%=path %>/manage/manageUserFunction/save.do">
			<input type="hidden" name="userId" value="${userId}">
		<div id="tabs">
			<ul>
			<c:forEach items="${map}" var="module" varStatus="moduleIndex">
				<li><a href="#tabs-${moduleIndex.index}" >${module.value.moduleName}</a></li>   
		   	</c:forEach>
			</ul>
			<c:forEach items="${map}" var="module" varStatus="moduleIndex">
				<div id="tabs-${moduleIndex.index}">
					<table cellpadding="0" cellspacing="0" style="width: 950px; margin: 0px;padding: 0px;">
						<c:forEach items="${module.value.menuMap}" var="menu" >
							<tr style="border: 1px solid;">
								<td style="border: 1px solid; width: 40px">${menu.value.menuMame}</td>
								<td style="border: 1px solid;">
									<c:forEach items="${menu.value.List}" var="function" >
										<input type="checkbox" name="functionId${module.value.moduleCode}"   value="${function.functionId }"
											<c:forEach items="${module.value.checkedList}" var="item1" > 
					            				 <c:if test="${function.functionId == item1.functionId}">
					            				  checked 
					            				 </c:if>
					            			 </c:forEach>
										/>
										${function.functionName }
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:forEach>
		</div>
		</form>
		<div style="text-align: center; padding: 5px;margin-top:60px">
            <a href="javascript:void(0)" onclick="saveData('', 'addFuntion')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
	</div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 450px;"></div>
</div>
</body>

</html>
