<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>北青社区平台数据后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<style type="text/css">
        .easyui-accordion ul
        {
            list-style-type: none;
            margin: 0px;
            padding: 10px;
        }
        .easyui-accordion ul li
        {
            padding: 0px;
        }
        .easyui-accordion ul li a
        {
            line-height: 24px;
        }
        .easyui-accordion ul li div
        {
            margin: 2px 0px;
            padding-left: 10px;
            padding-top: 2px;
        }
        .easyui-accordion ul li div.hover
        {
            border: 1px dashed #99BBE8;
            background: #E0ECFF;
            cursor: pointer;
        }
        .easyui-accordion ul li div.hover a
        {
            color: #416AA3;
        }
        .easyui-accordion ul li div.selected
        {
            border: 1px solid #99BBE8;
            background: #E0ECFF;
            cursor: default;
        }
        .easyui-accordion ul li div.selected a
        {
            color: #416AA3;
            font-weight: bold;
        }
    </style>
  </head>
  <script type="text/javascript">
  
	function aClick(tabTitle, url) {
		addTab(tabTitle, url);
	}
	
	function treeOnFrame(obj){
		addTab(obj.title,obj.url);
	}
	
	function addTab(subTitle, url) {
		if(!$('#tabs').tabs('exists', subTitle)) {
			$('#tabs').tabs('add', {
				title: subTitle,
				content: createFrame(url),
				closable: true,
				width: $('#mainPanel').width - 10,
				height: $('#mainPanel').height - 26
			});
		}else{
			$('#tabs').tabs('select', subTitle);
		}
	}
	
	function createFrame(url) {
		var s = '<iframe id="mainFrame" name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
		return s;
	}
	
	function logout() {
		window.location.href="<%=basePath %>/health/healthAdmin/logout.do";
	}

