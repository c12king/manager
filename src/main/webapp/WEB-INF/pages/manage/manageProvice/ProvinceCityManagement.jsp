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
    
    <title>楼栋管理</title>
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
	<script type="text/javascript" src="<%=path %>/js/manage/provice/tree.js"></script>
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
	<div data-options='region:"west",split:true,border:true,title:"省份管理"', style='width: 350px;'>
		<div class="easyui-layout" data-options="fit:true">   
            <div data-options="region:'north',title:'省份列表'" style='height:300px'>
            	<table>
					<tr>
						<td><a href="javascript:append();">增加省份</a></td>
					</tr>
				</table>
				<ul id="treeul" class="easyui-tree">
				</ul>
            </div>   
            <div data-options="region:'center',title:'编辑楼栋'" style=''>
            	<form id="ff" method='post' action="<%=path%>/manage/manageProvice/update.do">
					<input type="hidden" name="proviceId">
					<table style="margin-top: 30px;margin-left: 20px">
						<tr >
							<td>楼栋名称<tb style='color: red'>*</tb>：</td>
							<td>
								<input id="f_name" class="easyui-validatebox" style='width: 150px;', type='text', name='provinceName', data-options="required:true,missingMessage:'省份名称必须输入',validType:['reName']">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div data-options='style="text-align: center; padding: 5px 0 0;"' style="margin-top: 30px">
									<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:newSave()'>保存</a>
									<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:searchRenew()'>重置</a>
								</div>
							</td>
						</tr>
					</table>
				</form>	
            </div>   
        </div> 
	</div>
	<div data-options='region:"center",split:true,border:true'>
		<div class="easyui-layout" data-options="fit:true">   
            <div data-options="region:'west',title:'城市管理'" style="width:350px">
				<div class="easyui-layout" data-options="fit:true">   
		            <div data-options="region:'north',title:'城市列表'" style='height:300px'>
		            	<table>
							<tr>
								<td><a href="javascript:append2();">增加城市</a></td>
							</tr>
						</table>
		            	<ul id="jobTreeul" class="easyui-tree">
						</ul>
		            </div>   
		            <div data-options="region:'center',title:'编辑楼栋'" style=''>
		            	<form id="cityForm" method='post' action="<%=path%>/manage/manageCity/update.do">
							<input type="hidden" name="cityId">
							<table style="margin-top: 30px;margin-left: 20px">
								<tr>
									<td>城市名称<tb style='color: red'>*</tb>：</td>
									<td>
										<input id="cityName" class="easyui-validatebox" style='width: 150px;', type='text', name='cityName', data-options="required:true,missingMessage:'城市名称必须输入',validType:['reName']">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div data-options='style="text-align: center; padding: 5px 0 0;"' style="margin-top: 30px">
											<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:cityFormSub()'>保存</a>
											<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:searchRenew()'>重置</a>
										</div>
									</td>
								</tr>
							</table>
						</form>	
		            </div>   
		        </div> 
            </div>   
            <div data-options="region:'center',title:'区域管理'">
            	<div class="easyui-layout" data-options="fit:true">   
		            <div data-options="region:'north',title:'区域列表'" style='height:300px'>
		            	<table >
							<tr>
								<td><a href="javascript:append3();">增加区域</a></td>
							</tr>
						</table>
		            	<ul id="countyTreeul" class="easyui-tree">
						</ul>
		            </div>   
		            <div data-options="region:'center',title:'编辑楼栋'" style=''>
		            	<form id="countyForm" method='post' action="<%=path%>/manage/manageCounty/update.do">
							<input type="hidden" name="countyId">
							<table style="margin-top: 30px;margin-left: 20px">
								<tr>
									<td>区域名称<tb style='color: red'>*</tb>：</td>
									<td>
										<input id="countyName" class="easyui-validatebox" style='width: 150px;', type='text', name='countyName', data-options="required:true,missingMessage:'区域名称必须输入',validType:['reName']">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div data-options='style="text-align: center; padding: 5px 0 0;"' style="margin-top: 30px">
											<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:countyFormSub()'>保存</a>
											<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:searchRenew()'>重置</a>
										</div>
									</td>
								</tr>
							</table>
						</form>	
		            </div>   
		        </div> 
            </div>   
        </div>   
		
		
	</div>
	<div id="monitor" class="easyui-menu" style='width:120px;'>
		<div onclick='removeit()', data-options='iconCls:"icon-remove"'>删除节点</div>
	</div>
	<div id="monitor2" class="easyui-menu" style='width:120px;'>
		<div onclick='removeit2()', data-options='iconCls:"icon-remove"'>删除节点</div>
	</div>
	<div id="monitor3" class="easyui-menu" style='width:120px;'>
		<div onclick='removeit3()', data-options='iconCls:"icon-remove"'>删除节点</div>
	</div>
	<div id="add-window" title="新增窗口" style="width: 350px; height: 300px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 300px;"></div>
    <div id="edit-window2" title="编辑窗口" style="width: 1000px; height: 500px;"></div>
</body>

</html>
