
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

</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/business/businessDepartment/save.do">
            <table>
					<tr>
			          <td>部门名称：</td>
			          <td>
			          	<input name="depName" id="depName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入部门名称" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>部门描述：</td>
			          <td>
			          	<input name="depDesc" id="depDesc" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入部门描述" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>创建时间：</td>
			          <td>
			          	<input name="createTime" id="createTime" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入创建时间" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑时间：</td>
			          <td>
			          	<input name="editTime" id="editTime" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入编辑时间" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入编辑人" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构类型：</td>
			          <td>
			          	<input name="orgType" id="orgType" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入机构类型" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构ID：</td>
			          <td>
			          	<input name="orgId" id="orgId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入机构ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="orgId" id="orgId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择机构ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>机构名称：</td>
			          <td>
			          	<input name="orgName" id="orgName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入机构名称" invalidMessage="内容不能超过32个字"/>
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