</script>
	<body class="easyui-layout">
	
		<div data-options='region:"north",border:true,split:true,title:"北青社区平台数据后台管理系统"' style='height: 60px; padding: 5px;'>
			<div style='text-align: left; padding-left: 10px;'>
				<span style='font-family: 应用字体; font-size: 14px; font-weight: normal; font-style: normal; text-decoration: none; color: #333333;'>
					欢迎您登录&nbsp;&nbsp;
					<a href="<%=path%>/index/logout.do">注销</a>
				</span>
			</div>
		</div>
		
		<div data-options='region:"west",split:true,border:true,title:"系统导航"' style="width:200px;"">
			<div id="menu" class="easyui-accordion" fit="true" border="false">
				<div title="菜单及用户管理" selected="true" style="overflow:auto;">
					<ul>
                        <li>
                        	<div class="selected"><a href="javascript:aClick('模块管理', '<%=path%>/manage/manageModule/enter.do');">模块管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('菜单管理', '<%=path%>/manage/businessMenu/menuTree.do');">菜单管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('功能管理', '<%=path%>/manage/manageFunction/enter.do');">功能管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('员工管理', '<%=path%>/manage/businessUser/enter.do');">员工管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('居民管理', '<%=path%>/app/appUser/enter.do');">居民管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('小区管理', '<%=path%>/manage/manageEstate/enter.do');">小区管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('运营管理', '<%=path%>/manage/manageOrg/org.do');">运营管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('社区报管理', '<%=path%>/manage/businessCommunity/enter.do');">社区报管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('驿站管理', '<%=path%>/manage/businessStation/enter.do');">驿站管理</a></div>	
                        	<div class="selected"><a href="javascript:aClick('物业管理', '<%=path%>/manage/businessProperty/enter.do');">物业管理</a></div>
                        	<div class="selected"><a href="javascript:aClick('省市区管理', '<%=path%>/manage/manageProvice/ProvinceCityManagement.do');">省市区管理</a></div>
                        </li>
                    </ul>
				</div>
				
				<div title="物业数据统计">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('物业报修受理总数', '<%=path%>/statis/property/repair.do');">物业报修受理总数</a></div>
                            <div class="selected"><a href="javascript:aClick('物业建议总数', '<%=path%>/statis/property/advise.do');">物业建议总数</a></div>
                            <div class="selected"><a href="javascript:aClick('物业投诉总数', '<%=path%>/statis/property/complaint.do');">物业投诉总数</a></div>
                            <div class="selected"><a href="javascript:aClick('物业公告浏览量', '<%=path%>/statis/property/annoVisits.do');">物业公告浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('物业公告评论量', '<%=path%>/statis/property/annoComments.do');">物业公告评论量</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('报修评价星级平均值', '<%=path%>/statis/property/starAverage.do');">报修评价星级平均值</a></div>
                            <div class="selected"><a href="javascript:aClick('星级评价个数', '<%=path%>/statis/property/star.do');">星级评价个数</a></div>
                            <div class="selected"><a href="javascript:aClick('不同报修分类星级个数', '<%=path%>/statis/property/starByType.do');">不同报修分类星级个数</a></div>
                        </li>
                    </ul>
				</div>
				
				<div title="驿站数据统计">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('驿站发件数量', '<%=path%>/statis/station/expressSend.do');">驿站发件数量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站上门取件数量', '<%=path%>/statis/station/expressGet.do');">驿站上门取件数量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站签收数量', '<%=path%>/statis/station/expressSign.do');">驿站签收数量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站送件上门数量', '<%=path%>/statis/station/expressDelivery.do');">驿站送件上门数量</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('快递服务投诉占比', '<%=path%>/statis/station/epxressComplaintCompare.do');">快递服务投诉占比</a></div>
                            <div class="selected"><a href="javascript:aClick('已发快递投诉占比', '<%=path%>/statis/station/expressSendComplaintCompare.do');">已发快递投诉占比</a></div>
                            <div class="selected"><a href="javascript:aClick('已收快递投诉占比', '<%=path%>/statis/station/expressGetComplaintCompare.do');">已收快递投诉占比</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('驿站建议总量', '<%=path%>/statis/station/advise.do');">驿站建议总量</a></div>
                            <div class="selected"><a href="javascript:aClick('公告浏览量', '<%=path%>/statis/station/annoVisits.do');">公告浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('公告评论量', '<%=path%>/statis/station/annoComments.do');">公告评论量</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('活动参与量', '<%=path%>/statis/station/actParticipates.do');">活动参与量</a></div>
                            <div class="selected"><a href="javascript:aClick('活动浏览量', '<%=path%>/statis/station/actVisits.do');">活动浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('活动点赞量', '<%=path%>/statis/station/actSupports.do');">活动点赞量</a></div>
                            <div class="selected"><a href="javascript:aClick('活动评论量', '<%=path%>/statis/station/actComments.do');">活动评论量</a></div>
                        </li>
                    </ul>
				</div>
				
				<div title="社区数据统计">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('新闻浏览总量', '<%=path%>/statis/community/newsVisits.do');">新闻浏览总量</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻评论总量', '<%=path%>/statis/community/newsComments.do');">新闻评论总量</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻点赞总量', '<%=path%>/statis/community/newsSupports.do');">新闻点赞总量</a></div>
                            <div class="selected"><a href="javascript:aClick('爆料总量', '<%=path%>/statis/community/breakCount.do');">爆料总量</a></div>
                            <div class="selected"><a href="javascript:aClick('爆料新闻浏览总量', '<%=path%>/statis/community/breakNewsVisits.do');">爆料新闻浏览总量</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('爆料选取总量', '<%=path%>/statis/community/breakSelect.do');">爆料选取总量</a></div>
                            <div class="selected"><a href="javascript:aClick('爆料选取占比', '<%=path%>/statis/community/breakSelectCompare.do');">爆料选取占比</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('单篇新闻浏览量排名', '<%=path%>/statis/community/singleNewsVisits.do');">单篇新闻浏览量排名</a></div>
                            <div class="selected"><a href="javascript:aClick('平均新闻浏览量', '<%=path%>/statis/community/averageNewsVisits.do');">平均新闻浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('单篇新闻评论量排名', '<%=path%>/statis/community/singleNewsComments.do');">单篇新闻评论量排名</a></div>
                            <div class="selected"><a href="javascript:aClick('平均新闻评论量', '<%=path%>/statis/community/averageNewsComments.do');">平均新闻评论量</a></div>
                            <div class="selected"><a href="javascript:aClick('单篇新闻点赞量排名', '<%=path%>/statis/community/singleNewsSupports.do');">单篇新闻点赞量排名</a></div>
                            <div class="selected"><a href="javascript:aClick('平均新闻点赞量', '<%=path%>/statis/community/averageNewsSupports.do');">平均新闻点赞量</a></div>
                            <div class="selected"><a href="javascript:aClick('爆料浏览量排名', '<%=path%>/statis/community/breakVisits.do');">爆料浏览量排名</a></div>
                            <div class="selected"><a href="javascript:aClick('平均爆料浏览量', '<%=path%>/statis/community/averageBreakVisits.do');">平均爆料浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('爆料评论量排名', '<%=path%>/statis/community/breakCommentsRank.do');">爆料评论量排名</a></div>
                            <div class="selected"><a href="javascript:aClick('平均爆料评论量', '<%=path%>/statis/community/averageBreakComments.do');">平均爆料评论量</a></div>
                            
                        </li>
                    </ul>
				</div>
				
				<div title="运营数据统计">
					<ul>
                        <li>
							<div class="selected"><a href="javascript:aClick('新闻总量', '<%=path%>/statis/operation/newsCount.do');">新闻总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区新闻总量占比', '<%=path%>/statis/operation/communityNewsCompare.do');">各社区新闻总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区新闻总量排名', '<%=path%>/statis/operation/communityNewsCountRank.do');">各社区新闻总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('新闻评论总量', '<%=path%>/statis/operation/newsComments.do');">新闻评论总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区新闻评论排名', '<%=path%>/statis/operation/communityNewsCommentsRank.do');">各社区新闻评论排名</a></div>
							<div class="selected"><a href="javascript:aClick('各社区新闻评论占比', '<%=path%>/statis/operation/communityNewsCommentsCompare.do');">各社区新闻评论占比</a></div>
							<div class="selected"><a href="javascript:aClick('新闻平均评论量', '<%=path%>/statis/operation/averageNewsComments.do');">新闻平均评论量</a></div>
							<div class="selected"><a href="javascript:aClick('爆料总量', '<%=path%>/statis/operation/breakCount.do');">爆料总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区爆料总量占比', '<%=path%>/statis/operation/communityBreakCompare.do');">各社区爆料总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区爆料总量排名', '<%=path%>/statis/operation/communityBreakRank.do');">各社区爆料总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('选取爆料总量', '<%=path%>/statis/operation/breakSelects.do');">选取爆料总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区选取爆料总量占比', '<%=path%>/statis/operation/communityBreakSelectsCompare.do');">各社区选取爆料总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区选取爆料排名', '<%=path%>/statis/operation/communityBreakSelectsRank.do');">各社区选取爆料排名</a></div>
							<div class="selected"><a href="javascript:aClick('选取爆料平均量', '<%=path%>/statis/operation/averageBreakSelects.do');">选取爆料平均量</a></div>
							<div class="selected"><a href="javascript:aClick('发件总量', '<%=path%>/statis/operation/expressSendCount.do');">发件总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区发件总量占比', '<%=path%>/statis/operation/communityExpressSendCountCompare.do');">各社区发件总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各小区发件总量占比', '<%=path%>/statis/operation/estateExpressSendCountCompare.do');">各小区发件总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区发件总量排名', '<%=path%>/statis/operation/communityExpressSendCountRank.do');">各社区发件总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('各小区发件总量排名', '<%=path%>/statis/operation/estateExpressSendCountRank.do');">各小区发件总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('上门取件总量', '<%=path%>/statis/operation/expressGetCount.do');">上门取件总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区上门取件总量占比', '<%=path%>/statis/operation/communityExpressGetCountCompare.do');">各社区上门取件总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各小区上门取件总量占比', '<%=path%>/statis/operation/estateExpressGetCountCompare.do');">各小区上门取件总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区上门取件总量排名', '<%=path%>/statis/operation/communityExpressGetCountRank.do');">各社区上门取件总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('各小区上门取件总量排名', '<%=path%>/statis/operation/estateExpressGetCountRank.do');">各小区上门取件总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('上门取件总量排名', '<%=path%>/statis/operation/expressGetCountRank.do');">上门取件总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('签收总量', '<%=path%>/statis/operation/expressSignCount.do');">签收总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区签收总量占比', '<%=path%>/statis/operation/communityExpressSignCountCompare.do');">各社区签收总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各小区签收总量占比', '<%=path%>/statis/operation/estateExpressSignCountCompare.do');">各小区签收总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区签收总量排名', '<%=path%>/statis/operation/communityExpressSignCountRank.do');">各社区签收总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('各小区签收总量排名', '<%=path%>/statis/operation/estateExpressSignCountRank.do');">各小区签收总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('活动总量', '<%=path%>/statis/operation/activityCount.do');">活动总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区活动总量占比', '<%=path%>/statis/operation/communityActivityCountCompare.do');">各社区活动总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各小区活动总量占比', '<%=path%>/statis/operation/estateActivityCountCompare.do');">各小区活动总量占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区活动总量排名', '<%=path%>/statis/operation/communityActivityCountRank.do');">各社区活动总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('各小区活动总量排名', '<%=path%>/statis/operation/estateActivityCountRank.do');">个小区活动总量排名</a></div>
							<div class="selected"><a href="javascript:aClick('活动参与人数总量', '<%=path%>/statis/operation/avtivityParticipateSum.do');">活动参与人数总量</a></div>
							<div class="selected"><a href="javascript:aClick('各社区活动参与人数占比', '<%=path%>/statis/operation/communityActivityParticipateCountCompare.do');">各社区活动参与人数占比</a></div>
							<div class="selected"><a href="javascript:aClick('各小区活动参与人数占比', '<%=path%>/statis/operation/estateActivityParticipateCountCompare.do');">个小区活动参与人数占比</a></div>
							<div class="selected"><a href="javascript:aClick('各社区活动参与人数排名', '<%=path%>/statis/operation/communityActivityParticipateCountRank.do');">各社区活动参与人数排名</a></div>
							<div class="selected"><a href="javascript:aClick('各小区活动参与人数排名', '<%=path%>/statis/operation/estateActivityParticipateCountRank.do');">个小区活动参与人数排名</a></div>
							<div class="selected"><a href="javascript:aClick('社区平均活动次数', '<%=path%>/statis/operation/communityAverageActivity.do');">社区平均活动次数</a></div>
							<div class="selected"><a href="javascript:aClick('小区平均活动次数', '<%=path%>/statis/operation/estateAverageActivity.do');">小区平均活动次数</a></div>
							<div class="selected"><a href="javascript:aClick('平均活动参与人数', '<%=path%>/statis/operation/averageActivityParticipate.do');">平均活动参与人数</a></div>
							                          
                        </li>
                    </ul>
				</div>
				
				<div title="APP统计">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('APP-APP总访问人数', '<%=basePath %>/app/appStatisticsClick/appCount.do');">APP-APP总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('APP-APP页面总浏览量', '<%=basePath %>/app/appStatisticsClick/appVisits.do');">APP-APP页面总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('APP-平均访问页数', '<%=basePath %>/app/appStatisticsClick/appAvePages.do');">APP-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('新闻-新发新闻总篇数', '<%=basePath %>/app/appStatisticsClick/newPubInfoCount.do');">新闻-新发新闻总篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-总访问人数', '<%=basePath %>/app/appStatisticsClick/infoCount.do');">新闻-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-页面总浏览量', '<%=basePath %>/app/appStatisticsClick/infoVisits.do');">新闻-页面总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-人均访问页数', '<%=basePath %>/app/appStatisticsClick/infoAvePages.do');">新闻-平均访问页数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-被访问新闻总篇数', '<%=basePath %>/app/appStatisticsClick/visitedInfoCount.do');">新闻-被访问新闻总篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-篇均浏览人数', '<%=basePath %>/app/appStatisticsClick/personCountPerPage.do');">新闻-篇均浏览人数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-社区报新增新闻篇数', '<%=basePath %>/app/appStatisticsClick/newComPubInfoCount.do');">新闻-社区报新增新闻篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-社区报新闻被访问新闻篇数', '<%=basePath %>/app/appStatisticsClick/comVisitedInfoCount.do');">新闻-社区报新闻被访问新闻篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-社区报篇均浏览人数', '<%=basePath %>/app/appStatisticsClick/comInfoAvePages.do');">新闻-社区报篇均浏览人数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-运营新增新闻篇数', '<%=basePath %>/app/appStatisticsClick/newOpePubInfoCount.do');">新闻-运营新增新闻篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-运营被访问新闻篇数', '<%=basePath %>/app/appStatisticsClick/opeVisitedInfoCount.do');">新闻-运营被访问新闻篇数</a></div>
                            <div class="selected"><a href="javascript:aClick('新闻-运营篇均浏览人数', '<%=basePath %>/app/appStatisticsClick/opeInfoAvePages.do');">新闻-运营篇均浏览人数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('快递-总访问人数数', '<%=basePath %>/app/appStatisticsClick/expressCount.do');">快递-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('快递-总浏览量', '<%=basePath %>/app/appStatisticsClick/expressVisits.do');">快递-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('快递-平均访问页数', '<%=basePath %>/app/appStatisticsClick/expressAvePages.do');">快递-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('跳蚤市场-总访问人数数', '<%=basePath %>/app/appStatisticsClick/marketCount.do');">跳蚤市场-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('跳蚤市场-总浏览量', '<%=basePath %>/app/appStatisticsClick/marketVisits.do');">跳蚤市场-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('跳蚤市场-平均访问页数', '<%=basePath %>/app/appStatisticsClick/marketAvePages.do');">跳蚤市场-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('邻里求助-总访问人数数', '<%=basePath %>/app/appStatisticsClick/helpCount.do');">邻里求助-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('邻里求助-总浏览量', '<%=basePath %>/app/appStatisticsClick/helpVisits.do');">邻里求助-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('邻里求助-平均访问页数', '<%=basePath %>/app/appStatisticsClick/helpAvePages.do');">邻里求助-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('中医养生-总访问人数数', '<%=basePath %>/app/appStatisticsClick/chinCount.do');">中医养生-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('中医养生-总浏览量', '<%=basePath %>/app/appStatisticsClick/chinVisits.do');">中医养生-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('中医养生-平均访问页数', '<%=basePath %>/app/appStatisticsClick/chinAvePages.do');">中医养生-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('健康饮食-总访问人数数', '<%=basePath %>/app/appStatisticsClick/dietCount.do');">健康饮食-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('健康饮食-总浏览量', '<%=basePath %>/app/appStatisticsClick/dietVisits.do');">健康饮食-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('健康饮食-平均访问页数', '<%=basePath %>/app/appStatisticsClick/dietAvePages.do');">健康饮食-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('社区报-总访问人数数', '<%=basePath %>/app/appStatisticsClick/newsCount.do');">社区报-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('社区报-总浏览量', '<%=basePath %>/app/appStatisticsClick/newsVisits.do');">社区报-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('社区报-平均访问页数', '<%=basePath %>/app/appStatisticsClick/newsAvePages.do');">社区报-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('社区活动-总访问人数数', '<%=basePath %>/app/appStatisticsClick/activityCount.do');">社区活动-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('社区活动-总浏览量', '<%=basePath %>/app/appStatisticsClick/activityVisits.do');">社区活动-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('社区活动-平均访问页数', '<%=basePath %>/app/appStatisticsClick/activityAvePages.do');">社区活动-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('驿站服务-总访问人数数', '<%=basePath %>/app/appStatisticsClick/serviceCount.do');">驿站服务-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站服务-总浏览量', '<%=basePath %>/app/appStatisticsClick/serviceVisits.do');">驿站服务-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站服务-平均访问页数', '<%=basePath %>/app/appStatisticsClick/serviceAvePages.do');">驿站服务-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('驿站女孩-总访问人数数', '<%=basePath %>/app/appStatisticsClick/girlCount.do');">驿站女孩-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站女孩-总浏览量', '<%=basePath %>/app/appStatisticsClick/girlVisits.do');">驿站女孩-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站女孩-平均访问页数', '<%=basePath %>/app/appStatisticsClick/girlAvePages.do');">驿站女孩-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('驿站公告-总访问人数数', '<%=basePath %>/app/appStatisticsClick/stationAnnoCount.do');">驿站公告-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站公告-总浏览量', '<%=basePath %>/app/appStatisticsClick/stationAnnoVisits.do');">驿站公告-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('驿站公告-平均访问页数', '<%=basePath %>/app/appStatisticsClick/stationAnnoAvePages.do');">驿站公告-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('物业通知-总访问人数数', '<%=basePath %>/app/appStatisticsClick/propAnnoCount.do');">物业通知-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('物业通知-总浏览量', '<%=basePath %>/app/appStatisticsClick/propAnnoVisits.do');">物业通知-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('物业通知-平均访问页数', '<%=basePath %>/app/appStatisticsClick/propAnnoAvePages.do');">物业通知-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('物业手册-总访问人数数', '<%=basePath %>/app/appStatisticsClick/bookCount.do');">物业手册-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('物业手册-总浏览量', '<%=basePath %>/app/appStatisticsClick/bookVisits.do');">物业手册-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('物业手册-平均访问页数', '<%=basePath %>/app/appStatisticsClick/bookAvePages.do');">物业手册-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('小区周边-总访问人数数', '<%=basePath %>/app/appStatisticsClick/aroundCount.do');">小区周边-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('小区周边-总浏览量', '<%=basePath %>/app/appStatisticsClick/aroundVisits.do');">小区周边-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('小区周边-平均访问页数', '<%=basePath %>/app/appStatisticsClick/aroundAvePages.do');">小区周边-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('社区黄页-总访问人数数', '<%=basePath %>/app/appStatisticsClick/yellowCount.do');">社区黄页-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('社区黄页-总浏览量', '<%=basePath %>/app/appStatisticsClick/yellowVisits.do');">社区黄页-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('社区黄页-平均访问页数', '<%=basePath %>/app/appStatisticsClick/yellowAvePages.do');">社区黄页-平均访问页数</a></div>
                            
                            <div class="selected"><a href="javascript:aClick('首页-总访问人数数', '<%=basePath %>/app/appStatisticsClick/indexCount.do');">首页-总访问人数</a></div>
                            <div class="selected"><a href="javascript:aClick('首页-总浏览量', '<%=basePath %>/app/appStatisticsClick/indexVisits.do');">首页-总浏览量</a></div>
                            <div class="selected"><a href="javascript:aClick('首页-平均访问页数', '<%=basePath %>/app/appStatisticsClick/indexAvePages.do');">首页-平均访问页数</a></div>
                            
                         
                        </li>
                    </ul>
				</div>
				
				<div title="系统管理">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('系统用户管理', '<%=basePath %>/health/healthCountry/enter.do');">系统用户管理</a></div>
                        </li>
                    </ul>
				</div>
				
				<div title="服务电话">
					<ul>
                        <li>
