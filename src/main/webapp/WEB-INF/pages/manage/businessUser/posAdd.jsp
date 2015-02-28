
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
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	
	</script>
</head>
<body>
<script type="text/javascript">
$(function(){
	//init("userPhotoImage");
})
</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/manage/businessUser/save.do">
            <table>
            	<input name="positionId" id="positionId" type="hidden" style="width: 150px;" value="" class="easyui-validatebox" />
            	<input name="posName" id="positionName" type="hidden" style="width: 150px;" value="" class="easyui-validatebox"/>
					<tr>
			          <td>职位：</td>
			          <td>
			          	<input name="orgPosName" id="orgPosName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请选择职位"  disabled/>
			          	<a class="easyui-linkbutton" onclick="selectPos()">修改</a>  
			          	
			          </td>
			        </tr>
			        <tr>
			          <td>真实姓名：</td>
			          <td>
			          	<input name="userName" id="userName" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入真实姓名" validType="reName"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td>角色类型：</td>
			          <td>
			          	  	标准角色
			          	<!-- <select name="roleType" id="roleType" class="easyui-validatebox" required="true" missingMessage="请选择角色类型">
			          		<option value="0" selected >标准角色</option>
			          		<option value="1">特殊角色</option>
			          	</select> -->
			          </td>
			        </tr>
			        
			        <tr>
			          <td>角色：</td>
			          <td>
			          
			          <div id="tabs">
							<table cellpadding="0" cellspacing="0" style="width: 950px; margin: 0px;padding: 0px;">
								
								<tr style="border: 1px solid #C0C0C0; line-height: 25px;">
									<td style="padding-left:5px; border: 1px solid #C0C0C0; width: 200px" >角色组</td>
									<td style="border: 1px solid #C0C0C0;">角色</td>
								</tr>
								
								<c:forEach items="${groupList}" var="group" varStatus="groupIndex">								
								<tr style="border: 1px solid #C0C0C0; line-height: 25px;">
									<td style="padding-left:5px; border: 1px solid  #C0C0C0; width: 100px">
									${group.groupName}</td>
									<td style="border: 1px solid #C0C0C0;">
										<c:forEach items="${group.roleList}" var="role">
											<input type="checkbox" id="roleId_${role.roleId}" name="roleId" value="${role.roleId }" />
											${role.roleName }
										</c:forEach>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						
					</div>
			          
			          </td>
			        </tr>
			        
			        <%-- <tr>
			          <td>&nbsp;</td>
			          <td>
			          	<select name="roleId" id="roleId" multiple="multiple" size="8" style="width:150px;" class="easyui-validatebox" required="true" missingMessage="请选择角色">
			          		<option value="">角色</option>
			          		<c:forEach items="${roleList}" var="role" > 
	            				<option value="${role.roleId }">${role.roleName }</option>
	            			</c:forEach>
			          	</select>
			          </td>
			        </tr> --%>
			        
			        <tr>
			          <td>部门：</td>
			          <td>
			          	<select name="orgType" id="orgType" style="width: 150px;" class="easyui-validatebox" required="true" missingMessage="请输入部门" >
			          		<option value="">部门</option>
			          		<option value="property">物业</option>
			          		<option value="station">驿站</option>
			          		<option value="community">社区报</option>
			          		<option value="operation">运营</option>
			          	</select>
			          </td>
			        </tr>
					<tr>
			          <td>电话号码：</td>
			          <td>
			          	<input name="userTel" id="userTel" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入电话号码" validType="reTel"/>
			          </td>
			        </tr>	
					<tr>
			          <td>密码：</td>
			          <td>
			          	<input name="userPassword" id="userPassword" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入登录密码" validType="rePas"/>
			          </td>
			        </tr>
			        <tr>
			          <td>确认密码：</td>
			          <td>
			          	<input name="userPassword1" id="userPassword1" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入登录密码" data-options="validType:['rePas','rePassword[\'#userPassword\']']"/>
			          </td>
			        </tr>
					<tr>
			          <td>邮箱：</td>
			          <td>
			          	<input name="userEmail" id="userEmail" type="text" style="width: 150px;" value="" class="easyui-validatebox" required="true" missingMessage="请输入邮箱" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>照片：</td>
			          <td>
			          	<input name="userPhoto" id="userPhotoImage" type="hidden" style="width: 150px;" value="" class="easyui-validatebox" />
				         <!--  <form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="userPhotoImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('userPhotoImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#userPhotoImage-uploadWindow').window('open')">修改</a>   -->
					 	</td> 
			        </tr>
					<tr>
			          <td>个人介绍：</td>
			          <td>
			          	<textarea name="userBrief"  id="userBrief" rows="5" cols="18" class="easyui-validatebox" ></textarea>
			          </td>
			        </tr>
					<tr>
			          <td>服务内容：</td>
			          <td>
			          	<textarea name="userService"  id="userService" rows="5" cols="18" class="easyui-validatebox" ></textarea>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <%-- <div id="userPhotoImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="userPhotoImage-tforma">  
                   <input type="hidden" name="picPath" id="userPhotoImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="userPhotoImage/*" id="userPhotoImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>  --%>
</body>
</html>