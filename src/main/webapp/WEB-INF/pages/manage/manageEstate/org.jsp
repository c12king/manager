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
	<script type="text/javascript" src="<%=path %>/js/manage/estate/tree.js"></script>
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
	<div data-options='region:"west",split:true,border:true,title:"楼栋管理"', style='width: 290px;'>
		<div class="easyui-layout" data-options="fit:true">   
            <div data-options="region:'north',title:'楼栋列表'" style='height:280'>
            	<table>
					<tr>
						<td><a href="javascript:append();">增加楼栋</a></td>
					</tr>
				</table>
				<ul id="treeul" class="easyui-tree">
				</ul>
            </div>   
            <div data-options="region:'center',title:'编辑楼栋'" style=''>
            	<form id="ff" method='post' action="<%=path%>/manage/manageBuilding/update.do">
					<input type="hidden" name="buildingId">
					<table>
						<tr>
							<td>楼栋名称<tb style='color: red'>*</tb>：</td>
							<td>
								<input id="f_name" class="easyui-validatebox" style='width: 150px;', type='text', name='buildingName', data-options="required:true,missingMessage:'栏目名称必须输入',validType:['reName']">
							</td>
						</tr>
						<tr>
							<td>楼栋描述<tb style='color: red'>*</tb>：</td>
							<td>
								<textarea name="buildingDesc"  id="buildingDesc" rows="5" cols="18" class="easyui-validatebox" required="true" missingMessage="请输入楼栋描述" validType="reDes"></textarea>
							</td>
						</tr>
						<tr>
							<td>静态地图<tb style='color: red'>*</tb>：</td>
							<td>
								<input id="buildingImage" class="easyui-validatebox" style='width: 150px;', type="hidden", name='buildingMap'>
								<form:hidden path="picPath" id="picPath"></form:hidden>  
								      <span id="buildingImage-statusPic" style="color: #666;">  
								      <a href="javascript:void(0)" onclick="Preview('buildingImage')">预览</a></span>  
								      <a class="easyui-linkbutton" onclick="$('#buildingImage-uploadWindow').window('open')">修改</a>  
							</td> 
						</tr>
						<tr>
							<td colspan="2">
								<div data-options='style="text-align: center; padding: 5px 0 0;"'>
									<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:newSave()'>保存</a>
									<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:renew()'>重置</a>
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
            <div data-options="region:'west',title:'单元管理'" style="width:290px">
				<div class="easyui-layout" data-options="fit:true">   
		            <div data-options="region:'north',title:'楼栋列表'" style='height:280'>
		            	<table>
							<tr>
								<td><a href="javascript:append2();">增加单元</a></td>
							</tr>
						</table>
		            	<ul id="jobTreeul" class="easyui-tree">
						</ul>
		            </div>   
		            <div data-options="region:'center',title:'编辑楼栋'" style=''>
		            	<form id="unitForm" method='post' action="<%=path%>/manage/manageUnit/update.do">
							<input type="hidden" name="unitId">
							<table>
								<tr>
									<td>单元名称<tb style='color: red'>*</tb>：</td>
									<td>
										<input id="unitName" class="easyui-validatebox" style='width: 150px;', type='text', name='unitName', data-options="required:true,missingMessage:'栏目名称必须输入',validType:['reName']">
									</td>
								</tr>
								<tr>
									<td>静态地图<tb style='color: red'>*</tb>：</td>
									<td>  								
									  <input id="unitImage" class="easyui-validatebox" style='width: 150px;', type="hidden", name='unitMap' >
									  <form:hidden path="picPath" id="picPath"></form:hidden>  
								      <span id="unitImage-statusPic" style="color: #666;">  
								      <a href="javascript:void(0)" onclick="Preview('unitImage')">预览</a></span>  
								      <a class="easyui-linkbutton" onclick="$('#unitImage-uploadWindow').window('open')">修改</a>  
								     </td>  
								</tr>
								<tr>
						          <td>经度：</td>
						          <td>
						          	<input name="estateLongitude" id="estateLatitude" type="text" style="width: 150px;" value=""/>
						          </td>
						        </tr>
						        <tr>
						          <td>纬度：</td>
						          <td>
						          	<input name="estateLatitude" id="estateLatitude" type="text" style="width: 150px;" value=""/>
						          </td>
						        </tr>
								<tr>
									<td colspan="2">
										<div data-options='style="text-align: center; padding: 5px 0 0;"'>
											<a id="saveBtn" class="easyui-linkbutton" data-options='iconCls:"icon-ok"', href='javascript:void(0)', onclick='javascript:unitFormSub()'>保存</a>
											<a id="cancleBtn" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"', href='javascript:void(0)', onclick='javascript:renew()'>重置</a>
										</div>
									</td>
								</tr>
							</table>
						</form>	
		            </div>   
		        </div> 
            </div>   
            <div data-options="region:'center',title:'住户'">
            	<div id="grid" fit="true">
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
	<div id="add-window" title="新增窗口" style="width: 350px; height: 300px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 350px; height: 300px;"></div>
    <div id="edit-window2" title="编辑窗口" style="width: 1000px; height: 500px;"></div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 300px;">
	<div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/business/businessUser/list.do">
            <table>
					<tr>
			          <td>门号：</td>
			          <td>
			          	<input name="houseNo" id="name" type="text" style="width: 150px;" value=""/>
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
	<div id="unitImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="unitImage-tforma">  
                   <input type="hidden" name="picPath" id="unitImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="unitImage/*" id="unitImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
    <div id="buildingImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="buildingImage-tforma">  
                   <input type="hidden" name="picPath" id="buildingImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="buildingImage/*" id="buildingImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div> 
</body>

</html>
