<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
	<script type="text/javascript" src="<%=path %>/js/json2.js"></script>
	
<script type="text/javascript">
var addWin;
var win;
var grid;
$(function() {
	
	grid = $('#grid').datagrid({
        title: 'BusinessRole管理',
        iconCls: 'icon-save',
        url: '<%=ctx %>/manage/businessRole/specialList.do',
        fit: true,
        fitColumns: true,
		resize: true,
        sortName: 'roleId',
        sortOrder: 'desc',
        idField: 'roleId',
        pageSize:30,
        frozenColumns: [[
                         { field: 'roleId', checkbox: true }
        		]],
        columns: [[
    		          { field: 'roleName', title: '角色名称', width: 150, align:'center' },
    		          { field: 'roleDesc', title: '角色描述', width: 150, align:'center' },
    		          { field: 'groupId', title: '所属部门', width: 150, align:'center' }
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
        }, '-', {
            text: '查找',
            iconCls: 'icon-search',
            handler: OpensearchWin
        }, '-', {
            text: '所有',
            iconCls: 'icon-search',
            handler: showAll
        }]
    });

	var p = $('#grid').datagrid('getPager');
	if (p){                
		$(p).pagination({                    
			onSelectPage: function(pageNumber, pageSize) {
				$(this).pagination('loading');
				var queryParams = {pageNo: pageNumber, pageSize: pageSize};
				grid.datagrid('reload', queryParams);
			}               
		});            
	}

    $('#btn-search, #btn-search-cancel').linkbutton();
    $('body').layout();
    
    $( "#tabs" ).tabs();
    
});

function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
         ids.push(rows[i].roleId);
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

function add() {
	addWin = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        maximized:true,
        href: '<%=ctx %>/manage/businessRole/specialAdd.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
    $('#resourceRightAdd').val('');
    initAllObj();
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
    	addWin = $('#add-window').window({
            closed: true,
            modal: true,
            shadow: false,
            cache: false,
            href: '<%=ctx %>/manage/businessRole/specialAdd.do?roleId='+rows[0].roleId
            
        });
    	$('#add-window').window('open');
    	
    	//初始化权限
    	initResourceRight(rows[0].roleId);
    }
}

//初始化权限
function initResourceRight(roleId) {
		$('#resourceRightAdd').val('');
	    initAllObj();
		var tableDom = $('#addResourceRightTable');
		if(tableDom == null || tableDom == undefined) {
			timer = setTimeout('initResourceRight('+roleId+')', 500);	
		}else{
			clearTimeout(timer);
			$.ajax({
				type: "POST",
			   	url: '<%=ctx%>/manage/businessRole/initSpecialResourceRight.do',
			    dataType: 'json',
			    data: {roleId: roleId},
			   	success: function(result){
			        resourceRight = result.data;
			        for(var i=0;i<resourceRight.length;i++) {
			        	var resourceRightObj = resourceRight[i];
			        	
				        //展示已选择的数据
						//初始化展示记录
						var newTr = $('<tr id="tr_'+resourceRightObj.itemIndex+'" style="border: 1px solid #000fff;"></tr>');
						$('#addResourceRightTable').append(newTr);
						var resourceTd = $('<td id="resourceTd_'+resourceRightObj.itemIndex+'" style="padding:5px; border: 1px solid  #C0C0C0; width: 250px"></td>');
						var rightTd = $('<td id="rightTd_'+resourceRightObj.itemIndex+'" style="border: 1px solid #C0C0C0;"></td>');
						$(newTr).append(resourceTd);
						$(newTr).append(rightTd);
						//树结构
						$('<div id="tree_'+resourceRightObj.itemIndex+'"></div>').appendTo(resourceTd);;
						$('#tree_'+resourceRightObj.itemIndex).tree({ 
							data: resourceRightObj.resource
						});	
						//资源删除编辑
						$('<br /><div><a style="color:red;" href="javascript:deleteResourceRight('+resourceRightObj.itemIndex+')">删除特殊权限</a>&nbsp;&nbsp;&nbsp;&nbsp;<a style="color:blue;" href="javascript:editResource('+resourceRightObj.itemIndex+')">编辑</a></div>').appendTo(resourceTd);
						
						var rightHtml = '<div id="menuFunction_'+resourceRightObj.itemIndex+'">';
						var tempRight = resourceRightObj.right; 
						for(var j=0;j<tempRight.length;j++) {
							var menuName = tempRight[j].menuName;
							rightHtml += '<div style="font-wieght:bold;">'+menuName+'</div>';
							var functionChildren = tempRight[j].children;
							rightHtml += '<div>';
							for(var k=0;k<functionChildren.length;k++) {
								var functionName = functionChildren[k].functionName;
								rightHtml += functionName+'&nbsp;&nbsp;';
							}
							rightHtml += '</div><br />';
						}
						rightHtml += '</div>';
						$(rightTd).append(rightHtml);
						$('<div style="color:blue;"><a href="javascript:editRight('+resourceRightObj.itemIndex+')">编辑</a></div>').appendTo(rightTd);
								
			        }
			   }
			});
		}	
	}