<%--                        <div class="selected"><a href="javascript:aClick('小区电话', '<%=path%>/manage/manageEstate/enterEstTel.do');">小区电话</a></div> --%>
							<div class="selected"><a href="javascript:aClick('小区电话', '<%=path %>/manage/manageEstate/manageEstTel.do');">小区电话</a></div>  
                            <div class="selected"><a href="javascript:aClick('社区电话', '<%=path %>/manage/businessCommunity/manageComTel.do');">社区电话</a></div>
                        </li>
                    </ul>
				</div>
				
<%-- 	<div class="selected"><a href="javascript:aClick('功能管理', '<%=path%>/manage/manageFunction/enter.do');">功能管理</a></div> --%>
				<div title="短信管理">
					<ul>
                        <li>
                            <div class="selected"><a href="javascript:aClick('短信管理', '<%=path%>/manage/manageSendMsg/enter.do');">短信管理</a></div>
                        </li>
                    </ul>
				</div>

			</div>
		</div>
		
		<div region='center' border="true" style="overflow:hidden;">
			<div id="tabs" class="easyui-tabs" fit='true', border='false', plain='true'>
				<div title="主页" style="padding:20px;overflow:hidden;"> 
					<div style="margin-top:20px;">
						<h3>北青社区平台数据后台管理系统</h3>
					</div>
				</div>
			</div>
		</div>
		
		<div data-options='region:"south",border:true,split:true,title:"版权信息"' style='height: 60px; padding: 5px;'>
			北青社区报版权所有
		</div>
	</body>
</html>

