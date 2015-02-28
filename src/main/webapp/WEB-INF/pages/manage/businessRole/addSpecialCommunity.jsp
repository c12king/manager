
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
							<table id="addSpecialCommunityTable" cellpadding="0" cellspacing="0" style="width: 800px; margin: 0px;padding: 0px;">
								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid #C0C0C0; width: 200px" >社区范围</td>
									<td style="border: 1px solid #C0C0C0;">小区范围</td>
								</tr>
								
								<c:forEach items="${resourceList}" var="resource" varStatus="menuIndex">								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid  #C0C0C0; width: 100px">
									<input type="checkbox" id="comId_${resource.comId}_${resource.comName}" name="comId" value="${resource.comId }" onclick="selectCom(${resource.comId }, '${resource.comName }')"/>
									${resource.comName}</td>
									<td style="border: 1px solid #C0C0C0;">
										<c:forEach items="${resource.manageEstateList}" var="estate">
											<input type="checkbox" class="estateType" id="estateId_${estate.estateId}_${estate.estateName}" name="estateId_${resource.comId}" value="${estate.estateId }" onclick="selectEstate(${resource.comId},'${resource.comName}', ${estate.estateId}, '${estate.estateName}')"/>
											${estate.estateName }
										</c:forEach>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="resetCom()" id="btn-reset-community" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>重置</a>
            <a href="javascript:void(0)" onclick="resourceNext()" id="btn-resource-next" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>下一步，配置权限</a>
            <a href="javascript:void(0)" onclick="updateResource()" id="btn-update-community" style="display:none;" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
        </div>
</body>
</html>