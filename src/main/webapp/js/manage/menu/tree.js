
var ajax_error = function (msg) {
    return function () {
        $.messager.alert('系统提示', msg, 'warning')
    }
}
$(function(){
	$('#treeul').tree({
	    url:path+'/manage/businessMenu/treeData.do',
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
	        	return null;
	        }
	        var stu =$.post(path+'/manage/businessMenu/selectMenuId.do',{menuId: node.id},function(date){
	            if(date.status == 'ERROR'){
	                $.messager.alert('系统提示', '未成功请联系管理员!', 'warning');
	            }else{
	                //$("#ff").form('load', date);
	            	var obj = JSON.parse(date);
	            	$("#ff").form('load', obj);
	            }
	        })
	        stu.error(ajax_error("请求未成功"));

	    }
	})
	init("logImage");
	init("unSelectedIconImage");
})


function append(){
    var t = $('#treeul');
    var node = t.tree('getSelected');

    var stu = $.post(path+'/manage/businessMenu/addMenu.do',{parentId: node.id},function(date){
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
function removeit(){
    var node = $('#treeul').tree('getSelected');
    if(node.id==0){
    	return null;
    }
    $.messager.confirm('系统提示', '栏目确定要删除？', function (r) {
        if (r) {
            $.post(path+'/manage/businessMenu/deleteMenu.do',{menuId: node.id},function(date){
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
		var stu = $.post(path+'/manage/businessMenu/addMenu.do',{parentId: 0},function(date){
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
	        	var node = $('#treeul').tree('getSelected');
	        	var name=$("[name=name]").val();
	            if (data=="1") {
	            	$('#treeul').tree('update', {
	            		target: node.target,
	            		text: name
	            	});
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
	//搜索按钮
	function searchFn() {


	    $('#m').window('open').panel('setTitle', "搜索栏目");
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
