
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning')
    }
}
$(function(){
	$('#treeul').tree({
	    url:path+'/manage/manageOrg/fullOrgTreeData.do',
	    method: 'post',
	    animate: true,
	    onClick:function(node) {
	        var node = $('#treeul').tree('getSelected');
	        if(node.id==0){
	        	loadTree(-1)
	        	return null;
	        }
	        orgName=node.text;
	        var attr=node.attributes;
	        attr=JSON.parse(attr);
	        loadDepTree(node.id,attr.type);
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
	    	loadTree(-1)
	    }
	})
	
	
})

var orgId;//被选中的组织机构id
var orgName;//被选中的组织机构名称
function loadDepTree(id,type){
	orgId=id;
	$('#depTreeul').tree({
	    url:path+'/business/businessDepartment/treeData.do?type='+type+'&id='+id,
	    method: 'post',
	    animate: true,
	    onClick:function(node) {
	    	depName=node.text;
	    	loadTree(node.id)
	    },
	    onLoadSuccess:function(node,data){
	    	loadTree(-1)
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
	    onClick:function(node) {
	    	console.log(11)
	    	$("[name=positionId]").val(node.id);
	    	$("[name=posName]").val(node.text);
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

    var stu = $.post(path+'/business/businessPosition/save.do',{parentId: node.id,parentName:node.text,orgId:orgId,orgName:orgName,depId:depId,depName:depName},function(date){
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
    var t = $('#treeul');
    var node = t.tree('getSelected');
    if(null==node){
    	$.messager.alert('系统提示', '请选择组织机构!', 'warning');
    	return ;
    }

    var stu = $.post(path+'/business/businessDepartment/save.do',{orgId:orgId,orgName:orgName,orgType:0},function(date){
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
