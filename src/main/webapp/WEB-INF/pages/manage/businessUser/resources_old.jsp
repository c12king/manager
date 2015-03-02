<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>权限管理</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui-1.10.2.custom.min.css" >
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.10.2.custom.min.js"></script>
<script>
$(function() {
	$('#tt').tabs({   
	    border:false,   
	    onSelect:function(title){   
	        alert(title+' is selected');   
	    }   
	});
});

</script>
</head>
<body>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.10.2.custom.min.js"></script>

<div style="padding: 20px 20px 40px 30px;">
	<div data-options='region:"center",split:true,border:true'>
	
		<form id="addResource" method="post" action="<%=path %>/business/businessUserResource/save_resources.do">
			<input type="hidden" name="userId" value="${userId}">
			<%-- <c:forEach items="${estateList}" var="estate" >
				<input type="checkbox" name="estateId1"   value="${estate.estateId}"
					<c:forEach items="${estateValueList}" var="re" > 
           				 <c:if test="${re.estateId == estate.estateId}">
           				  checked 
           				 </c:if>
           			 </c:forEach>
				/>
				${estate.estateName}
			</c:forEach>
			<br /><br /><br />
			<div>社区资源:</div>
			<br />
			<c:forEach items="${communityList}" var="community">
				<input type="checkbox" name="comId"   value="${community.comId}"
					<c:forEach items="${comValueList}" var="re" > 
           				 <c:if test="${re.comId == community.comId}">
           				  checked 
           				 </c:if>
           			 </c:forEach>
				/>
				${community.comName}
			</c:forEach> --%>
			
			<table id="addSpecialCommunityTable" cellpadding="0" cellspacing="0" style="width: 800px; margin: 0px;padding: 0px;">
								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid #C0C0C0; width: 150px" >社区范围</td>
									<td style="border: 1px solid #C0C0C0;">小区范围</td>
								</tr>
								
								<c:forEach items="${resourceList}" var="resource" varStatus="menuIndex">								
								<tr style="border: 1px solid;">
									<td style="padding-left:5px; border: 1px solid  #C0C0C0; width: 100px">
									<input type="checkbox" id="comId_${resource.comId}_${resource.comName}" name="comId" value="${resource.comId }" onclick="selectCom(${resource.comId }, '${resource.comName }')"
									<c:forEach items="${userResoruceList}" var="ur" > 
			            				 <c:if test="${resource.comId == ur.comId}">
			            				  checked 
			            				 </c:if>
			            			 </c:forEach>				 					
									/>
									${resource.comName}</td>
									<td style="border: 1px solid #C0C0C0;">
										<c:forEach items="${resource.manageEstateList}" var="estate">
											<input type="checkbox" class="estateId_${resource.comId}" id="estateId_${estate.estateId}_${estate.estateName}" name="estateId" value="${estate.estateId }" onclick="selectEstate(${resource.comId},'${resource.comName}', ${estate.estateId}, '${estate.estateName}')"
											
											<c:forEach items="${userResoruceList}" var="ur" > 
					            				 <c:if test="${estate.estateId == ur.estateId}">
					            				  checked 
					            				 </c:if>
					            			 </c:forEach>
											
											/>
											${estate.estateName }
										</c:forEach>
									</td>
								</tr>
								</c:forEach>
							</table>
		</form>
	
	    <div style="text-align: center; padding: 5px;margin-top:60px">
            <a href="javascript:void(0)" onclick="saveData('', 'addResource')" id="btn-save" class="easyui-linkbutton" data-options='iconCls:"icon-ok"'>保存</a>
            <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" class="easyui-linkbutton" data-options='iconCls:"icon-cancel"'>取消</a>
        </div>
	</div>
    <div id="edit-window" style="width: 350px; height: 500px;"></div>
    
</div>
</body>

</html>
