function treeOnclick(node) {
    var attributs = node.attributes;
    var type = jQuery.type(attributs);
    
    if (type == 'undefined') {
        return;
    }
   
    var url = attributs.authorityUrl;
    var url = $.trim(url)
    if (url.length == 0 || /^[#/]+$/.test(url)) {
        return;
    }
    var title = node.text;
    if ($('#tt').tabs('exists', title)) {
        $('#tt').tabs('select', title);
    } else {
        var tab = $('#tt').tabs('add', {
            title: title,
            closable: true,
            cache: false,
            content: '<iframe scrolling="yes" frameborder="0"  src="' + url + '?d=' + new Date().getTime() + '" style="width:100%;height:100%;"></iframe>'
        });
    }
}

//跨frame启动标签页
//args{title:string, url:string}
function treeOnFrame(args) {

    if ($('#tt').tabs('exists', args.title)) {
        $('#tt').tabs('select', args.title);
    } else {
        var url = args.url;
        console.log(url);
        if (/\?/.test(url) == true) {
            url += '&d=' + new Date().getTime();
        }
        else {
            url += '?d=' + new Date().getTime();
        }
        var tab = $('#tt').tabs('add', {
            title: args.title,
            closable: true,
            cache: false,
            content: '<iframe scrolling="yes" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>'
        });
    }
}

// 跨页面调用其他tab方法
// args{title:string, func:string, args: object}
function remoteCall(args) {
    if ($('#tt').tabs('exists', args.title)) {
        var tab = $('#tt').tabs('getTab', args.title)
        return $(tab.panel('options').content)[0];
    }
}

//为子页面提alert接口
function showMessage(msg) {
    $.messager.alert('提示信息', msg)
}

// 启动时显示默认页面
$(function () {
    //treeOnclick({attributes: {authorityUrl: '/admin/settings/frame/welcome.html'}, text: '欢迎'});
   // $("#log").click(function(){
   //     window.location.href="/admin/settings/site/log.html"
   // })
	//$('#aa').accordion('select','Title1');
});
var json;
//$.getJSON('/scripts/admin/settings/frame/info.json', function (data) {
//    data.callback=function(data){
//        console.log(data)
//    }
//    json = data
//
//})
var callback;// 保存时回调函数
var win; //window  窗口
var key; //返回值键值对
function add(json) {
    console.log(json)
    callback=json.callback
    key=json.data
    var o1, o2, o3;
    /**/o1 = {
        width: 600,
        height: 400,
        title: "属性编辑窗口",
        closed: true,
        modal: true,
        shadow: false
    }
    o2 = json.window;
    o3 = {
        href: '/admin/settings/page/modify1.html',
        onLoad: function () {

            if(json.tabs.length==1){
                $("#base").append(type(json.tabs[0].info.type,json.tabs[0],key))
            }else{
                var p = $('#property').window("panel");
                var divb = p.find('#base')
                //$(divb).attr("class","easyui-tabs")
                $(divb).tabs()
                for(var i= 0;i< json.tabs.length;i++){
                    $(divb).tabs('add', {
                        title:json.tabs[i].info.title ,
                        closable: false,
                        cache: false,
                        content:type(json.tabs[i].info.type,json.tabs[i],key)
                    });
                }
            }

        }
    }
    win = $('#property')
    win.window($.extend(o1, o2, o3))
    win.window('open');
    win.window('resize');
}
//判断是那种方式的加载
function type(type,data,upData){
    console.log("aa",data)
    console.log("type",upData)
    var str;
    switch (type){
        case 'info' :str= info(data,upData);break;
        case 'html' :str= html(data,upData);break;
        default :str=$("<p>类型未定义</p>")
    }
    return str;
}


function info(obj,upData){
    console.log("info",upData)
    var data=obj.fields;
    var div=$("<div style='height:290px;overflow: hidden;'>  </div>")
    var table=$("<table></table>")
    div.append(table)
    for(var i=0;i<data.length;i++){
        table.append(types(data[i].type,data[i],upData));
    }
    return div;
}
function html(data,upData){
    var div=$("<div style='height:290px;overflow: hidden;'></div>")
    var ife=$("<iframe src="+data.info.url+" width='100%' height='100%'></iframe>")
    var hid=$("<input type='hidden' name="+data.info.key+">")
    div.append(ife);
    try{
        hid.val(JSON.stringify(upData[data.info.key]))
    } catch(e){
        hid.val(upData[data.info.key])
    }

    $("body").append(hid)

    return div;
}



function saveData(){
    console.log(key)
    for(i in key){
        console.log($("[name="+i+"]").val())
        try{
            key[i]=JSON.parse($("[name="+i+"]").val())
        } catch(e){
            key[i]=$("[name="+i+"]").val()
        }

    }
    callback(key)
    win.window('close');
}
function closeWindow(){
    win.window('close');
}


