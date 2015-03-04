<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<html>
  <head>
    <base href="<%=basePath%>">
    <title>自定义分配小区</title>
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
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	</script>
</head>
<body>
<script type="text/javascript">
$(function(){
	    $("#selectAll").click(function(){
	    	 $("#chkBox :checkbox").prop("checked", true);  
        });
  		$("#deSelect").click(function(){
  			$("#chkBox :checkbox").each(function () {  
                $(this).prop("checked", !$(this).prop("checked"));    
            });  
  		});
  		
  		 $("#unSelect").click(function(){
             $("#chkBox :checkbox").prop("checked", false);      

         });
})
</script> 
	<div style="padding: 20px 20px 40px 30px;">
            <form id="addForm" method="post" action="<%=path %>/business/businessUserResource/saveEst.do">
            <input name="userId"   type="hidden" 	value="${userId}" />
            <input name="comId"    type="hidden" 	value="${comId}"  /> 
            <table id="chkBox">
            <tr>
	            <td>
	            	&nbsp;&nbsp;&nbsp;&nbsp;<input name="hi1" id="selectAll"  type="button" value="全选">
	       
	             	&nbsp;&nbsp;&nbsp;&nbsp;<input name="hi2" id="deSelect" type="button" value="反选">    
	    
	             	&nbsp;&nbsp;&nbsp;&nbsp;<input name="hi3" id="unSelect" type="button" value="全不选 ">  
	            </td> 
            </tr>
            <tr>
            	<td>
            	</td>
            </tr>   
            <tr>
            <c:forEach items="${checkBoxList}" var="estate" varStatus="status">
	            	<td>
	            		&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  name="estateId" value="${estate.estateId }_#_${estate.estateName}" 
						            				 <c:if test="${estate.state == 1}">
						            				  checked 
						            				 </c:if>  
						            			/> ${estate.estateName }
	            										
					</td>
				<c:if test="${(status.index+1)%3 == 0}"> 
					</tr><tr>
	            </c:if>     
            </c:forEach>
            </tr> 
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="saveData('add', 'addForm')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
</body>
</html>