function del() {
    var arr = getSelectedArr();
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: '<%=ctx %>/manage/businessRole/specialDelete.do?id=' + arr2str(arr),
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
	grid.datagrid('reload',{});
}

function saveData(oper, formId) {
	//加入资源权限数据结构
	if(resourceRight.length == 0) {
		alert('请添加特殊权限');
		return;
	}else{
		$('#resourceRightAdd').val(JSON.stringify(resourceRight));
		$('#'+formId).form('submit', {
	        url: $('#'+formId).attr('action'),
	        onSubmit:function(){  
	    		return $(this).form('validate');  
		 	},
	        success: function (data) {
	            eval('data=' + data);
	            if (data.success) {
	            	//释放整个资源权限对象
	        		initAllObj();
	                grid.datagrid('reload');
	                addWin.window('close');
	                $('#'+formId).form('clear');
	            } else {
	                $.messager.alert('错误', data.msg, 'error');
	            }
	        }
	    });
	}	
}

function updateData(oper, formId) {
	//加入资源权限数据结构
	if(resourceRight.length == 0) {
		alert('请添加特殊权限');
		return;
	}else{
		$('#resourceRightEdit').val(JSON.stringify(resourceRight));
		$('#'+formId).form('submit', {
	        url: $('#'+formId).attr('action'),
	        onSubmit:function(){  
	    		return $(this).form('validate');  
		 	},
	        success: function (data) {
	            eval('data=' + data);
	            if (data.success) {
	            	//释放整个资源权限对象
	        		resourceRight = new Array();
	                grid.datagrid('reload');
	                win.window('close');
	                $('#'+formId).form('clear');
	            } else {
	                $.messager.alert('错误', data.msg, 'error');
	            }
	        }
	    });
	}	
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
	addWin.window('close');
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

function selectMenu(menuId, menuName) {
	if($('#menuId_'+menuId+'_'+menuName).is(':checked')) {
		$("input[name='functionId_"+menuId+"']").each(function(index, item) {
			$(item).prop("checked",true);
		});
	}else{
		$("input[name='functionId_"+menuId+"']").each(function(index, item) {
			$(item).prop("checked",false);
		});
	}
}

function selectMenuForEdit(menuId) {
	if($('#menuId_'+menuId).is(':checked')) {
		$("input[name='functionId_"+menuId+"']").each(function(index, item) {
			$(item).prop("checked",true);
		});
	}else{
		$("input[name='functionId_"+menuId+"']").each(function(index, item) {
			$(item).prop("checked",false);
		});
	}
}

function selectFunction(menuId, menuName, functionId, functionName) {
	if($('#functionId_'+functionId+'_'+functionName).is(':checked')) {
		$('#menuId_'+menuId+'_'+menuName).prop("checked",true);
	}else{
		var ll = $("input[name='functionId_"+menuId+"']:checked").length;
		if(ll == 0) {
			$('#menuId_'+menuId+'_'+menuName).prop("checked",false);
		}
	}
}

function selectFunctionForEdit(menuId, functionId) {
	if($('#functionId_'+functionId).is(':checked')) {
		$('#menuId_'+menuId).prop("checked",true);
	}else{
		var ll = $("input[name='functionId_"+menuId+"']:checked").length;
		if(ll == 0) {
			$('#menuId_'+menuId).prop("checked",false);
		}
	}
}

//打开新增社区窗口
function openSpecialComAdd() {
	win = $('#add-community-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=ctx %>/manage/businessRole/addSpecialCommunity.do'
    });
    $('#add-community-window').window('open');
    $('#add-community-window').window('resize');
}

