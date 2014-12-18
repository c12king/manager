
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
            <form id="addForm" method="post" action="<%=path %>/manage/manageFunction/save.do">
            <table>
					<tr>
			          <td>菜单：</td>
			          <td>
			          	<div  type='text' id="menu1" name="menuId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
					<tr>
			          <td>功能名称：</td>
			          <td>
			          	<input name="functionName" id="functionName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入功能名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>功能描述：</td>
			          <td>
			          	 <textarea name="functionDesc"  id="functionDesc" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入功能描述" validType="reDes"></textarea>
			          </td>
			        </tr>
					<tr>
			          <td>功能编码：</td>
			          <td>
			          	<input name="functionCode" id="functionCode" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入功能编码" validType="reName"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
<script type="text/javascript">
$(function(){
	$.ajax({
	    type: "post",
	    url: "<%=path %>/manage/businessMenu/getComboboxData.do",
	    success: function(data){
	        data=JSON.parse(data);
	        vm ={
	        	editable:false,
	            valueField:'label',
	            textField:'value',
	            data:  data ,
	            required: true,
	            missingMessage:'该输入项为必填项'
	        }
	        $("#menu1").combobox(vm);
	    },
	    error:function(error){
	        $.messager.alert('系统提示', error, 'warning');

	    }
	});
})

</script>
</body>
</html>