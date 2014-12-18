
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning')
    }
}
$(function(){
	loadDepTree()
})


function loadDepTree(){
	$('#depTreeul').tree({
	    url:path+'/business/businessDepartment/treeData.do?type='+type+'&id='+staId,
	    method: 'post',
	    animate: true,
	    onContextMenu: function(e,node){
	        e.preventDefault();
	        $(this).tree('select',node.target);
	        $('#monitor3').menu('show',{
	            left: e.pageX,
	            top: e.pageY
	        });
	    },
	    onClick:function(node) {
	    	depName=node.text;
	    	loadTree(node.id)
	    },
	    onLoadSuccess:function(node,data){
	    	//loadUser(-1)
	    }
	})
}

var depId;//被选中的组织机构id
var depName;//被选中的组织机构名称
function loadTree(id){
	depId=id;
	$('#jobTreeul').tree({
	    url:path+'/business/businessPosition/treeData.do?depId='+id,
	    method: 'post',
	    animate: true,
	    onContextMenu: function(e,node){
	        e.preventDefault();
	        $(this).tree('select',node.target);
	        $('#monitor2').menu('show',{
	            left: e.pageX,
	            top: e.pageY
	        });
	    },
	    onClick:function(node) {
	        var node = $('#jobTreeul').tree('getSelected');
	        if(node.id==0){
	        	return null;
	        }
	        loadUser(node.id);
	        /*var stu =$.post(path+'/menu/selectMenuId.do',{menuId: node.id},function(date){
	            if(date.status == 'ERROR'){
	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
	            }else{
	            	console.log(date)
	                //$("#ff").form('load', date);
	            	var obj = JSON.parse(date);
	            	$("#ff").form('load', obj);
	            }
	        })
	        stu.error(ajax_error("请求未成功"));
			*/
	    },
	    onLoadSuccess:function(node,data){
	    	loadUser(-1)
	    }
	})
}
function append(){
    var t = $('#treeul');
    var node = t.tree('getSelected');

    var stu = $.post(path+'/manage/manageOrg/save.do',{parentId: node.id},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	 t.tree('append', {
                 parent: (node?node.target:null),
                 data: [{
                	 text:"新节点",
                     id:date
                 }]
             });
                    /*$('#treeul').tree({
                        url: path+'/menu/treeData.do',
                        method: 'post'

                    })*/
            

        }
    })
    stu.error(ajax_error("请求未成功"));


}

function append2(){
    var t = $('#jobTreeul');
    var node = t.tree('getSelected');

    var stu = $.post(path+'/business/businessPosition/save.do',{parentId: node.id,parentName:node.text,orgId:staId,orgName:staName,depId:depId,depName:depName,orgType:type},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	 t.tree('append', {
                 parent: (node?node.target:null),
                 data: [{
                	 text:"新节点",
                     id:date
                 }]
             });
                    /*$('#treeul').tree({
                        url: path+'/menu/treeData.do',
                        method: 'post'

                    })*/
            

        }
    })
    stu.error(ajax_error("请求未成功"));


}

function append3(){
    var stu = $.post(path+'/business/businessDepartment/save.do',{orgId:staId,orgName:staName,orgType:type},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$('#depTreeul').tree('reload');
        }
    })
    stu.error(ajax_error("请求未成功"));


}
function removeit(){
    var node = $('#treeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }

    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/manageOrg/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else if (date == '0'){
                    $.messager.alert('系统提示', '存在子栏目，不能删除!', 'warning');
                }else{
                    $('#treeul').tree('remove', node.target);
                }
            })

        } else{
            return;
        }
    })
}
function removeit2(){
    var node = $('#jobTreeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }

    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/business/businessPosition/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else if (date == '0'){
                    $.messager.alert('系统提示', '存在子栏目，不能删除!', 'warning');
                }else{
                    $('#jobTreeul').tree('remove', node.target);
                }
            })

        } else{
            return;
        }
    })
}

function removeit3(){
    var node = $('#depTreeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }

    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/business/businessDepartment/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else if (date == '0'){
                    $.messager.alert('系统提示', '存在子栏目，不能删除!', 'warning');
                }else{
                    $('#depTreeul').tree('remove', node.target);
                }
            })

        } else{
            return;
        }
    })
}
function collapse(){
    var node = $('#treeul').tree('getSelected');
    $('#treeul').tree('collapse',node.target);
}
function expand(){
    var node = $('#treeul').tree('getSelected');
    $('#treeul').tree('expand',node.target);
}
$.messager.defaults.ok='确定'
	var ajax_error = function (msg) {
	    return function () {
	        $.messager.alert('系统提示', msg, 'warning')
	    }
	}

	function closeWinFn() {
	    $('#w').window('close');
	}

	function newNode(){
		var stu = $.post(path+'/menu/addMenu.do',{parentId: 0},function(date){
	        if(date.status == 'ERROR'){
	            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
	        }else{
	            

	                    $('#treeul').tree({
	                        url: path+'/menu/treeData.do',
	                        method: 'post'

	                    })
	            
	        }
	    })
	    stu.error(ajax_error("请求未成功"));
	}

	function searchRenew ()  {
	    $("#mm").form('reset');
	}
	function newSave() {

	    $('#ff').form('submit', {
	        url: $('#ff').attr('action'),
	        success: function (data) {
	            //eval('data=' + data);
	            //if (data.success) {
	            if (data=="1") {
	            	$('#treeul').tree({
	                    url: path+'/menu/treeData.do',
	                    method: 'post'

	                })
	                $.messager.alert('成功', "操作成功","warning");
	            } else {
	                $.messager.alert('错误', "操作失败", 'error');

	            }
	        },
	        error:function(error){
	            $.messager.alert('错误', error, 'error');

	        }
	    });
	}
