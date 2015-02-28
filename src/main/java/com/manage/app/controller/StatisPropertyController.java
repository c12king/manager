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

/**
 * 物业统计
 * @author zyp-2_000
 *
 */
@Controller
@RequestMapping("/statis/property")
public class StatisPropertyController {
	private static Logger GSLogger = LoggerFactory.getLogger(StatisPropertyController.class);

	@Autowired
	private StatisService statisService;
	
	/**
	 * 进入物业报修总数
	 * @return
	 */
	@RequestMapping(value="repair")
	public ModelAndView repair(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/repair");
		return mav;
	}
	
	/**
	 * 物业报修总数数据
	 * @return
	 */
	@RequestMapping(value="repairList")
	public void repairList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(r.repairTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date(r.repairTime) order by r.repairTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(r.repairTime),weekday(r.repairTime)),' - ',subdate(date(r.repairTime),weekday(r.repairTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date_format(r.repairTime, '%Y-%v') order by r.repairTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(r.repairTime, '%Y-%m') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by month(r.repairTime) order by r.repairTime desc";
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
	 * 进入物业建议数量
	 * @return
	 */
	@RequestMapping(value="advise")
	public ModelAndView advise(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController advise 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/advise");
		return mav;
	}
	
	/**
	 * 物业建议数量数据
	 * @return
	 */
	@RequestMapping(value="adviseList")
	public void adviseList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(f.fbTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 1 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date(f.fbTime) order by f.fbTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(f.fbTime),weekday(f.fbTime)),' - ',subdate(date(f.fbTime),weekday(f.fbTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_feedback f where f.fbType = 1 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date_format(f.fbTime, '%Y-%v') order by f.fbTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(f.fbTime, '%Y-%m') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 1 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by month(f.fbTime) order by f.fbTime desc";
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/property/adviseList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业投诉数量
	 * @return
	 */
	@RequestMapping(value="complaint")
	public ModelAndView complaint(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController complaint 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/complaint");
		return mav;
	}
	
	/**
	 * 物业投诉数量数据
	 * @return
	 */
	@RequestMapping(value="complaintList")
	public void complaintList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(f.fbTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 0 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date(f.fbTime) order by f.fbTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(f.fbTime),weekday(f.fbTime)),' - ',subdate(date(f.fbTime),weekday(f.fbTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_feedback f where f.fbType = 0 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date_format(f.fbTime, '%Y-%v') order by f.fbTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(f.fbTime, '%Y-%m') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 0 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by month(f.fbTime) order by f.fbTime desc";
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/property/adviseList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业公告浏览量
	 * @return
	 */
	@RequestMapping(value="annoVisits")
	public ModelAndView annoVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController annoVisits 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/annoVisits");
		return mav;
	}
	
	/**
	 * 物业公告浏览量数据
	 * @return
	 */
	@RequestMapping(value="annoVisitsList")
	public void annoVisitsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.visits) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.visits) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.visits) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
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
	 * 进入物业公告评论量
	 * @return
	 */
	@RequestMapping(value="annoComments")
	public ModelAndView annoComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController annoComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/annoComments");
		return mav;
	}
	
	/**
	 * 物业公告评论量数据
	 * @return
	 */
	@RequestMapping(value="annoCommentsList")
	public void annoCommentsList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.comments) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.comments) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.comments) as timeValue from business_anno a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
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
	 * 进入报修评价星级平均值
	 * @return
	 */
	@RequestMapping(value="starAverage")
	public ModelAndView starAverage(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController starAverage 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/starAverage");
		return mav;
	}
	
	/**
	 * 报修评价星级平均值数据
	 * @return
	 */
	@RequestMapping(value="starAverageList")
	public void starAverageList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(r.repairTime, '%Y-%m-%d') as timeField, sum(r.repairScore)/count(1) as timeValue from business_repair r where r.repairScore > 0 and date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date(r.repairTime) order by r.repairTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(r.repairTime),weekday(r.repairTime)),' - ',subdate(date(r.repairTime),weekday(r.repairTime))+INTERVAL 6 DAY) as timeField, sum(r.repairScore)/count(1) as timeValue from business_repair r where r.repairScore > 0 and date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date_format(r.repairTime, '%Y-%v') order by r.repairTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(r.repairTime, '%Y-%m') as timeField, sum(r.repairScore)/count(1) as timeValue from business_repair r where r.repairScore > 0 and date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by month(r.repairTime) order by r.repairTime desc";
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
	 * 进入星级评价个数
	 * @return
	 */
	@RequestMapping(value="star")
	public ModelAndView star(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController star 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/star");
		return mav;
	}
	
	/**
	 * 报修星级评价个数数据
	 * @return
	 */
	@RequestMapping(value="starList")
	public void starList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String score = request.getParameter("score");
		String scope = request.getParameter("scope");
		Integer scopeValue = 0;
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null &&
				//score != null &&
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(r.repairTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date(r.repairTime) order by r.repairTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(r.repairTime, '%Y-%v') as weekField, CONCAT(subdate(date(r.repairTime),weekday(r.repairTime)),' - ',subdate(date(r.repairTime),weekday(r.repairTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date_format(r.repairTime, '%Y-%v') order by r.repairTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(r.repairTime, '%Y-%m') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by month(r.repairTime) order by r.repairTime desc";
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
				for(int k=1;k<=5;k++) {
					String starSql = "";
					List starList = new ArrayList();
					if(scopeValue == 0) {//日
						starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by r.repairTime desc";
					}else if(scopeValue == 1) {//周
						starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%v') = '" + obj.getWeekField() + "' order by r.repairTime desc";
					}else if(scopeValue == 2) {//月
						starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%m') = '" + obj.getTimeField() + "' order by r.repairTime desc";
					}
					starList = statisService.statisBySql(starSql);
					for(int m=0;m<starList.size();m++) {
						ResultBean starObj = (ResultBean) starList.get(m);
						result.append("{")
						.append("\"id\":\"").append(k).append("\"").append(",")
					    .append("\"timeField\":\"").append("").append("\"").append(",")
					    .append("\"title\":\"").append(k+"星").append("\"").append(",")
					    .append("\"timeValue\":\"").append(starObj.getTimeValue()).append("\"").append(",")
					    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
						.append("}").append(",");
					}						
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
	 * 进入不同报修分类星级个数
	 * @return
	 */
	@RequestMapping(value="starByType")
	public ModelAndView starByType(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController starByType 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/property/starByType");
		return mav;
	}
	
	/**
	 * 不同报修分类星级个数
	 * @return
	 */
	@RequestMapping(value="starByTypeList")
	public void starByTypeList(HttpServletRequest request, HttpServletResponse response) {
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
					sql = "select date_format(r.repairTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date(r.repairTime) order by r.repairTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select date_format(r.repairTime, '%Y-%v') as weekField, CONCAT(subdate(date(r.repairTime),weekday(r.repairTime)),' - ',subdate(date(r.repairTime),weekday(r.repairTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by date_format(r.repairTime, '%Y-%v') order by r.repairTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(r.repairTime, '%Y-%m') as timeField, count(1) as timeValue from business_repair r where date(r.repairTime) between '" + startDate + "' and '" + endDate + "' group by month(r.repairTime) order by r.repairTime desc";
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
			    .append("\"timeValue\":\"").append("").append("\"")
				.append("}").append(",");
				if(scopeValue == 0) {//日
					sql = "select '' as timeField, r.repairType as title, count(distinct(r.repairId)) as timeValue " +
							"from business_repair r " +
							"where date_format(r.repairTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' " +
							"group by r.repairType order by r.repairType asc";
				}else if(scopeValue == 1) {//周
					sql = "select '' as timeField, r.repairType as title, count(distinct(r.repairId)) as timeValue " +
							"from business_repair r " +
							"and date_format(r.repairTime, '%Y-%v') = '" + obj.getTimeField() + "' " +
							"group by r.repairType order by r.repairType asc";
				}else if(scopeValue == 2) {//月
					sql = "select '' as timeField, r.repairType as title, count(distinct(r.repairId)) as timeValue " +
							"from business_repair r " +
							"and date_format(r.repairTime, '%Y-%m') = '" + obj.getTimeField() + "' " +
							"group by r.repairType order by r.repairType asc";
				}
				sublist = statisService.statisBySql(sql);
				for(int j=0;j<sublist.size();j++) {
					ResultBean subObj = (ResultBean) sublist.get(j);
					result.append("{")
					.append("\"id\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeField\":\"").append(subObj.getTimeField()).append("\"").append(",")
				    .append("\"title\":\"").append(subObj.getTitle()).append("\"").append(",")
				    .append("\"timeValue\":\"").append("").append("\"").append(",")
				    .append("\"_parentId\":\"").append(obj.getTimeField()).append("\"")
					.append("}").append(",");
					for(int k=1;k<=5;k++) {
						String starSql = "";
						List starList = new ArrayList();
						if(scopeValue == 0) {//日
							starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairType = " + subObj.getTitle() + " and r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%m-%d') = '" + obj.getTimeField() + "' order by r.repairTime desc";
						}else if(scopeValue == 1) {//周
							starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairType = " + subObj.getTitle() + " and r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%v') = '" + obj.getWeekField() + "' order by r.repairTime desc";
						}else if(scopeValue == 2) {//月
							starSql = "select '' as timeField, count(1) as timeValue from business_repair r where r.repairType = " + subObj.getTitle() + " and r.repairScore = " + k + " and date_format(r.repairTime, '%Y-%m') = '" + obj.getTimeField() + "' order by r.repairTime desc";
						}
						starList = statisService.statisBySql(starSql);
						for(int m=0;m<starList.size();m++) {
							ResultBean starObj = (ResultBean) starList.get(m);
							result.append("{")
							.append("\"id\":\"").append(k).append("\"").append(",")
						    .append("\"timeField\":\"").append("").append("\"").append(",")
						    .append("\"title\":\"").append(k+"星").append("\"").append(",")
						    .append("\"timeValue\":\"").append(starObj.getTimeValue()).append("\"").append(",")
						    .append("\"_parentId\":\"").append(subObj.getTitle()).append("\"")
							.append("}").append(",");
						}						
					}
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
	
}
