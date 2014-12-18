/**
 * Created with JetBrains WebStorm.
 * User: s
 * Date: 13-12-23
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
var win;
var grid;
$(function() {
    grid = $('#grid').datagrid({
        title: '用户管理',
        iconCls: 'icon-save',
        url: path+'/log/userListData.do',
        queryParams:{
        	name:function(){
        		console.log($("#SearchName").val());
        		return $("#SearchName").val();
        	}
        },
        fit: true,
        resize: true,
        sortOrder: 'userid',
        method: 'post',
        idField: 'userid',
        singleSelect:true,
        onClickCell:ClickCell,
        frozenColumns: [[
            { field: 'userid', checkbox: true }
        ]],
        columns: [[
            //{ field: 'caption', title: '标题', width: 200, align:'center' },
            { field: 'username', title: '组件名称', width: 150, align:'center' },
            //{ field: 'type', title: '组件类型', width: 130, align:'center' },
            //{ field: 'descript', title: '组件描述', width: 200, align:'center' },
            //{ field: 'state', title: '组件状态', width: 120, align:'center' },
            //  { field: 'edition', title: '组件版本', width: 100, align:'center' },
            //  { field: 'producer', title: '组件生产商', width: 100, align:'center' },
            //  { field: 'digitautograph', title: '数字签名', width: 100, align:'center' },
            // { field: 'email', title: '联系邮箱', width: 100, align:'center' },
            //{ field: 'f0', title: '操作', width: 110, align:'center',formatter:f0_formatter },
            //{ field: 'f1', title: '预览', width: 110, align:'center',formatter:f1_formatter }
        ]],
        pagination: true,
        pageNumber: 1,
        pageSize: 15,
        pageList: [10,15,20,30,50],
        nowrap:false,
        striped: true,
        loadMsg:'数据装载中......',
        rownumbers: true,
        toolbar: [{
            text: '增加',
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
         },/* '-', {
         text: '所有',
         iconCls: 'icon-search',
         handler: showAll
         }, '-', {
         text: '预览',
         iconCls: 'icon-search',
         handler: preview
         }*/]
    });



    $('#btn-search, #btn-search-cancel').linkbutton();
    $('body').layout();
});
function f0_formatter(a,row,b){
    if(row.state=="1") {
        return "<button onclick='javascript:void(0); ' type='button'>卸载</button>";
    } {
        return "<button onclick='javascript:void(0); ' type='button'>启动</button>";
    }

}
function f1_formatter(a,row,b){
    return "<button onclick='javascript:void(0); ' type='button'>预览</button>";
}

function ClickCell (rowIndex, field){
    switch (field){
        case 'f0':
            var rows=$('#grid').datagrid("getRows");
            var state=rows[rowIndex].state;
            var component_id=rows[rowIndex].component_id
            if(state=="1"){
                state=0
            }else{
                state=1
            }
            $.ajax({
                type: "POST",
                url: "/admin/settings/component/updatestatus",
                data: {state:state,component_id:component_id},
                success: function(data){
                    if(data==1){
                        grid.datagrid('reload');
                        grid.datagrid('clearSelections');
                        $.messager.alert('成功', "操作成功！", 'warning')

                    }else{
                        $.messager.alert('失败', "操作失败！", 'warning')
                    }
                },
                error:function(error){
                    $.messager.alert('失败', error, 'warning')

                }
            });
            break;
        case 'f1' :
            var rows=$('#grid').datagrid("getRows");
            var id=rows[rowIndex].component_id
            var title=rows[rowIndex].name+"|预览"
            var url="/admin/settings/component/selectpro?id="+id+"&flag=1"
            var obj ={
                title:title,
                url:url
            }
            window.parent.treeOnFrame(obj)
            break;
    }
}
function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids.push(rows[i].userid);
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
function register(){
	win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        href: path+'/log/addHtml.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}
function getRegister(){
    var url=$("#registerUrl").val()
    $.ajax({
        type: "post",
        url: url,
        data:{id:"1"} ,
        success: function(data){
            if(data==null || data==""){
                $.messager.alert('失败', "没有返回数据，数据为空！", 'warning')
            }else{
                try{
                    var obj=JSON.parse(data)
                    var json=JSON.stringify(obj)
                    $("#register").attr("data-register-data",json)
                    closeWindow()
                    add()
                }catch(e){
                    $.messager.alert('失败', e.message+" 数据解析有误，数据格式错误", 'warning')

                }
            }
        },
        error:function(error){
            $.messager.alert('失败', "地址不存在，地址错误！", 'warning')
        }
    });
}
function add() {
    win = $('#add-window').window({
        closed: true,
        modal: true,
        shadow: false,
        href: path+'/log/addHtml.do'
    });
    $('#add-window').window('open');
    $('#add-window').window('resize');
}

function timing(form,url){
    $(form).form('clear');
    $(form).form('load',url);
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
    	var id=rows[0].userid
        win = $('#edit-window').window({
            closed: true,
            modal: true,
            shadow: false,
            href: path+'/log/selectId.do?userid='+id       // +rows[0].id   修改主题的id
        });
       
        $('#edit-window').window('open');
    }
}
function preview() {
    var rows = grid.datagrid('getSelections');
    var num = rows.length;
    if (num == 0) {
        $.messager.alert('提示', '请选择一条记录进行操作!', 'info');
        return;
    } else if (num > 1) {
        $.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行预览!', 'info');
        return;
    }
    else{
        var id=rows[0].component_id
        var title=rows[0].name+"|预览"
        var url="/admin/settings/component/selectpro?id="+id+"&flag=1"
        var obj ={
            title:title,
            url:url
        }
        window.parent.treeOnFrame(obj)
    }
}

