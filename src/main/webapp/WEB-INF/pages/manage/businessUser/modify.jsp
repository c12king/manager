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
	init("modifyUserPhotoImage");
})
</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/businessUser/update.do">
            <table>
						<input type="hidden" id="userId" name="userId" value="${businessUser.userId}" />
					<tr>
			          <td>真实姓名：</td>
			          <td>
			          	<input name="userName" id="userName" type="text" style="width: 150px;" value="${businessUser.userName}" class="easyui-validatebox" required="true" missingMessage="请输入真实姓名" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>电话号码：</td>
			          <td>
			          	<input name="userTel" id="userTel" type="text" style="width: 150px;" value="${businessUser.userTel}" class="easyui-validatebox" required="true" missingMessage="请输入电话号码" validType="reTel"/>
			          </td>
			        </tr>
					<tr>
			          <td>密码：</td>
			          <td>
			          	<input name="userPassword" id="userPassword2" type="text" style="width: 150px;" value="${businessUser.userPassword}" class="easyui-validatebox" required="true" missingMessage="请输入登录密码" validType="rePas"/>
			          </td>
			        </tr>
			        <tr>
			          <td>确认密码：</td>
			          <td>
			          	<input name="userPassword1" id="userPassword1" type="text" style="width: 150px;" value="${businessUser.userPassword}" class="easyui-validatebox" required="true" missingMessage="请输入登录密码" data-options="validType:['rePas','rePassword[\'#userPassword2\']']"/>
			          </td>
			        </tr>
					<tr>
			          <td>邮箱：</td>
			          <td>
			          	<input name="userEmail" id="userEmail" type="text" style="width: 150px;" value="${businessUser.userEmail}" class="easyui-validatebox" required="true" missingMessage="请输入邮箱" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>照片：</td>
			          <td>
			          	<input name="userPhoto" id="modifyUserPhotoImage" type="hidden" style="width: 150px;" value="${businessUser.userPhoto}" class="easyui-validatebox" />
			          	<form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="modifyUserPhotoImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('modifyUserPhotoImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#modifyUserPhotoImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
					<tr>
			          <td>个人介绍：</td>
			          <td>
			          	<textarea name="userBrief"  id="userBrief" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入个人介绍" validType="reDes">${businessUser.userBrief}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>服务内容：</td>
			          <td>
			          	<textarea name="userService"  id="userService" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入服务内容" validType="reDes">${businessUser.userService}</textarea>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="modifyUserPhotoImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifyUserPhotoImage-tforma">  
                   <input type="hidden" name="picPath" id="modifyUserPhotoImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifyUserPhotoImage/*" id="modifyUserPhotoImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
</body>
</html>