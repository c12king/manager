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
            <form id="modifyForm" method="post" action="<%=path %>/manage/manageEstate/update.do">
            <table>
						<input type="hidden" id="estateId" name="estateId" value="${manageEstate.estateId}" />
			        <tr>
			          <td>区域：</td>
			          <td>
			          	<div  type='text' id="countyId1" name="countyId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
			        <tr>
			          <td>社区：</td>
			          <td>
			          	<div  type='text' id="comId1" name="comId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
			        <tr>
			          <td>物业：</td>
			          <td>
			          	<div  type='text' id="proId1" name="proId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
			        <tr>
			          <td>驿站：</td>
			          <td>
			          	<div  type='text' id="stationId1" name="stationId" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
					<tr>
			          <td>小区名称：</td>
			          <td>
			          	<input name="estateName" id="estateName" type="text" style="width: 150px;" value="${manageEstate.estateName}" class="easyui-validatebox" required="true" missingMessage="请输入小区名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>小区描述：</td>
			          <td>
			          	<textarea name="estateDesc"  id="estateDesc" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入小区描述" validType="reDes">${manageEstate.estateDesc}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>小区地址：</td>
			          <td>
			          	<textarea name="estateAddress"  id="estateAddress" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入小区地址" validType="reDes">${manageEstate.estateAddress}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>小区静态地图：</td>
			          <td>
			          	<input name="estateMap" id="modifyEstateMapImage" type="hidden" style="width: 150px;" value="${manageEstate.estateMap}" class="easyui-validatebox" />
			         	 <form:hidden path="picPath" id="picPath"></form:hidden>  
					      <span id="modifyEstateMapImage-statusPic" style="color: #666;">  
					      <a href="javascript:void(0)" onclick="Preview('modifyEstateMapImage')">预览</a></span>  
					      <a class="easyui-linkbutton" onclick="$('#modifyEstateMapImage-uploadWindow').window('open')">修改</a>  
					</td> 
			        </tr>
					<tr>
			          <td>小区经度：</td>
			          <td>
			          	<input name="estateLongitude" id="estateLongitude" type="text" style="width: 150px;" value="${manageEstate.estateLongitude}" class="easyui-validatebox" required="true" missingMessage="请输入小区经度" />
			          </td>
			        </tr>
					<tr>
			          <td>小区纬度：</td>
			          <td>
			          	<input name="estateLatitude" id="estateLatitude" type="text" style="width: 150px;" value="${manageEstate.estateLatitude}" class="easyui-validatebox" required="true" missingMessage="请输入小区纬度" />
			          </td>
			        </tr>
					<tr>
			          <td>小区车位图：</td>
			          <td>
			          	<input name="estateCarMap" id="modifyEstateCarMapImage" type="hidden" style="width: 150px;" value="${manageEstate.estateCarMap}" class="easyui-validatebox"  />
			          	<form:hidden path="picPath" id="picPath"></form:hidden>  
					      <span id="modifyEstateCarMapImage-statusPic" style="color: #666;">  
					      <a href="javascript:void(0)" onclick="Preview('modifyEstateCarMapImage')">预览</a></span>  
					      <a class="easyui-linkbutton" onclick="$('#modifyEstateCarMapImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
					<tr>
			          <td>小区类型：</td>
			          <td>
			         	<select name="estateType" id="estateType" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择状态" style="width: 150px;">
			          		<option value="0" <c:if test="${manageEstate.estateType == 0}">selected </c:if>>高端</option>
			          		<option value="1" <c:if test="${manageEstate.estateType == 1}">selected </c:if>>终端</option>
			          		<option value="2" <c:if test="${manageEstate.estateType == 2}">selected </c:if>>低端</option>
			          	</select>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="modifyEstateCarMapImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifyEstateCarMapImage-tforma">  
                   <input type="hidden" name="picPath" id="modifyEstateCarMapImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifyEstateCarMapImage/*" id="modifyEstateCarMapImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
    <div id="modifyEstateMapImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifyEstateMapImage-tforma">  
                   <input type="hidden" name="picPath" id="modifyEstateMapImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifyEstateMapImage/*" id="modifyEstateMapImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
</body>
</html>