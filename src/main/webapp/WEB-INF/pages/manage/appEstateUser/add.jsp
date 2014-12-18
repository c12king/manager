
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
            <form id="addForm" method="post" action="<%=path %>/app/appEstateUser/save.do">
            <table>
					<tr>
			          <td>小区ID：</td>
			          <td>
			          	<input name="estateId" id="estateId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入小区ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="estateId" id="estateId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择小区ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>用户ID：</td>
			          <td>
			          	<input name="userId" id="userId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入用户ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="userId" id="userId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择用户ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>楼栋ID：</td>
			          <td>
			          	<input name="buildingId" id="buildingId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入楼栋ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="buildingId" id="buildingId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择楼栋ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>单元ID：</td>
			          <td>
			          	<input name="unitId" id="unitId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入单元ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="unitId" id="unitId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择单元ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>住户ID：</td>
			          <td>
			          	<input name="houseId" id="houseId" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入住户ID" validType="[0,100000]" invalidMessage="只能输入数字,最大为100000"/>
			          	<select name="houseId" id="houseId" class="selectwidth easyui-validatebox"  required="true" missingMessage="请选择住户ID">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>小区名称：</td>
			          <td>
			          	<input name="estateName" id="estateName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入小区名称" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>楼栋名称：</td>
			          <td>
			          	<input name="buildingName" id="buildingName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入楼栋名称" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>单元：</td>
			          <td>
			          	<input name="unitName" id="unitName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入单元" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>门号：</td>
			          <td>
			          	<input name="houseNo" id="houseNo" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入门号" invalidMessage="内容不能超过32个字"/>
			          </td>
			        </tr>
					<tr>
			          <td>类型：</td>
			          <td>
			          	<input name="memberType" id="memberType" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入类型" validType="reName"/>
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
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>