//选择社区
function selectCom(comId, comName) {
	if($('#comId_'+comId+'_'+comName).is(':checked')) {
		$("input[name='estateId_"+comId+"']").each(function(index, item) {
			$(item).prop("checked",true);
		});
	}else{
		$("input[name='estateId_"+comId+"']").each(function(index, item) {
			$(item).prop("checked",false);
		});
	}
}

//选择小区
function selectEstate(comId, comName, estateId, estateName) {
	if($('#estateId_'+estateId+'_'+estateName).is(':checked')) {
		$('#comId_'+comId+'_'+comName).prop("checked",true);
	}else{
		var ll = $("input[name='estateId_"+comId+"']:checked").length;
		if(ll == 0) {
			$('#comId_'+comId+'_'+comName).prop("checked",false);
		}
	}
}

//重置社区选择
function resetCom() {
	$('input[name="comId"]:checked').each(function(idx, item) {
		$(item).attr('checked', false);
	});
	$('.estateType').each(function(idx, item) {
		if($(item).is(':checked')){
			$(item).attr('checked', false);
		}
	});
}

//一个资源+权限记录由资源配置和权限配置组成，curCom为当前的资源记录，curRight为当前权限记录
//json结构示例
/*
resourcRight:[{
	itemIndex: 0, //记录索引
	resourRightId: 0, //资源权限ID，与数据库对应,新增时默认为0
	resource ：[{ //资源
		 			id：1, //社区ID
		 			text: '天通苑' //社区名称
		 			children：[{ //小区
		 				id：1,  //小区ID
		 				text：'东区' //小区名称
		 			}]
		 		}],
 	right：[{       //权限
 			menuId: 1,  //菜单ID
 			menuName: '公告',  //菜单名称
 			children：[{   //功能
 				functionId: 1,   //功能ID
 				functionName: '发布公告' //功能名称
 			}]
 		}]
}]
*/
//最终的资源权限记录数组
var resourceRight = new Array();
//当前资源权限记录
var curItem = {};
//当前资源
var curResource = new Array();
//当前权限
var curRight = new Array();
//当前社区对象
var curCom = {};
//当前小区对象
var curEstate = {};
//当前菜单对象
var curMenu = {};
//当前功能对象
var curFunction = {};

function initAllObj(){
	//最终的资源权限记录数组
	resourceRight = new Array();
	//当前资源权限记录
	curItem = {};
	//当前资源
	curResource = new Array();
	//当前权限
	curRight = new Array();
	//当前社区对象
	curCom = {};
	//当前小区对象
	curEstate = {};
	//当前菜单对象
	curMenu = {};
	//当前功能对象
	curFunction = {};
}

//暂存社区信息，下一步去分配权限
function resourceNext() {
	var ll = 0;
	$('.estateType').each(function(idx, item) {
		if($(item).is(':checked')){
			ll++;
		}
	});
	if($('input[name="comId"]:checked').length == 0 ||
		ll == 0	
		) {
		alert('请选择资源');return;
	}else{
		//组建资源JSON对象到缓存
		curResource = new Array();
		$('input[name="comId"]:checked').each(function(i, comItem) {
			var comId = $(comItem).attr('id').split('_');
			curCom = {};
			curCom.id = comId[1];
			curCom.text = comId[2];
			curCom.children = new Array();
			var estateArr = new Array();
			$("input[name='estateId_"+comId[1]+"']:checked").each(function(j, estateItem) {
				var estateId = $(estateItem).attr('id').split('_');
				curEstate = {};
				curEstate.id = estateId[1];
				curEstate.text = estateId[2];
				estateArr.push(curEstate);
			});
			curCom.children = estateArr;
			curResource.push(curCom); 
		});		
		curItem.resource = curResource;
		//关闭资源分配窗口
		$('#add-community-window').window('close');
		
		//打开权限分配窗口
		openSpecialRightAdd();		
	}
}

