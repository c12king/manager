
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
	        var stu =$.post(path+'/menu/selectMenuId.do',{menuId: node.id},function(date){
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
})


function append(){
    var t = $('#treeul');
    var node = t.tree('getSelected');

    var stu = $.post(path+'/menu/addMenu.do',{parentId: node.id},function(date){
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
            $.post(path+'/menu/deleteMenu.do',{menuId: node.id},function(date){
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