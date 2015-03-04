<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>资源编辑</title>
    <meta http-equiv="Content-Type" content="textml;charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui-1.10.2.custom.min.css" >
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript">
	var path='<%=path %>'
</script>
<script type="text/javascript">
var win;
var grid;
var userId = ${userId};
$(function() {
	grid = $('#grid').datagrid({
		title: '资源编辑窗口' ,
        iconCls: 'icon-save',
        url: '<%=path %>/manage/businessUser/comList.do',
        fit: true,
        fitColumns: true,
        queryParams:{
        	userId:userId,
        	comName:function(){
        		return $("#comName").val();
        	}
        },
		resize: true,
		sortName: 'comId',
        sortOrder: 'desc',
        idField: 'comId',
        pageSize:10,
//         frozenColumns: [[
//                          { field: 'comId', checkbox: false }
//         		]], 
        columns: [[
						{ field: 'comName', title: '社区名称', width: 150, align:'center', },
						{ field: 'grantAll', title: '分配小区', width: 150, align:'center',
							  //添加超级链 
	                        formatter:function(value,rowData,rowIndex){
	                            //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
	                            return rowData.htmlStr;    
// 	                            "<a href='javacript:;' onclick='grantAll("+rowData.comId+");'>分配该社区下所有小区</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
// 	                           	"<a href='javacript:;' onclick='revokeAll("+rowData.comId+");'>取消该社区下所有小区</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
// 	                           	"<a href='javacript:;' onclick='customEst("+rowData.comId+");'>自定义分配小区</a>";
	                       }
						}
						
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
        toolbar: [{
            text: '查找',
            iconCls: 'icon-search',
            handler: OpensearchWin,
        }, '-', {
            text: '所有',
            iconCls: 'icon-search',
            handler: showAll,
        }]
    });


    $('#btn-search, #btn-search-cancel').linkbutton();
    $('body').layout();
});

function grantAll(comId) {
	var elIdA = comId+'_a';
	var elIdB = comId+'_b';
	$.ajax({   
	    type: "post",
	    url: '<%=path %>/business/businessUserResource/grantAllEst.do?comId='+comId+'&userId='+userId,   
	    dataType: 'json',
	    success: function(data){   
	        alert(data.message);
	        $("#"+elIdA).attr('disabled',"true");
	        $("#"+elIdB).removeAttr("disabled");//attr('disabled',"true");//
	    },
	    error:function(data){
	    	alert(data.message);
	    }
	});   
}
function revokeAll(comId) {
	var elIdA = comId+'_a';
	var elIdB = comId+'_b';
	$.ajax({   
	    type: "post",
	    url: '<%=path %>/business/businessUserResource/revokeAllEst.do?comId='+comId+'&userId='+userId,   
	    dataType: 'json',
	    success: function(data){
	        alert(data.message);
	        $("#"+elIdA).removeAttr("disabled");
	        $("#"+elIdB).attr('disabled',"true");
	    },
	    error:function(data){
	    	alert(data.message);
	    }
	});   
}
function customEst(comId) { 
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=path %>/business/businessUserResource/customEst.do?comId='+comId+'&userId='+userId,  
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}
// function customEst() {
//     var ids = [];
//     var rows = grid.datagrid('getSelections');
//     for (var i = 0; i < rows.length; i++) {
//          ids.push(rows[i].userId);
//     }
//     return ids;
// }

function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].userId);
    }
    return ids;
}



function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].userId);
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



function posEdit() {
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
            href: '<%=path %>/manage/businessUser/posModify.do?id='+rows[0].userId
            
        });
    	$('#edit-window').window('open');
        $('#modifyForm').form('clear');
    }
}
function edit2() {
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
    	win = $('#edit-window2').window({
            closed: true,
            modal: true,
            shadow: false,
            cache: false,
            href: '<%=path %>/manage/businessUser/org.do?id='+rows[0].userId
            
        });
    	var con = '<iframe style="width:100%;height:100%;border:0;" src="'+path+'/manage/businessUser/org.do?id='+rows[0].userId+'"></iframe>';  
    	$('#edit-window2').html(con);
    	$('#edit-window2').window('open');
    }
}