function del() {
    var arr = getSelectedArr();
    str=arr2str(arr)
    if (arr.length>0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: path+'/log/deleteId.do?id='+str,
                    //data:{"id":str},
                    success: function (data) {
                    	if (data=="1") {
                    		grid.datagrid('reload');
                            grid.datagrid('clearSelections');
                            $.messager.alert('成功', "操作成功","warning");
                        } else {
                            $.messager.alert('错误', "操作失败", 'error');
                        }
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
    $('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        success: function (data) {
            //eval('data=' + data);
            //if (data.success) {
            if (data) {
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
            //eval('data=' + data);
            //if (data.success) {
            if (data) {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
            } else {
                $.messager.alert('错误', data.msg, 'error');
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
    $('#search-window').window('close');
    $('#searchForm').form('submit', {
        url: $('#searchForm').attr('action'),
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                grid.datagrid('reload');
                win.window('close');
                $('#searchForm').form('clear');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }

        }
    });
}
function saveData2(oper, formId) {
    $('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        success: function (data) {
            //eval('data=' + data);
            //if (data.success) {
            if (data=="1") {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
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
function saveData3(oper, formId) {
    $('#'+formId).form('submit', {
        url: $('#'+formId).attr('action'),
        success: function (data) {
            //eval('data=' + data);
            //if (data.success) {
            if (data) {
                grid.datagrid('reload');
                win.window('close');
                $('#'+formId).form('clear');
                //$("#preview").attr("data-area",data)
                //open("preview")
                /*open("preview")
                 setTimeout("fun1("+data+")","100");*/

            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
function open(id) {
    win = $("#"+id).window({

        closed: true,
        modal: true,
        shadow: false,
        href: id+".html"
    });
    $("#"+id).window('open');
    $("#"+id).window('resize');
}
function  getProperty(id){
    $.ajax({
        type: "get",
        url: "/admin/settings/component/selectprop",
        data: { id:id  },
        success: function (data) {
            html=""
            for (var i=0;i<data.length ;i++ ){
                flag=$("#flag").val()
                if(flag==""){
                    flag=1
                }else{
                    flag=parseInt(flag) +1
                }
                $("#flag").val(flag)
                html+= '<tr><td>属性名称'+flag+'：</td><td><input type="text" name="property_name'+flag+'" value="'+data[i].name+'"/><input type="hidden" name="property_id'+flag+'" value="'+data[i].comp_property_id+'"/></td></tr>'
                if(data[i].value_type=="text"){
                    html+='<tr><td>属性类型'+flag+'：</td><td><select name="value_type'+flag+'"><option value="text" selected>输入框</option><option value="select">下拉菜单</option></select></select></td></tr>'
                }else{
                    html+='<tr><td>属性类型'+flag+'：</td><td><select name="value_type'+flag+'"><option value="text">输入框</option><option value="select" selected>下拉菜单</option></select></select></td></tr>'
                }
                html+='<tr><td>可选键值对'+flag+'：</td><td><input type="text" name="value_list'+flag+'" value=\''+data[i].value_list+'\'/><span>[{option："中国",：value："china"},{option："城市",：value："city"}]</span></td></tr>'
                html+='<tr><td>默认值'+flag+'：</td><td><input type="text" name="value_def'+flag+'" value="'+data[i].value_def+'"/></td></tr>'
            }
            $("#flag").before(html)
        }
    });
}
function setProperty(id){
    $("#setproperty").attr("data-comp_area_id",id)
    open("set-property")
}

function closeSearchWindow() {
    $('#search-window').window('close');
}
function addProperty(){
    flag=$("#flag").val()
    if(flag==""){
        flag=1
    }else{
        flag=parseInt(flag) +1
    }
    $("#flag").val(flag)
    $("#flag").before('<tr><td>属性名称'+flag+'：</td><td><input type="text" name="property_name'+flag+'"/><input type="hidden" name="property_id'+flag+'" value="0"/></td></tr><tr><td>属性类型'+flag+'：</td><td><select name="value_type'+flag+'"><option value="text">输入框</option><option value="select">下拉菜单</option></select></select></td></tr><tr><td>可选键值对'+flag+'：</td><td><input type="text" name="value_list'+flag+'"/><span>[{option："中国",：value："china"},{option："城市",：value："city"}]</span></td></tr><tr><td>默认值'+flag+'：</td><td><input type="text" name="value_def'+flag+'"/></td></tr>')
}
function delProperty(){
    flag=$("#flag").val()
    if(flag==""||flag==0){
        $.messager.alert('错误',"没有可删除属性", 'error');

    }else{
        $("#flag").prev('tr').remove()
        $("#flag").prev('tr').remove()
        $("#flag").prev('tr').remove()
        $("#flag").prev('tr').remove()
        flag=parseInt(flag) - 1
        $("#flag").val(flag)
    }

}

function Search(){
	grid.datagrid('reload');
	win.window('close');
}
