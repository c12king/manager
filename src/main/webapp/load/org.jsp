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
 
<body>
<tr>  
     <td align="right">图片:</td><td>  <form:hidden path="picPath" id="picPath"></form:hidden>  
      <span id="image-statusPic" style="color: #666;">  
      <a href="javascript:void(0)" onclick="window.smartMenu.insert.replaceString()">预览</a></span>  
      <a class="easyui-linkbutton" onclick="$('#image-uploadWindow').window('open')">修改</a>  
     </td>  
</tr>  
  
<!-- 点击修改调出窗口 -->  
  
<div id="image-uploadWindow" class="easyui-window" title="图片上传" modal="true" resizable="false" collapsible="false" minimizable="false" maximizable="false" closed="true" style="width:520px;height:100px;padding:5px;background: #fafafa;">  
        <div class="easyui-layout  with iframe" fit="true">  
            <div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">  
                <form action="<%=path %>/manage/loadImage/uploadFile.do" method="post" enctype="multipart/form-data" style="color: #666;" id="image-tforma">  
                   <input type="hidden" name="picPath" id="image-picPath" value="111"/>  
                      图片路径: <input type="file" name="itemPic" alt="" accept="image/*" id="image-itemPic">图片大小不超过2M<input  class="easyui-linkbutton" type="submit" value="上传">  
                 </form>  
            </div>  
        </div>  
    </div>  
<script type="text/javascript">
<!-- 页面刚刚加载时调用 -->  
init= function(uuid) {  
    // this.identifier 是设定的全局变量，uuid是页面加载时的唯一编码  
    this.identifier = uuid;  
    // 图片上传  
    var idf = this.identifier;  
    var that = this;  
    $('#'+idf+'-tforma').form({  
        dataType : 'json',  
    beforeSubmit : function(a, f, o) {  
      $('#'+idf+'-statusPic').html('上传中...');  
    },  
        success : function(data) {    
     if (typeof (data) == 'string')  
       data = eval('(' + data + ')');  
     $('#'+idf+'-uploadWindow').window('close');  
     if ("success" == data.message) {  
         $('div[identifier='+that.identifier+']').find('#picPath').val(data.path); 
		 console.log(11,data.path)
         console.log(data.path .replace( "\\", "/"))
         $("#"+idf+"-path").val(data.path .replace( "\\", "/"));  
         $("#"+idf+"-statusPic").html( "<a target='window' href='" + data.path .replace( "\\", "/") + "'>预览</a>");  
     } else if ("error" == data.message)  
         $("#"+idf+"-statusPic").html("非图片数据!");  
     else  
         $("#"+idf+"-statusPic").html("上传数据错误!");  
          $("#"+idf+"-itemPic").val('');  
     },  
     error : function(jqXHR, textStatus,errorThrown) {  
         $('#$'+idf+'-uploadWindow').window('close');  
         //console.log("error:"+ data.responseText);  
         //console.log("status:" + textStatus);  
         $("#"+idf+"-statusPic").html("上传失败!");  
         $("#"+idf+"-itemPic").val('');  
     } });  
    }  
$(function(){
	init("image")
})

	
</script>

</body>

</html>