//打开新增权限窗口
function openSpecialRightAdd() {
	win = $('#add-right-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=ctx %>/manage/businessRole/addSpecialRight.do'
    });
    $('#add-right-window').window('open');
    $('#add-right-window').window('resize');
}

//重置权限
function resetRight() {
	$('input[name="menuId"]:checked').each(function(idx, item) {
		$(item).attr('checked', false);
	});
	$('.functionType').each(function(idx, item) {
		if($(item).is(':checked')){
			$(item).attr('checked', false);
		}
	});
}

//验证权限并保存资源权限记录
function saveResourceRight() {
	var ll = 0;
	$('.functionType').each(function(idx, item) {
		if($(item).is(':checked')){
			ll++;
		}
	});
	if($('input[name="menuId"]:checked').length == 0 ||
		ll == 0	
		) {
		alert('请选择权限');return;
	}else{
		//记录索引
		for(var i=0;i<resourceRight.length;i++) {
			var reri = resourceRight[i];
		}
		if(resourceRight.length == 0) {
			resourceRight = new Array();
			curItem.itemIndex = 1;
		}else{
			curItem.itemIndex = (resourceRight[(resourceRight.length-1)].itemIndex)+1;
		}
		//alert(curItem.itemIndex);
		var newTrIndex = curItem.itemIndex;
		//组建权限JSON对象到缓存
		curRight = new Array();
		$('input[name="menuId"]:checked').each(function(i, menuItem) {
			var menuId = $(menuItem).attr('id').split('_');
			curMenu = {};
			curMenu.menuId = menuId[1];
			curMenu.menuName = menuId[2];
			curMenu.children = new Array();
			var functionArr = new Array();
			$("input[name='functionId_"+menuId[1]+"']:checked").each(function(j, functionItem) {
				var functionId = $(functionItem).attr('id').split('_');
				curFunction = {};
				curFunction.functionId = functionId[1];
				var idxLength = ('functionId_'+functionId[1]+'_').length;
				curFunction.functionName = $(functionItem).attr('id').substring(idxLength);
				functionArr.push(curFunction);
			});
			curMenu.children = functionArr;
			curRight.push(curMenu); 
		});		
		curItem.right = curRight;
		//构造整条资源权限记录
		resourceRight.push(curItem);
		
		//初始化展示这条记录
		var newTr = $('<tr id="tr_'+newTrIndex+'" style="border: 1px solid #000fff;"></tr>');
		$('#addResourceRightTable').append(newTr);
		var resourceTd = $('<td id="resourceTd_'+newTrIndex+'" style="padding:5px; border: 1px solid  #C0C0C0; width: 250px"></td>');
		var rightTd = $('<td id="rightTd_'+newTrIndex+'" style="border: 1px solid #C0C0C0;"></td>');
		$(newTr).append(resourceTd);
		$(newTr).append(rightTd);
		//树结构
		$('<div id="tree_'+newTrIndex+'"></div>').appendTo(resourceTd);;
		$('#tree_'+newTrIndex).tree({ 
			data: curItem.resource
		});	
		//资源删除编辑
		$('<br /><div><a style="color:red;" href="javascript:deleteResourceRight('+newTrIndex+')">删除特殊权限</a>&nbsp;&nbsp;&nbsp;&nbsp;<a style="color:blue;" href="javascript:editResource('+newTrIndex+')">编辑</a></div>').appendTo(resourceTd);
		
		var rightHtml = '<div id="menuFunction_'+newTrIndex+'">';
		for(var i=0;i<curRight.length;i++) {
			var menuName = curRight[i].menuName;
			rightHtml += '<div style="font-wieght:bold;">'+menuName+'</div>';
			var functionChildren = curRight[i].children;
			rightHtml += '<div>';
			for(var j=0;j<functionChildren.length;j++) {
				var functionName = functionChildren[j].functionName;
				rightHtml += functionName+'&nbsp;&nbsp;';
			}
			rightHtml += '</div><br />';
		}
		rightHtml += '</div>';
		$(rightTd).append(rightHtml);
		$('<div style="color:blue;"><a href="javascript:editRight('+newTrIndex+')">编辑</a></div>').appendTo(rightTd);
		
		//初始化当前项
		curItem = {};
		
		//关闭资源分配窗口
		$('#add-right-window').window('close');
				
	}
}

