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
	init("modifyEstateCarMapImage");
	init("modifyEstateMapImage");
	$.ajax({
	    type: "post",
	    url: "<%=path %>/manage/manageCounty/getComboboxData.do",
	    success: function(data){
	        data=JSON.parse(data);
	        for(var i=0;i<data.length;i++){
                if(data[i].label=='${manageOrg.countyId}'){
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
	        $("#countyId").combobox(vm);
	    },
	    error:function(error){
	        $.messager.alert('系统提示', error, 'warning');

	    }
	});
})

</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/manageOrg/update.do">
            <table>
						<input type="hidden" id="orgId" name="orgId" value="${manageOrg.orgId}" />
					<tr>
			          <td>区域：</td>
			          <td>
			          	<div  type='text' id="countyId" name="countyId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
					<tr>
			          <td>机构名称：</td>
			          <td>
			          	<input name="orgName" id="orgName" type="text" style="width: 150px;" value="${manageOrg.orgName}" class="easyui-validatebox" required="true" missingMessage="请输入机构名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构介绍：</td>
			          <td>
			          	 <textarea name="orgDesc"  id="orgDesc" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入机构介绍" validType="reDes">${manageOrg.orgDesc}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>机构状态：</td>
			          <td>
			          <select name="orgState" id="orgState" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择状态" style="width: 150px;">
			          		<option value="">请选择</option>
			          		<option value="0" <c:if test="${manageOrg.orgState == 0}">selected </c:if> >启用</option>
			          		<option value="1" <c:if test="${manageOrg.orgState == 1}">selected </c:if> >禁用</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>机构电话：</td>
			          <td>
			          	<input name="orgTel" id="orgTel" type="text" style="width: 150px;" value="${manageOrg.orgTel}" class="easyui-validatebox" required="true" missingMessage="请输入机构电话" validType="reTel"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构邮箱：</td>
			          <td>
			          	<input name="orgEmail" id="orgEmail" type="text" style="width: 150px;" value="${manageOrg.orgEmail}" class="easyui-validatebox" required="true" missingMessage="请输入机构邮箱" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>机构微信：</td>
			          <td>
			          	<input name="orgWeixin" id="orgWeixin" type="text" style="width: 150px;" value="${manageOrg.orgWeixin}" class="easyui-validatebox" required="true" missingMessage="请输入机构微信" validType="maxLength[32]"/>
			          </td>
			        </tr>
					<tr>
			          <td>排序：</td>
			          <td>
			          	<input name="ord" id="ord" type="text" style="width: 150px;" value="${manageOrg.ord}" class="easyui-validatebox" required="true" missingMessage="请输入排序"  validType="reSz"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData1('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>