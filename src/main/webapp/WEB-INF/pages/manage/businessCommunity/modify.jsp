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
	init("modifyComIconImage");
})

</script>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/businessCommunity/update.do">
            <table>
						<input type="hidden" id="comId" name="comId" value="${businessCommunity.comId}" />
					<tr>
			          <td>机构：</td>
			          <td>
			          	<input name="orgId" id="orgId" type="hidden" style="width: 150px;" value="${businessCommunity.orgId}" class="easyui-validatebox" required="true" missingMessage="请选择社区名称" data-options="editable:false"/>
			          	<input name="orgName" id="orgName" type="text" style="width: 150px;" value="${businessCommunity.orgName}" class="easyui-validatebox" required="true" missingMessage="请选择社区名称" disabled/>
			          	<a class="easyui-linkbutton" onclick="selectOrg()">修改</a>  
			          </td>
			        </tr>
					<tr>
			          <td>社区名称：</td>
			          <td>
			          	<input name="comName" id="comName" type="text" style="width: 150px;" value="${businessCommunity.comName}" class="easyui-validatebox" required="true" missingMessage="请输入社区名称" validType="reName"/>
			          </td>
			        </tr>
					<tr>
			          <td>社区简介：</td>
			          <td>
			          	<textarea name="comBrief"  id="comBrief" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入社区简介" validType="reDes">${businessCommunity.comBrief}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>社区服务说明：</td>
			          <td>
			          	<textarea name="comService"  id="comService" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入社区服务说明" validType="reDes">${businessCommunity.comService}</textarea>
			          </td>
			        </tr>
					<tr>
			          <td>社区电话：</td>
			          <td>
			          	<input name="comTel" id="comTel" type="text" style="width: 150px;" value="${businessCommunity.comTel}" class="easyui-validatebox" required="true" missingMessage="请输入社区电话" validType="reTel"/>
			          </td>
			        </tr>
					<tr>
			          <td>社区邮件：</td>
			          <td>
			          	<input name="comEmail" id="comEmail" type="text" style="width: 150px;" value="${businessCommunity.comEmail}" class="easyui-validatebox" required="true" missingMessage="请输入社区邮件" data-options="validType:['reEmail','maxLength[32]']"/>
			          </td>
			        </tr>
					<tr>
			          <td>社区微信：</td>
			          <td>
			          	<input name="comWeixin" id="comWeixin" type="text" style="width: 150px;" value="${businessCommunity.comWeixin}" class="easyui-validatebox" required="true" missingMessage="请输入社区微信" validType="maxLength[32]"/>
			          </td>
			        </tr>
					<tr>
			          <td>社区图标：</td>
			          <td>
			          	<input name="comIcon" id="modifyComIconImage" type="hidden" style="width: 150px;" value="${businessCommunity.comIcon}" class="easyui-validatebox" />
			          <form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="modifyComIconImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('modifyComIconImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#modifyComIconImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
					<tr>
			          <td>社区经度：</td>
			          <td>
			          	<input name="comLongitude" id="comLongitude" type="text" style="width: 150px;" value="${businessCommunity.comLongitude}" class="easyui-validatebox" required="true" missingMessage="请输入社区经度" validType="reSz"/>
			          </td>
			        </tr>
					<tr>
			          <td>社区纬度：</td>
			          <td>
			          	<input name="comLatitude" id="comLatitude" type="text" style="width: 150px;" value="${businessCommunity.comLatitude}" class="easyui-validatebox" required="true" missingMessage="请输入社区纬度" validType="reSz"/>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        <div id="modifyComIconImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifyComIconImage-tforma">  
                   <input type="hidden" name="picPath" id="modifyComIconImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifyComIconImage/*" id="modifyComIconImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>
</body>
</html>