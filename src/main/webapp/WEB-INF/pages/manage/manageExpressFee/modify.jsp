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
            <form id="modifyForm" method="post" action="<%=path %>/manage/manageExpressFee/update.do">
            <input name="feeId" id="feeId" type="hidden" value="${manageExpressFee.feeId}" /> 
            <input name="expressId" id="expressId" type="hidden" value="${manageExpressFee.expressId}" /> 
            <table>
			         <tr>
			          <td>范围：</td>
			          <td>
			            <textarea name="title" id="title"   type="text" style="width: 250px;" maxlength="256"  class="easyui-validatebox"  required="true" missingMessage="请输入快递范围" >${manageExpressFee.title}</textarea>
			          </td>
			        </tr>
			        <tr>
			          <td>内容：</td>
			          <td>
			            <textarea name="content" id="content"   type="text" style="width: 250px;" maxlength="256"  class="easyui-validatebox"  required="true" missingMessage="请输入快递资费" >${manageExpressFee.content}</textarea>
			          </td>
			        </tr>
			        
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData3('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>