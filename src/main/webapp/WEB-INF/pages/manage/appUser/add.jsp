
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
	init("portraitImage");
})
</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/app/appUser/save.do">
            <table>
					<tr>
			          <td>用户姓名：</td>
			          <td>
			          	<input name="realname" id="realname" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入用户姓名" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>账号昵称：</td>
			          <td>
			          	<input name="nickname" id="nickname" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入账号昵称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>密码：</td>
			          <td>
			          	<input name="password" id="password" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入密码" validType="rePas"/>
			          </td>
			        </tr>
			        <tr>
			          <td>确认密码：</td>
			          <td>
			          	<input name="password1" id="password1" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入密码" data-options="validType:['rePas','rePassword[\'#password\']']"/>
			          </td>
			        </tr>
					<tr>
			          <td>电话：</td>
			          <td>
			          	<input name="tel" id="tel" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入电话"  validType="reTel"/>
			          </td>
			        </tr>
					<tr>
			          <td>性别：</td>
			          <td>
			          	<select name="sex" id="sex" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择性别" style="width: 150px;">
			          		<option value="0" >男</option>
			          		<option value="1">女</option>
			          	</select> 
			          </td>
			        </tr>
					<tr>
			          <td>类型：</td>
			          <td>
			         	<select name="type" id="type" class="selectwidth easyui-validatebox" required="true" missingMessage="请选择类型" style="width: 150px;">
			          		<option value="0" >居民</option>
			          		<option value="1">内部员工</option>
			          	</select> 
			          </td>
			        </tr>
					<tr>
			          <td>头像：</td>
			          <td>
			          	<input name="portrait" id="portraitImage" type="hidden" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入头像" validType="reName"/>
			          <form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="portraitImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('portraitImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#portraitImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
					<tr>
			          <td>身份证：</td>
			          <td>
			          	<input name="idCard" id="idCard" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入身份证" validType="reIdCard"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="portraitImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="portraitImage-tforma">  
                   <input type="hidden" name="picPath" id="portraitImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="portraitImage/*" id="portraitImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
</body>
</html>