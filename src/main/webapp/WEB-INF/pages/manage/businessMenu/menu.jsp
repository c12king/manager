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
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript" src="<%=path %>/js/manage/menu/tree.js"></script>
	<style type="text/css">
		#u0_img {
                position:absolute;
                left:0px;
                top:0px;
                width:160px;
                height:91px;
            }
	</style>
  </head>
 <script type="text/javascript">
	var path='<%=path %>'
</script>
<body class="easyui-layout">
	<div data-options='region:"west",split:true,border:true,title:"菜单管理"', style='width: 250px; padding: 10px;'>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
		<ul id="treeul" class="easyui-tree">
		</ul>
	</div>
	<div region='center', border='false'>
		<form id="ff" method='post' action="<%=path%>/manage/businessMenu/updateMenu.do">
			<input type="hidden" name="menuId">
			<table>
				<tr>
					<td>菜单名称<tb style='color: red'>*</tb>：</td>
					<td>
						<input id="f_name" class="easyui-validatebox" style='width: 150px;', type='text', name='name', data-options="required:true,missingMessage:'栏目名称必须输入'">
					</td>
				</tr>
				<tr>
					<td>菜单序号<tb style='color: red'>*</tb>：</td>
					<td>
						<input id="f_ord" class="easyui-validatebox" style='width: 150px;', type='text', name='ord', data-options="required:true,missingMessage:'栏目序号必须输入',validType:'reSz'">
					</td>
				</tr>
				<tr>
					<td>菜单url<tb style='color: red'>*</tb>：</td>
					<td>	
						<input id="f_path" class="easyui-validatebox" style='width: 500px;', type='text', name='url', data-options="required:true,missingMessage:'栏目路径必须输入',validType:['reUrl']">
					</td>
				</tr>
				<tr>
					<td>菜单图标<tb style='color: red'>*</tb>：</td>
					<td>	
						<input id="f_code" class="easyui-validatebox" style='width: 500px;', type='text', name='code', data-options="required:true,missingMessage:'菜单图标'">
					</td>
				</tr>
				<tr>
					<td>选中时图标图标<tb style='color: red'>*</tb>：</td>
					<td>	
						<input id="logImage" class="easyui-validatebox" style='width: 150px;', type="hidden", name='selectedIcon'>
						<form:hidden path="picPath" id="picPath"></form:hidden>  
					      <span id="logImage-statusPic" style="color: #666;">  
					      <a href="javascript:void(0)" onclick="Preview('logImage')">预览</a></span>  
					      <a class="easyui-linkbutton" onclick="$('#logImage-uploadWindow').window('open')">修改</a>  
					 </td> 
				</tr>
				<tr>
					<td>选中时图标图标<tb style='color: red'>*</tb>：</td>
					<td>	
						<input id="unSelectedIconImage" class="easyui-validatebox" style='width: 150px;', type="hidden", name='unSelectedIcon'>
					<form:hidden path="picPath" id="picPath"></form:hidden>  
									      <span id="unSelectedIconImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('unSelectedIconImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#unSelectedIconImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div data-options='style="text-align: center; padding: 5px 0 0;"'>
							<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:newSave()'>保存</a>
							<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:renew()'>重置</a>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="monitor" class="easyui-menu" style='width:120px;'>
		<div onclick='append()', data-options='iconCls:"icon-add"'>增加节点</div>
		<div onclick='removeit()', data-options='iconCls:"icon-remove"'>删除节点</div>
		<div class="menu-sep"></div>
		<div onclick='expand()'>展开节点</div>
		<div onclick='collapse()'>隐藏节点</div>
	</div>
<div id="logImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="logImage-tforma">  
                   <input type="hidden" name="picPath" id="logImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="logImage/*" id="logImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
<div id="unSelectedIconImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="unSelectedIconImage-tforma">  
                   <input type="hidden" name="picPath" id="unSelectedIconImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="unSelectedIconImage/*" id="unSelectedIconImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>
</body>

</html>
