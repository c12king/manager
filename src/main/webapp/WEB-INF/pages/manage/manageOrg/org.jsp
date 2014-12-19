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
	<script type="text/javascript" src="<%=path %>/js/manage/org/tree.js"></script>
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
	<div data-options='region:"west",split:true,border:true,title:"组织机构"', style='width: 250px; padding: 10px;'>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
		<ul id="treeul" class="easyui-tree">
		</ul>
	</div>
	<div data-options='region:"center",split:true,border:true'>
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
            <div data-options="region:'center'">
            	<div class="easyui-layout" data-options="fit:true">   
		            <div data-options="region:'west',title:'职位'" style="width:200px">
		            	<ul id="jobTreeul" class="easyui-tree">
						</ul>
		            </div>   
		            <div data-options="region:'center',title:'用户'">
		            	<div id="grid" fit="true">
		        		</div>
		            </div>   
		        </div> 
            </div>   
        </div>   
		
		
	</div>
	<div id="monitor" class="easyui-menu" style='width:120px;'>
		<div onclick='edit1()', data-options='iconCls:"icon-add"'>编辑节点</div>
		<div onclick='append()', data-options='iconCls:"icon-add"'>增加节点</div>
		<div onclick='removeit()', data-options='iconCls:"icon-remove"'>删除节点</div>
		<div class="menu-sep"></div>
		<div onclick='expand()'>展开节点</div>
		<div onclick='collapse()'>隐藏节点</div>
	</div>
	<div id="monitor2" class="easyui-menu" style='width:120px;'>
		<div onclick='edit2()', data-options='iconCls:"icon-add"'>编辑节点</div>
		<div onclick='append2()', data-options='iconCls:"icon-add"'>增加节点</div>
		<div onclick='removeit2()', data-options='iconCls:"icon-remove"'>删除节点</div>
		<div class="menu-sep"></div>
		<div onclick='expand()'>展开节点</div>
		<div onclick='collapse()'>隐藏节点</div>
	</div>
	<div id="monitor3" class="easyui-menu" style='width:120px;'>
		<div onclick='edit3()', data-options='iconCls:"icon-add"'>编辑节点</div>
		<div onclick='removeit3()', data-options='iconCls:"icon-remove"'>删除节点</div>
	</div>
	<div id="add-window" title="新增窗口" style="width: 400px; height: 500px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 400px; height: 500px;"></div>
    <div id="edit-window2" title="编辑窗口" style="width: 900px; height: 500px;"></div>
    <div id="edit-window3" title="编辑窗口" style="width: 400px; height: 500px;"></div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 500px;">
	<div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/business/businessUser/list.do">
            <table>
					<tr>
			          <td>真实姓名：</td>
			          <td>
			          	<input name="userNames" id="userName" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="SearchOK()" id="btn-search" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>确定</a>
            <a href="javascript:void(0)" onclick="closeSearchWindow()" id="btn-search-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>
                取消</a>
        </div>
    </div>
</body>

</html>