function edit1 (){
	var node = $('#treeul').tree('getSelected');
	if(node.id==0){
    	return null;
    }
	win = $('#edit-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/manageOrg/modify.do?id='+node.id
    });
	$('#edit-window').window('open');

}
function edit2 (){
	var node = $('#jobTreeul').tree('getSelected');
	if(node.id==0){
    	return null;
    }
	win = $('#edit-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/business/businessPosition/modify.do?id='+node.id
    });
	$('#edit-window').window('open');

}
function edit3 (){
	var node = $('#depTreeul').tree('getSelected');
	console.log(node)
	win = $('#edit-window3').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/business/businessDepartment/modify.do?id='+node.id
    });
	$('#edit-window3').window('open');

}
function saveData1(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	$.messager.alert('成功', "操作成功","warning");
            	var node = $('#treeul').tree('getSelected');
            	var name=$("[name=orgName]").val();
            	$('#treeul').tree('update', {
            		target: node.target,
            		text: name
            	});
                win.window('close');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function saveData2(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	$.messager.alert('成功', "操作成功","warning");
            	var node = $('#jobTreeul').tree('getSelected');
            	var name=$("[name=positionName]").val();
            	$('#jobTreeul').tree('update', {
            		target: node.target,
            		text: name
            	});
                win.window('close');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function saveData3(oper, formId) {
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	$('#depTreeul').tree('reload');
                win.window('close');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function closeWindow() {
	win.window('close');
}
var win;
var grid;
function loadUser(id){
	grid = $('#grid').datagrid({
        title: 'BusinessUser管理',
        iconCls: 'icon-save',
        url: path+'/manage/businessUser/posList.do',
        fit: true,
        fitColumns: true,
        queryParams:{
        	name:function(){
        		console.log($("#userNames").val());
        		return $("#userName").val();
        	},
        	id:function(){
        	    var node = $('#jobTreeul').tree('getSelected');
        	    if(null==node){
        	    	return id
        	    }
        		return node.id;
        	}
        },
		resize: true,
        sortOrder: 'userId',
        idField: 'userId',
        pageSize:30,
        frozenColumns: [[
                         { field: 'userId', checkbox: true }
        		]],
        columns: [[
    		          { field: 'userName', title: '真实姓名', width: 150, align:'center' },
    		          { field: 'posName', title: '职位名称', width: 150, align:'center' },
    		          { field: 'isCharge', title: '是否是该职位负责人', width: 150, align:'center',formatter:f0_formatter },
    		          { field: 'userTel', title: '电话号码', width: 150, align:'center' },
    		          { field: 'lastLoginTime', title: '最近登录时间', width: 150, align:'center' },
    		          { field: 'userEmail', title: '邮箱', width: 150, align:'center' },
    		          { field: 'userPhoto', title: '照片', width: 150, align:'center' },
    		          { field: 'userBrief', title: '个人介绍', width: 150, align:'center' },
    		          { field: 'userService', title: '服务内容', width: 150, align:'center' },
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
        toolbar: [{
            text: '新增',
            iconCls: 'icon-add',
            handler: add
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: edit
        }, '-', {
            text: '编辑职位',
            iconCls: 'icon-edit',
            handler: edit4
        }, '-', {
            text: '设置为负责人',
            iconCls: 'icon-edit',
            handler: isCharge
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: del
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

function add() {
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/businessUser/add.do'
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
            href: path+'/manage/businessUser/modify.do?id='+rows[0].userId
            
        });
    	
    	$('#edit-window').window('open');
    }
}
function edit4() {
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
            inline:true
        });
    	var con = '<iframe style="width:100%;height:100%;border:0;" src="'+path+'/manage/businessUser/position.do?id='+rows[0].userId+'"></iframe>';  
    	$('#edit-window2').html(con);
    	$('#edit-window2').window('open');
    }
}
function isCharge(){
	var rows = grid.datagrid('getSelections');
    var node = $('#jobTreeul').tree('getSelected');
	var stu = $.post(path+'/manage/businessUser/isCharge.do',{userId:rows[0].userId,positionId:node.id},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$.messager.alert('成功', "操作成功","warning");
            grid.datagrid('reload');
        }
    })
    stu.error(ajax_error("请求未成功"));
}
function del() {
    var arr = getSelectedArr();
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: path+'/manage/businessUser/delete.do?id=' + arr2str(arr),
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
	var str=$('#'+formId).attr('action')
	if(oper=="add"){
		var node = $('#jobTreeul').tree('getSelected');
		$("#positionId").val(node.id)
		$("#positionName").val(node.text)
		$("#orgType").val(type)
		str=path+"/manage/businessUser/savePosUser.do";
	}
	$('#'+formId).form('submit', {
        url: str,
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                win.window('close');
                grid.datagrid('reload');
                $('#'+formId).form('clear');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function saveDataJob(oper, formId) {
	var str=$('#'+formId).attr('action')
	if(oper=="add"){
		var node = $('#jobTreeul').tree('getSelected');
		$("#positionId").val(node.id)
		$("#positionName").val(node.text)
		str=path+"/manage/businessUser/savePosUser.do";
	}
	$('#'+formId).form('submit', {
        url: str,
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	parent.win.window('close');
            	parent.grid.datagrid('reload');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function SearchOK() {
	grid.datagrid('reload');
    $('#search-window').window('close');	
}
function OpensearchWin() {
	win = $('#search-window').window({
		closed: true,
		modal: true
	});
	$('#search-window').window('open');
	
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
function f0_formatter(a,row,b){
    if(row.isCharge=="1") {
        return "不是";
    } {
        return "是";
    }

}