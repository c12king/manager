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
    
    <title>短信管理</title>
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

<script type="text/javascript">
var win;
var grid;
$(function() {
	
	grid = $('#grid').datagrid({
        title: '短信管理',
        iconCls: 'icon-save',
        url: '<%=path %>/manage/manageSendMsg/list.do',
        fit: true,
        fitColumns: true,
        queryParams:{
        	sendTel:function(){
        		return $("#sendTel").val();
        	},
			state:function(){
				return $("[name=state]").val();
			}
        },
		resize: true,
		sortName: 'sendId',
        sortOrder: 'desc',
        idField: 'sendId',
//         frozenColumns: [[
//                          { field: 'sendId', checkbox: true }
//         		]],
        columns: [[
					{ field: 'sendTel', title: '手机号', width: 150, align:'center' },
					{ field: 'sendContent', title: '内容', width: 150, align:'center' },
					{ field: 'recvCode', title: '是否成功', width: 150, align:'center' },
					{ field: 'sendTime', title: '发送时间', width: 150, align:'center' },
					{ field: 'sendType', title: '发送类型', width: 150, align:'center' },
					{ field: 'resend', title: '重新发送', width: 150, align:'center',
						  //添加超级链 
                        formatter:function(value,rowData,rowIndex){
                            //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
                            return "<a href='javascript:;' onclick='resend("+rowData.sendId+");'>重新发送</a>"; 
                       }  
					
					},
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
        toolbar: [
                /*  {
            text: '新增',
            iconCls: 'icon-add',
            handler: add
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: edit
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: del
        }, '-',*/ {
            text: '查找',
            iconCls: 'icon-search',
            handler: OpensearchWin
        }
        /*, '-', {
            text: '所有',
            iconCls: 'icon-search',
            handler: showAll
        }*/
        ]
    });


    $('#btn-search, #btn-search-cancel').linkbutton();
    
    $('body').layout();
    var data = "[{\"label\":0,\"value\":\"全部\"},{\"label\":1,\"value\":\"成功\"},{\"label\":2,\"value\":\"失败\"}]";
//     alert(data);  
    data=JSON.parse(data);   
    vm ={
		editable:false,
	    valueField:'label',
	    textField:'value',
	    data:  data ,
	    required: true,
	    missingMessage:'该输入项为必填项'
	};
    $("#state").combobox(vm);

//     $.ajax({
// 	    type: "post",
<%-- 	    url: "<%=path %>/manage/businessMenu/getComboboxData.do", --%>
// 	    success: function(data){
// 	    	alert(data);
// 	        data=JSON.parse(data);
// 	        vm ={
// 	        	editable:false,
// 	            valueField:'label',
// 	            textField:'value',
// 	            data:  data ,
// 	            required: true,
// 	            missingMessage:'该输入项为必填项'
// 	        }
// 	        alert(data);
// 	        $("#menu").combobox(vm);
// 	    },
// 	    error:function(error){
// 	        $.messager.alert('系统提示', error, 'warning');

// 	    }
// 	});
});

function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].functionId);
    }
    return ids;
}

// function resend(id){
// 	alert("-----"); 
// }

function resend(id){
 $.ajax({
	    type: "post",
	    url: "<%=path %>/manage/manageSendMsg/resend.do?telId="+id,	    
	    success: function(data){
	    	data=JSON.parse(data);
	        alert(data.message);
	    },
	    error:function(error){
	    	//alert(data.message);
// 	    	alert("发送失败！");
			alert('系统提示', error, 'warning');
	    }
	});
}
function getSelectedID() {
    var ids = getSelectedArr();
    return ids.join(',');
}

function arr2str(arr) {
    return arr.join(',');
}

function add() {
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=path %>/manage/manageFunction/add.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}

function edit() {
    var rows = grid.datagrid('getSelections');
    var num = rows.length;
    if (num == 0) {
        $.messager.alert('提示', '请选择一条记录进行操作!', 'info');
        return;
    } else if (num > 1) {
        $.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行修改!', 'info');
        return;
    }
    else{
    	win = $('#edit-window').window({
            closed: true,
            modal: true,
            shadow: false,
            cache: false,
            href: '<%=path %>/manage/manageFunction/modify.do?id='+rows[0].functionId
            
        });
    	$('#edit-window').window('open');
        $('#modifyForm').form('clear');
        $('#modifyForm').form('load', '<%=path %>/manage/manageFunction/edit.do?id=' + rows[0].functionId);
    }
}

function del() {
    var arr = getSelectedArr();
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: '<%=path %>/manage/manageFunction/delete.do?id=' + arr2str(arr),
                    timeout: 1000,
                    cache: false,
                    success: function (data) {
                        grid.datagrid('reload');
                        grid.datagrid('clearSelections');
                    },
                    error: function () {
                        $.messager.alert('错误', '删除失败!', 'error');
                    }
                });
            }
        });
    } else {
        $.messager.show({
            title: '警告',
            msg: '请先选择要删除的记录。'
        });
    }
}

function showAll() {
	$('#searchForm').form('clear');
	grid.datagrid('reload');
}

function saveData(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}

function modifyDate() {
	$('#modifyForm').form('submit', {
		url: $('#modifyForm').attr('action'),
		success: function(data) {
			eval('data=' + data);
			if(data.success) {
				grid.dataGrid(reload);
				$('#edit-window').window('close');
				form.form('clear');
			}
		}
	});
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
	grid.datagrid('reload');
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
    <div id="add-window" title="新增窗口" style="width: 400px; height: 500px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 400px; height: 500px;"></div>
    <div id="search-window" title="查询窗口" style="width: 400px; height: 500px;">
        <div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/manage/manageFunction/list.do">
            <table>
					<tr>
			          <td>手机号：</td>
			          <td>
			          	<input name="sendTel" id="sendTel" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>状态：</td>
			          <td>
			          	<div  type='text' id="state" name="state" style='width:150px; margin-right:5px'>
			          	</div>
			          </td>
			        </tr>
            </table>
            </form>
        </div>
        <div style="text-align: center; padding: 5px;">
            <a href="javascript:void(0)" onclick="SearchOK()" id="btn-search" icon="icon-ok">确定</a>
            <a href="javascript:void(0)" onclick="closeSearchWindow()" id="btn-search-cancel" icon="icon-cancel">
                取消</a>
        </div>
    </div>
</body>

</html>