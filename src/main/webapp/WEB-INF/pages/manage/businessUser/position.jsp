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
    
    <title>组织机构管理</title>
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
	<script type="text/javascript" src="<%=path %>/js/manage/user/positionTree.js"></script>
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
 
<body class="easyui-layout">
<script type="text/javascript">
var path='<%=path %>'
</script>
<script type="text/javascript" src="<%=path %>/js/manage/user/positionTree.js"></script>
<div class="easyui-layout">
	<div data-options='region:"west",split:true,border:true,title:"已拥有职位"', style='width: 250px;'>
		<form id="addJob" method="post" action="<%=path %>/manage/businessUser/saveJOB.do">
		<table id="JobTable">
			<input type="hidden" name="userId" value="${businessUser.userId }">
			<input type="hidden" name="positionId" value="${businessUser.positionId }">
			<input type="hidden" name="posName" value="${businessUser.posName }">
			<tr>
				<td>职位名称：</td>
				<td>${businessUser.posName}</td>
			</tr>
			
		</table>
		</form>
	</div>
	<div data-options='region:"center",split:true,border:true'>
		<div class="easyui-layout" data-options="fit:true">   
            <div data-options="region:'center'">
            	<div class="easyui-layout" data-options="fit:true">   
		            <div data-options="region:'west',title:'部门'" style="width:200px">
		            	<table>
							<tr>
								<td><a href="javascript:append3();">增加部门</a></td>
							</tr>
						</table>
		            	<ul id="depTreeul" class="easyui-tree">
						</ul>
		            </div>   
		            <div data-options="region:'center',title:'职位'">
		            	<ul id="jobTreeul" class="easyui-tree">
						</ul>
		            </div>   
		        </div> 
            </div>   
        </div>   
	</div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 500px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:200px;">
    	<div style="text-align: center; padding: 5px;margin-top:60px">
            <a href="javascript:void(0)" onclick="saveDataJob('', 'addJob')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="parent.closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
    </div>
</div>

</body>

</html>
