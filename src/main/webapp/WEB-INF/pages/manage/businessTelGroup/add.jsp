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
<script type="text/javascript">
$(function(){
	$.ajax({
	    type: "post",
	    url: "<%=path %>/manage/manageCounty/getComboboxData.do",
	    success: function(data){
	        data=JSON.parse(data);
	        vm ={
	        	editable:false,
	            valueField:'label',
	            textField:'value',
	            data:  data ,
	            required: true,
	            missingMessage:'该输入项为必填项',
	            onSelect:function(param){
	            	$.ajax({
	            	    type: "post",
	            	    url: "<%=path %>/manage/businessCommunity/getComboboxData.do?countyId="+param.label,
	            	    success: function(data){
	            	        data=JSON.parse(data);
	            	        for(var i=0;i<data.length;i++){
	                            if(data[i].label=='${manageEstate.comId}'){
	                                data[i].selected=true
	                            }else{
	                                data[i].selected=false
	                            }
	                        }
	            	        vm ={
	            	        	editable:false,
	            	            valueField:'label',
	            	            textField:'value',
	            	            data:  data ,
	            	            required: true,
	            	            missingMessage:'该输入项为必填项'
	            	        }
	            	        $("#comId1").combobox(vm);
	            	    },
	            	    error:function(error){
	            	        $.messager.alert('系统提示', error, 'warning');

	            	    }
	            	});
	            	
	            	$.ajax({
	            	    type: "post",
	            	    url: "<%=path %>/manage/businessProperty/getComboboxData.do?countyId="+param.label,
	            	    success: function(data){
	            	        data=JSON.parse(data);
	            	        for(var i=0;i<data.length;i++){
	                            if(data[i].label=='${manageEstate.proId}'){
	                                data[i].selected=true
	                            }else{
	                                data[i].selected=false
	                            }
	                        }
	            	        vm ={
	            	        	editable:false,
	            	            valueField:'label',
	            	            textField:'value',
	            	            data:  data
	            	        }
	            	        $("#proId1").combobox(vm);
	            	    },
	            	    error:function(error){
	            	        $.messager.alert('系统提示', error, 'warning');

	            	    }
	            	});
	            	
	            	$.ajax({
	            	    type: "post",
	            	    url: "<%=path %>/manage/businessStation/getComboboxData.do?countyId="+param.label,
	            	    success: function(data){
	            	        data=JSON.parse(data);
	            	        for(var i=0;i<data.length;i++){
	                            if(data[i].label=='${manageEstate.stationId}'){
	                                data[i].selected=true
	                            }else{
	                                data[i].selected=false
	                            }
	                        }
	            	        vm ={
	            	        	editable:false,
	            	            valueField:'label',
	            	            textField:'value',
	            	            data:  data
	            	        }
	            	        $("#stationId1").combobox(vm);
	            	    },
	            	    error:function(error){
	            	        $.messager.alert('系统提示', error, 'warning');

	            	    }
	            	});	
	            }
	        }
	        $("#countyId1").combobox(vm);
	        $("#countyId1").combobox('select', '${manageEstate.countyId}');
	    },
	    error:function(error){
	        $.messager.alert('系统提示', error, 'warning');

	    }
	});
})

</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/manage/businessTelGroup/save.do">
<%--             <input type="hidden" id="groupId" name="groupId" value="${businessTelGroup.groupId}" /> --%>
<%-- 				<input type="hidden" id="estateId" name="estateId" value="${estateId}" />  --%> 
            <table>
			        <tr>
			          <td>城市ID：</td>
			          <td>
			          	<input name="cityId" id="cityId" type="text" style="width: 150px;" value="0" class="easyui-validatebox"  readonly/>

			          </td>
			        </tr>
					
			        <tr>
			          <td>社区ID：</td>
			          <td>
			          	<input name="comId" id="comId" type="text" style="width: 150px;" value="${comId}" class="easyui-validatebox"  readonly/>
			          </td>
			        </tr>
			        <tr>
			          <td>小区ID：</td>
			          <td>
			          	<input name="estateId" id="estateId" type="text" style="width: 150px;" value="${estateId}" class="easyui-validatebox"  readonly/>
			          </td>
			        </tr>
			        <tr>
			          <td>组名：</td>
			          <td>

			          	<input name="groupName" id="groupName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入小区纬度" />
			          	
			          </td>
			        </tr>
			        <tr>
			          <td>描述：</td>
			          <td>
			          	<input name="memo" id="memo" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入小区纬度" />
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData2('addxxx', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>