function del() {
    var arr = getSelectedArr();
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: '<%=path %>/manage/businessUser/delete.do?id=' + arr2str(arr),
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
	$("#comName").val(""); 
	grid.datagrid('reload'); 
}

function saveData(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
//         	alert("dddd");    
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
function saveDataJob(oper, formId) {
	 var orgNode = $('#treeul').tree('getSelected');
	 var depNode = $('#depTreeul').tree('getSelected');
	 var posNode = $('#jobTreeul').tree('getSelected');
	 var attr=orgNode.attributes;
     attr=JSON.parse(attr);
     console.log("arr",attr)
     var type = attr.type;
     $("#orgType").val(type);
     $("#orgType1").val(type);
	 $("#positionId").val(posNode.id);
	 $("#positionName").val(posNode.text);
	 $("#orgPosName").val(orgNode.text+"-"+depNode.text+"-"+posNode.text);
	 $("#positionId1").val(posNode.id);
	 $("#positionName1").val(posNode.text);
	 $("#orgPosName1").val(orgNode.text+"-"+depNode.text+"-"+posNode.text);
	 closeSelectPosWindow()
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
	console.log(1111);
	grid.datagrid('reload');
    $('#search-window').window('close');
}

function closeSearchWindow() {
    $('#search-window').window('close');
}
function closeSelectPosWindow() {
    $('#selectPos-window').window('close');
}
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
         $("#"+idf+"-path").val(data.path);  
         $("#"+idf).val(data.path.replace( "\\", "/"))
         $("#"+idf+"-statusPic").html( "<a target='window' href='javascript:void(0);' onclick='Preview(\""+idf+"\")'>预览</a>");  
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
function Preview(id){
	var url =$("#"+id).val()
	if(url==""){
		return ;
	}
    var title="图片预览"
    var obj ={
        title:title,
        url:url
    }
    window.parent.treeOnFrame(obj);
}

function editPermissions() {
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
		win = $('#editPermissions-window').window({
	        closed: true,
	        modal: true,
	        shadow: false,
	        cache: false,
	        href: '<%=path %>/manage/businessUser/editPermissions.do?orgType='+rows[0].orgType+'&userId='+rows[0].userId
	    });
	    $('#editPermissions-window').window('open');
    }
}

function resources() {
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
		win = $('#resource-window').window({
	        closed: true,
	        modal: true,
	        shadow: false,
	        cache: false,
	        maximized:true,
	        href: '<%=path %>/manage/businessUser/resources.do?orgType='+rows[0].orgType+'&userId='+rows[0].userId
	    });
	    $('#resource-window').window('open');
    }
}




</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;">
 
    <div region="center" style="width: 500px; height: 300px; padding: 1px; background: #eee;
        overflow-y: hidden">
        <div id="grid" fit="true">
        </div>
    </div>
    <div id="editPermissions-window" title="权限编辑窗口" style="width: 800px; height: 500px;"></div>
    <div id="resource-window" title="资源编辑窗口" style="width: 800px; height: 500px;"></div>
    <div id="selectPos-window" title="选择组织结构窗口" style="width: 800px; height: 500px;"></div>
    <div id="add-window" title="新增窗口" style="width: 800px; height: 500px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 800px; height: 500px;"></div>
    <div id="edit-window2" title="编辑窗口" style="width: 1000px; height: 550px;"></div>
    <div id="search-window" title="查询窗口" style="width: 500px; height: 500px;">
        <div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=path %>/manage/businessUser/comList.do">
            <table>
					<tr>
			          <td>社区名称：</td>
			          <td>
			          	<input name="comName" id="comName" type="text" style="width: 150px;" value=""/>
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