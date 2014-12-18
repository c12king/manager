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

<div class="easyui-layout">
	<div data-options='region:"center",split:true,border:true'>
	    <form id="addFuntion" method="post" action="<%=path %>/business/businessUserResource/save_resources.do">
			<input type="hidden" name="userId" value="${userId}">
			<c:forEach items="${estateList}" var="estate" >
				<input type="checkbox" name="estateId"   value="${estate.estateId}"
					<c:forEach items="${reList}" var="re" > 
           				 <c:if test="${re.estateId == estate.estateId}">
           				  checked 
           				 </c:if>
           			 </c:forEach>
				/>
				${estate.estateName}
			</c:forEach>
			<c:forEach items="${communityList}" var="community">
				<input type="checkbox" name="comId"   value="${community.comId}"
					<c:forEach items="${reList}" var="re" > 
           				 <c:if test="${re.comId == community.comId}">
           				  checked 
           				 </c:if>
           			 </c:forEach>
				/>
				${community.comName}
			</c:forEach>
		</form>
	</div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 500px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:200px;">
    	<div style="text-align: center; padding: 5px;margin-top:60px">
            <a href="javascript:void(0)" onclick="saveData('', 'addFuntion')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
    </div>
</div>
</body>

</html>
