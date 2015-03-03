
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
    
    <title>自定义分配小区</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	
	</script>
</head>
<body>
<script type="text/javascript">
$(function(){

})
</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/manage/businessUser/save.do">
            <table>
            <tr>
            <td>
            <c:forEach items="${checkBoxList}" var="estate">
            											<input type="checkbox" class="estateId_${resource.comId}" id="estateId_${estate.estateId}_${estate.estateName}" name="estateId" value="${estate.estateId }" onclick="selectEstate(${resource.comId},'${resource.comName}', ${estate.estateId}, '${estate.estateName}')"
											
					            				 <c:if test="${estate.state == 1}">
					            				  checked 
					            				 </c:if>
											
											/>
            </c:forEach>
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