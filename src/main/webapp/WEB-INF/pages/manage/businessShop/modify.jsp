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
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div style="padding: 20px 20px 40px 30px;">
            <form id="modifyForm" method="post" action="<%=path %>/manage/businessShop/update.do">
            <input name="shopId" id="shopId" type="hidden" value="${businessShop.shopId}" /> 
            <input name="typeId" id="typeId" type="hidden" value="${businessShop.typeId}" /> 
            <table>
<!-- 			         <tr> -->
<!-- 			          <td>范围：</td> -->
<!-- 			          <td> -->
<%-- 			            <textarea name="title" id="title"   type="text" style="width: 250px;" maxlength="256"  class="easyui-validatebox"  required="true" missingMessage="请输入快递范围" >${manageExpressFee.title}</textarea> --%>
<!-- 			          </td> -->
<!-- 			        </tr> -->
<!-- 			        <tr> -->
<!-- 			          <td>内容：</td> -->
<!-- 			          <td> -->
<%-- 			            <textarea name="content" id="content"   type="text" style="width: 250px;" maxlength="256"  class="easyui-validatebox"  required="true" missingMessage="请输入快递资费" >${manageExpressFee.content}</textarea> --%>
<!-- 			          </td> -->
<!-- 			        </tr> -->
			        <tr>
			          <td>商铺名称：</td>
			          <td>
			          	<input name="shopName" id="shopName" type="text" style="width: 200px;" value="${businessShop.shopName}" maxlength="256" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>商铺编码 ：</td>
			          <td>
			          	<input name="shopCode" id="shopCode" type="text" style="width: 200px;" value="${businessShop.shopCode}" maxlength="40" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>商铺秘钥 ：</td>
			          <td>
			          	<input name="shopKey" id="shopKey" type="text" style="width: 200px;" value="${businessShop.shopKey}" maxlength="40" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>商铺地址 ：</td>
			          <td>
			          	<input name="shopAddr" id="shopAddr" type="text" style="width: 200px;" value="${businessShop.shopAddr}" maxlength="200" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>商铺描述 ：</td>
			          <td>
			          	<input name="shopDesc" id="shopDesc" type="text" style="width: 200px;" value="${businessShop.shopDesc}" maxlength="512" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>商铺连接地址 ：</td>
			          <td>
			          	<input name="shopUrl" id="shopUrl" type="text" style="width: 200px;" value="${businessShop.shopUrl}" maxlength="128" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 200px;" value="${businessShop.editor}" maxlength="32" class="easyui-validatebox"   missingMessage="请输入商铺类型名称" />
			          </td>
			        </tr>
			        <tr>
			          <td>图片路径 ：</td>
<!-- 			          <td> -->
<%-- 			          	<input name="shopImg" id=shopImg type="text" style="width: 200px;" value="${businessShop.shopImg}" maxlength="60" class="easyui-validatebox"  required="true" missingMessage="请输入商铺类型名称" /> --%>
<!-- 			          </td> -->
			          <td>
			          	<input name="shopImg" id="modifyModuleIconImage" type="hidden" style="width: 150px;" value="${businessShop.shopImg}" class="easyui-validatebox"  />
			           <form:hidden path="picPath" id="picPath"></form:hidden> 
									      <span id="modifyModuleIconImage-statusPic" style="color: #666;">  
									      <a href="javascript:void(0)" onclick="Preview('modifyModuleIconImage')">预览</a></span>  
									      <a class="easyui-linkbutton" onclick="$('#modifyModuleIconImage-uploadWindow').window('open')">修改</a>  
					 	</td> 
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData3('edit', 'modifyForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
        
        
        <div id="modifyModuleIconImage-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="modifyModuleIconImage-tforma">  
                   <input type="hidden" name="picPath" id="modifyModuleIconImage-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="modifyModuleIconImage/*" id="modifyModuleIconImage-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>
<script type="text/javascript">
$(function(){ 
// 	alert('ccc')
	init("modifyModuleIconImage");
});
</script>
</body>
</html>