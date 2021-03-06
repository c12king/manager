
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
            <form id="addForm" method="post" action="<%=path %>/manage/businessProperty/save.do">
            <table>
					<tr>
			          <td>机构：</td>
			          <td>
			          <input name="orgId" id="orgId1" type="hidden" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请选择物业名称" />
			          	<input name="orgName1" id="orgName1" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请选择物业名称"  disabled/>
			          	<a class="easyui-linkbutton" onclick="selectOrg()">修改</a>  
			          
			          </td>
			        </tr>
					<tr>
			          <td>物业名称：</td>
			          <td>
			          	<input name="proName" id="proName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>物业简介：</td>
			          <td>
			          	<textarea name="proBrief"  id="proBrief" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入物业简介" validType="reDes"></textarea>
			          </td>
			        </tr>
					<tr>
			          <td>物业服务说明：</td>
			          <td>
			          	<textarea name="proService"  id="proService" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入物业服务说明" validType="reDes"></textarea>
			          </td>
			        </tr>
					<tr>
			          <td>物业电话：</td>
			          <td>
			          	<input name="proTel" id="proTel" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业电话" validType="reTel"/>
			          </td>
			        </tr>
					<tr>
			          <td>物业邮件：</td>
			          <td>
			          	<input name="proEmail" id="proEmail" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业邮件" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>物业微信：</td>
			          <td>
			          	<input name="proWeixin" id="proWeixin" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业微信" validType="maxLength[32]"/>
			          </td>
			        </tr>
					<tr>
			          <td>物业图标：</td>
			          <td>
			          	<input name="proIcon" id="proIconImage" type="hidden" style="width: 150px;" value="" class="easyui-validatebox"  />
			           <form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="proIconImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('proIconImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#proIconImage-uploadWindow').window('open')">修改</a>  
					 	</td>
			        </tr>
					<tr>
			          <td>物业经度：</td>
			          <td>
			          	<input name="proLongitude" id="proLongitude" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业经度" validType="reSz"/>
			          </td>
			        </tr>
					<tr>
			          <td>物业纬度：</td>
			          <td>
			          	<input name="proLatitude" id="proLatitude" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入物业纬度" validType="reSz"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="proIconImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="proIconImage-tforma">  
                   <input type="hidden" name="picPath" id="proIconImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="proIconImage/*" id="proIconImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
<script type="text/javascript">
$(function(){
	init("proIconImage");
})

</script>
</body>
</html>