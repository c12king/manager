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
            <form id="modifyForm" method="post" action="<%=path %>/manage/manageExpress/update.do">
            <input type="hidden" id="expressId" name="expressId" value="${manageExpress.expressId}" />
            <table>
			        <tr>
			          <td>快递公司：</td>
			          <td>
			          	<input name="expressComppay" id="expressComppay" type="text" style="width: 200px;" maxlength="64" value="${manageExpress.expressComppay}" class="easyui-validatebox"  required="true" missingMessage="请输入快递公司名称" />
			          </td>
			        </tr>
					
			        <tr>
			          <td>快递公司描述：</td>
			          <td>
			          	<textarea name="expressDesc" id="expressDesc"  maxlength="255"   type="text" style="width: 200px;"  class="easyui-validatebox"  required="true" missingMessage="请输入快递公司描述" >${manageExpress.expressDesc}</textarea>
			          </td>
			        </tr>
			        <tr>
			          <td>快递公司地址：</td>
			          <td>
			          	<input name="expressAddress" id="expressAddress" type="text" style="width: 200px;"  maxlength="128" value="${manageExpress.expressAddress}" class="easyui-validatebox"  required="true" missingMessage="请输入快递公司地址" />
			          </td>
			        </tr>
			        <tr>
			          <td>公司LOGO：</td>
			          <td>
			          	<input name="expressIcon" id="expressIcon" type="text" style="width: 200px;" maxlength="128" value="${manageExpress.expressIcon}" class="easyui-validatebox"  required="true" missingMessage="请输入公司LOGO路径" />
			          </td>
			        </tr>
			        <tr>
			          <td>快递电话：</td>
			          <td>
			          	<input name="expressTel" id="expressTel" type="text" style="width: 200px;"  maxlength="32" value="${manageExpress.expressTel}" class="easyui-validatebox"  required="true" missingMessage="请输入快递电话" />
			          </td>
			        </tr>
			        <tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 200px;" maxlength="32"  value="${manageExpress.editor}" class="easyui-validatebox"    missingMessage="请输入编辑人" />
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData2('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>