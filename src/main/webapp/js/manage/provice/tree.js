
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning')
    }
}
$(function(){
	$('#treeul').tree({
	    url:path+'/manage/manageProvice/treeData.do',
	    method: 'post',
	    animate: true,
	    onContextMenu: function(e,node){
	        e.preventDefault();
	        $(this).tree('select',node.target);
	        $('#monitor').menu('show',{
	            left: e.pageX,
	            top: e.pageY
	        });
	    },
	    onClick:function(node) {
	        var node = $('#treeul').tree('getSelected');
	        if(node.id==0){
	        	loadTree(-1)
	        	return null;
	        }
	        orgName=node.text;
	        loadTree(node.id);
	        var stu =$.post(path+'/manage/manageProvice/selectProviceId.do',{id: node.id},function(date){
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
	    },
	    onLoadSuccess:function(node,data){
	    	loadTree(-1)
	    }
	})
})
function loadTree(id){
	$('#jobTreeul').tree({
	    url:path+'/manage/manageCity/treeData.do?id='+id,
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
	        	loadUser(-1);
	        	return null;
	        }
	        loadCounty(node.id);
	        var stu =$.post(path+'/manage/manageCity/selectCityId.do',{id: node.id},function(date){
	            if(date.status == 'ERROR'){
	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
	            }else{
	            	console.log(date)
	                //$("#ff").form('load', date);
	            	var obj = JSON.parse(date);
	            	$("#cityForm").form('load', obj);
	            }
	        })
	        stu.error(ajax_error("请求未成功"));
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
	    }
	})
}
function append(){
	
    var stu = $.post(path+'/manage/manageProvice/save.do',function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$('#treeul').tree('reload');
        }
    })
    stu.error(ajax_error("请求未成功"));


}
function append2(){
    var t = $('#treeul');
    var node = t.tree('getSelected');
    if(null==node){
    	$.messager.alert('系统提示', '请选择楼栋!', 'warning');
    	return ;
    }
    var stu = $.post(path+'/manage/manageCity/save.do',{provinceId:node.id},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$('#jobTreeul').tree('reload');
        }
    })
    stu.error(ajax_error("请求未成功"));


}

function append3(){
    var t = $('#jobTreeul');
    var node = t.tree('getSelected');
    if(null==node){
    	$.messager.alert('系统提示', '请选择城市!', 'warning');
    	return ;
    }
    var stu = $.post(path+'/manage/manageCounty/save.do',{cityId:node.id},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$('#countyTreeul').tree('reload');
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
            $.post(path+'/manage/manageProvice/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
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
            $.post(path+'/manage/manageCity/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else{
                    $('#jobTreeul').tree('remove', node.target);
                }
            })

        } else{
            return;
        }
    })
}
function removeit2(){
    var node = $('#jobTreeul').tree('getSelected');
    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/manageCity/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
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
    var node = $('#countyTreeul').tree('getSelected');
    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/manageCounty/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else{
                    $('#countyTreeul').tree('remove', node.target);
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


	function searchRenew ()  {
	    $("#ff").form('reset');
	    $("#cityForm").form('reset');
	    $("#countyForm").form('reset');
	}
	function newSave() {
		$('#ff').form('submit', {
	        url: $('#ff').attr('action'),
	        success: function (data) {
	            eval('data=' + data);
	            if (data.success) {
	            	$('#treeul').tree('reload');
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
	function cityFormSub() {
		$('#cityForm').form('submit', {
	        url: $('#unitForm').attr('action'),
	        success: function (data) {
	            eval('data=' + data);
	            if (data.success) {
	            	$('#jobTreeul').tree('reload');
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
	
function countyFormSub() {
	$('#countyForm').form('submit', {
        url: $('#unitForm').attr('action'),
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	$('#countyTreeul').tree('reload');
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

function closeWindow() {
	win.window('close');
}
function loadCounty(id){
	$('#countyTreeul').tree({
	    url:path+'/manage/manageCounty/treeData.do?id='+id,
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
	    	console.log(11,node)
	        var stu =$.post(path+'/manage/manageCounty/selectCountyId.do',{id: node.id},function(date){
	            if(date.status == 'ERROR'){
	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
	            }else{
	            	console.log(date)
	                //$("#ff").form('load', date);
	            	var obj = JSON.parse(date);
	            	$("#countyForm").form('load', obj);
	            }
	        })
	        stu.error(ajax_error("请求未成功"));
	    }
	})
}


