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
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/businessStationService/update.do"> 
            <table>
						<input type="hidden" id="serviceId" name="serviceId" value="${businessStationService.serviceId}" />
						<input type="hidden" id="stationId" name="stationId" value="${businessStationService.stationId}" />
						<tr>
			          <td>驿站名称：</td>
			          <td>
			          	${staName}
			          </td>
			        </tr> 
					<tr>
			          <td>服务名称：</td>
			          <td>
			          	<input name="serviceName"  id="serviceName"  style="width: 250px;" value="${businessStationService.serviceName}"  class="easyui-validatebox" required="true" missingMessage="请输入服务名称" />
			          </td>
			        </tr>
					<tr>
			          <td>服务内容：</td>
			          <td>
			          	<input name="content"  id="content" rows="5" cols="18" style="width: 250px;" value="${businessStationService.content}"  class="easyui-validatebox" required="true" missingMessage="请输入服务内容" />
			          </td>
			        </tr>
					<tr>
			          <td>图片路径：</td>
			          <td>
			          	<input name="servicePic" id="servicePic" type="text" style="width: 250px;" value="${businessStationService.servicePic}" class="easyui-validatebox" required="true" missingMessage="图片路径" />
			          </td>
			        </tr>
					<tr>
			          <td>编辑人 ：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 250px;" value="${businessStationService.editor}"  missingMessage="请输入编辑人 "/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
    </div>
</body>
</html>