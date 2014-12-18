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
            <form id="modifyForm" method="post" action="<%=path %>/manage/businessStation/update.do">
            <table>
						<input type="hidden" id="stationId" name="stationId" value="${businessStation.stationId}" />
					<tr>
			          <td>机构ID：</td>
			          <td>
						<input name="orgId" id="orgId" type="hidden" style="width: 150px;" value="${businessStation.orgId}" class="easyui-validatebox" required="true" missingMessage="请选择驿站名称" data-options="editable:false"/>
			          	<input name="orgName1" id="orgName" type="text" style="width: 150px;" value="${businessStation.orgName}" class="easyui-validatebox" required="true" missingMessage="请选驿站名称" disabled/>
			          	<a class="easyui-linkbutton" onclick="selectOrg()">修改</a>  
			          </td>
			        </tr>
					<tr>
			          <td>驿站名称：</td>
			          <td>
			          	<input name="staName" id="staName" type="text" style="width: 150px;" value="${businessStation.staName}" class="easyui-validatebox" required="true" missingMessage="请输入驿站名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>驿站简介：</td>
			          <td>
			          	<textarea name="staBrief"  id="staBrief" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入驿站简介" validType="reDes">${businessStation.staBrief}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>驿站服务说明：</td>
			          <td>
			         	<textarea name="staService"  id="staService" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入驿站服务说明" validType="reDes">${businessStation.staService}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>驿站电话：</td>
			          <td>
			          	<input name="staTel" id="staTel" type="text" style="width: 150px;" value="${businessStation.staTel}" class="easyui-validatebox" required="true" missingMessage="请输入驿站电话" validType="reTel" />
			          </td>
			        </tr>
					<tr>
			          <td>驿站邮件：</td>
			          <td>
			          	<input name="staEmail" id="staEmail" type="text" style="width: 150px;" value="${businessStation.staEmail}" class="easyui-validatebox" required="true" missingMessage="请输入驿站邮件" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>驿站微信：</td>
			          <td>
			          	<input name="staWeixin" id="staWeixin" type="text" style="width: 150px;" value="${businessStation.staWeixin}" class="easyui-validatebox" required="true" missingMessage="请输入驿站微信" validType="maxLength[32]"/>
			          </td>
			        </tr>
					<tr>
			          <td>驿站图标：</td>
			          <td>
			          	<input name="staIcon" id="modifystaIconImage" type="hidden" style="width: 150px;" value="${businessStation.staIcon}" class="easyui-validatebox" required="true" missingMessage="请输入驿站图标" />
			         <form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="modifystaIconImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('modifystaIconImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#modifystaIconImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
					<tr>
			          <td>驿站经度：</td>
			          <td>
			          	<input name="staLongitude" id="staLongitude" type="text" style="width: 150px;" value="${businessStation.staLongitude}" class="easyui-validatebox" required="true" missingMessage="请输入驿站经度" validType="reSz"/>
			          </td>
			        </tr>
					<tr>
			          <td>驿站纬度：</td>
			          <td>
			          	<input name="staLatitude" id="staLatitude" type="text" style="width: 150px;" value="${businessStation.staLatitude}" class="easyui-validatebox" required="true" missingMessage="请输入驿站纬度" validType="reSz"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="modifystaIconImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifystaIconImage-tforma">  
                   <input type="hidden" name="picPath" id="modifystaIconImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifystaIconImage/*" id="modifystaIconImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>
<script type="text/javascript">
$(function(){
	init("modifystaIconImage");
})

</script>
</body>
</html>