/**
 * Created with JetBrains WebStorm.
 * User: s
 * Date: 14-1-23
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
var reUser=/^[a-zA-Z_]\w{1,10}$/;
var reUserUserMessage="该输入项只能是数字、字母和下划线，并不能以数字开头，至少1位，最多10位"

var reUserCon=/^[a-zA-Z_]\w{1,30}$/;
var reUserConUserMessage="该输入项只能是数字、字母和下划线，并不能以数字开头，至少1位，最多30位"

var reName=/^[a-zA-Z0-9_\u4e00-\u9fa5]{1,64}$/;
var reNameMessage="该输入项只能是数字、字母，下划线和汉字,最多64位"

var rePath=/^([a-zA-Z0-9_.#]+)+$/;
var rePathMessage="该输入项只能是数字、字母和指定符号"

var reColor=/^[#[a-fA-F0-9_.#]+]{7}$/;
var reColorMessage="该输入项只能是数字、字母和指定符号（/,.,#），并以斜线开头"

var rePort=/^([1-9][0-9]{3}|[1-5][0-9]{4})$/;
var rePortUserMessage="该使用有效的端口号"

var reSz=/^[0-9.]{0,11}$/;
var reSzMessage="请使用有效数字"

var rePas=/^\w{6,16}$/;
var rePasUserMessage="该输入项只能是数字、字母和下划线，至少6位，最多16位"

var reIdCard=/^[0-9]{17}[0-9x]$/;
var reIdCardMessage="请输入合法身份证号";

var reKey=/^[a-zA-Z0-9_\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5,]{0,50}$/;
var reKeyMessage="该输入项只能是数字、字母、下划线和汉字组成，最多50位"

var reUrl=/^\/[\w\/=.&?]{0,127}$/;
var reUrlMessage="该输入项只能‘/’开头，由数字、字母、下划线、‘/’、‘.’、‘&’、‘=’、‘?’组成，最多128位"

var reDes=/^[\w\u4e00-\u9fa5]{1,200}$/;
var reDesMessage="该输入项只能由数字、字母、下划线和汉字组成，最多200位"

var reTel=/^[0-9-]{1,11}$/;
var reTelMessage="该输入项只能由数字和'-'组成，最多11位"

var reEmail=/^\w+@\w+\.(com|cn|com\.cn$)/;
var reEmailMessage="请输入正确邮箱"

	

$.extend($.fn.validatebox.defaults.rules, {
    reUser: {
        validator: function(value, param){
            return reUser.test(value)
        },
        message: reUserUserMessage
    },
    reName: {
        validator: function(value, param){
            return reName.test(value)
        },
        message: reNameMessage
    },
    rePassword: {
        validator: function(value, param){
        	if(value==$(param[0]).val()){
	    		return true;
	    	}
	    	return false;
        },
        message: "俩次密码不相同"
    },
    rePas: {
        validator: function(value, param){
        	console.log(1111)
            return reName.test(value)
        },
        message: reNameMessage
    },
    rePath: {
        validator: function(value, param){
            return rePath.test(value)
        },
        message: rePathMessage
    },
    rePort: {
        validator: function(value, param){
            return rePort.test(value)
        },
        message: rePortUserMessage
    },
    reSz: {
        validator: function(value, param){
            return reSz.test(value)
        },
        message: reSzMessage
    },
    rePas: {
        validator: function(value, param){
            return rePas.test(value)
        },
        message: rePasUserMessage
    },reKey: {
        validator: function(value, param){
            return reKey.test(value)
        },
        message: reKeyMessage
    },reUrl: {
        validator: function(value, param){
            return reUrl.test(value)
        },
        message: reUrlMessage
    } ,reDes: {
        validator: function(value, param){
            return reDes.test(value)
        },
        message: reDesMessage
    },reTel: {
        validator: function(value, param){
            return reTel.test(value)
        },
        message: reTelMessage
    },reEmail: {
        validator: function(value, param){
            return reEmail.test(value)
        },
        message: reEmailMessage
    },maxLength: {    
        validator: function(value, param){  
        	console.log("sss",param)
            return value.length <= param[0];    
        },    
        message: '该选项长度不能超过{0}'
        	
    },reIdCard: {    
        validator: function(value, param){  
        	console.log(1)
        	return reIdCard.test(value)
        },    
        message: reIdCardMessage
        	
    }  
});