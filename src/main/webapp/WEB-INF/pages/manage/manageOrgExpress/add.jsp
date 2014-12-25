
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
<body onload="loadSelect()">
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/manage/manageOrgExpress/save.do">
           <input name="stationId" id="stationId" type="hidden" style="width: 150px;" value="${stationId}"  />
            <table>
					<tr>
			          <td>驿站名称：</td>
			          <td>
			          	${staName}
			          </td>
			        </tr> 
					<tr>
			          <td>快递公司：</td>
			          <td>
			          <div  type='text' id="expressId" name="expressId" style='width:250px; margin-right:5px'>    
			          	</div>
			          </td>
			        </tr>
					<tr>
			          <td>是否上门取件：</td>
			          <td>
			               <input class="radiostyle" type="radio" name="expState" value="0"  checked>是
                           <input class="radiostyle" type="radio" name="expState" value="1">否
			          </td>
			        </tr>
					<tr>
			          <td>编辑人 ：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 250px;" value=""  missingMessage="请输入编辑人 "/>
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
	    url: "<%=path %>/manage/manageExpress/getComboboxData.do",
	    success: function(data){
	        data=JSON.parse(data);
	        vm ={
	        	editable:false,
	            valueField:'label',
	            textField:'value',
	            data:  data ,
	            required: true,
	            missingMessage:'该输入项为必填项'
	        };
	        $("#expressId").combobox(vm);
	    },
	    error:function(error){
	        $.messager.alert('系统提示', error, 'warning');

	    }
	});

})
</script>

</body>
</html>