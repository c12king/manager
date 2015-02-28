
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning');
    };
};
var win;
var grid;
$(function(){
	initTree();
});

function initTree()
{
	$('#shopTreeul').tree({
		url:path+'/manage/businessShopType/treeData.do',
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
	        var node = $('#shopTreeul').tree('getSelected');
	        if(node.id==0){
	        	return null;
	        }
	        loadExpFee(node.id); 
	    },
	    onLoadSuccess:function(node,data){
	    	//loadExpFee(-1)
	    }
	});
}

var orgId;//被选中的组织机构id
var orgName;//被选中的组织机构名称

function append2(){
	
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/businessShopType/add.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
    
}

function removeit2(){
    var node = $('#shopTreeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }

    var rows = $('#grid').datagrid('getRows').length;
    if (rows != 0)
    {
    	alert("该快递公司下有资费信息,无法删除!");
    	return null;
    }
    
    $.messager.confirm('系统提示', '确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/businessShopType/delete.do',{id : node.id},function(date){
                if(date.status == 'ERROR'){
                    $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
                }else{
                    $('#shopTreeul').tree('remove', node.target);
                }
            });
        } else{
            return;
        }
    });
}


function collapse2(){
    var node = $('#shopTreeul').tree('getSelected');
    $('#shopTreeul').tree('collapse',node.target);
}
function expand2(){
    var node = $('#shopTreeul').tree('getSelected');
    $('#shopTreeul').tree('expand',node.target);
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

//	function newNode(){
//		var stu = $.post(path+'/menu/addMenu.do',{parentId: 0},function(date){
//	        if(date.status == 'ERROR'){
//	            $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
//	        }else{
//	            
//
//	                    $('#treeul').tree({
//	                        url: path+'/menu/treeData.do',
//	                        method: 'post'
//
//	                    })
//	            
//	        }
//	    })
//	    stu.error(ajax_error("请求未成功"));
//	}

	function searchRenew ()  {
	    $("#mm").form('reset');
	}

	function unitFormSub() {
		$('#unitForm').form('submit', {
	        url: $('#unitForm').attr('action'),
	        success: function (data) {
	            eval('data=' + data);
	            if (data.success) {
	            	$('#shopTreeul').tree('reload');
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
//function edit1 (){
//	var node = $('#treeul').tree('getSelected');
//	if(node.id==0){
//    	return null;
//    }
//	win = $('#edit-window').window({
//        closed: true,
//        modal: true,
//        shadow: false,
//        cache: false,
//        href: path+'/manage/manageOrg/modify.do?id='+node.id
//    });
//	$('#edit-window').window('open');
//
//}
function edit2 (){
	var node = $('#shopTreeul').tree('getSelected');
	if(node.id==0){
    	return null;
    }
	win = $('#edit-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/businessShopType/modify.do?typeId='+node.id
    });
	$('#edit-window').window('open');

}

function saveData2(oper, formId) {
	if(oper=="add"){
	var node = $('#shopTreeul').tree('getSelected');
	$("#expressId").val(node.id);
}
	
	$('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        onSubmit:function(){  
    		return $(this).form('validate');  
	 	},
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
            	$.messager.alert('成功', "操作成功","warning");
            	var node = $('#shopTreeul').tree('getSelected');
            	var name=$("[name=positionName]").val();
            	$('#shopTreeul').tree('update', {
            		target: node.target,
            		text: name
            	});
                win.window('close');
                initTree();
                //TODO  reload
//                var node = $('#treeul').tree('getSelected');
//                if (node.id ==0 )
//                	return ;
//                loadTree(node.id);  
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function closeWindow() {
	win.window('close');
}
function loadExpFee(id){
	grid = $('#grid').datagrid({
        title: '商铺管理',
        iconCls: 'icon-save',
        url: path+'/manage/businessShop/list.do',   
        fit: true,
        fitColumns: true,
        queryParams:{
        	shopName:function(){
        		return $("#name").val();
        	},
        	typeId:function(){
        		var node = $('#shopTreeul').tree('getSelected');
         	    if(null==node){
         	    	return id;
         	    }
         		return node.id;
        	}
        },
		resize: true,
        sortOrder: 'shopId',
        idField: 'shopId',
        frozenColumns: [[
                         { field: 'shopId', checkbox: true }
        		]],
        columns: [[
 		          { field: 'shopName', title: '商铺名称', width: 150, align:'center' },
		          { field: 'typeId', title: '商铺类型', width: 150, align:'center' },
		          { field: 'shopCode', title: '商铺编码', width: 150, align:'center' },
		          { field: 'shopKey', title: '商铺秘钥', width: 150, align:'center' },
		          { field: 'shopAddr', title: '商铺地址', width: 150, align:'center' },
		          { field: 'shopDesc', title: '商铺描述', width: 150, align:'center' },
		          { field: 'shopImg', title: '图片路径', width: 150, align:'center' },
		          { field: 'shopUrl', title: '商铺连接地址', width: 150, align:'center' },
		          { field: 'editor', title: '编辑人', width: 150, align:'center' },
		          { field: 'creatTime', title: '创建时间', width: 150, align:'center' },
		          { field: 'editTime', title: '编辑时间', width: 150, align:'center' },
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
//				alert(pageNumber); 
				var queryParams = {
						pageNo: pageNumber, pageSize: pageSize ,
//						page: pageNumber, rows: pageSize ,
						expressId:function(){ 
			        		var node = $('#shopTreeul').tree('getSelected');
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
         ids.push(rows[i].shopId); 
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
	
	var node = $('#shopTreeul').tree('getSelected');
	
	if (node == null || node.id == 0)
	{
		alert("请选择商铺类型！");
		return 0;
	}
	$("#typeId").val(node.id);
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        cache: false,
        href: path+'/manage/businessShop/add.do?typeId='+node.id
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
            href: path+'/manage/businessShop/modify.do?shopId='+rows[0].shopId
        });
    	$('#edit-window').window('open');
        $('#modifyForm').form('clear');
        $('#modifyForm').form('load', '<%=path %>/manage/businessShop/edit.do?shopId=' + rows[0].shopId); 
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
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: path+'/manage/businessShop/delete.do?id=' + arr2str(arr), 
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
		var node = $('#shopTreeul').tree('getSelected');
		$("#expressId").val(node.id);
		//str=path+"/manage/buseinessTel/save.do";
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
                initTree(); 
                //loadTree(-1);
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}

function saveData3(oper, formId) {
	var str=$('#'+formId).attr('action');
	if(oper=="add"){
		var node = $('#shopTreeul').tree('getSelected');
		$("#typeId").val(node.id);
		//str=path+"/manage/buseinessTel/save.do";
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
                //initTree(); 
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
//init= function(uuid) {
//    // this.identifier 是设定的全局变量，uuid是页面加载时的唯一编码  
//    this.identifier = uuid;  
//    // 图片上传  
//    var idf = this.identifier;  
//    var that = this;  
//    $('#'+idf+'-tforma').form({  
//        dataType : 'json',  
//    beforeSubmit : function(a, f, o) {  
//      $('#'+idf+'-statusPic').html('上传中...');  
//    },  
//        success : function(data) {    
//     if (typeof (data) == 'string')  
//       data = eval('(' + data + ')');  
//     $('#'+idf+'-uploadWindow').window('close');  
//     if ("success" == data.message) {  
//         $('div[identifier='+that.identifier+']').find('#picPath').val(data.path);  
//         $("#"+idf+"-path").val(data.path);  
//         $("#"+idf).val(data.path.replace( "\\", "/"))
//         $("#"+idf+"-statusPic").html( "<a target='window' href='javascript:void(0);' onclick='Preview(\""+idf+"\")'>预览</a>");  
//     } else if ("error" == data.message)  
//         $("#"+idf+"-statusPic").html("非图片数据!");  
//     else  
//         $("#"+idf+"-statusPic").html("上传数据错误!");  
//          $("#"+idf+"-itemPic").val('');  
//     },  
//     error : function(jqXHR, textStatus,errorThrown) {  
//         $('#$'+idf+'-uploadWindow').window('close');  
//         //console.log("error:"+ data.responseText);  
//         //console.log("status:" + textStatus);  
//         $("#"+idf+"-statusPic").html("上传失败!");  
//         $("#"+idf+"-itemPic").val('');  
//     } });  
//    }  
//function Preview(id){
//	var url =$("#"+id).val()
//	if(url==""){
//		return ;
//	}
//    var title="图片预览";
//    var obj ={
//        title:title,
//        url:url
//    }
//    window.parent.treeOnFrame(obj);
//}


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
         $("#"+idf).val(data.path.replace( "\\", "/"));
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
    };
function Preview(id){
	var url =$("#"+id).val();
	if(url==""){
		return ;
	}
    var title="图片预览";
    var obj ={
        title:title,
        url:url
    };
    window.parent.treeOnFrame(obj);
}