
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning');
    };
};
$(function(){
	$('#treeul').tree({
	    url:path+'/manage/manageEstate/treeData.do?id='+estateId,
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
	        //alert(node.id);  
	        if(node.id==0){
	        	loadTree(-1);
	        	return null;
	        }
	        orgName=node.text;
	        loadTree(node.id);
//	        var stu =$.post(path+'/manage/businessTelGroup/treeData.do',{id: node.id},function(date){
//	            if(date.status == 'ERROR'){
//	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
//	            }else{
//	            	console.log(date);
//	            	var obj = JSON.parse(date);
//	            	$("#ff").form('load', obj);
//	            }
//	        })
//	        stu.error(ajax_error("请求未成功") );
	    },
	    onLoadSuccess:function(node,data){
	    	loadTree(-1);
	    }
	})
	init("unitImage");
	init("buildingImage");
})
var orgId;//被选中的组织机构id
var orgName;//被选中的组织机构名称
function loadTree(id){
	orgId=id;
	$('#jobTreeul').tree({
	    url:path+'/manage/businessTelGroup/treeData.do?id='+id,   
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
//	    	alert(node.id); 
	        var node = $('#jobTreeul').tree('getSelected');
	        if(node.id==0){
	        	//loadUser(-1);
	        	return null;
	        }
//	        alert(node.id);
//	        alert(node.value);
	        loadUser(node.id); 
//	        var stu =$.post(path+'/manage/manageUnit/selectUnitId.do',{id: node.id},function(date){
//	            if(date.status == 'ERROR'){
//	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
//	            }else{
//	            	console.log(date);
//	                //$("#ff").form('load', date);
//	            	var obj = JSON.parse(date);
//	            	$("#unitForm").form('load', obj);
//	            }
//	        })
//	        stu.error(ajax_error("请求未成功"));
	        
	        
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
	    	//loadUser(-1)
	    }
	})
}
function append(){
	
    var stu = $.post(path+'/manage/manageBuilding/save.do',{estateId: estateId},function(date){
        if(date.status == 'ERROR'){
            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
        }else{
        	$('#treeul').tree('reload');
                    /*$('#treeul').tree({
                        url: path+'/menu/treeData.do',
                        method: 'post'

                    })*/
            

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
	
//    var stu = $.post(path+'/manage/businessTelGroup/add.do',{estateId:node.id},function(date){
//        if(date.status == 'ERROR'){
//            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
//        }else{
//        	$('#jobTreeul').tree('reload');
//        }
//    })
//    stu.error(ajax_error("请求未成功"));
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/businessTelGroup/add.do?estateId='+node.id
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');

}
function removeit(){
    var node = $('#treeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }

    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/manageBuilding/delete.do',{id: node.id},function(date){
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

    var rows = $('#grid').datagrid('getRows').length;
    if (rows != 0)
    {
    	alert("该分组下有电话号码,无法删除!");
    	return null;
    }
    
    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/businessTelGroup/delete.do',{id: node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else{
                    $('#jobTreeul').tree('remove', node.target);
                }
            });
        } else{
            return;
        }
    });
}
function collapse(){
    var node = $('#treeul').tree('getSelected');
    $('#treeul').tree('collapse',node.target);
}
function expand(){
    var node = $('#treeul').tree('getSelected');
    $('#treeul').tree('expand',node.target);
}

function collapse2(){
    var node = $('#jobTreeul').tree('getSelected');
    $('#jobTreeul').tree('collapse',node.target);
}
function expand2(){
    var node = $('#jobTreeul').tree('getSelected');
    $('#jobTreeul').tree('expand',node.target);
}


$.messager.defaults.ok='确定';
	var ajax_error = function (msg) {
	    return function () {
	        $.messager.alert('系统提示', msg, 'warning');
	    };
	};

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
	function unitFormSub() {
		$('#unitForm').form('submit', {
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
        href: path+'/manage/businessTelGroup/modify.do?groupId='+node.id
    });
	$('#edit-window').window('open');

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
                //TODO  reload
                var node = $('#treeul').tree('getSelected');
                if (node.id ==0 )
                	return ;
                loadTree(node.id);  
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function closeWindow() {
	win.window('close');
}
function loadUser(id){
	grid = $('#grid').datagrid({
        title: '小区电话管理',
        iconCls: 'icon-save',
        url: path+'/manage/buseinessTel/list.do',   
        fit: true,
        fitColumns: true,
        queryParams:{
        	name:function(){
        		return $("#name").val();
        	},
        	id:function(){
        		var node = $('#jobTreeul').tree('getSelected');
         	    if(null==node){
         	    	return id;
         	    }
         		return node.id;
        	}
        },
		resize: true,
        sortOrder: 'telId',
        idField: 'telId',
//        pageSize:30,
        frozenColumns: [[
                         { field: 'telId', checkbox: true }
        		]],
        columns: [[
//                   	  { field: 'tel', title: 'TelId', width: 150, align:'center' },
    		          { field: 'telName', title: '服务名称', width: 150, align:'center' },
    		          { field: 'tel', title: '服务电话', width: 150, align:'center' },
                ]],
        pagination: true,
//        pageNumber: 1,
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
				var queryParams = {pageNo: pageNumber, pageSize: pageSize ,
//				var queryParams = {page: pageNumber, rows: pageSize//,
			        	id:function(){
			        		var node = $('#jobTreeul').tree('getSelected');
			         	    if(null==node){
			         	    	return id;
			         	    }
			         		return node.id;
			        	}
				};
				
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
         ids.push(rows[i].telId);
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
        href: path+'/manage/buseinessTel/add.do?'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}

function edit() {
	
    var currPageRows = grid.datagrid('getRows').length;
    if (currPageRows == 0)
    {
    	alert("请选择一条记录进行操作!");
    	return null;
    }
	
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
//    	alert(rows[0].telId);
    	win = $('#edit-window').window({
            closed: true,
            modal: true,
            shadow: false,
            cache: false,
            href: path+'/manage/buseinessTel/modify.do?telId='+rows[0].telId
        });
    	$('#edit-window').window('open');
        $('#modifyForm').form('clear');
        $('#modifyForm').form('load', '<%=path %>/manage/buseinessTel/edit.do?telId=' + rows[0].telId);
    }
}

function del() {
    var currPageRows = grid.datagrid('getRows').length;
//  alert(currPageRows);
  if (currPageRows == 0)
  {
  	alert("请选择一条记录进行操作!");
  	return null;
  }
  
    var arr = getSelectedArr();
//    alert(arr);
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: path+'/manage/buseinessTel/delete.do?id=' + arr2str(arr),
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
	var str=$('#'+formId).attr('action');
	if(oper=="add"){
		var node = $('#jobTreeul').tree('getSelected');
		$("#groupId").val(node.id);
		str=path+"/manage/buseinessTel/save.do";
	}
	$('#'+formId).form('submit', {
        url: str,
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
                //loadTree(-1);
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
    var title="图片预览";
    var obj ={
        title:title,
        url:url
    }
    window.parent.treeOnFrame(obj);
}