function deleteResourceRight(itemIndex) {
	//从表格删除
	$('#tr_'+itemIndex).remove();
	//从数据结构删除
	for(var i=0;i<resourceRight.length;i++) {
			var reri = resourceRight[i];
			if(reri.itemIndex == itemIndex) {
				resourceRight.splice(i, 1);
			}
	}
}

var updateIndex = 0;
var timer = null;
function resourceShow(itemIndex) {
	var ll = $('#addSpecialCommunityTable').find('tr').length;
	//alert('aaa   '+ll);
	if(ll == 0) {
		timer = setTimeout('resourceShow('+itemIndex+')', 500);	
	}else{
		clearTimeout(timer);
		$('#btn-resource-next').hide();
		$('#btn-update-community').show();
		//默认选中社区和小区
		for(var i=0;i<resourceRight.length;i++) {
				var reri = resourceRight[i];
				if(reri.itemIndex == itemIndex) {
					var resource = reri.resource;
					//编辑社区
					for(var j=0;j<resource.length;j++) {
						var comObj = resource[j];
						$('#comId_'+comObj.id+'_'+comObj.text).attr('checked', true);
						//编辑小区
						var estates = comObj.children;
						for(var k=0;k<estates.length;k++) {
							var estateObj = estates[k];
							$('#estateId_'+estateObj.id+'_'+estateObj.text).attr('checked', true);
						}
					}				
				}
		}
		
	}	
}

//编辑资源窗口
function editResource(itemIndex) {
	updateIndex = itemIndex;
	win = $('#add-community-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=ctx %>/manage/businessRole/addSpecialCommunity.do'
    });
	$('#add-community-window').window('open');
	$('#add-community-window').window('resize');	
	
	resourceShow(itemIndex);
}
//编辑资源
function updateResource() {
	var ll = 0;
	$('.estateType').each(function(idx, item) {
		if($(item).is(':checked')){
			ll++;
		}
	});
	if($('input[name="comId"]:checked').length == 0 ||
		ll == 0	
		) {
		alert('请选择资源');return;
	}else{
		//找到要修改的资源对象
		for(var i=0;i<resourceRight.length;i++) {
			var reri = resourceRight[i];
			if(reri.itemIndex == updateIndex) {
				//组建资源JSON对象到缓存
				curResource = new Array();
				$('input[name="comId"]:checked').each(function(i, comItem) {
					var comId = $(comItem).attr('id').split('_');
					curCom = {};
					curCom.id = comId[1];
					curCom.text = comId[2];
					curCom.children = new Array();
					var estateArr = new Array();
					$("input[name='estateId_"+comId[1]+"']:checked").each(function(j, estateItem) {
						var estateId = $(estateItem).attr('id').split('_');
						curEstate = {};
						curEstate.id = estateId[1];
						curEstate.text = estateId[2];
						estateArr.push(curEstate);
					});
					curCom.children = estateArr;
					curResource.push(curCom); 
				});
				reri.resource = curResource;
				//curItem.resource = curResource;
				//关闭资源分配窗口
				$('#add-community-window').window('close');
				//变更树结构
				$('#tree_'+updateIndex).tree({ 
					data: curResource
				});
				//打开权限分配窗口
				//openSpecialRightAdd();		
			}
			}
		}	
		
}

//编辑权限
function editRight(itemIndex) {
	updateIndex = itemIndex;
	win = $('#add-right-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: '<%=ctx %>/manage/businessRole/addSpecialRight.do'
    });
    $('#add-right-window').window('open');
    $('#add-right-window').window('resize');
    
    rightShow(itemIndex);
}

