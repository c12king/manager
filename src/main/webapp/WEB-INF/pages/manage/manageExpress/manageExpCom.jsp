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
    <title>快递资费管理</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript" src="<%=path %>/js/manage/express/expTree.js"></script>
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
	var estateId='${estateId}'
</script>
	<div data-options='region:"west",split:true,border:true'>
		<div class="easyui-layout" data-options="fit:true">   
            <div data-options="region:'west',title:'快递公司'" style="width:290px">
				<div class="easyui-layout" data-options="fit:true" style="overflow:auto;"> 
		            	<ul id="expTreeul" class="easyui-tree">
						</ul>
		        </div> 
            </div>   
            <div data-options="region:'center',title:'快递公司资费表'">
            	<div id="grid" fit="true">
        		</div>
            </div>   
        </div>   
	</div>
	
	<div id="monitor" class="easyui-menu" style='width:120px;'>
		<div onclick='edit2()', data-options='iconCls:"icon-add"'>编辑节点</div>
		<div onclick='append2()', data-options='iconCls:"icon-add"'>增加节点</div>
		<div onclick='removeit2()', data-options='iconCls:"icon-remove"'>删除节点</div>
		<div class="menu-sep"></div>
		<div onclick='expand2()'>展开节点</div>
		<div onclick='collapse2()'>隐藏节点</div>
	</div>
	
	<div id="add-window" title="新增窗口" style="width: 400px; height: 350px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 400px; height: 350px;"></div>   
    <div id="edit-window2" title="编辑窗口" style="width: 1000px; height: 500px;"></div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 300px;">
	<div style="padding: 20px 20px 40px 80px;">
	    <form id="searchForm" method="post" action="<%=path %>/manage/buseinessTel/list.do">
	            <table>
						<tr>
				          <td>名称：</td>
				          <td>
				          	<input name="name" id="name" type="text" style="width: 150px;" value=""/>
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
<!-- 	<div id="unitImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">   -->
<!--         <div class="easyui-layout  with iframe" fit="true">   -->
<!--             <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">   -->
<%--                 <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="unitImage-tforma">   --%>
<!--                    <input type="hidden" name="picPath" id="unitImage-picPath" value="111"/>   -->
<!--                       图片路径: <input type="file" name="itemPic" alt="" accept="unitImage/*" id="unitImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">   -->
<!--                  </form>   -->
<!--             </div>   -->
<!--         </div>   -->
<!--     </div>  -->
<!--     <div id="buildingImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">   -->
<!--         <div class="easyui-layout  with iframe" fit="true">   -->
<!--             <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">   -->
<%--                 <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="buildingImage-tforma">   --%>
<!--                    <input type="hidden" name="picPath" id="buildingImage-picPath" value="111"/>   -->
<!--                       图片路径: <input type="file" name="itemPic" alt="" accept="buildingImage/*" id="buildingImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">   -->
<!--                  </form>   -->
<!--             </div>   -->
<!--         </div>   -->
<!--     </div>  -->
</body>

</html>
