package com.manage.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.common.ResultBean;
import com.manage.app.service.BusinessCommunityService;
import com.manage.app.service.StatisService;

@Controller
@RequestMapping("/statis/operation")
public class StatisOperationController {

	private static Logger GSLogger = LoggerFactory.getLogger(StatisOperationController.class);
	
	@Autowired
	private StatisService statisService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	

	/**
	 * 进入新闻总量
	 * @return
	 */
	@RequestMapping(value="newsCount")
	public ModelAndView newsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newsCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/newsCount");
		return mav;
	}
	
	/**
	 * 新闻总量
	 * @return
	 */
	@RequestMapping(value="newsCountList")
	public void newsCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/operation/expressSendList", e);
			e.printStackTrace();
		}
	}
	

	/**
	 * 进入各社区新闻总量占比
	 * @return
	 */
	@RequestMapping(value="communityNewsCompare")
	public ModelAndView communityNewsCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityNewsCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityNewsCompare");
		return mav;
	}
	
	/**
	 * 各社区新闻总量占比
	 * @return
	 */
	@RequestMapping(value="communityNewsCompareList")
	public void communityNewsCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, n.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, n.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, n.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区新闻总量排名
	 * @return
	 */
	@RequestMapping(value="communityNewsCountRank")
	public ModelAndView communityNewsCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityNewsCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityNewsCountRank");
		return mav;
	}
	
	/**
	 * 各社区新闻总量排名
	 * @return
	 */
	@RequestMapping(value="communityNewsCountRankList")
	public void communityNewsCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, n.comName as title, count(1) as timeValue from business_news n where date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by n.comName order by count(1) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, n.comName as title, count(1) as timeValue from business_news n where date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' group by n.comName order by count(1) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, n.comName as title, count(1) as timeValue from business_news n where date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' group by n.comName order by count(1) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻评论总量
	 * @return
	 */
	@RequestMapping(value="newsComments")
	public ModelAndView newsComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newsComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/newsComments");
		return mav;
	}
	
	/**
	 * 新闻评论总量
	 * @return
	 */
	@RequestMapping(value="newsCommentsList")
	public void newsCommentsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/operation/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区新闻评论排名
	 * @return
	 */
	@RequestMapping(value="communityNewsCommentsRank")
	public ModelAndView communityNewsCommentsRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityNewsCommentsRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityNewsCommentsRank");
		return mav;
	}
	
	/**
	 * 各社区新闻评论排名
	 * @return
	 */
	@RequestMapping(value="communityNewsCommentsRankList")
	public void communityNewsCommentsRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.comments) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, n.comName as title, sum(n.comments) as timeValue from business_news n where date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by n.comName order by sum(n.comments) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, n.comName as title, sum(n.comments) as timeValue from business_news n where date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' group by n.comName order by sum(n.comments) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, n.comName as title, sum(n.comments) as timeValue from business_news n where date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' group by n.comName order by sum(n.comments) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区新闻评论占比
	 * @return
	 */
	@RequestMapping(value="communityNewsCommentsCompare")
	public ModelAndView communityNewsCommentsCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityNewsCommentsCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityNewsCommentsCompare");
		return mav;
	}
	
	/**
	 * 各社区新闻评论占比
	 * @return
	 */
	@RequestMapping(value="communityNewsCommentsCompareList")
	public void communityNewsCommentsCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.comments) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.comments) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.comments) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, n.comName as title, round(sum(n.comments)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, n.comName as title, round(sum(n.comments)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, n.comName as title, round(sum(n.comments)/"+obj.getTimeValue()+")*100 as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' group by n.comName order by n.newsId desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻平均评论量
	 * @return
	 */
	@RequestMapping(value="averageNewsComments")
	public ModelAndView averageNewsComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageNewsComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/averageNewsComments");
		return mav;
	}
	
	/**
	 * 新闻平均评论量
	 * @return
	 */
	@RequestMapping(value="averageNewsCommentsList")
	public void averageNewsCommentsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, round(sum(n.comments)/count(1)) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, round(sum(n.comments)/count(1)) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, round(sum(n.comments)/count(1)) as timeValue from business_news n where n.comments > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/operation/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入爆料总量
	 * @return
	 */
	@RequestMapping(value="breakCount")
	public ModelAndView breakCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/breakCount");
		return mav;
	}
	
	/**
	 * 爆料总量
	 * @return
	 */
	@RequestMapping(value="breakCountList")
	public void breakCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by b.breakTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/operation/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区爆料总量占比
	 * @return
	 */
	@RequestMapping(value="communityBreakCompare")
	public ModelAndView communityBreakCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityBreakCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityBreakCompare");
		return mav;
	}
	
	/**
	 * 各社区爆料总量占比
	 * @return
	 */
	@RequestMapping(value="communityBreakCompareList")
	public void communityBreakCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by date(b.breakTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by date_format(b.breakTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by month(b.breakTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%v') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%m') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区爆料总量排名
	 * @return
	 */
	@RequestMapping(value="communityBreakRank")
	public ModelAndView communityBreakRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityBreakRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityBreakRank");
		return mav;
	}
	
	/**
	 * 各社区爆料总量排名
	 * @return
	 */
	@RequestMapping(value="communityBreakRankList")
	public void communityBreakRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by date(b.breakTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by date_format(b.breakTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by month(b.breakTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%v') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where date_format(b.breakTime, '%Y-%m') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入爆料选取总量
	 * @return
	 */
	@RequestMapping(value="breakSelects")
	public ModelAndView breakSelects(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakSelects 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/breakSelects");
		return mav;
	}
	
	/**
	 * 爆料选取数据
	 * @return
	 */
	@RequestMapping(value="breakSelectsList")
	public void breakSelectsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by b.breakTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区选取爆料总量占比
	 * @return
	 */
	@RequestMapping(value="communityBreakSelectsCompare")
	public ModelAndView communityBreakSelectsCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityBreakSelectsCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityBreakSelectsCompare");
		return mav;
	}
	
	/**
	 * 各社区选取爆料总量占比
	 * @return
	 */
	@RequestMapping(value="communityBreakSelectsCompareList")
	public void communityBreakSelectsCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by date(b.breakTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by date_format(b.breakTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by month(b.breakTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%v') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(1)/"+obj.getTimeValue()+")*100 as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%m') = '" + obj.getTimeField() + "' group by b.comId order by b.breakTime desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区选取爆料排名
	 * @return
	 */
	@RequestMapping(value="communityBreakSelectsRank")
	public ModelAndView communityBreakSelectsRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityBreakSelectsRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityBreakSelectsRank");
		return mav;
	}
	
	/**
	 * 各社区选取爆料排名
	 * @return
	 */
	@RequestMapping(value="communityBreakSelectsRankList")
	public void communityBreakSelectsRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by date(b.breakTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by date_format(b.breakTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, count(1) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by month(b.breakTime) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%v') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(1) as timeValue from business_break b inner join business_community c on c.comId = b.comId where b.selectedNum > 0 and date_format(b.breakTime, '%Y-%m') = '" + obj.getTimeField() + "' group by b.comId order by count(1) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入选取爆料平均量
	 * @return
	 */
	@RequestMapping(value="averageBreakSelects")
	public ModelAndView averageBreakSelects(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageBreakSelects 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/averageBreakSelects");
		return mav;
	}
	
	/**
	 * 选取爆料平均量
	 * @return
	 */
	@RequestMapping(value="averageBreakSelectsList")
	public void averageBreakSelectsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, round(sum(b.selectedNum)/count(1)) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, round(sum(b.selectedNum)/count(1)) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, round(sum(b.selectedNum)/count(1)) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by b.breakTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入发件总量
	 * @return
	 */
	@RequestMapping(value="expressSendCount")
	public ModelAndView expressSendCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressSendCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/expressSendCount");
		return mav;
	}
	
	/**
	 * 发件总量
	 * @return
	 */
	@RequestMapping(value="expressSendCountList")
	public void expressSendCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
		
	/**
	 * 进入活动总量
	 * @return
	 */
	@RequestMapping(value="activityCount")
	public ModelAndView activityCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController activityCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/activityCount");
		return mav;
	}
	
	/**
	 * 活动总量
	 * @return
	 */
	@RequestMapping(value="activityCountList")
	public void activityCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区活动总量占比
	 * @return
	 */
	@RequestMapping(value="communityActivityCountCompare")
	public ModelAndView communityActivityCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityActivityCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityActivityCountCompare");
		return mav;
	}
	
	/**
	 * 各社区活动总量占比
	 * @return
	 */
	@RequestMapping(value="communityActivityCountCompareList")
	public void communityActivityCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List communityList = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				communityList = businessCommunityService.findAll();
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				for(int j=0;j<communityList.size();j++) {
					BusinessCommunity businessCommunity = (BusinessCommunity) communityList.get(j);
					if(scopeValue == 0) {//日
							sql = "select '' as timeField, c.comName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
									"from business_activity a " +
									"inner join business_activity_scope s on a.actId = s.actId " +
									"inner join manage_estate e on e.estateId = s.estateId " +
									"right join business_community c on c.comId = e.comId " +
									"where date_format(a.publishDate, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
											"and c.comId = " + businessCommunity.getComId() + " " +
											"order by a.publishDate desc";
							/*sql = "select '' as timeField, c.comName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
									"from business_activity a " +
									"inner join business_activity_scope s on a.actId = s.actId " +
									"inner join manage_estate e on e.estateId = s.estateId " +
									"right join business_community c on c.comId = e.comId " +
									"where date_format(a.publishDate, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by c.comId order by a.publishDate desc";*/
					}else if(scopeValue == 1) {//周
						sql = "select '' as timeField, c.comName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
								"from business_activity a " +
								"left join business_activity_scope s on a.actId = s.actId " +
								"inner join manage_estate e on e.estateId = s.estateId " +
								"right join business_community c on c.comId = e.comId " +
								"where date_format(a.publishDate, '%Y-%v') = '" + obj.getTimeField() + "' " +
										"and c.comId = " + businessCommunity.getComId() + " " +
										"order by a.publishDate desc";
					}else if(scopeValue == 2) {//月
						sql = "select '' as timeField, c.comName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
								"from business_activity a " +
								"left join business_activity_scope s on a.actId = s.actId " +
								"inner join manage_estate e on e.estateId = s.estateId " +
								"right join business_community c on c.comId = e.comId " +
								"where date_format(a.publishDate, '%Y-%m') = '" + obj.getTimeField() + "' " +
								"and c.comId = " + businessCommunity.getComId() + " " +		
								"order by a.publishDate desc";
					}
					//拼入明细记录
					sublist = statisService.statisBySql(sql);
					for(int k=0;k<sublist.size();k++) {
						ResultBean subObj = (ResultBean) sublist.get(k);
						result.append("{")
						.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
					    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
					    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
					    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
					    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
						.append("}").append(",");
					}
				}
				//sublist = statisService.statisBySql(sql);
				/*for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}*/
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区活动总量排名
	 * @return
	 */
	@RequestMapping(value="communityActivityCountRank")
	public ModelAndView communityActivityCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityActivityCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityActivityCountRank");
		return mav;
	}
	
	/**
	 * 各社区活动总量排名
	 * @return
	 */
	@RequestMapping(value="communityActivityCountRankList")
	public void communityActivityCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(distinct(a.actId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity a on a.actId = s.actId " +
							" and date_format(a.publishDate, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(a.actId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(distinct(a.actId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity a on a.actId = s.actId " +
							"and date_format(a.publishDate, '%Y-%v') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(a.actId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(distinct(a.actId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity a on a.actId = s.actId " +
							"and date_format(a.publishDate, '%Y-%m') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(a.actId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 进入各小区活动总量占比
	 * @return
	 */
	@RequestMapping(value="estateActivityCountCompare")
	public ModelAndView estateActivityCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateActivityCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateActivityCountCompare");
		return mav;
	}
	
	/**
	 * 各小区活动总量占比
	 * @return
	 */
	@RequestMapping(value="estateActivityCountCompareList")
	public void estateActivityCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by e.estateId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%v') = '" + obj.getTimeField() + "' group by e.estateId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%m') = '" + obj.getTimeField() + "' group by e.estateId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各小区活动总量排名
	 * @return
	 */
	@RequestMapping(value="estateActivityCountRank")
	public ModelAndView estateActivityCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateActivityCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateActivityCountRank");
		return mav;
	}
	
	/**
	 * 各小区活动总量排名
	 * @return
	 */
	@RequestMapping(value="estateActivityCountRankList")
	public void estateActivityCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, count(distinct(a.actId)) as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%m-%d') = '" + obj.getTimeField() + "' group by e.estateId order by count(distinct(a.actId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, count(distinct(a.actId)) as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%v') = '" + obj.getTimeField() + "' group by e.estateId order by count(distinct(a.actId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, count(distinct(a.actId)) as timeValue from manage_estate e left join business_activity_scope s on s.estateId = e.estateId left join business_activity a on s.actId = a.actId and date_format(a.publishDate, '%Y-%m') = '" + obj.getTimeField() + "' group by e.estateId order by count(distinct(a.actId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入活动参与人数总量
	 * @return
	 */
	@RequestMapping(value="avtivityParticipateSum")
	public ModelAndView avtivityParticipateSum(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController avtivityParticipateSum 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/avtivityParticipateSum");
		return mav;
	}
	
	/**
	 * 活动参与人数总量
	 * @return
	 */
	@RequestMapping(value="avtivityParticipateSumList")
	public void avtivityParticipateSumList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(p.joinTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date(p.joinTime) order by p.joinTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(p.joinTime),weekday(p.joinTime)),' - ',subdate(date(p.joinTime),weekday(p.joinTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date_format(p.joinTime, '%Y-%v') order by p.joinTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(p.joinTime, '%Y-%m') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by month(p.joinTime) order by p.joinTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区活动参与人数占比
	 * @return
	 */
	@RequestMapping(value="communityActivityParticipateCountCompare")
	public ModelAndView communityActivityParticipateCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityActivityParticipateCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityActivityParticipateCountCompare");
		return mav;
	}
	
	/**
	 * 各社区活动参与人数占比
	 * @return
	 */
	@RequestMapping(value="communityActivityParticipateCountCompareList")
	public void communityActivityParticipateCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(p.joinTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date(p.joinTime) order by p.joinTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(p.joinTime),weekday(p.joinTime)),' - ',subdate(date(p.joinTime),weekday(p.joinTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date_format(p.joinTime, '%Y-%v') order by p.joinTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(p.joinTime, '%Y-%m') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by month(p.joinTime) order by p.joinTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(distinct(p.memberId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							" and date_format(p.joinTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(distinct(p.memberId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(distinct(p.memberId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 进入各社区活动参与人数排名
	 * @return
	 */
	@RequestMapping(value="communityActivityParticipateCountRank")
	public ModelAndView communityActivityParticipateCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityActivityParticipateCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityActivityParticipateCountRank");
		return mav;
	}
	
	/**
	 * 各社区活动参与人数排名
	 * @return
	 */
	@RequestMapping(value="communityActivityParticipateCountRankList")
	public void communityActivityParticipateCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(p.joinTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date(p.joinTime) order by p.joinTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(p.joinTime),weekday(p.joinTime)),' - ',subdate(date(p.joinTime),weekday(p.joinTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date_format(p.joinTime, '%Y-%v') order by p.joinTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(p.joinTime, '%Y-%m') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by month(p.joinTime) order by p.joinTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(distinct(p.memberId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							" and date_format(p.joinTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(p.memberId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(distinct(p.memberId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(p.memberId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(distinct(p.memberId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(p.memberId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 进入各小区活动参与人数占比
	 * @return
	 */
	@RequestMapping(value="estateActivityParticipateCountCompare")
	public ModelAndView estateActivityParticipateCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateActivityParticipateCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateActivityParticipateCountCompare");
		return mav;
	}
	
	/**
	 * 各小区活动参与人数占比
	 * @return
	 */
	@RequestMapping(value="estateActivityParticipateCountCompareList")
	public void estateActivityParticipateCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(a.actId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各小区活动参与人数排名
	 * @return
	 */
	@RequestMapping(value="estateActivityParticipateCountRank")
	public ModelAndView estateActivityParticipateCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateActivityParticipateCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateActivityParticipateCountRank");
		return mav;
	}
	
	/**
	 * 各小区活动参与人数排名
	 * @return
	 */
	@RequestMapping(value="estateActivityParticipateCountRankList")
	public void estateActivityParticipateCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, count(distinct(p.memberId)) as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(p.memberId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, count(distinct(p.memberId)) as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(p.memberId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, count(distinct(p.memberId)) as timeValue " +
							"from manage_estate e " +
							"left join business_activity_scope s on s.estateId = e.estateId " +
							"left join business_activity_participate p on p.actId = s.actId " +
							"and date_format(p.joinTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(p.memberId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入平均活动参与人数
	 * @return
	 */
	@RequestMapping(value="averageActivityParticipate")
	public ModelAndView averageActivityParticipate(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageActivityParticipate 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/averageActivityParticipate");
		return mav;
	}
	
	/**
	 * 平均活动参与人数
	 * @return
	 */
	@RequestMapping(value="averageActivityParticipateList")
	public void averageActivityParticipateList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(a.publishDate, '%Y-%v') as weekField, CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, count(1) as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				
				if(scopeValue == 0) {//日
					sql = "select count(1) as timeValue " +
							"from business_activity_participate p " +
							"where date_format(p.joinTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' ";
				}else if(scopeValue == 1) {//周
					sql = "select count(1) as timeValue " +
							"from business_activity_participate p " +
							"where date_format(p.joinTime, '%Y-%v') = '" + obj.getWeekField() + "' ";
				}else if(scopeValue == 2) {//月
					sql = "select count(1) as timeValue " +
							"from business_activity_participate p " +
							"where date_format(p.joinTime, '%Y-%m') = '" + obj.getTimeField() + "' ";
				}
				sublist = statisService.statisBySql(sql);
				ResultBean subBean = (ResultBean) sublist.get(0);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(new Integer(subBean.getTimeValue())/new Integer(obj.getTimeValue())).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区发件总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressSendCountCompare")
	public ModelAndView communityExpressSendCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressSendCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressSendCountCompare");
		return mav;
	}
	
	/**
	 * 各社区发件总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressSendCountCompareList")
	public void communityExpressSendCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							" and date_format(ex.sendTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区发件总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressSendCountRank")
	public ModelAndView communityExpressSendCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressSendCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressSendCountRank");
		return mav;
	}
	
	/**
	 * 各社区发件总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressSendCountRankList")
	public void communityExpressSendCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							" and date_format(ex.sendTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入各小区发件总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressSendCountCompare")
	public ModelAndView estateExpressSendCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressSendCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressSendCountCompare");
		return mav;
	}
	
	/**
	 * 各小区发件总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressSendCountCompareList")
	public void estateExpressSendCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							" and date_format(ex.sendTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by e.estateId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各小区发件总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressSendCountRank")
	public ModelAndView estateExpressSendCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressSendCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressSendCountRank");
		return mav;
	}
	
	/**
	 * 各小区发件总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressSendCountRankList")
	public void estateExpressSendCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							" and date_format(ex.sendTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 2 " +
							"and date_format(ex.sendTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入上门取件总量
	 * @return
	 */
	@RequestMapping(value="expressGetCount")
	public ModelAndView expressGetCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressGetCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/expressGetCount");
		return mav;
	}
	
	/**
	 * 上门取件总量
	 * @return
	 */
	@RequestMapping(value="expressGetCountList")
	public void expressGetCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区上门取件总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressGetCountCompare")
	public ModelAndView communityExpressGetCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressGetCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressGetCountCompare");
		return mav;
	}
	
	/**
	 * 各社区上门取件总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressGetCountCompareList")
	public void communityExpressGetCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							" and date_format(ex.modifyTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区上门取件总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressGetCountRank")
	public ModelAndView communityExpressGetCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressGetCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressGetCountRank");
		return mav;
	}
	
	/**
	 * 各社区上门取件总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressGetCountRankList")
	public void communityExpressGetCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							" and date_format(ex.modifyTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入各小区上门取件总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressGetCountCompare")
	public ModelAndView estateExpressGetCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressGetCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressGetCountCompare");
		return mav;
	}
	
	/**
	 * 各小区上门取件总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressGetCountCompareList")
	public void estateExpressGetCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							" and date_format(ex.modifyTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各小区上门取件总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressGetCountRank")
	public ModelAndView estateExpressGetCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressGetCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressGetCountRank");
		return mav;
	}
	
	/**
	 * 各小区上门取件总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressGetCountRankList")
	public void estateExpressGetCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							" and date_format(ex.modifyTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 1 " +
							"and date_format(ex.modifyTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入签收总量
	 * @return
	 */
	@RequestMapping(value="expressSignCount")
	public ModelAndView expressSignCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressSignCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/expressSignCount");
		return mav;
	}
	
	/**
	 * 签收总量
	 * @return
	 */
	@RequestMapping(value="expressSignCountList")
	public void expressSignCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区签收总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressSignCountCompare")
	public ModelAndView communityExpressSignCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressSignCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressSignCountCompare");
		return mav;
	}
	
	/**
	 * 各社区签收总量占比
	 * @return
	 */
	@RequestMapping(value="communityExpressSignCountCompareList")
	public void communityExpressSignCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							" and date_format(ex.signTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by c.comId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各社区签收总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressSignCountRank")
	public ModelAndView communityExpressSignCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityExpressSignCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityExpressSignCountRank");
		return mav;
	}
	
	/**
	 * 各社区签收总量排名
	 * @return
	 */
	@RequestMapping(value="communityExpressSignCountRankList")
	public void communityExpressSignCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							" and date_format(ex.signTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, c.comName as title, count(distinct(ex.expId)) as timeValue " +
							"from business_community c " +
							"left join manage_estate e on c.comId = e.comId " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
							"group by c.comId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入各小区签收总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressSignCountCompare")
	public ModelAndView estateExpressSignCountCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressSignCountCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressSignCountCompare");
		return mav;
	}
	
	/**
	 * 各小区签收总量占比
	 * @return
	 */
	@RequestMapping(value="estateExpressSignCountCompareList")
	public void estateExpressSignCountCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							" and date_format(ex.signTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, round(count(distinct(ex.expId))/"+obj.getTimeValue()+", 2)*100 as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入各小区签收总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressSignCountRank")
	public ModelAndView estateExpressSignCountRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateExpressSignCountRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateExpressSignCountRank");
		return mav;
	}
	
	/**
	 * 各小区签收总量排名
	 * @return
	 */
	@RequestMapping(value="estateExpressSignCountRankList")
	public void estateExpressSignCountRankList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							" and date_format(ex.signTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, e.estateName as title, count(distinct(ex.expId)) as timeValue " +
							"from manage_estate e " +
							"left join business_exp ex on ex.estateId = e.estateId and ex.expState = 6 " +
							"and date_format(ex.signTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
									"group by e.estateId order by count(distinct(ex.expId)) desc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append(subObj.getTimeValue()).append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
				}
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区平均活动次数
	 * @return
	 */
	@RequestMapping(value="communityAverageActivity")
	public ModelAndView communityAverageActivity(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController communityAverageActivity 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/communityAverageActivity");
		return mav;
	}
	
	/**
	 * 社区平均活动次数
	 * @return
	 */
	@RequestMapping(value="communityAverageActivityList")
	public void communityAverageActivityList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				//活动总量
				Integer comCount = statisService.countBySql("select count(1) from business_community");
				
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, round(count(1)/"+comCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, round(count(1)/"+comCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, round(count(1)/"+comCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入小区平均活动次数
	 * @return
	 */
	@RequestMapping(value="estateAverageActivity")
	public ModelAndView estateAverageActivity(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController estateAverageActivity 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/operation/estateAverageActivity");
		return mav;
	}
	
	/**
	 * 小区平均活动次数
	 * @return
	 */
	@RequestMapping(value="estateAverageActivityList")
	public void estateAverageActivityList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			List sublist = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				//小区总量
				Integer estateCount = statisService.countBySql("select count(1) from manage_estate");
				
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.publishDate, '%Y-%m-%d') as timeField, round(count(1)/"+estateCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date(a.publishDate) order by date(a.publishDate) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.publishDate),weekday(a.publishDate)),' - ',subdate(date(a.publishDate),weekday(a.publishDate))+INTERVAL 6 DAY) as timeField, round(count(1)/"+estateCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by date_format(a.publishDate, '%Y-%v') order by date_format(a.publishDate, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.publishDate, '%Y-%m') as timeField, round(count(1)/"+estateCount+") as timeValue from business_activity a where date(a.publishDate) between '" + startDate + "' and '" + endDate + "' group by month(a.publishDate) order by month(a.publishDate) desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
				.append("\"id\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	
	
}
