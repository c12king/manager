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
    <meta http-equiv="Content-Type" content="textml;charset=GBK"/>
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
	
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<script src="<%=path %>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
	<script src="<%=path %>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
	
<script type="text/javascript">
var win;
var grid;
$(function() {
	
	grid = $('#grid').datagrid({
        title: '篇均浏览人数',
        iconCls: 'icon-save',
        url: '<%=path %>/app/appStatisticsClick/personCountPerPageList.do',
        fit: true,
        fitColumns: true,
		resize: true,
		//sortName: 'stationId',
        //sortOrder: 'desc',
        //idField: 'stationId',
        pageSize:100,
        /* frozenColumns: [[
                         { field: 'stationId', checkbox: true }
        		]], */
        columns: [[
    		          { field: 'timeField', title: '日期', width: 50, align:'center' },
    		          { field: 'timeValue', title: '篇均浏览人数', width: 150, align:'center' }
                ]],
        pagination: false,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10,20,30,40,50],
        nowrap:false,
        striped: true,
        loadMsg:'数据装载中......',
        rownumbers: true,
        singleSelect: true,
        toolbar: [{
            text: '查找',
            iconCls: 'icon-search',
            handler: OpensearchWin
        }/* , '-', {
            text: '所有',
            iconCls: 'icon-search',
            handler: showAll
        } */]
    });


    $('#btn-search, #btn-search-cancel').linkbutton();
    $('body').layout();
    
    $("#startDate").datepicker({
    	altFormat: 'yy-mm-dd',
    	dateFormat: 'yy-mm-dd',
		autoSize: true,
		changeYear: true,
		changeMonth: true
	},
	$.datepicker.regional['zh-CN']);
    
    $("#endDate").datepicker({
    	altFormat: 'yy-mm-dd',
    	dateFormat: 'yy-mm-dd',
		autoSize: true,
		changeYear: true,
		changeMonth: true
	},
	$.datepicker.regional['zh-CN']);
    
});

function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].stationId);
    }
    return ids;
}

function getSelectedID() {
    var ids = getSelectedArr();
    return ids.join(',');
}

function arr2str(arr) {
    return arr.join(',');
}

function showAll() {
	$('#searchForm').form('clear');
	grid.datagrid('reload',{});
}

function closeWindow() {
	win.window('close');
}

function OpensearchWin() {
	win = $('#search-window').window({
		closed: true,
		modal: true
	});
	$('#search-window').window('open');
}

function SearchOK() {
	var startDate = $('#startDate').val();
	if(startDate == '') {
		alert('请选择开始日期');return;
	}
	var endDate = $('#endDate').val();
	if(endDate == '') {
		alert('请选择结束日期');return;
	}
	var scope = $('#scope').val();
	if(scope == '') {
		alert('请选择条件');return;
	}
	var queryParams = {startDate: startDate, endDate: endDate, scope: scope};
	grid.datagrid('reload', queryParams);
    $('#search-window').window('close');
}

function closeSearchWindow() {
    $('#search-window').window('close');
}

</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;">
 
    <div region="center" style="width: 500px; height: 300px; padding: 1px; background: #eee;
        overflow-y: hidden">
        <div id="grid" fit="true">
        </div>
    </div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 500px;">
        <div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/manage/businessStation/list.do">
            <table>
					<tr>
			          <td>开始时间：</td>
			          <td>
			          	<input name="startDate" id="startDate" type="text" style="width: 150px;" required="true" missingMessage="请选择开始日期"  value=""/>
			          </td>
			        </tr>
			        <tr>
			          <td>结束时间：</td>
			          <td>
			          	<input name="endDate" id="endDate" type="text" style="width: 150px;" required="true" missingMessage="请选择结束日期"  value=""/>
			          </td>
			        </tr>
			        <!-- <tr>
			          <td>按条件：</td>
			          <td>
			          	按
			          	<select name="scope" id="scope">
			          		<option value="0" selected >日</option>
			          		<option value="1">周</option>
			          		<option value="2">月</option>
			          	</select>
			          	搜索
			          </td>
			        </tr> -->
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