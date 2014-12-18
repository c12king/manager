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
	

</head>
<body class="easyui-layout" style="overflow-y: hidden;">
<script type="text/javascript">
var winEstate;
var gridEstate;
$(function() {
	
	gridEstate = $('#gridEstate').datagrid({
        title: 'AppEstateUser管理',
        iconCls: 'icon-save',
        url: '<%=path %>/app/appEstateUser/list.do',
        fit: true,
        fitColumns: true,
        queryParams:{
        	name:function(){
        		console.log($("#name").val());
        		return $("#name").val();
        	},
        	id:'${id}'
        },
		resize: true,
		sortName: 'estMemId',  
        sortOrder: 'desc',
        idField: 'estMemId',
        pageSize:30,
        columns: [[
    		          { field: 'estateName', title: '小区名称', width: 150, align:'center' },
    		          { field: 'buildingName', title: '楼栋名称', width: 150, align:'center' },
    		          { field: 'unitName', title: '单元', width: 150, align:'center' },
    		          { field: 'houseNo', title: '门号', width: 150, align:'center' },
    		          { field: 'memberType', title: '类型', width: 150, align:'center' },
    		          { field: 'createTime', title: '创建时间', width: 150, align:'center' },
    		          { field: 'editTime', title: '编辑时间', width: 150, align:'center' },
    		          { field: 'editor', title: '编辑人', width: 150, align:'center' },
                ]],
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10,20,30,40,50],
        nowrap:false,
        striped: true,
        loadMsg:'数据装载中......',
        rownumbers: true,
        singleSelect: true,
        toolbar: []
    });

});



</script>
    <div region="center" style="width: 760px; height: 460px; padding: 1px; background: #eee;
        overflow-y: hidden">
        <div id="gridEstate" fit="true">
        </div>
    </div>
</body>

</html>