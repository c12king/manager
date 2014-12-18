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

import com.manage.app.common.ResultBean;
import com.manage.app.service.StatisService;

@Controller
@RequestMapping("/statis/community")
public class StatisCommunityController {

private static Logger GSLogger = LoggerFactory.getLogger(StatisCommunityController.class);
	
	@Autowired
	private StatisService statisService;
	
	/**
	 * 进入新闻浏览总量
	 * @return
	 */
	@RequestMapping(value="newsVisits")
	public ModelAndView newsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newsVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/newsVisits");
		return mav;
	}
	
	/**
	 * 新闻浏览总量数据
	 * @return
	 */
	@RequestMapping(value="newsVisitsList")
	public void newsVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.visits) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.visits) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.visits) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
		ModelAndView mav = new ModelAndView("/manage/statis/community/newsComments");
		return mav;
	}
	
	/**
	 * 新闻评论总量数据
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻点赞总量
	 * @return
	 */
	@RequestMapping(value="newsSupports")
	public ModelAndView newsSupports(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newsSupports 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/newsSupports");
		return mav;
	}
	
	/**
	 * 新闻点赞总量数据
	 * @return
	 */
	@RequestMapping(value="newsSupportsList")
	public void newsSupportsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.supports) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.supports) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.supports) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakCount");
		return mav;
	}
	
	/**
	 * 爆料总量数据
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/community/breakCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入爆料新闻浏览总量
	 * @return
	 */
	@RequestMapping(value="breakNewsVisits")
	public ModelAndView breakNewsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakNewsVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakNewsVisits");
		return mav;
	}
	
	/**
	 * 爆料新闻浏览总量
	 * @return
	 */
	@RequestMapping(value="breakNewsVisitsList")
	public void breakNewsVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.visits) as timeValue " +
							"from business_news n " +
							"inner join business_break b on b.breakId = n.breakId " +
							"where date(n.createTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date(n.createTime) ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.visits) as timeValue " +
							"from business_break b " +
							"where date(n.createTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date_format(n.createTime, '%Y-%v') ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.visits) as timeValue " +
							"from business_break b " +
							"where date(n.createTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by month(n.createTime) ";
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/community/breakCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入爆料选取总量
	 * @return
	 */
	@RequestMapping(value="breakSelect")
	public ModelAndView breakSelect(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakSelect 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakSelect");
		return mav;
	}
	
	/**
	 * 爆料选取数据
	 * @return
	 */
	@RequestMapping(value="breakSelectList")
	public void breakSelectList(HttpServletRequest request, HttpServletResponse response) {
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
	 * 进入爆料选取占比
	 * @return
	 */
	@RequestMapping(value="breakSelectCompare")
	public ModelAndView breakSelectCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakSelectCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakSelectCompare");
		return mav;
	}
	
	/**
	 * 爆料选取占比数据
	 * @return
	 */
	@RequestMapping(value="breakSelectCompareList")
	public void breakSelectCompareList(HttpServletRequest request, HttpServletResponse response) {
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
				//爆料总量
				Integer total = statisService.countBySql("select count(1) from business_break");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, round(count(1)/"+total+"*100) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, round(count(1)/"+total+"*100) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, round(count(1)/"+total+"*100) as timeValue from business_break b where b.selectedNum > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by b.breakTime desc";
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
	 * 进入单篇新闻浏览量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsVisits")
	public ModelAndView singleNewsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController singleNewsVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/singleNewsVisits");
		return mav;
	}
	
	/**
	 * 单篇新闻浏览量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsVisitsList")
	public void singleNewsVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.visits) as timeValue from business_news n where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.visits) as timeValue from business_news n where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.visits) as timeValue from business_news n where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_news n where n.visits > 0 and date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_news n where n.visits > 0 and date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_news n where n.visits > 0 and date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
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
	 * 进入平均新闻浏览量
	 * @return
	 */
	@RequestMapping(value="averageNewsVisits")
	public ModelAndView averageNewsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageNewsVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/averageNewsVisits");
		return mav;
	}
	
	/**
	 * 平均新闻浏览量
	 * @return
	 */
	@RequestMapping(value="averageNewsVisitsList")
	public void averageNewsVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
				Integer newsCount = statisService.countBySql("select count(1) from business_news");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
	 * 进入单篇新闻评论量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsComments")
	public ModelAndView singleNewsComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController singleNewsComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/singleNewsComments");
		return mav;
	}
	
	/**
	 * 单篇新闻评论量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsCommentsList")
	public void singleNewsCommentsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.comments as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by n.comments desc limit 10";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.comments as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' order by n.comments desc limit 10";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.comments as timeValue from business_news n where n.comments > 0 and date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' order by n.comments desc limit 10";
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
	 * 进入平均新闻评论量
	 * @return
	 */
	@RequestMapping(value="averageNewsComments")
	public ModelAndView averageNewsComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageNewsComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/averageNewsComments");
		return mav;
	}
	
	/**
	 * 平均新闻评论量
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
				Integer newsCount = statisService.countBySql("select count(1) from business_news");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, round(sum(n.comments)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, round(sum(n.comments)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, round(sum(n.comments)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
	 * 进入单篇新闻点赞量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsSupports")
	public ModelAndView singleNewsSupports(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController singleNewsSupports 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/singleNewsSupports");
		return mav;
	}
	
	/**
	 * 单篇新闻点赞量排名
	 * @return
	 */
	@RequestMapping(value="singleNewsSupportsList")
	public void singleNewsSupportsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.supports) as timeValue from business_news n where n.supports > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.supports) as timeValue from business_news n where n.supports > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.supports) as timeValue from business_news n where n.supports > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.supports as timeValue from business_news n where n.supports > 0 and date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by n.supports desc limit 10";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.supports as timeValue from business_news n where n.supports > 0 and date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' order by n.supports desc limit 10";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.supports as timeValue from business_news n where n.supports > 0 and date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' order by n.supports desc limit 10";
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
	 * 进入平均新闻点赞量
	 * @return
	 */
	@RequestMapping(value="averageNewsSupports")
	public ModelAndView averageNewsSupports(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageNewsSupports 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/averageNewsSupports");
		return mav;
	}
	
	/**
	 * 平均新闻点赞量
	 * @return
	 */
	@RequestMapping(value="averageNewsSupportsList")
	public void averageNewsSupportsList(HttpServletRequest request, HttpServletResponse response) {
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
				Integer newsCount = statisService.countBySql("select count(1) from business_news");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, round(sum(n.supports)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, round(sum(n.supports)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, round(sum(n.supports)/"+newsCount+") as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
	 * 进入爆料浏览量排名
	 * @return
	 */
	@RequestMapping(value="breakVisits")
	public ModelAndView breakVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakVisits");
		return mav;
	}
	
	/**
	 * 爆料浏览量排名
	 * @return
	 */
	@RequestMapping(value="breakVisitsList")
	public void breakVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, sum(n.visits) as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by date(n.createTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, sum(n.visits) as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by date_format(n.createTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, sum(n.visits) as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by month(n.createTime) desc";
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
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date_format(n.createTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date_format(n.createTime, '%Y-%v') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, n.title, n.visits as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where n.visits > 0 and date_format(n.createTime, '%Y-%m') = '" + obj.getTimeField() + "' order by n.visits desc limit 10";
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
	 * 进入平均爆料浏览量
	 * @return
	 */
	@RequestMapping(value="averageBreakVisits")
	public ModelAndView averageBreakVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageBreakVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/averageBreakVisits");
		return mav;
	}
	
	/**
	 * 平均爆料浏览量
	 * @return
	 */
	@RequestMapping(value="averageBreakVisitsList")
	public void averageBreakVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
				Integer newsCount = statisService.countBySql("select count(1) from business_break");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(n.createTime),weekday(n.createTime)),' - ',subdate(date(n.createTime),weekday(n.createTime))+INTERVAL 6 DAY) as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(n.createTime, '%Y-%v') order by n.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(n.createTime, '%Y-%m') as timeField, round(sum(n.visits)/"+newsCount+") as timeValue from business_break b inner join business_news n on b.breakId = n.breakId where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by month(n.createTime) order by n.createTime desc";
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
	 * 进入爆料评论量排名
	 * @return
	 */
	@RequestMapping(value="breakCommentsRank")
	public ModelAndView breakCommentsRank(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController breakCommentsRank 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/breakCommentsRank");
		return mav;
	}
	
	/**
	 * 爆料评论量排名
	 * @return
	 */
	@RequestMapping(value="breakCommentsRankList")
	public void breakCommentsRankList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, sum(b.comments) as timeValue from business_break b where b.comments > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by date(b.breakTime) desc ";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, sum(b.comments) as timeValue from business_break b where b.comments > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by date_format(b.breakTime, '%Y-%v') desc ";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, sum(b.comments) as timeValue from business_break b where b.comments > 0 and date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by month(b.breakTime) desc";
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
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, b.breakContent as title, b.comments as timeValue from business_break b where b.comments > 0 and date_format(b.breakTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by b.comments desc limit 10";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, b.breakContent as title, b.comments as timeValue from business_break b where b.comments > 0 and date_format(b.breakTime, '%Y-%v') = '" + obj.getTimeField() + "' order by b.comments desc limit 10";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, b.breakContent as title, b.comments as timeValue from business_break b where b.comments > 0 and date_format(b.breakTime, '%Y-%m') = '" + obj.getTimeField() + "' order by b.comments desc limit 10";
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
	 * 进入平均新闻点赞量
	 * @return
	 */
	@RequestMapping(value="averageBreakComments")
	public ModelAndView averageBreakComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController averageBreakComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/community/averageBreakComments");
		return mav;
	}
	
	/**
	 * 平均新闻点赞量
	 * @return
	 */
	@RequestMapping(value="averageBreakCommentsList")
	public void averageBreakCommentsList(HttpServletRequest request, HttpServletResponse response) {
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
				Integer newsCount = statisService.countBySql("select count(1) from business_break");
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(b.breakTime, '%Y-%m-%d') as timeField, round(sum(b.comments)/"+newsCount+") as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date(b.breakTime) order by b.breakTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(b.breakTime),weekday(b.breakTime)),' - ',subdate(date(b.breakTime),weekday(b.breakTime))+INTERVAL 6 DAY) as timeField, round(sum(b.comments)/"+newsCount+") as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by date_format(b.breakTime, '%Y-%v') order by b.breakTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(b.breakTime, '%Y-%m') as timeField, round(sum(b.comments)/"+newsCount+") as timeValue from business_break b where date(b.breakTime) between '" + startDate + "' and '" + endDate + "' group by month(b.breakTime) order by b.breakTime desc";
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
	
}