//编辑权限
function updateRight() {
	var ll = 0;
	$('.functionType').each(function(idx, item) {
		if($(item).is(':checked')){
			ll++;
		}
	});
	if($('input[name="menuId"]:checked').length == 0 ||
		ll == 0	
		) {
		alert('请选择权限');return;
	}else{
		for(var i=0;i<resourceRight.length;i++) {
			var reri = resourceRight[i];
			if(reri.itemIndex == updateIndex) {
				//组建权限JSON对象到缓存
				curRight = new Array();
				$('input[name="menuId"]:checked').each(function(i, menuItem) {
					var menuId = $(menuItem).attr('id').split('_');
					curMenu = {};
					curMenu.menuId = menuId[1];
					curMenu.menuName = menuId[2];
					curMenu.children = new Array();
					var functionArr = new Array();
					$("input[name='functionId_"+menuId[1]+"']:checked").each(function(j, functionItem) {
						var functionId = $(functionItem).attr('id').split('_');
						curFunction = {};
						curFunction.functionId = functionId[1];
						var idxLength = ('functionId_'+functionId[1]+'_').length;
						curFunction.functionName = $(functionItem).attr('id').substring(idxLength);
						functionArr.push(curFunction);
					});
					curMenu.children = functionArr;
					curRight.push(curMenu); 
				});		
				reri.right = curRight;
				//关闭权限分配窗口
				$('#add-right-window').window('close');
				//变更展现
				var rightHtml = '';
				for(var i=0;i<curRight.length;i++) {
					var menuName = curRight[i].menuName;
					rightHtml += '<div style="font-wieght:bold;">'+menuName+'</div>';
					var functionChildren = curRight[i].children;
					rightHtml += '<div>';
					for(var j=0;j<functionChildren.length;j++) {
						var functionName = functionChildren[j].functionName;
						rightHtml += functionName+'&nbsp;&nbsp;';
					}
					rightHtml += '</div><br />';
				}
				$('#menuFunction_'+updateIndex).html(rightHtml);
			}
		}
	}	
}
	
//初始化权限
function rightShow(itemIndex) {
	var ll = $('#addSpecialRightTable').find('tr').length;
	//alert('aaa   '+ll);
	if(ll == 0) {
		timer = setTimeout('rightShow('+itemIndex+')', 500);	
	}else{
		clearTimeout(timer);
		$('#btn-save-right').hide();
		$('#btn-update-right').show();
		//默认选中菜单和功能
		for(var i=0;i<resourceRight.length;i++) {
				var reri = resourceRight[i];
				if(reri.itemIndex == itemIndex) {
					var right = reri.right;
					//编辑菜单
					for(var j=0;j<right.length;j++) {
						var menuObj = right[j];
						$('#menuId_'+menuObj.menuId+'_'+menuObj.menuName).attr('checked', true);
						//编辑小区
						var children = menuObj.children;
						for(var k=0;k<children.length;k++) {
							var funtionObj = children[k];
							$('#functionId_'+funtionObj.functionId+'_'+funtionObj.functionName).attr('checked', true);
						}
					}				
				}
		}
		
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
    <div id="add-window" title="新增窗口" style="width: 700px; height: 300px;"></div>
    <div id="edit-window" title="编辑窗口" style="width: 450px; height: 300px;"></div>
    <div id="add-community-window" title="新增特殊资源窗口" style="width: 650px; height: 400px;"></div>
    <div id="add-right-window" title="新增特殊权限窗口" style="width: 650px; height: 400px;"></div>
    
    <div id="edit-community-window" title="编辑特殊资源窗口" style="width: 650px; height: 400px;"></div>
    <div id="edit-right-window" title="编辑特殊权限窗口" style="width: 650px; height: 400px;"></div>
    
    <div id="search-window" title="查询窗口" style="width: 400px; height: 300px;">
        <div style="padding: 20px 20px 40px 80px;">
            <form id="searchForm" method="post" action="<%=ctx %>/manage/businessRole/specialList.do">
            <table>
					<tr>
			          <td>角色名称：</td>
			          <td>
			          	<input name="roleName" id="roleName" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>角色描述：</td>
			          <td>
			          	<input name="roleDesc" id="roleDesc" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>创建时间：</td>
			          <td>
			          	<input name="createTime" id="createTime" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑时间：</td>
			          <td>
			          	<input name="editTime" id="editTime" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>编辑人：</td>
			          <td>
			          	<input name="editor" id="editor" type="text" style="width: 150px;" value=""/>
			          </td>
			        </tr>
					<tr>
			          <td>是否特殊角色：</td>
			          <td>
			          	<input name="isSpecial" id="isSpecial" type="text" style="width: 150px;" value=""/>
			          	<select name="isSpecial" id="isSpecial" class="selectwidth">
			          		<option value="">请选择</option>
			          		<option value="0">是</option>
			          		<option value="1">否</option>
			          	</select>
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